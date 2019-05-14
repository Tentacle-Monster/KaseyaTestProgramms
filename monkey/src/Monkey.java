
import java.util.ArrayList;
import java.util.Arrays;

public class Monkey {
    protected ArrayList<Fruit>ration;


    public Monkey(ArrayList<Fruit> ration) {
        this.ration = ration;
    }

    public Monkey() {
        this.ration = null;
    }

    public Monkey(Fruit ... Fruitration) {
        this.ration = new ArrayList<Fruit>(Arrays.asList(Fruitration));

    }

    public void addToRation(Fruit ... Fruitration){
        if(ration == null)ration = new ArrayList<Fruit>();
        else ration.addAll( Arrays.asList(Fruitration));
    }
    public void removeFromRation(Fruit ... Fruitration){
        if(ration == null)ration =new ArrayList<Fruit>();
        else ration.removeAll(Arrays.asList(Fruitration));
    }




    public int search(FruitTree target){
        int fruits = 0;
        try {
            if(MyArraylistHelper.isItemInList(target.getFruittype(),this.ration) && target.getRoot()!=null)
            fruits = searchAtBranch(target.getRoot());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fruits;
    }

    private int searchAtBranch(Branch target){
        Branch[] childs = target.getChilds();
        int fruits = 0;
        fruits += target.getNomberOfFruits();
        if(childs != null)
         for(int i =0; i<childs.length;i++ ){
            fruits += childs[i].getChilds().length;
        }

        return fruits;

    }

    public ArrayList<Fruit> getRation() {
        return ration;
    }

    public void setRation(ArrayList<Fruit> ration) {
        this.ration = ration;
    }



}
