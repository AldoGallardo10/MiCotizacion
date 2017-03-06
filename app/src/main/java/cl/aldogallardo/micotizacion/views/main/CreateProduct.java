package cl.aldogallardo.micotizacion.views.main;

import android.util.Log;

import cl.aldogallardo.micotizacion.models.Product;

import static android.content.ContentValues.TAG;

/**
 * Created by Aldo Gallardo on 03-03-2017.
 */

public class CreateProduct {

    private ProductCallback callback;

    public CreateProduct(ProductCallback callback) {
        this.callback = callback;
    }

    public void add(String name, String measurement, int price, int quantity){

        if (name.trim().length()<=0  ) {
            callback.emptyName();
        }else if(measurement.trim().length()<=0) {
            callback.emptyMeasurement();
        }else {
            Product product = new Product();
            product.setName(name);
            product.setMeasurement(measurement);
            product.setPrice(price);
            product.setQuantity(quantity);
            product.save();
            Log.i("save", "se a guardado el dato con exito");
            callback.createProduct(product);

        }


    }
}
