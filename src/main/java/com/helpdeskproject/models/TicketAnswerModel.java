package com.helpdeskproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "ticket_answers")
public class TicketAnswerModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long answers_id;
    
    @NotEmpty(message = "The ticket id is required.")
    @Size(min = 2, max = 100, message = "The length of ticket id must be between 2 and 20 characters.")
    @Column(nullable = false, length = 20)
    Long ticket_id;

    @NotEmpty(message = "The answer message is required.")
    @Size(min = 2, max = 100, message = "The length of answer message must be between 2 and 100 characters.")
    @Column(nullable = false, length = 40)
    String answers_message;

    @NotEmpty(message = "The answer author is required.")
    @Size(min = 2, max = 100, message = "The length of answer author must be between 2 and 255 characters.")
    @Column(nullable = false, length = 255)
    String answers_author;

    public Long getAnswerId() {
        return answers_id;
    }

    public void setAnswerId(Long answers_id) {
        this.answers_id = answers_id;
    }

    public Long getTicketId() {
        return ticket_id;
    }

    public void setTicketId(Long ticket_id) {
        this.ticket_id = ticket_id;
    }

    public String getAnswersMessage() {
        return answers_message;
    }

    public void setAnswerMessage(String answers_message) {
        this.answers_message = answers_message;
    }

    public String getAnswerAuthor() {
        return answers_author;
    }

    public void setAnswerAuthor(String answers_author) {
        this.answers_author = answers_author;
    }
}
