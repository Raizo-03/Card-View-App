package com.example.cardviewapp;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

//This will be the adapter class
public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.SportsViewHolder> {

    private List<Sport> sportList;

    public MyCustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }

    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_item_layout,
                parent,
                false);


        return new SportsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {
        Sport sport = sportList.get(position);

        holder.imageView.setImageResource(sport.getSportImage());
        holder.title.setText(sport.getSportTitle());
        holder.description.setText(sport.getSportDescription());

        // Define gradient color pairs
        int[][] gradientColors = {
                {Color.parseColor("#FF5733"), Color.parseColor("#FFC300")},  // Orange to Yellow
                {Color.parseColor("#8E44AD"), Color.parseColor("#3498DB")},  // Purple to Blue
                {Color.parseColor("#1ABC9C"), Color.parseColor("#16A085")},  // Turquoise to Teal
                {Color.parseColor("#FF6F61"), Color.parseColor("#6B4226")},  // Coral to Brown
                {Color.parseColor("#F1C40F"), Color.parseColor("#E67E22")}   // Golden Yellow to Orange
        };

        // Select a gradient based on position (cyclical)
        int[] selectedColors = gradientColors[position % gradientColors.length];

        // Create a GradientDrawable programmatically
        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.BL_TR,  // Set gradient direction
                selectedColors                      // Pass the color array
        );
        gradientDrawable.setCornerRadius(40f);   // Set corner radius to match the card

        // Since CardView is the root of the layout, use holder.itemView to reference it directly
        CardView cardView = (CardView) holder.itemView;
        cardView.setBackground(gradientDrawable);

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }


    public static class SportsViewHolder extends RecyclerView.ViewHolder{
        //Holds the references of the views within the item layout
        ImageView imageView;
        TextView title, description;

        public SportsViewHolder(View view) {
            super(view);

            imageView = itemView.findViewById(R.id.imageViewCard);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
        }
    }


}
