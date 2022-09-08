package com.helpdeskproject.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity(name = "tickets")
public class TicketCreationModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long ticket_id ;
    @NotEmpty(message = "The title is required.")
    @Size(min = 2, max = 2000, message = "The length of title must be between 2 and 50 characters.")
    @Column(nullable = false, length = 50)
    String ticket_title;

    @NotEmpty(message = "The message is required.")
    @Size(min = 2, max = 2000, message = "The length of message must be between 2 and 2000 characters.")
    @Column(nullable = false, length = 2000)
    String ticket_message;

    @NotEmpty(message = "The status is required.")
    @Size(min = 2, max = 2000, message = "The length of status must be between 2 and 40 characters.")
    @Column(nullable = false, length = 40)
    String ticket_status;

    @NotEmpty(message = "The tokenAutor is required")
    @Size(min = 2, max = 500, message = "The length of tokenAutor must be between 2 and 500 characters.")
    @Column(nullable = false, length = 40)
    String ticket_author;

    public Long getTicket_id () {
        return ticket_id;
    }

    public void setTicket_id (Long ticket_id ) {
        this.ticket_id  = ticket_id ;
    }

    public String getTicketTitle() {
        return ticket_title;
    }

    public void setTicketTitle(String ticket_title) {
        this.ticket_title = ticket_title;
    }

    public String getTicketMessage() {
        return ticket_message;
    }

    public void setTicketMessage(String ticket_message) {
        this.ticket_message = ticket_message;
    }

    public String getTicketStatus() {
        return ticket_status;
    }

    public void setTicketStatus(String ticket_status) {
        this.ticket_status = ticket_status;
    }

    public String getTicketAuthor() {
        return ticket_author;
    }

    public void setTicketAuthor(String ticket_author) {
        this.ticket_author = ticket_author;
    }

}
