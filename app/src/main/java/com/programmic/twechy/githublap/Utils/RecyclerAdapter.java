package com.programmic.twechy.githublap.Utils;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.programmic.twechy.githublap.POJO_Models.Users.UserResponse;
import com.programmic.twechy.githublap.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private List<UserResponse> users;
    private Context context;

    public RecyclerAdapter(Context context, List<UserResponse> users){
        this.context=context.getApplicationContext();
        this.users=users;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        String BASE_API = "http://172.26.145.49:8080/twechy_app/users/";

        holder.name.setText(String.format("%s %s", users.get(position).getName(), users.get(position).getLastname()));
        holder.age.setText(String.valueOf(users.get(position).getAge()));
        holder.job.setText(users.get(position).getJob());
        Picasso.with(context).load(String.format("%s%s", BASE_API, users.get(position).getPath())).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        TextView name, age, job;
        ImageView image;

        MyViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.user_image);
            name = itemView.findViewById(R.id.user_name);
            age = itemView.findViewById(R.id.user_age);
            job = itemView.findViewById(R.id.user_job);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, name.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });


        }
    }
}
