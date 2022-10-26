package com.example.danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CONTACTS_ASK_PERMISSIONS = 1001;

    private Button btn_danhba;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControl();
        addEvent();

    }

    private void addEvent() {
        btn_danhba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XuLiManHinhDanhBa();
            }
        });
    }

    private void XuLiManHinhDanhBa() {
        Intent intent = new Intent(MainActivity.this,DanhBa.class);
        intent.setClassName("com.example.danhba","com.example.danhba.DanhBa");
        startActivity(intent);
    }

    private void addControl() {
        btn_danhba = findViewById(R.id.btn_ht_danhBa);
    }
}