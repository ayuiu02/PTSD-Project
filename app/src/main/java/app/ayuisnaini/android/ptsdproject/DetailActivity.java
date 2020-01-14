package app.ayuisnaini.android.ptsdproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    Toolbar toolbar_art;
    TextView postTitle, postAuthor, postSummary, postDate;
    ImageView postImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        toolbar_art = findViewById(R.id.toolbar_article);
        toolbar_art.setTitle("Article");

        setSupportActionBar(toolbar_art);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);

        postTitle = findViewById(R.id.dTitle);
        postAuthor = findViewById(R.id.dAuthor);
        postSummary = findViewById(R.id.dSummary);
        postDate = findViewById(R.id.dDate);
        postImage = findViewById(R.id.dImage);

        byte[] bytes = getIntent().getByteArrayExtra("image");
        String getTitle = getIntent().getStringExtra("title");
        String getAuthor = getIntent().getStringExtra("author");
        String getDate = getIntent().getStringExtra("date");
        String getSummary = getIntent().getStringExtra("summary");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);

        postTitle.setText(getTitle);
        postSummary.setText(getSummary);
        postAuthor.setText(getAuthor);
        postDate.setText(getDate);
        postImage.setImageBitmap(bmp);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
