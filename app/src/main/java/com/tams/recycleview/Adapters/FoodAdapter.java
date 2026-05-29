package com.tams.recycleview.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tams.recycleview.Models.FoodModel;
import com.tams.recycleview.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.viewHolder> {

    ArrayList<FoodModel> arrlist;
    Context context;

    public FoodAdapter(ArrayList<FoodModel> arrlist, Context context){
        this.arrlist = arrlist;
        this.context = context;
    }

    @NonNull
    @Override
    public FoodAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // layoutinflater is used to convert sample_recycleview.xml into real view obj in memory
        View view = LayoutInflater.from(context).inflate(R.layout.sample_recyclerview, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodAdapter.viewHolder holder, int position) {
        // it is used to set values of data items we have taken, here we have
        // take imageview and Textview
        FoodModel model = arrlist.get(position);
        holder.imgviw.setImageResource(model.getImage());
        holder.txtview.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        // it is used to count the number of items available
        // in the list that is to get the size of list
        return arrlist.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView imgviw;
        TextView txtview;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imgviw = itemView.findViewById(R.id.imgviw);
            txtview = itemView.findViewById(R.id.txtview);
        }
    }

}
