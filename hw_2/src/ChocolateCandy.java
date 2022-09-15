public class ChocolateCandy extends Sweets {

    private String uniqueName;

    public ChocolateCandy(String name, int weight, int price, String uniqueName) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.uniqueName = uniqueName;
    }

    @Override
    public String toString() {
        return String.format("%s,Вес %d гр.,Цена %d руб.,%s", name, weight, price, uniqueName);
    }
}
