import java.util.Random;

public class Branch {




    protected Branch root;
    protected Branch[] childs;
    protected int nomberOfFruits;

    public Branch(Branch root, Branch[] childs, int nomberOfFruits) {
        this.root = root;
        this.childs = childs;
        this.nomberOfFruits = nomberOfFruits;
    }


    public Branch(Branch root, Random random, int generationsLeft, int maxFruit, int maxChild){
        Init(root,random,generationsLeft,random.nextInt(maxChild+1),random.nextInt(maxFruit+1),maxChild,maxFruit);
    }

    public Branch(Branch root,Random random ,  int generationsLeft, int maxFruit, int maxChild,int nomberOfChilds, int nomberOfFruits) {
          Init(root,random,generationsLeft,nomberOfChilds,nomberOfFruits,maxChild,maxFruit);
    }

    private  void Init(Branch root,Random random ,  int generationsLeft, int nomberOfChilds, int nomberOfFruits, int maxchild, int maxfruit) {
        this.root = root;
        if (random == null) random = new Random();
        this.nomberOfFruits = nomberOfFruits;
        if(generationsLeft !=0){
            childs = new Branch[nomberOfChilds];
            for(int i=0;i<nomberOfChilds;i++){
                childs[i]=new Branch(this, random, generationsLeft-1,maxfruit,maxchild);
            }
        }
    }


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
