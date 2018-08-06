package com.myapplicationdev.android.p12mydatabook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String> {
    Context context;
    String[] items;
    int resource;
    ImageView iv;
    TextView tvTitle;

    public CustomAdapter(Context context, int resource, String[] items) {
        super(context, resource, items);
        this.context = context;
        this.items = items;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        //Match the UI components with Java variables
        String item = items[position];

        tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        iv = (ImageView) rowView.findViewById(R.id.iv);

        tvTitle.setText("" + item);

        //Check position to set images
        if (position == 0) {
            iv.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (position == 1) {
            iv.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (position == 2) {
            iv.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else {
            iv.setImageResource(android.R.drawable.btn_star_big_on);
        }

        return rowView;
    }
}
