package com.example.vrzv.form;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button telepon,alamat,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telepon=(Button)findViewById(R.id.Telepon);
        alamat=(Button)findViewById(R.id.Alamat);
        email=(Button)findViewById(R.id.Email);
    }

    public void openPhone(View v){
        String phone = "082243935188";

        Uri uri = Uri.parse("tel:"+phone);
        Intent it = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(it);
    }

    public void openAddress(View v){
        Uri uri = Uri.parse("geo:-6.981900,110.252428?q="+Uri.encode("Perumahan Kaliwungu Indah"));
        Intent it = new Intent(Intent.ACTION_VIEW, uri);
        it.setPackage("com.google.android.apps.maps");
        startActivity(it);
    }

    public void openEmail(View v){
        Intent it = new Intent(Intent.ACTION_SEND);
        //startActivity(it);
        it.setType("text/plain");
        it.putExtra(Intent.EXTRA_EMAIL, new String[]{"vvo.knightforce@gmail.com"});
        it.putExtra(Intent.EXTRA_SUBJECT, "Mengirim Email");

        try {
            startActivity(Intent.createChooser(it, "Mengirimkan E-mail ?"));
        } catch (android.content.ActivityNotFoundException ex) {

        }

    }
}
