package tests.main.entity;

import com.framework.base.BrowserElements;
import org.openqa.selenium.NoSuchElementException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tests.main.pages.GamePage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GameObject {

    private static final Logger log = LoggerFactory.getLogger(GamePage.class.getName());

    private String name;
    private String price;
    private String discount;

    public GameObject(String name, String price, String discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String gameName) {
        this.name = gameName;
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

    public GameObject(BrowserElements name, BrowserElements price, BrowserElements discount) {
        String discountValue = null;
        if (discount != null) {
            try {
                discountValue = discount.getText();
            } catch (NoSuchElementException exception) {
                log.info("Game don't have discount: " + name.getText());
            }
        }
        log.info("Game object with name " + name.getText() + " price " + price.getText() + " discount " + discountValue + "parameters was create");
        this.name = name.getText();
        this.price = price.getText();
        this.discount = discountValue;
    }
}
