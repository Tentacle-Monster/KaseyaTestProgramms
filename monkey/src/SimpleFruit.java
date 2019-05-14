public class SimpleFruit implements Fruit{
    private int id;

    public SimpleFruit(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }
}
