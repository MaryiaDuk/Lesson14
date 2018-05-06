package by.it_academy.ProductList;

public class Milk implements Products {
    final int price = 12;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Milk{" +
                "price=" + price +
                '}';
    }
}