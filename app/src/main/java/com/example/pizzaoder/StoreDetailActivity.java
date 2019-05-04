package com.example.pizzaoder;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.pizzaoder.databinding.ActivityStoreDetailBinding;
import android.databinding.DataBindingUtil;
import com.example.pizzaoder.datas.Stores;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.security.Permission;
import java.util.List;

public class StoreDetailActivity extends AppCompatActivity {

    ActivityStoreDetailBinding act;

    Stores mStoreData;
    String selectedSpinner;
    String selectedStoreName;

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


        act.menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedSpinner = act.menuspinner.getSelectedItem().toString();
                selectedStoreName = act.mstoreNameTxt.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("selectedSpinner",selectedSpinner);
                intent.putExtra("selectedStoreName",selectedStoreName);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        act.callImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Uri uri = Uri.parse(String.format("tel:%s", mStoreData.phoneNumber));
//                        Intent intent = new Intent(Intent.ACTION_CALL,uri);
//                        startActivity(intent);
                PermissionListener permissionListener = new PermissionListener() {
                    @Override
                    public void onPermissionGranted() {
                        Uri uri = Uri.parse(String.format("tel:%s", mStoreData.phoneNumber));
                        Intent intent = new Intent(Intent.ACTION_CALL,uri);
                        startActivity(intent);
                    }

                    @Override
                    public void onPermissionDenied(List<String> deniedPermissions) {
                        Toast.makeText(StoreDetailActivity.this, "전화 권한이 거부되어 통화에 실패했습니다.", Toast.LENGTH_SHORT).show();


                    }
                };
                TedPermission.with(StoreDetailActivity.this)
                        .setPermissionListener(permissionListener)
                        .setDeniedMessage("전화 권한을 거부하면 통화가 불가합니다. [설정]에서 활성화해주세요.")
                        .setPermissions(Manifest.permission.CALL_PHONE)
                        .check();
            }

        });
    }


}
