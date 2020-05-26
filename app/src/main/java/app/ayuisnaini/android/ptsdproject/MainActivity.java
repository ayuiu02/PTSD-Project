package app.ayuisnaini.android.ptsdproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

        Thread t = new Thread(){
            @Override
            public void run(){
                try{
                    while (!isInterrupted()){
                        Thread.sleep(1000);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textViewDate = findViewById(R.id.tvDate);
                                TextView textViewClock = findViewById(R.id.tvClock);
//                                long date = System .currentTimeMillis();
                                SimpleDateFormat forDate = new SimpleDateFormat("EEEE, dd MMMM yyyy");
                                SimpleDateFormat forClock = new SimpleDateFormat("HH:mm");
                                String currentDate = forDate.format(new Date());
                                String currentClock = forClock.format(new Date());
                                textViewDate.setText(currentDate);
                                textViewClock.setText(currentClock);
                            }
                        });
                    }
                } catch (InterruptedException e){}
            }
        };

        t.start();

        //Greeting
        TextView textViewGreeting = findViewById(R.id.tvGreeting);
        SimpleDateFormat forGreeting = new SimpleDateFormat("H");
        String currentGreeting = forGreeting.format(new Date());
        int hour = Integer.parseInt(currentGreeting);

        if (hour <= 11 && hour > 0 ){
            textViewGreeting.setText("Good Morning!");
        } else if (hour <= 14 && hour > 11 ){
            textViewGreeting.setText("Good Day!");
        } else if (hour <= 18 && hour >14){
            textViewGreeting.setText("Good Afternoon!");
        } else {
            textViewGreeting.setText("Good Evening!");
        }
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
