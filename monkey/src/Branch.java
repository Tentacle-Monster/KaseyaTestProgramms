import java.util.Random;

public class Branch {
    public static final int MAXFRUITCOUNT=10;
    public static final int MAXCHILDCOUNT=10;



    protected Branch root;
    protected Branch[] childs;
    protected int nomberOfFruits;

    public Branch(Branch root, Branch[] childs, int nomberOfFruits) {
        this.root = root;
        this.childs = childs;
        this.nomberOfFruits = nomberOfFruits;
    }

  //  protected Branch generateRandomBranch(Random random, )

    public Branch(Branch root,Random random , int nomberOfChilds, int branchingsLeft, int nomberOfFruits) {
          Init(root,random, nomberOfChilds, branchingsLeft,nomberOfFruits, MAXCHILDCOUNT, MAXFRUITCOUNT);
    }

    public Branch(Branch root,Random random , int nomberOfChilds, int branchingsLeft, int nomberOfFruits, int maxchild, int maxfruit) {
         Init(root,random,nomberOfChilds,branchingsLeft,nomberOfFruits,maxchild,maxfruit);
    }


    private  void Init(Branch root,Random random , int nomberOfChilds, int branchingsLeft, int nomberOfFruits, int maxchild, int maxfruit) {
        this.root = root;
        if (random == null) random = new Random();
        this.nomberOfFruits = nomberOfFruits;
        if(branchingsLeft !=0){
            childs = new Branch[nomberOfChilds];
            for(int i=0;i<nomberOfChilds;i++){
                childs[i]=new Branch(this,random,random.nextInt(maxchild),branchingsLeft-1,random.nextInt(maxfruit));
            }
        }
    }

  //  public Branch (Branch root, Random random, int branchingsLeft)

    public Branch[] getChilds() {
        return childs;
    }

    public void setChilds(Branch[] childs) {
        this.childs = childs;
    }

    public int getNomberOfFruits() {
        return nomberOfFruits;
    }

    public void setNomberOfFruits(int nomberOfFruits) {
        this.nomberOfFruits = nomberOfFruits;
    }
}
