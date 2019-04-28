package com.example.pizzaoder.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pizzaoder.MainActivity;
import com.example.pizzaoder.R;
import com.example.pizzaoder.datas.Stores;

import java.util.List;

public class PizzarAdapter extends ArrayAdapter<Stores> {

    Context mContext;
    List<Stores> mList;
    LayoutInflater inf;

public PizzarAdapter(Context context, List<Stores> list){
  super(context, R.layout.list_item,list);

   mContext =context;
   mList = list;
   inf = LayoutInflater.from(mContext);
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row= convertView;

        if (row == null){
            row =inf.inflate(R.layout.list_item, null);
        }

        Stores storedata =mList.get(position);

       TextView storenameTxt = row.findViewById(R.id.storenameTxt);
       TextView openTimeTxt = row.findViewById(R.id.openTimeTxt);
       ImageView logoImg = row.findViewById(R.id.logoImg);

       storenameTxt.setText(storedata.storeName);
       openTimeTxt.setText(storedata.openTime);
       Glide.with(mContext).load(storedata.logoUrl).into(logoImg);

        return row;


    }
}
