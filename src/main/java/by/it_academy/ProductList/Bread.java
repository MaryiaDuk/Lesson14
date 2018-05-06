package by.it_academy.ProductList;

public class Bread implements Products{
final int price = 10;

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Bread{" +
                "price=" + price +
                '}';
    }
}