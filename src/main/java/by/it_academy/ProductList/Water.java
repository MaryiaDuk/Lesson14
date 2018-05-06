package by.it_academy.ProductList;

public class Water implements Products {
    final int price = 5;

    @Override
    public int getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return "Water{" +
                "price=" + price +
                '}';
    }
}
