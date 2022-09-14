import java.util.*;

public class Present implements Box {

    private List<Sweets> boxPresent = new ArrayList<>();
    private final Random random = new Random();
    private int weightPresent;
    private int countWeightBox;
    private int countPriceBox;
    private List<Sweets> productRange = List.of(
            new Biscuit("Печенье", 50, 50, "Сладости на завтрак"),
            new Caramel("Карамель", 10, 15, "Побереги зубы"),
            new Toffee("Ирис", 10, 10, "Липнет ко всему"),
            new ChocolateCandy("Шоколадная конфета", 15, 50, "Взрослые вкусности"),
            new Marshmallow("Зефир", 15, 35, "Виолетта"),
            new Caramel("Карамель", 10, 5, "Вкус детства"),
            new ChocolateCandy("Шоколадная конфета", 25, 20, "Кот в сапогах"),
            new Toffee("Ирис", 8, 30, "Кис"),
            new ChocolateCandy("Шоколадная конфета", 12, 40, "Снежок"),
            new Wafer("Вафли", 25, 50, "Шоколадные"));

    public Present(int weightPresent) {
        this.weightPresent = weightPresent;
    }

    public void fillBox() {
        countWeightBox = 0;
        while (countWeightBox <= 2000) {
            int addSweets = random.nextInt(10);
            Sweets sweets = productRange.get(addSweets);
            addSweets(sweets);
            countWeightBox += sweets.getWeight();
            countPriceBox += sweets.getPrice();
        }
    }

    public void input() {
        System.out.println("Что хотите удалить из подарка?");
        System.out.println("Чтобы выбрать что удалить из подарка, введите цифру от 1 до 2");
        System.out.println("1 - удаляем самые легкие сладости\n" + "2 - удаляем самые дешевые сладости\n");
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        switch (number) {
            case (1):
                optimizationWeight();
                break;
            case (2):
                optimizationPrice();
                break;
            default:
                System.out.println("Вы ввели неправильную цифру!!!\n" + "\nУ нас в наличии есть подарок:");
        }
    }

    @Override
    public void addSweets(Sweets sweets) {
        boxPresent.add(sweets);
    }

    @Override
    public void removeSweets(int index) {
        boxPresent.remove(index);
    }

    @Override
    public void getPresentWeight() {
        System.out.println("Вес подарка: " + countWeightBox + " гр.");
    }

    @Override
    public void getPresentPrice() {
        System.out.println("Цена подарка: " + countPriceBox + " руб.");
    }

    @Override
    public void getAllInformation() {
        System.out.println("Какие сладости в подарке:");
        boxPresent.forEach(System.out::println);
    }

    public void optimizationWeight() {
        while (weightPresent < countWeightBox) {
            Sweets sweets = boxPresent.stream().min(Comparator.comparingInt(Sweets::getWeight)).stream().findFirst().orElse(null);
            int remove = boxPresent.indexOf(sweets);
            removeSweets(remove);
            if (sweets != null) {
                countWeightBox -= sweets.getWeight();
                countPriceBox -= sweets.getPrice();
            }
        }
    }

    public void optimizationPrice() {
        while (weightPresent < countWeightBox) {
            Sweets sweets = boxPresent.stream().min(Comparator.comparingInt(Sweets::getPrice)).stream().findFirst().orElse(null);
            int remove = boxPresent.indexOf(sweets);
            removeSweets(remove);
            if (sweets != null) {
                countPriceBox -= sweets.getPrice();
                countWeightBox -= sweets.getWeight();
            }
        }
    }
}
