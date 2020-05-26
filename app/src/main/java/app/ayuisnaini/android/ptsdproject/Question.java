package app.ayuisnaini.android.ptsdproject;

public class Question {

    private String textQuestion;
    private String optYes;
    private String optNo;
    private Double valueYes;
    private String group;

    public Question(String textQuestion, String optYes, String optNo, String group, Double valueYes) {
        this.textQuestion = textQuestion;
        this.optYes = optYes;
        this.optNo = optNo;
        this.group = group;
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

    public Double getValueYes() {
        return valueYes;
    }

    public void setValueYes(Double valueYes) {
        this.valueYes = valueYes;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
