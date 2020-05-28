package com.example.tugasproject3;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Bangun Ruang");
    }

    public void setTitle(String title) {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextSize(20);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.colorAccent));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_name) {
            startActivity(new Intent(MainActivity.this, About.class));
        }
        return  super.onOptionsItemSelected(item);
    }

    public void goKerucut(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Ruang", "Kerucut");
        startActivity(i);
    }

    public void goBalok(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Ruang", "Balok");
        startActivity(i);
    }

    public void goPrismaSegilima(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Ruang", "Prisma Segilima");
        startActivity(i);
    }

    public void goLimasSegilima(View view) {
        Intent i = new Intent(MainActivity.this, Hitung.class);
        i.putExtra("Bangun Ruang", "Limas Segilima");
        startActivity(i);
    }

}
