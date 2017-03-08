package com.oak.vaishnaviponna.oak_oneofakind;

/**
 * Created by Kartheeka on 3/6/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Belal on 2/23/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context context;
    private List<Upload> uploads;
    public String cemail;
    public String phoneno;
    public String username;

    public MyAdapter(Context context, List<Upload> uploads, String cemail,String phoneno,String username) {
        this.uploads = uploads;
        this.context = context;
        this.cemail= cemail;
        this.phoneno=phoneno;
        this.username=username;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {
        final Upload upload = uploads.get(position);



         //  holder.textViewName.setText(upload.getName());

            Glide.with(context).load(upload.getUrl()).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
              //  Toast.makeText(view.getContext(), "Recycle Click" + position, Toast.LENGTH_SHORT).show();

                        Intent i0 = new Intent(context.getApplicationContext(), Profile.class);
                        i0.putExtra("Email", upload.getEmail());
                        i0.putExtra("phoneno",upload.getPhoneno());
                        i0.putExtra("username",upload.getUsername());
                        i0.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        context.getApplicationContext().startActivity(i0);

            }
        });



    }
    @Override
    public int getItemCount() {
        return uploads.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewName;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
