package cl.aldogallardo.micotizacion.data;

import java.util.ArrayList;
import java.util.List;

import cl.aldogallardo.micotizacion.models.Product;

/**
 * Created by Aldo Gallardo on 05-03-2017.
 */

public class Queries {

    public List<Product> allProducts()
    {

        List<Product> products = new ArrayList<>();
        List<Product> productList = Product.listAll(Product.class);
        if (productList != null && productList.size()>0){
            products.addAll(productList);
        }

        return products;
    }
}
