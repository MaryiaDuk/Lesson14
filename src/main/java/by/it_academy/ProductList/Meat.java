package by.it_academy.ProductList;

public class Meat implements Products {
    final int price = 25;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "price=" + price +
                '}';
    }
}