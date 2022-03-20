package quanghuu.example.donut.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import quanghuu.example.donut.R;
import quanghuu.example.donut.model.Donut;
import quanghuu.example.donut.secondActivity;

public class DonutAdapter extends RecyclerView.Adapter<DonutAdapter.viewHolder> {
    private Context context;
    private ArrayList<Donut> listDonut;
    private RecyclerViewClickListener recyclerViewClickListener;

    public DonutAdapter(Context context, ArrayList<Donut> listDonut,RecyclerViewClickListener recyclerViewClickListener) {
        this.context = context;
        this.listDonut = listDonut;
        this.recyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_donut,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Donut donut = listDonut.get(position);
        holder.image.setImageResource(donut.getImage());
        holder.title.setText(donut.getTitle());
        holder.detail.setText(donut.getDetail());
        holder.price.setText("$" + String.valueOf(donut.getPrice()));
        holder.btn_plus.setImageResource(R.drawable.plus_button);
    }

    @Override
    public int getItemCount() {
        return listDonut.size();
    }

    class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView image,btn_plus;
        TextView title,detail,price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image);
            title = itemView.findViewById(R.id.title);
            detail = itemView.findViewById(R.id.detail);
            price = itemView.findViewById(R.id.price);
            btn_plus = itemView.findViewById(R.id.btn_plus);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            recyclerViewClickListener.onClick(view,getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View view,int position);
    }
}
