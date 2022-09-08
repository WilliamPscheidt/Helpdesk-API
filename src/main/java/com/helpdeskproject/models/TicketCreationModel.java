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

    @Column(nullable = true, length = 40)
    String ticketTitle;

    @NotEmpty(message = "The message is required.")
    @Size(min = 2, max = 2000, message = "The length of message must be between 2 and 2000 characters.")
    @Column(nullable = false, length = 2000)
    String ticketMessage;

    @Column(nullable = true, length = 40)
    String ticketStatus;

    @NotEmpty(message = "The token is required")
    @Size(min = 2, max = 500, message = "The length of token must be between 2 and 500 characters.")
    @Column(nullable = false, length = 40)
    String ticketAuthor;

    public String getTicket_id () {
        return ticketTitle;
    }

    public void setTicket_id (Long ticket_id ) {
        this.ticket_id  = ticket_id ;
    }

    public String getTicketTitle() {
        return ticketTitle;
    }

    public void setTicketTitle(String ticketTitle) {
        this.ticketTitle = ticketTitle;
    }

    public String getTicketMessage() {
        return ticketMessage;
    }

    public void setTicketMessage(String ticketMessage) {
        this.ticketMessage = ticketMessage;
    }

    public String getTicketAuthor() {
        return ticketAuthor;
    }

    public void setTicketAuthor(String ticketAuthor) {
        this.ticketAuthor = ticketAuthor;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
