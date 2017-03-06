package cl.aldogallardo.micotizacion.views.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.aldogallardo.micotizacion.R;
import cl.aldogallardo.micotizacion.models.Product;

public class MainActivity extends AppCompatActivity implements ProductCallback {

    EditText nameEt,quantityEt,priceEt,measurementEt;
    String name,measurement;
    int quantity,price;
    Button btnAdd;

    private ProductListFragment productListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        productListFragment = (ProductListFragment) getSupportFragmentManager().findFragmentById(R.id.productListFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_add_product);
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

                btnAdd = (Button)dialog.findViewById(R.id.addBtn);

                btnAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        nameEt = (EditText) dialog.findViewById(R.id.nameEt);
                        quantityEt = (EditText) dialog.findViewById(R.id.quantityEt);
                        priceEt = (EditText) dialog.findViewById(R.id.priceEt);
                        measurementEt = (EditText) dialog.findViewById(R.id.measurementEt);

                        name = nameEt.getText().toString();
                        measurement = measurementEt.getText().toString();
                        quantity = Integer.parseInt(quantityEt.getText().toString());
                        price = Integer.parseInt(priceEt.getText().toString());

                        CreateProduct createProduct = new CreateProduct(MainActivity.this);
                        createProduct.add(name,measurement,price,quantity);
                        dialog.dismiss();
                    }
                });

                dialog.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if(id == R.id.action_info){

            messageInfo();
        }

        return super.onOptionsItemSelected(item);
    }

    public void messageInfo(){
        final Dialog dialogInfo = new Dialog(MainActivity.this);
        dialogInfo.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogInfo.setContentView(R.layout.dialog_info);
        dialogInfo.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialogInfo.show();
    }
    @Override
    public void createProduct(Product product) {
        productListFragment.addProduct(product);
    }


    @Override
    public void emptyName() {
        Toast.makeText(this, "campo nombre no debe estar vacio", Toast.LENGTH_SHORT).show();
    }


    @Override
    public void emptyMeasurement() {
        Toast.makeText(this, "su producto tiene que tener medidas", Toast.LENGTH_SHORT).show();
    }
}
