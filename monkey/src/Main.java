import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Fruit apple = new SimpleFruit(1);
        Fruit mango = new SimpleFruit(2);
        Fruit banana = new SimpleFruit(3);
        Monkey vasia = new Monkey();
        Monkey ergan = new Monkey(mango);
        Monkey vania = new Monkey(apple,mango);
        Monkey alfred = new Monkey(apple,banana,mango);
        Random random = new Random();
        System.out.println("there are 4 monkeys:" +
                "\n > Vasia eats nothing" +
                "\n > Ergan eats mango" +
                "\n > Vania eats apple and mango" +
                "\n > Alfred eats apple, banana and mango" );
        FruitTree bananatree2 = new FruitTree(banana,200,2,1,random);
        FruitTree mangotree = new FruitTree(mango,random);
        FruitTree bananatree1 = new FruitTree(banana,0,random);
        FruitTree appletree = new FruitTree(apple,random);
        System.out.println("Alfred & banana tree");
        System.out.println(alfred.search(bananatree1));
        System.out.println("Vania & banana tree");
        System.out.println(vania.search(bananatree1));
        System.out.println("Alfred & second banana tree");
        System.out.println(alfred.search(bananatree2));
        System.out.println("Alfred & mango tree");
        System.out.println(alfred.search(mangotree));
        System.out.println("Ergan & banana tree");
        System.out.println(ergan.search(mangotree));
        System.out.println("Vania & banana tree");
        System.out.println(vania.search(mangotree));
        System.out.println("Vasia & apple tree");
        System.out.println(vasia.search(appletree));
        System.out.println("well, NullPointer exception");
        System.out.println("now, we should add apples to Vasia's ration");
        vasia.addToRation(apple);
        System.out.println("Vasia & apple tree, second try");
        System.out.println(vania.search(appletree));




    }
}
