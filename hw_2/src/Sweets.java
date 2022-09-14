public abstract class Sweets {
    protected String name;
    protected int weight;
    protected int price;
    protected String uniqueName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getUniqueName() {
        return uniqueName;
    }

    public void setUniqueName(String uniqueName) {
        this.uniqueName = uniqueName;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,Вес %d гр.,Цена %d руб.",name,uniqueName,weight,price);
    }
}
