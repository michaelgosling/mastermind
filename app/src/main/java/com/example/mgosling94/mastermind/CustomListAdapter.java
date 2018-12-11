package com.example.mgosling94.mastermind;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;


public class CustomListAdapter extends BaseAdapter {
    private static LayoutInflater inflater = null;
    private Peg[][] guessArray;
    private ColorStateList[] colors;
    private Context context;

    public CustomListAdapter(MainActivity mainActivity, Peg[][] guessArray, ColorStateList[] colors) {
        this.colors = colors;
        this.guessArray = guessArray;
        this.context = mainActivity;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return guessArray.length;
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
        rowView = inflater.inflate(R.layout.list_item, null);
        holder.cardPeg1 = rowView.findViewById(R.id.cardPeg1);
        holder.cardPeg2 = rowView.findViewById(R.id.cardPeg2);
        holder.cardPeg3 = rowView.findViewById(R.id.cardPeg3);
        holder.cardPeg4 = rowView.findViewById(R.id.cardPeg4);
        holder.cardKeyPeg1 = rowView.findViewById(R.id.cardKeyPeg1);
        holder.cardKeyPeg2 = rowView.findViewById(R.id.cardKeyPeg2);
        holder.cardKeyPeg3 = rowView.findViewById(R.id.cardKeyPeg3);
        holder.cardKeyPeg4 = rowView.findViewById(R.id.cardKeyPeg4);
        holder.cardPeg1.setImageTintList(getPegTint(guessArray[position][0].getColor()));
        holder.cardPeg2.setImageTintList(getPegTint(guessArray[position][1].getColor()));
        holder.cardPeg3.setImageTintList(getPegTint(guessArray[position][2].getColor()));
        holder.cardPeg4.setImageTintList(getPegTint(guessArray[position][3].getColor()));
        holder.cardKeyPeg1.setImageTintList(getPegTint(guessArray[position][4].getColor()));
        holder.cardKeyPeg2.setImageTintList(getPegTint(guessArray[position][5].getColor()));
        holder.cardKeyPeg3.setImageTintList(getPegTint(guessArray[position][6].getColor()));
        holder.cardKeyPeg4.setImageTintList(getPegTint(guessArray[position][7].getColor()));
        return rowView;
    }

    private ColorStateList getPegTint(Peg.PegColor pegColor) {
        ColorStateList color = null;
        switch (pegColor) {
            case White:
                color = ColorStateList.valueOf(Color.WHITE);
                break;
            case Black:
                color = ColorStateList.valueOf(Color.BLACK);
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