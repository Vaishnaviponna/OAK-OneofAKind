package com.oak.vaishnaviponna.oak_oneofakind;

/**
 * Created by mukesh on 2/18/2017.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder>
{

    private Context mContext;
    private List<Album> albumList;
    private static AdapterView.OnItemClickListener onItemClickListener;
 //  public Earrings e;
    public BlankFragment fragment;


    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }




    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView title, count;
        public ImageView thumbnail, overflow;
        private List<Album> albumList;
       Context mContext;

        public MyViewHolder(View view) {
            super(view);

            title = (TextView) view.findViewById(R.id.title);
           count = (TextView) view.findViewById(R.id.count);
            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);
            this.albumList= albumList;
            this.mContext= mContext;
           // thumbnail= (ImageView) view.findViewById(R.id.card_view);

          //  overflow = (ImageView) view.findViewById(R.id.overflow);



        }

        @Override
        public void onClick(View view) {
            int position= getAdapterPosition();
            Album album= this.albumList.get(position);
            switch(position)
            {
                case 0:   Intent intent= new Intent(this.mContext,Designers_edit.class);
                    this.mContext.startActivity(intent);
                   // Toast.makeText(view.getContext(), "hih" + position, Toast.LENGTH_SHORT).show();
            }



        }
    }






    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        final Album album = albumList.get(position);
        holder.title.setText(album.getName());
     //   holder.count.setText(album.getNumOfSongs() + " items");

        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(view.getContext(), "Recycle Click" + position, Toast.LENGTH_SHORT).show();
                switch (position)
                {
                    case 0:
                        Intent i0= new Intent(mContext.getApplicationContext(), ShowWallpapers.class);
                        i0.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i0);
                        break;
                    case 1:
                        Intent i1= new Intent(mContext.getApplicationContext(), ShowFrames.class);
                        i1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i1);
                        break;
                    case 2:
                        Intent i2= new Intent(mContext.getApplicationContext(), ShowCreativestuff.class);
                        i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i2);
                        break;
                    case 3:
                        Intent i3= new Intent(mContext.getApplicationContext(), ShowNecklaces.class);
                        i3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i3);
                        break;
                    case 4:
                        Intent i4= new Intent(mContext.getApplicationContext(), ShowBangles.class);
                        i4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i4);
                        break;
                    case 5:
                        Intent i5= new Intent(mContext.getApplicationContext(), ShowEarrings.class);
                        i5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i5);
                        break;
                    case 6:
                        Intent i6= new Intent(mContext.getApplicationContext(), ShowBracelets.class);
                        i6.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i6);
                        break;
                    case 7:
                        Intent i7= new Intent(mContext.getApplicationContext(), ShowGreetingcards.class);
                        i7.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
                        mContext.getApplicationContext().startActivity(i7);
                        break;

                }
               // Intent i= new Intent( mContext,Designers_info.class);
               // mContext.startActivity(i);


            }
        });

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);

      /* holder.overflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showPopupMenu(holder.overflow);
            }
        });  */




    }





        /**
         * Showing popup menu when tapping on 3 dots
         */
  /*  private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_album, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    } */

    /**
     * Click listener for popup menu items
     */
    /* class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.action_add_favourite:
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.action_play_next:
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }  */







    @Override
    public int getItemCount() {
        return albumList.size();
    }



}

