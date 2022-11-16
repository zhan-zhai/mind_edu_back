package application.controller.json_model;

import java.util.Date;

public class FinishedShort {
    private Long assignmentLongId;
    private String title;
    private String correct_answer;
    private String answer;
    private Date submit_time;

    public Date getSubmit_time() {
        return submit_time;
    }

    public void setSubmit_time(Date submit_time) {
        this.submit_time = submit_time;
    }

    public Long getAssignmentLongId() {
        return assignmentLongId;
    }

    public void setAssignmentLongId(Long assignmentLongId) {
        this.assignmentLongId = assignmentLongId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(String correct_answer) {
        this.correct_answer = correct_answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
