package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Objects;

import androidx.appcompat.widget.Toolbar;


public class info extends AppCompatActivity {

    Toolbar toolbar_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        toolbar_info = findViewById(R.id.toolbar_article);
        toolbar_info.setTitle("Info");
        setSupportActionBar(toolbar_info);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}