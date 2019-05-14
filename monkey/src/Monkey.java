
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

    public void addToration(Fruit ... Fruitration){
        ArrayList<Fruit> additionRation = (ArrayList<Fruit>) Arrays.asList(Fruitration);
        if(ration == null)ration = additionRation;
        else ration.addAll(additionRation);
    }
    public void removeFromRation(Fruit ... Fruitration){
        ArrayList<Fruit> excessRation = (ArrayList<Fruit>) Arrays.asList(Fruitration);
        if(ration == null)ration =new ArrayList<Fruit>();
        else ration.removeAll(excessRation);
    }




    public int search(FruitTree target){
        int fruits = 0;
        try {
            if(MyArraylistHelper.isFruitInList(target.getFruittype(),this.ration) && target.getRoot()!=null)
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
