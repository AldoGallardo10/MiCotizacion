package cl.aldogallardo.micotizacion.views.main;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.aldogallardo.micotizacion.R;
import cl.aldogallardo.micotizacion.adapters.ProductAdapter;
import cl.aldogallardo.micotizacion.adapters.ProductClickListener;
import cl.aldogallardo.micotizacion.adapters.SwipeHelper;
import cl.aldogallardo.micotizacion.models.Product;
import cl.aldogallardo.micotizacion.views.details.DetailActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductListFragment extends Fragment implements ProductClickListener {

    private ProductAdapter adapter;

    public ProductListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.productRv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new ProductAdapter(this); // le pasamos el constructor del adapter porque contiene la interdace
        recyclerView.setAdapter(adapter);

        ItemTouchHelper.Callback callback = new SwipeHelper(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(recyclerView);

    }

    public void addProduct(Product product){
        adapter.addProduct(product);
    }



    @Override
    public void clickedId(long id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}
