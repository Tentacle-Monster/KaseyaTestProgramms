package com.mycompany.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserInterface implements Runnable {
    //---------------------------------------------------UI---CONSTANTS-----------------
    private static final String CONFIRM_COMMAND ="yes";
    private static final String DENAI_COMMAND ="no";
    private static final String HELP_COMMAND ="help";
    private static final String START_COMMAND ="start";
    private static final String STOP_COMMAND ="stop";
    private static final String QUIT_COMMAND ="quit";
    private static final String RELOAD_COMMAND ="reload";
    private static final String SETTINGS_COMMAND ="settings";
    private static final String HELP_DIALOG =
            QUIT_COMMAND+"- to exit application " +
            "\n"+START_COMMAND+"- to start parsing and " +STOP_COMMAND+"to stop"+
            "\n"+SETTINGS_COMMAND+"- to see all preset list ";
    private static final String CHANGE_DIALOG = "";
    private static final String SELECT_DIALOG = "";
    private static final String ADD_DIALOG = "";
    private static final String CONFIRM_DIALOG = " type \"" +CONFIRM_COMMAND+"\" to confirm or \""+DENAI_COMMAND+"\" to discard";
    private static final String CONTINUE_DIALOG = "press Enter to continue";
    private static final String DEFAULT_DIALOG= "unknown command, please type \""+HELP_COMMAND+ "\" to see command list";
    private static final String WELCOME_DIALOG= "Programm runned successfuly";
    // public static int select

    private static final String UI_LINE_HORIZONTAL="================================================================================";
    private static final String UI_LINE_HORIZONTAL_SMALL="__________________________________";
    private static final String UI_LINE_VERTICAL ="||";


    private Controller controller ;
    private java.io.BufferedReader in;



    public UserInterface(Controller controller) {
        this.controller = controller;
        in = new BufferedReader(new InputStreamReader(System.in));
        interfaceSay(WELCOME_DIALOG);

    }



    public void run()  {
        boolean readyToQuit=false;
        while (!readyToQuit){
            String input = null;
            try {
                input = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(input.toLowerCase().contains("quit"))
                readyToQuit = true;
            try {
                meny(input);
            } catch (Exception e) {
                e.printStackTrace();
            }




        }

        controller.die();


    }

    private void meny(String command) throws Exception{
        if(command.contains(HELP_COMMAND))help();
        else if(command.contains(START_COMMAND) ||command.contains(RELOAD_COMMAND))interfaceSay(controller.refresh()?"runed":"unable");
        else if(command.contains(STOP_COMMAND))  interfaceSay(controller.stop()?"stopped":"unable");
        else if(command.contains(SETTINGS_COMMAND))AssetMeny();
        else  interfaceSay(DEFAULT_DIALOG);

/*
        switch (command.hashCode()){
            case HELP_COMMAND_HASH:
                help();
                break;



            case START_COMMAND_HASH:
            case RELOAD_COMMAND_HASH:

                interfaceSay(controller.refresh()?"runed":"unable");
                break;
            case STOP_COMMAND_HASH:
                interfaceSay(controller.stop()?"stopped":"unable");
                break;

            case SETTINGS_COMMAND_HASH:
                AssetMeny();
                break;


            default:
                interfaceSay(DEFAULT_DIALOG);
                break;


        }*/

    }


    protected void help(){
        interfaceSay(HELP_DIALOG +
                "\n"+ UI_LINE_HORIZONTAL_SMALL+"\n"+CONTINUE_DIALOG);
        Vait();


    }

    protected void Vait(){
        try {
            in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void continueScreen(){
        interfaceSay(CONTINUE_DIALOG);
        Vait();
    }

    protected void unknown(){
        interfaceSay(DEFAULT_DIALOG);
    }

    private void interfaceSay(String input){
        clearConsole();
        System.out.print("\033\143");
        System.out.println(UI_LINE_HORIZONTAL);
       String[]lines=(input.split("\n"));
       for(String every:lines)System.out.println(UI_LINE_VERTICAL +every);
        System.out.println(UI_LINE_HORIZONTAL);

    }



    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

    private boolean confirm() throws IOException {
        for(;;){
            interfaceSay(CONFIRM_DIALOG);
        switch (in.readLine()){
            case CONFIRM_COMMAND:
                return true;

            case DENAI_COMMAND:
                return false;

        }
    }}

    private void AssetMeny() throws IOException {
        ArrayList<ParsingAsset> assets =controller.getAssets();
        boolean signal = false;
        while (!signal){
            showAssets(assets);

           String input = in.readLine();

           if(input.contains("+")){try {
               addAsset();
               return;
           }catch (Exception e){
               signal = false;
           }

           }else{
               int nomber = Integer.parseInt(input);
               if(nomber>=0 && nomber<assets.size()){
                   try {
                       selectedAsset(assets, nomber);
                       return;
                   } catch (Exception e) {
                       signal = false;
                   }


               }
           }



        }

    }

    private void selectedAsset(ArrayList<ParsingAsset>assets, int nomber) throws Exception{
        boolean input = false;
        while(!input) {
            interfaceSay(" \'remove \' to remove, \'updase \' to redact, \'select \' to select  \'back\' to escape");
            input = true;
            String command = in.readLine();
            interfaceSay(" \'remove\' to remove, \'updase\' to redact, \'select \' to select \'");
            if (command.contains("remove")) removeAsset(nomber);
            else if (command.contains("select")) controller.changeAsset(nomber);
            else if (command.contains("update")) controller.updateAsset(nomber, newAsset());
            else if (command.contains("back"))return;
            else input = false;
        }


    }

    private void removeAsset(int i) throws Exception{
        if(confirm())controller.deleteAsset(i);
    }

    private void showAssets(ArrayList<ParsingAsset> assets){
        String assetList = new String(" avalible assets: \n");
        for(int i=0;i<assets.size();i++)  assetList += "\n"+i+")    " + assets.get(i).getMinimumString();
        assetList += "\n"+UI_LINE_HORIZONTAL_SMALL+"\n nomber to select , + to add";
        interfaceSay(assetList);

    }

    private  void  addAsset() throws Exception{
        try{
            ParsingAsset asset = newAsset();
            controller.addAsset(asset);
        }catch (Exception e){ throw  new Exception("unable to create");}

    }

    public ParsingAsset newAsset() throws Exception {
        interfaceSay("please enter url");
        String url = in.readLine();
        interfaceSay("enter keywords vs spaces between");
        String[] keywords = in.readLine().split(" ");
        interfaceSay("enter pause between iterations, in milis");
        long delay = Integer.parseInt(in.readLine());
        interfaceSay( "is upper case important?");
        boolean caseEqual = !confirm();
        return new ParsingAsset(url,keywords,caseEqual,delay);
    }







}
