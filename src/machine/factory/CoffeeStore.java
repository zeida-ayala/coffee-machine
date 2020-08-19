package machine.factory;

abstract class CoffeeStore {

    protected abstract AbstractCoffee createCoffee();

    public AbstractCoffee orderCoffee() {
        AbstractCoffee coffee = createCoffee();
        coffee.prepare();
        return coffee;
    }
}
