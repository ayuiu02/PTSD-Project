package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {

    private static int hasilDS = DempsterShafer.screeningDS();
    private static  int hasilFT = FuzzyTsukamoto.screeningFT();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.d("Hasil Dempster Shafer", String.valueOf(hasilDS));
        Log.d("Hasil Fuzzy Tsukamoto", String.valueOf(hasilFT));
    }
}
