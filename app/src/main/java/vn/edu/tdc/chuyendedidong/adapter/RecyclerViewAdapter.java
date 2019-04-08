package vn.edu.tdc.chuyendedidong.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.List;

import vn.edu.tdc.chuyendedidong.R;
import vn.edu.tdc.chuyendedidong.data_models.Product;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Product> data;

    public RecyclerViewAdapter(Context context, List<Product> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.cardview_item_search_mh3, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
        // Cách format số double
        DecimalFormat decimalFormat = new DecimalFormat("0");
        String temp = decimalFormat.format(data.get(i).getPrice());
        myViewHolder.lblNameProduct.setText(data.get(i).getNameProduct()+"");
        myViewHolder.lblPrice.setText("Giá : " + temp);
        myViewHolder.imgProduct.setImageResource(data.get(i).getID_Image());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView lblNameProduct;
        TextView lblPrice;
        ImageView imgProduct;

        public MyViewHolder(View itemView) {
            super(itemView);

            lblNameProduct = (TextView) itemView.findViewById(R.id.lblNameProduct);
            lblPrice = (TextView) itemView.findViewById(R.id.lblPrice);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
        }
    }
}
