package jsonModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EligibilityAnswers {

    @SerializedName("questionGuid")
    @Expose
    private String questionGuid;
    @SerializedName("questionText")
    @Expose
    private String questionText;
    @SerializedName("preferenceText")
    @Expose
    private Object preferenceText;
    @SerializedName("affirmationText")
    @Expose
    private String affirmationText;
    @SerializedName("negationText")
    @Expose
    private String negationText;
    @SerializedName("answer")
    @Expose
    private Object answer;
    @SerializedName("preferenceValue")
    @Expose
    private Object preferenceValue;

    public String getQuestionGuid() {
        return questionGuid;
    }

    public void setQuestionGuid(String questionGuid) {
        this.questionGuid = questionGuid;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public Object getPreferenceText() {
        return preferenceText;
    }

    public void setPreferenceText(Object preferenceText) {
        this.preferenceText = preferenceText;
    }

    public String getAffirmationText() {
        return affirmationText;
    }

    public void setAffirmationText(String affirmationText) {
        this.affirmationText = affirmationText;
    }

    public String getNegationText() {
        return negationText;
    }

    public void setNegationText(String negationText) {
        this.negationText = negationText;
    }

    public Object getAnswer() {
        return answer;
    }

    public void setAnswer(Object answer) {
        this.answer = answer;
    }

    public Object getPreferenceValue() {
        return preferenceValue;
    }

    public void setPreferenceValue(Object preferenceValue) {
        this.preferenceValue = preferenceValue;
    }

}