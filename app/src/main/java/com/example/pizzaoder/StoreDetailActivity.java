package com.example.pizzaoder;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pizzaoder.databinding.ActivityStoreDetailBinding;
import android.databinding.DataBindingUtil;
import com.example.pizzaoder.datas.Stores;

public class StoreDetailActivity extends AppCompatActivity {

    ActivityStoreDetailBinding act;

    Stores mStoreData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        act = DataBindingUtil.setContentView(this,R.layout.activity_store__detail);

        mStoreData = (Stores) getIntent().getSerializableExtra("storeData");

        act.mstoreNameTxt.setText(mStoreData.storeName);
        act.mphoneNumberTxt.setText(mStoreData.phoneNumber);
        //act.mlogoImg.setImageResource(mStoreData.logoUrl);
        Glide.with(this).load(mStoreData.logoUrl).into(act.mlogoImg);
        //Toast.makeText(this, String.format("%s",mStoreData.storeName), Toast.LENGTH_SHORT).show();
    }
}
