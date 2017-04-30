package alvi17.eidrecipe.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import alvi17.eidrecipe.DBHelper;
import alvi17.eidrecipe.R;
import alvi17.eidrecipe.RecipeDetailsActivity;

/**
 * Created by User on 4/21/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    static String TAG="CustomAdapter";

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_item_layout, parent, false);



        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, int position) {
        holder.getTextView().setText(recipeNames[holder.getAdapterPosition()]);
        holder.imageView.setImageResource(images[holder.getAdapterPosition()]);

        int status=dbHelper.getSaveValue(holder.getAdapterPosition());
        Log.e("CustomAdapter",status+" "+holder.getAdapterPosition());
        if(status==1)
        {
            holder.visited_image.setVisibility(View.VISIBLE);
        }
        else
        {
            holder.visited_image.setVisibility(View.GONE);
        }

        int rating=dbHelper.getRatingValue(holder.getAdapterPosition());
        holder.ratingBar.setRating(rating);

        holder.reciep_OrderText.setText(num_orders[holder.getAdapterPosition()]);
    }

    @Override
    public int getItemCount() {
        return recipeNames.length;
    }

    static Context context;
    String[] recipeNames,num_orders;
    Integer[] images;
    static ArrayList<String> visited;
    static DBHelper dbHelper;

    public CustomAdapter(Context context,String[] names,Integer[] images)
    {
        this.context=context;
        this.recipeNames=names;
        this.images=images;
        num_orders=context.getResources().getStringArray(R.array.recipe_order);
        dbHelper=new DBHelper(context);

    }


    public static Context getContext()
    {
        return  context;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,reciep_OrderText;
        ImageView imageView,visited_image;
        RatingBar ratingBar;

        public ViewHolder(View v) {
            super(v);
            // Define click listener for the ViewHolder's View.
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e(TAG, "Element " + getAdapterPosition() + " clicked. "+textView.getText());
                    Intent intent=new Intent(getContext(), RecipeDetailsActivity.class);
                    intent.putExtra("Position",getAdapterPosition());
                    getContext().startActivity(intent);
                }
            });

            textView = (TextView) v.findViewById(R.id.recipe_text_list);
            reciep_OrderText=(TextView)v.findViewById(R.id.recipe_order);
            imageView=(ImageView) v.findViewById(R.id.receipe_image_list);
            visited_image=(ImageView)v.findViewById(R.id.doneimage);
            ratingBar=(RatingBar)v.findViewById(R.id.item_rating_mainpage);

        }

        public TextView getTextView() {
            return textView;
        }

        public int getPositionofItem()
        {
            return  getAdapterPosition();
        }
    }
}
