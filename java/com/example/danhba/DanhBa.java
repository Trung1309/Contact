package com.example.danhba;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.danhba.model.Contact;

import java.util.ArrayList;

public class DanhBa extends AppCompatActivity {

    private static final int REQUEST_CODE_ASK_PERMISSIONS = 1001;

    private ListView listView;
    private ArrayList<Contact> dsDanhBa;
    private ArrayAdapter<Contact> adapterDanhBa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danh_ba);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        addControl();
        showAllContactFromDevice();

    }

    private void addControl() {
        listView = findViewById(R.id.lv_danhBa);
        dsDanhBa = new ArrayList<>();
        adapterDanhBa = new ArrayAdapter<>(DanhBa.this, android.R.layout.simple_list_item_1,dsDanhBa);
        listView.setAdapter(adapterDanhBa);
    }


    private void showAllContactFromDevice() {

        Uri uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri,null,null,null,null);

        dsDanhBa.clear();

        while (cursor.moveToNext()){
            String tenname = ContactsContract.Contacts.DISPLAY_NAME;
            String tenphone = ContactsContract.CommonDataKinds.Phone.NUMBER;

            int VitriName = cursor.getColumnIndex(tenname);
            int ViTriPhone = cursor.getColumnIndex(tenphone);

            String name = cursor.getString(VitriName);
            String phone = cursor.getString(ViTriPhone);

            Contact contact = new Contact(name,phone);
            dsDanhBa.add(contact);
            adapterDanhBa.notifyDataSetChanged();
        }
    }
}