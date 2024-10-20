package com.example.btvd;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<Mycontact> {
    Context context;
    int layout;
    ArrayList<Mycontact> myListContact;
    public ContactAdapter(@NonNull Context context, int resource, ArrayList<Mycontact> lsContacts) {
        super(context, resource, lsContacts);
        this.context = context;
        this.layout = resource;
        this.myListContact = lsContacts;
    }

    public ContactAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return myListContact.size();
    }

    @Nullable
    @Override
    public Mycontact getItem(int position) {
        return myListContact.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if(currentView==null){
            //load layout item de hien thi du lieu
            currentView = LayoutInflater.from(context).inflate(layout,parent,false);
        }
        //lay ra doi tuong mycontact tai vi tri position
        Mycontact contact = getItem(position);
        TextView txtName = currentView.findViewById(R.id.txtname);
        TextView txtPhone = currentView.findViewById(R.id.txtphone);
        Button btnCall = currentView.findViewById(R.id.btnCall);
        Button btnSendtext = currentView.findViewById(R.id.btnSendtext);

        txtName.setText(contact.getName());
        txtPhone.setText(contact.getPhone());

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo
                Intent intentcall = new Intent(new Intent(Intent.ACTION_DIAL));
                intentcall.setData(Uri.parse("tel:"+contact.getPhone()));
                context.startActivity(intentcall);
            }
        });
        btnSendtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo

                Uri smsUri = Uri.parse("smsto:"+ contact.getPhone());
                Intent intentSms = new Intent(new Intent(Intent.ACTION_SENDTO,smsUri));
                intentSms.putExtra("sms_body", "hello,I'm in");
                context.startActivity(intentSms);
            }
        });
        //data Bind imageView
        assert contact!=null;
        return currentView;
    }
}
