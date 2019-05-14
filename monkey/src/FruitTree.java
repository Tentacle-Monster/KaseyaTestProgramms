import java.util.Random;

public class FruitTree {
    protected Branch root;
    protected Fruit fruittype;
    private static final int MAXHEIGHT = 5;

    public FruitTree(Branch root, Fruit fruittype) {
        this.root = root;
        this.fruittype = fruittype;
    }

    public FruitTree(Fruit fruittype, int height) {
        this.fruittype = fruittype;
        Random random = new Random();
        root = new Branch(null,random,random.nextInt(Branch.MAXCHILDCOUNT),height,0);
    }

    public FruitTree(Fruit fruittype) {
        this.fruittype = fruittype;
        Random random = new Random();
        root = new Branch(null,random,random.nextInt(Branch.MAXCHILDCOUNT),MAXHEIGHT,0);
    }

    public FruitTree(Fruit fruittype, int height, int maxchild, int maxfruit) {
        this.fruittype = fruittype;
        Random random = new Random();
        root = new Branch(null,random,random.nextInt(maxchild),height,0,maxchild,maxfruit);
    }




    public Branch getRoot() {
        return root;
    }

    public void setRoot(Branch root) {
        this.root = root;
    }

    public Fruit getFruittype() {
        return fruittype;
    }

    public void setFruittype(Fruit fruittype) {
        this.fruittype = fruittype;
    }


}
