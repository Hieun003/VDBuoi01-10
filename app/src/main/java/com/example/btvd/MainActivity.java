package com.example.btvd;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvContact;
    ArrayList<Mycontact> lstContacts = new ArrayList<>();
    ContactAdapter contactAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initData();
        lvContact = findViewById(R.id.lvContact);
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.layout_iteam_contact,lstContacts);
        lvContact.setAdapter(contactAdapter);
    }

    private void initData(){
        lstContacts.add(new Mycontact(R.drawable.ic_launcher_background,"Mai", "032569874"));
        lstContacts.add(new Mycontact(R.drawable.ic_launcher_background,"Thuy", "032565874"));
        lstContacts.add(new Mycontact(R.drawable.ic_launcher_background,"Ha", "032569864"));
        lstContacts.add(new Mycontact(R.drawable.ic_launcher_background,"Hai", "032569774"));
    }
}