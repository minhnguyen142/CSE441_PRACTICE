package com.hikari.ex13_4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static String[] arrayName = {"Ảnh 1", "Ảnh 2", "Ảnh 3"};
    public static int[] imageName = {R.drawable.img1, R.drawable.img2, R.drawable.img3};
    GridView gridViewDemo;

    MyArrayAdapter adapterDanhSach;
    ArrayList<Image> arrimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridViewDemo = (GridView) findViewById(R.id.grid1);
        arrimage = new ArrayList<Image>();

        adapterDanhSach = new MyArrayAdapter(MainActivity.this, R.layout.list_item, arrimage);
        gridViewDemo.setAdapter(adapterDanhSach);


        for (int i = 0; i < imageName.length; i++) {
            Image myimage = new Image();
            myimage.setName(arrayName[i]);
            myimage.setImg(imageName[i]);
            arrimage.add(myimage);

            adapterDanhSach.notifyDataSetChanged();
        }

        gridViewDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Intent intent1 = new Intent(MainActivity.this, SubActivity.class);

                Bundle bundle = new Bundle();
                bundle.putInt("TITLE", position);
                intent1.putExtras(bundle);
                startActivity(intent1);
            }
        });
    }
}