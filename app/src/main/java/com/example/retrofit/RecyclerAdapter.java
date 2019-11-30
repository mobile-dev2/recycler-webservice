package com.example.retrofit;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserVH> {

    private List<Data> dataList;

    private Context context;

    public RecyclerAdapter(Context context, List<Data> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public void setList(List<Data> dataList){
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new UserVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserVH holder, int position) {
        holder.setData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class UserVH extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView imgPhoto;
        TextView txtvName;

        public UserVH(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            txtvName = itemView.findViewById(R.id.txtName);
        }

        public void setData(Data data) {
            Glide.with(context).load(dataList.get(getAdapterPosition()).getAvatar()).into(imgPhoto);
            //Picasso.get().load(dataList.get(getAdapterPosition()).getAvatar()).into(imgPhoto);
            txtvName.setText(data.getFirst_name());
        }

        @Override
        public void onClick(View v) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("user", dataList.get(getAdapterPosition()));

            Intent intent = new Intent(context.getApplicationContext(), DetailActivity.class);
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }
}
