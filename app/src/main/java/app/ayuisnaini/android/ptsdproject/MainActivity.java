package app.ayuisnaini.android.ptsdproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.cardview.widget.CardView;

public class MainActivity extends Activity implements View.OnClickListener{

    private CardView articleCard, screeningCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        articleCard = findViewById(R.id.article);
        screeningCard = findViewById(R.id.screening);

        articleCard.setOnClickListener(this);
        screeningCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.article : i = new Intent(this, ArticleActivity.class); startActivity(i);
            break;

            case R.id.screening : i = new Intent(this, ScreeningActivity.class); startActivity(i);
            break;

            default:break;
        }
    }
}
