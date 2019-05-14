import java.util.ArrayList;

public class MonkeyFounf {
    public static void main(String[] args) {
        Fruit apple = new SimpleFruit(1);
        Fruit mango = new SimpleFruit(2);
        Fruit banana = new SimpleFruit(3);
        Monkey Vasia = new Monkey();
        Monkey Ergan = new Monkey(mango);
        Monkey Vania = new Monkey(apple,mango);
        Monkey Slava = new Monkey(banana);
        Monkey Alfred = new Monkey(apple,banana,mango);

        FruitTree mangotree1 = new FruitTree(mango);
        FruitTree mangotree2 = new FruitTree(mango);
        FruitTree bananatree1 = new FruitTree(banana);
        FruitTree bananatree2 = new FruitTree(banana);
        FruitTree appletree = new FruitTree(apple);
        System.out.println(Alfred.search(bananatree1));
        System.out.println(Vania.search(bananatree1));
        System.out.println(Alfred.search(bananatree2));
        System.out.println(Alfred.search(mangotree1));
        System.out.println(Ergan.search(mangotree1));
        System.out.println(Vania.search(mangotree1));
        System.out.println(Vasia.search(bananatree1));
        System.out.println(Vania.search(mangotree1));








    }
}
