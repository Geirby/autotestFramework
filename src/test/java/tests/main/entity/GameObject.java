package tests.main.entity;

import java.util.Objects;

public class GameObject {

    private String name;
    private String price;
    private String discount;

    public GameObject(String gamesName, String price, String discount) {
        this.name = gamesName;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setGamesName(String gamesName) {
        this.name = gamesName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameObject that = (GameObject) o;
        return Objects.equals(name, that.name) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, discount);
    }
}
