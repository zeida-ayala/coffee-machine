package machine.enums;

import java.util.stream.Stream;

public enum CoffeeType {
    EXPRESSO("Expresso", 1, 4),
    LATTE("Latte", 2, 7),
    CAPPUCCINO("Cappuccino", 3, 6);

    String name;
    int option;
    int price;

    CoffeeType(String name, int option, int price) {
        this.name = name;
        this.option = option;
        this.price = price;
    }

    public String getName() {
        return name;
    }
    public int geOption() {
        return option;
    }

    public int getPrice() {
        return price;
    }

    public static Stream<CoffeeType> stream() {
        return Stream.of(CoffeeType.values());
    }

}
