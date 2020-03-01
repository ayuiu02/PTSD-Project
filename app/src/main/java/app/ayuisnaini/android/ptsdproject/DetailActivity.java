package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Objects;

import androidx.appcompat.widget.Toolbar;

public class DetailActivity extends AppCompatActivity {

    TextView mTitle, mAuthor, mSummary, mDate;
    ImageView mImage;
    Toolbar toolbar_art;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar_art = findViewById(R.id.toolbar_article);
        toolbar_art.setTitle("Articles");
        setSupportActionBar(toolbar_art);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        //inisialisasi views
        mTitle = findViewById(R.id.dTitle);
        mAuthor = findViewById(R.id.dAuthor);
        mSummary = findViewById(R.id.dSummary);
        mDate = findViewById(R.id.dDate);
        mImage = findViewById(R.id.dImage);

        //get data dari intent
        String getImage = getIntent().getStringExtra("image");
        String getTitle = getIntent().getStringExtra("title");
        String getAuthor = getIntent().getStringExtra("author");
        String getDate = getIntent().getStringExtra("date");
        String getSummary = getIntent().getStringExtra("summary");

        //set data di activity
        mTitle.setText(getTitle);
        mSummary.setText(getSummary);
        mAuthor.setText(getAuthor);
        mDate.setText(getDate);
        Picasso.get().load(getImage).into(mImage);
    }

    //@Override
    //public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return true;
//    }
}
