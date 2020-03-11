package app.ayuisnaini.android.ptsdproject;

import android.content.Intent;

public class Question {

    String textQuestion;
    String optYes;
    String optNo;
    Integer valueYes;

    public Question(String textQuestion, String optYes, String optNo, Integer valueYes) {
        this.textQuestion = textQuestion;
        this.optYes = optYes;
        this.optNo = optNo;
        this.valueYes = valueYes;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getOptYes() {
        return optYes;
    }

    public void setOptYes(String optYes) {
        this.optYes = optYes;
    }

    public String getOptNo() {
        return optNo;
    }

    public void setOptNo(String optNo) {
        this.optNo = optNo;
    }

    public Integer getValueYes() {
        return valueYes;
    }

    public void setValueYes(Integer valueYes) {
        this.valueYes = valueYes;
    }
}
