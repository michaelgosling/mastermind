package com.example.mgosling94.mastermind;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.List;

import static com.example.mgosling94.mastermind.R.id;
import static com.example.mgosling94.mastermind.R.layout;


public class CustomListAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private List<Peg[]> guessArray;
    private ColorStateList[] colors;
    private Context context;

    public CustomListAdapter(MainActivity mainActivity, List<Peg[]> guessArray, ColorStateList[] colors) {
        this.colors = colors;
        this.guessArray = guessArray;
        this.context = mainActivity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return guessArray.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder = new Holder();
        View rowView;
        rowView = inflater.inflate(layout.list_item, null);
        holder.cardPeg1 = rowView.findViewById(id.cardPeg1);
        holder.cardPeg2 = rowView.findViewById(id.cardPeg2);
        holder.cardPeg3 = rowView.findViewById(id.cardPeg3);
        holder.cardPeg4 = rowView.findViewById(id.cardPeg4);
        holder.cardKeyPeg1 = rowView.findViewById(id.cardKeyPeg1);
        holder.cardKeyPeg2 = rowView.findViewById(id.cardKeyPeg2);
        holder.cardKeyPeg3 = rowView.findViewById(id.cardKeyPeg3);
        holder.cardKeyPeg4 = rowView.findViewById(id.cardKeyPeg4);
        holder.cardPeg1.setImageTintList(getPegTint(guessArray.get(position)[0].getColor()));
        holder.cardPeg2.setImageTintList(getPegTint(guessArray.get(position)[1].getColor()));
        holder.cardPeg3.setImageTintList(getPegTint(guessArray.get(position)[2].getColor()));
        holder.cardPeg4.setImageTintList(getPegTint(guessArray.get(position)[3].getColor()));
        holder.cardKeyPeg1.setImageTintList(getPegTint(guessArray.get(position)[4].getColor()));
        holder.cardKeyPeg2.setImageTintList(getPegTint(guessArray.get(position)[5].getColor()));
        holder.cardKeyPeg3.setImageTintList(getPegTint(guessArray.get(position)[6].getColor()));
        holder.cardKeyPeg4.setImageTintList(getPegTint(guessArray.get(position)[7].getColor()));
        return rowView;
    }

    private ColorStateList getPegTint(Peg.PegColor pegColor) {
        ColorStateList color = null;
        switch (pegColor) {
            case White:
                color = colors[6];
                break;
            case Black:
                color = colors[7];
                break;
            case Color1:
                color = colors[0];
                break;
            case Color2:
                color = colors[1];
                break;
            case Color3:
                color = colors[2];
                break;
            case Color4:
                color = colors[3];
                break;
            case Color5:
                color = colors[4];
                break;
            case Color6:
                color = colors[5];
                break;
        }
        return color;
    }

    public class Holder {
        ImageView cardPeg1, cardPeg2, cardPeg3, cardPeg4, cardKeyPeg1, cardKeyPeg2, cardKeyPeg3, cardKeyPeg4;
    }


}