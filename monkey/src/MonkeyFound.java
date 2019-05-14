import java.util.Random;

public class MonkeyFound {
    public static void main(String[] args) {
        Fruit apple = new SimpleFruit(1);
        Fruit mango = new SimpleFruit(2);
        Fruit banana = new SimpleFruit(3);
        Monkey vasia = new Monkey();
        Monkey ergan = new Monkey(mango);
        Monkey vania = new Monkey(apple,mango);
        Monkey alfred = new Monkey(apple,banana,mango);
        Random random = new Random();
        FruitTree mangotree = new FruitTree(mango,random);
        FruitTree bananatree1 = new FruitTree(banana,random);
        FruitTree bananatree2 = new FruitTree(banana,random);
        FruitTree appletree = new FruitTree(apple,random);
        System.out.println(alfred.search(bananatree1));
        System.out.println(vania.search(bananatree1));
        System.out.println(alfred.search(bananatree2));
        System.out.println(alfred.search(mangotree));
        System.out.println(ergan.search(mangotree));
        System.out.println(vania.search(mangotree));
        System.out.println(vasia.search(appletree));
        vasia.addToRation(apple);
        System.out.println(vania.search(appletree));








    }
}
