package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class ScreeningActivity extends AppCompatActivity {

    Toolbar toolbar_scr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        toolbar_scr = findViewById(R.id.toolbarScreening);
        toolbar_scr.setTitle("Screening");
        setSupportActionBar(toolbar_scr);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}
