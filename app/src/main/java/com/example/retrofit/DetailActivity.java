package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView txtNameDetail;
    Data data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtNameDetail = findViewById(R.id.txtNameDetail);

        Bundle bundle = getIntent().getExtras();

        if(bundle != null){
            data = (Data) bundle.getSerializable("user");

            txtNameDetail.setText(data.getFirst_name());
        }
    }
}
