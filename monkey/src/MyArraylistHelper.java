import java.util.ArrayList;

public  class MyArraylistHelper {

    static public < T extends Comparable<T>>boolean isItemInList(T target, ArrayList< T > list) throws Exception{
       return  (firstItemPositionInList(target, list)>=0);
    }

    static public  < T extends Comparable<T>> int firstItemPositionInList(T target, ArrayList<T> list) throws Exception{
        if(target == null || list == null ) throw new Exception("empty parametre");
        for(int i=0; i<list.size();i++){
            try {
                if(target.compareTo(list.get(i))==0)return i;
            }
            catch (NullPointerException e){
                throw new Exception("empty position in ration");}
        }
        return -1;
    }

}
