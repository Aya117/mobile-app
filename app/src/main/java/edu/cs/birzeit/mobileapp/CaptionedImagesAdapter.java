package edu.cs.birzeit.mobileapp;


import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
public class CaptionedImagesAdapter extends RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>{
    private String[] captions;
    private int[] imageIds;
    private String[]ScreenSize;
    private String[]operatingSystem;
    private String[]battery;
    private String[]Memory;
    private String[]weight;
    private String[]price;
    private Context context;

    public CaptionedImagesAdapter(String[] captions,int[] imageIds,String [] ScreenSize,
                                  String [] operatingSystem,String [] battery,String [] Memory,
                                  String [] weight,String [] price,Context context){

        this.captions = captions;
        this.imageIds = imageIds;
        this.ScreenSize=ScreenSize;
        this.operatingSystem=operatingSystem;
        this.battery=battery;
        this.Memory=Memory;
        this.weight=weight;
        this.price=price;
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.card_image, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        ImageView imageView = (ImageView) cardView.findViewById(R.id.image);
           Drawable dr = ContextCompat.getDrawable(cardView.getContext(), imageIds[position]);

          imageView.setImageDrawable(dr);

        TextView txt = (TextView)cardView.findViewById(R.id.txtName);
        txt.setText(captions[position]);

        cardView.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context,phonedet.class);
                intent.putExtra("s",ScreenSize[position]);
                intent.putExtra("o",operatingSystem[position]);
                intent.putExtra("b",battery[position]);
                intent.putExtra("m",Memory[position]);
                intent.putExtra("w",weight[position]);
                intent.putExtra("p",price[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return captions.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView cardView){
            super(cardView);
            this.cardView = cardView;
        }

    }
}