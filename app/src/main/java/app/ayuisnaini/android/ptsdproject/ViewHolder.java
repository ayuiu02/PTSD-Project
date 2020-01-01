package app.ayuisnaini.android.ptsdproject;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    View mView;

    public ViewHolder(View itemView) {
        super(itemView);

        mView = itemView;

    }

    public void setDetails(Context ctx, String title, String summary, String author, String date, String image){
        TextView mTitle = mView.findViewById(R.id.rTitle);
        TextView mSummary = mView.findViewById(R.id.rSummary);
        TextView mAuthor = mView.findViewById(R.id.rAuthor);
        TextView mDate = mView.findViewById(R.id.rDate);
        ImageView mImage = mView.findViewById(R.id.rImage);

        mTitle.setText(title);
        mSummary.setText(summary);
        mAuthor.setText(author);
        mDate.setText(date);
        Picasso.get().load(image).into(mImage);
    }
}
