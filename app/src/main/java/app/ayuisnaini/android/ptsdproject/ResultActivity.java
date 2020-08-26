package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    private static double hasilDS = DempsterShafer.screeningDS();
    private static double hasilFT = FuzzyTsukamoto.screeningFT();
    TextView resultDS, resultFT, recoDS, recoFT;
    Button backHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultDS = findViewById(R.id.hasilScreeningDS);
        resultFT = findViewById(R.id.hasilScreeningFT);
        recoDS = findViewById(R.id.recoScreeningDS);
        recoFT = findViewById(R.id.recoScreeningFT);
        backHome = findViewById(R.id.backHome);

        backHome.setOnClickListener(this);

        DecimalFormat df = new DecimalFormat("#.##");

        String nilaiDS = String.valueOf(df.format(hasilDS));
        String nilaiFT = String.valueOf(df.format(hasilFT));

        if (hasilDS < 52) {
            recoDS.setText("Berdasarkan hasil tes, kami tidak mendeteksi adanya gejala PTSD");
        } else {
            recoDS.setText("Berdasarkan hasil tes, kami menyarankan Anda untuk segera melakukan diagnosa lanjutan bersama tenaga profesional");
        }

        if (hasilFT < 52) {
            recoFT.setText("Berdasarkan hasil tes, kami tidak mendeteksi adanya gejala PTSD");
        } else {
            recoFT.setText("Berdasarkan hasil tes, kami menyarankan Anda untuk segera melakukan diagnosa lanjutan bersama tenaga profesional");
        }

        resultDS.setText(nilaiDS);
        resultFT.setText(nilaiFT);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
