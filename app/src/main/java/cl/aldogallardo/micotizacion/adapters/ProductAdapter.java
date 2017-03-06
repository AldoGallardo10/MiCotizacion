package cl.aldogallardo.micotizacion.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.aldogallardo.micotizacion.R;
import cl.aldogallardo.micotizacion.data.Queries;
import cl.aldogallardo.micotizacion.models.Product;

import static android.R.attr.id;

/**
 * Created by Aldo Gallardo on 02-03-2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder>{

    private List<Product> products = new Queries().allProducts();
    private ProductClickListener listener; //creamos la interface

    public ProductAdapter(ProductClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_product, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Product product = products.get(position);
        holder.name.setText(product.getName());
        holder.quantity.setText(String.valueOf(product.getQuantity()));
        holder.measurement.setText(product.getMeasurement());
        holder.price.setText(String.valueOf(product.getPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product auxProduct = products.get(holder.getAdapterPosition());
                listener.clickedId(auxProduct.getId());
            }
        });

        // code for remover list item swipe dismiss
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public void addProduct(Product product){
        products.add(product);
        notifyDataSetChanged();
    }

    public  void removeProduct( int pos){
        products.remove(pos);
        notifyItemRemoved(pos);
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        private  final TextView quantity,name,measurement,price;


        public ViewHolder(View itemView) {
            super(itemView);

            quantity = (TextView) itemView.findViewById(R.id.quantityTv);
            name = (TextView) itemView.findViewById(R.id.nameTv);
            measurement = (TextView) itemView.findViewById(R.id.measurementTv);
            price = (TextView) itemView.findViewById(R.id.priceTv);
        }
    }
}
