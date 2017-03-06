package cl.aldogallardo.micotizacion.views.details;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import cl.aldogallardo.micotizacion.R;
import cl.aldogallardo.micotizacion.models.Product;
import cl.aldogallardo.micotizacion.views.main.MainActivity;

import static android.R.attr.name;
import static android.R.attr.pointerIcon;
import static cl.aldogallardo.micotizacion.R.id.nameTv;
import static cl.aldogallardo.micotizacion.R.id.pin;
import static cl.aldogallardo.micotizacion.R.id.quantityEt;
import static cl.aldogallardo.micotizacion.R.id.quantityTv;

public class DetailActivity extends AppCompatActivity {


    private Product product;
    EditText nameEt,quantityEt,measurementEt,priceEt;
    String name,measurement;
    int price,quantity;
    Button modifyBtn;
    long id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        id = getIntent().getLongExtra("id", 0);
        product = Product.findById(Product.class,id);
        setTitle("Editar");

        nameEt = (EditText) findViewById(R.id.nameDetailTv);
        quantityEt = (EditText) findViewById(R.id.quantityDetailTv);
        measurementEt = (EditText) findViewById(R.id.measurementDetailTv);
        priceEt = (EditText) findViewById(R.id.priceDetailTv);
        modifyBtn = (Button) findViewById(R.id.modifyBtn);

        name = product.getName().toString();
        measurement = product.getMeasurement().toString();
        quantity =  product.getQuantity();
        price = product.getPrice();

        nameEt.setText(name);
        quantityEt.setText(String.valueOf(quantity));
        measurementEt.setText(measurement);
        priceEt.setText(String.valueOf(price));

        modifyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.equals("")|| measurement.equals("") || price <= 0 || quantity <= 0) {
                    Toast.makeText(DetailActivity.this, "No deben haber campos vacidos y numeros negativos", Toast.LENGTH_SHORT).show();
                }else{
                    product.setName(nameEt.getText().toString());
                    product.setMeasurement(measurementEt.getText().toString());
                    product.setQuantity(Integer.parseInt(quantityEt.getText().toString()));
                    product.setPrice(Integer.parseInt(priceEt.getText().toString()));
                    product.save();
                    Toast.makeText(DetailActivity.this, "Datos Modificados", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(DetailActivity.this, MainActivity.class));
                }
            }
        });

    }


}
