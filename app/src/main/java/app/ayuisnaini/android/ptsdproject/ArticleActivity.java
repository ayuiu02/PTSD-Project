package app.ayuisnaini.android.ptsdproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

public class ArticleActivity extends AppCompatActivity {

    Toolbar toolbar_art;
    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        toolbar_art = findViewById(R.id.toolbar_article);
        toolbar_art.setTitle("Articles");
        setSupportActionBar(toolbar_art);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        mRecyclerView = findViewById(R.id.recycleView);
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("article");
    }

    private void firebaseSearch (String searchText){
        Query firebaseSearchQuery = mRef.orderByChild("title").startAt(searchText).endAt(searchText + "\uf8ff");

        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        firebaseSearchQuery
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {
                        viewHolder.setDetails(
                                getApplicationContext(),
                                model.getTitle(),
                                model.getSummary(),
                                model.getAuthor(),
                                model.getDate(),
                                model.getImage());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnClickListener(new ViewHolder.clickOnListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView postTitle = view.findViewById(R.id.rTitle);
                                TextView postAuthor = view.findViewById(R.id.rAuthor);
                                TextView postSummary = view.findViewById(R.id.rSummary);
                                TextView postDate = view.findViewById(R.id.rDate);
                                ImageView postImage = view.findViewById(R.id.rImage);

                                String Title = postTitle.getText().toString();
                                String Author = postAuthor.getText().toString();
                                String Summary = postSummary.getText().toString();
                                String Date = postDate.getText().toString();
                                Drawable drawable = postImage.getDrawable();
                                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

                                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte [] bytes = stream.toByteArray();

                                intent.putExtra("image", bytes);
                                intent.putExtra("title", Title);
                                intent.putExtra("summary", Summary);
                                intent.putExtra("date", Date);
                                intent.putExtra("author", Author);

                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        return viewHolder;
                    }
                };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Model, ViewHolder> firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Model, ViewHolder>(
                        Model.class,
                        R.layout.row,
                        ViewHolder.class,
                        mRef
                ) {
                    @Override
                    protected void populateViewHolder(ViewHolder viewHolder, Model model, int position) {

                        viewHolder.setDetails(
                                getApplicationContext(),
                                model.getTitle(),
                                model.getSummary(),
                                model.getAuthor(),
                                model.getDate(),
                                model.getImage());
                    }

                    @Override
                    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                        ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
                        viewHolder.setOnClickListener(new ViewHolder.clickOnListener() {
                            @Override
                            public void onItemClick(View view, int position) {
                                TextView postTitle = view.findViewById(R.id.rTitle);
                                TextView postAuthor = view.findViewById(R.id.rAuthor);
                                TextView postSummary = view.findViewById(R.id.rSummary);
                                TextView postDate = view.findViewById(R.id.rDate);
                                ImageView postImage = view.findViewById(R.id.rImage);

                                String Title = postTitle.getText().toString();
                                String Author = postAuthor.getText().toString();
                                String Summary = postSummary.getText().toString();
                                String Date = postDate.getText().toString();
                                Drawable drawable = postImage.getDrawable();
                                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();

                                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                                bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                                byte [] bytes = stream.toByteArray();

                                intent.putExtra("image", bytes);
                                intent.putExtra("title", Title);
                                intent.putExtra("summary", Summary);
                                intent.putExtra("date", Date);
                                intent.putExtra("author", Author);

                                startActivity(intent);
                            }

                            @Override
                            public void onItemLongClick(View view, int position) {

                            }
                        });
                        return viewHolder;
                    }
                };

        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                firebaseSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                firebaseSearch(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
}
