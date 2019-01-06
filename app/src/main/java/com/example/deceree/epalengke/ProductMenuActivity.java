package com.example.deceree.epalengke;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductMenuActivity extends AppCompatActivity {

    GridView gridView;

    String[] chicken = {"Leg","Whole","Wing","Thigh"};
    int[] chickenImages = {R.drawable.leg,R.drawable.thigh_part,R.drawable.whole,R.drawable.wing};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_menu);

        gridView = findViewById(R.id.gridview);

        CustomAdapter customAdapter = new CustomAdapter();
        gridView.setAdapter(customAdapter);

    }
    private class CustomAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return(chickenImages.length);
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View view1 = getLayoutInflater().inflate(R.layout.row_data,null);
            //getting view in row_data
            TextView name = view1.findViewById(R.id.txtMeat);
            ImageView image = view1.findViewById(R.id.images);

            name.setText(chicken[i]);
            image.setImageResource(chickenImages[i]);
            return view1;



        }
    }

}
