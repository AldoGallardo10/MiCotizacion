package cl.aldogallardo.micotizacion.views.main;

import cl.aldogallardo.micotizacion.models.Product;

/**
 * Created by Aldo Gallardo on 03-03-2017.
 */

public interface ProductCallback {

    void createProduct(Product product);
    void emptyName();
    void emptyMeasurement();
}
