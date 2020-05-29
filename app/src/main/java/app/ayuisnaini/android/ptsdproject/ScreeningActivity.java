package app.ayuisnaini.android.ptsdproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class ScreeningActivity extends AppCompatActivity implements View.OnClickListener{

    Toolbar toolbar_scr;
    private TextView textQuestion, countQuestion;
    private Button optYes, optNo;
    private List<Question> questionList;
    private int numQuestion;
    private FirebaseFirestore firestore;
    private static ArrayList<Double> arrayDS = new ArrayList<>();
    private static ArrayList<Double> arrayFT = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening);

        toolbar_scr = findViewById(R.id.toolbarScreening);
        toolbar_scr.setTitle("Screening");
//        setSupportActionBar(toolbar_scr);
//        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        arrayDS.clear();
        arrayFT.clear();

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
                                doc.getString("group"),
                                Double.valueOf(doc.getString("valueYes"))
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
        numQuestion = 0;

        textQuestion.setText(questionList.get(numQuestion).getTextQuestion());
        optYes.setText(questionList.get(numQuestion).getOptYes());
        optNo.setText(questionList.get(numQuestion).getOptNo());

        countQuestion.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnYes:
                arrayDS.add(questionList.get(numQuestion).getValueYes());
                arrayFT.add(questionList.get(numQuestion).getValueYes());
                break;

            case R.id.btnNo:
                arrayFT.add(0.0);
                break;

            default:
        }

        changeQuestion();
        Log.d("ArrayDS", String.valueOf(arrayDS));
        Log.d("ArrayFT", String.valueOf(arrayFT));
    }

    private void changeQuestion() {
        if (numQuestion < questionList.size() - 1){

            numQuestion++;

            textQuestion.setText(questionList.get(numQuestion).getTextQuestion());
            optYes.setText(questionList.get(numQuestion).getOptYes());
            optNo.setText(questionList.get(numQuestion).getOptNo());

            countQuestion.setText(String.valueOf(numQuestion + 1) + "/" + String.valueOf(questionList.size()));

        } else {

            Intent intentMove = new Intent(this, ResultActivity.class);
            startActivity(intentMove);
            finish();

        }
    }

    public static ArrayList<Double> returnDataDS(){
        return (arrayDS);
    }

    public static ArrayList<Double> returnDataFT(){
        return (arrayFT);
    }

}
