package app.ayuisnaini.android.ptsdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ScreeningActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar_scr;
    private TextView textQuestion, countQuestion;
    private Button optYes, optNo;
    private List<Question> questionList;
    private int numQuestion;
    private FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        toolbar_scr = findViewById(R.id.toolbarScreening);
        toolbar_scr.setTitle("Screening");
        setSupportActionBar(toolbar_scr);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        countQuestion = findViewById(R.id.qNumber);
        textQuestion = findViewById(R.id.qText);
        optYes = findViewById(R.id.btnYes);
        optNo = findViewById(R.id.btnNo);

        optYes.setOnClickListener(this);
        optNo.setOnClickListener(this);

        firestore = FirebaseFirestore.getInstance();
        
        getQuestionList();
    }

    private void getQuestionList() {
        questionList = new ArrayList<>();

        firestore.collection("PTSDProject").document("Screening")
                .collection("Question").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){
                    QuerySnapshot questions = task.getResult();

                    for (QueryDocumentSnapshot doc: questions){
                        questionList.add(new Question(doc.getString("textQuestion"),
                                doc.getString("optYes"),
                                doc.getString("optNo"),
                                Integer.valueOf(doc.getString("valueYes"))
                        ));
                    }

                    setQuestion();

                } else {
                    Toast.makeText(ScreeningActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void setQuestion() {
        textQuestion.setText(questionList.get(0).getTextQuestion());
        optYes.setText(questionList.get(0).getOptYes());
        optNo.setText(questionList.get(0).getOptNo());

        countQuestion.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));

        numQuestion = 0;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnYes:
                break;
            case R.id.btnNo:
                break;
            default:
        }

        changeQuestion();
    }

    private void changeQuestion() {
        if (numQuestion < questionList.size() - 1){

            numQuestion++;

            textQuestion.setText(questionList.get(numQuestion).getTextQuestion());
            optYes.setText(questionList.get(numQuestion).getOptYes());
            optNo.setText(questionList.get(numQuestion).getOptNo());

            countQuestion.setText(String.valueOf(numQuestion+1) + "/" + String.valueOf(questionList.size()));

        } else {

            Intent intent = new Intent(ScreeningActivity.this, ResultActivity.class);
            startActivity(intent);
            ScreeningActivity.this.finish();

        }
    }

}
