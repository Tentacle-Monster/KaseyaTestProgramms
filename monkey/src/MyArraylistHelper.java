import java.util.ArrayList;

public  class MyArraylistHelper {

    static public boolean isFruitInList(Fruit target, ArrayList<Fruit> list) throws Exception{
       return  (PositionFruitInList(target, list)>=0);
    }

    static public int PositionFruitInList(Fruit target, ArrayList<Fruit> list) throws Exception{
        if(target == null || list == null ) throw new Exception("empty parametre");
        for(int i=0; i<list.size();i++){
            try {
                if(target.getId()==list.get(i).getId())return i;
            }
            catch (NullPointerException e){
                throw new Exception("empty position in ration");}
        }
        return -1;
    }

}
