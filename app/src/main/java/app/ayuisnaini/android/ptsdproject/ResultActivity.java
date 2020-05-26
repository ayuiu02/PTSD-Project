package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity {

    private static double hasilDS = DempsterShafer.screeningDS();
    private static double hasilFT = FuzzyTsukamoto.screeningFT();
    TextView resultDS, resultFT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultDS = findViewById(R.id.hasilScreeningDS);
        resultFT = findViewById(R.id.hasilScreeningFT);

        DecimalFormat df = new DecimalFormat("#.##");

        String nilaiDS = String.valueOf(df.format(hasilDS));
        String nilaiFT = String.valueOf(df.format(hasilFT));

        resultDS.setText(nilaiDS);
        resultFT.setText(nilaiFT);
    }
}
