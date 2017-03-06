package cl.aldogallardo.micotizacion.models;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Aldo Gallardo on 02-03-2017.
 */

public class Product extends SugarRecord implements Serializable {

    private String name, measurement;
    private int price, quantity;

    public Product() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
