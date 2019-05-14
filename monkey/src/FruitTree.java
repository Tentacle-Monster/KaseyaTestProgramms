import java.util.Random;

public class FruitTree {
    protected Branch root;
    protected Fruit fruittype;
    private static final int MAXBRANCHGENERATION = 5;

    public FruitTree(Branch root, Fruit fruittype) {
        this.root = root;
        this.fruittype = fruittype;
    }

    public FruitTree(Fruit fruittype, int branchGenerations, Random random) {
        this.fruittype = fruittype;
        if(random == null) random = new Random();
        root = new Branch(null,random,branchGenerations,Branch.MAXCHILDCOUNT,Branch.MAXFRUITCOUNT);
    }

    public FruitTree(Fruit fruittype,Random random) {
        this.fruittype = fruittype;
        if(random == null) random = new Random();
        root = new Branch(null,random,MAXBRANCHGENERATION, Branch.MAXCHILDCOUNT, Branch.MAXFRUITCOUNT);
    }

    public FruitTree(Fruit fruittype, int branchGenerations, int maxchild, int maxfruit,Random random) {
        this.fruittype = fruittype;
        if(random == null) random = new Random();
        root = new Branch(null,random,random.nextInt(maxchild),branchGenerations,0,maxchild,maxfruit);
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
