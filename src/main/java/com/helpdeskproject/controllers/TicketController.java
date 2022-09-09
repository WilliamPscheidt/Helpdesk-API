package com.helpdeskproject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpdeskproject.models.TicketAnswerModel;
import com.helpdeskproject.models.TicketCreationModel;
import com.helpdeskproject.repository.TicketCreationRepository;
import com.helpdeskproject.utils.ResponseFormatter;

import static com.helpdeskproject.utils.TokenSecurity.VerifyEmailFromToken;

@RestController
public class TicketController {

    @Autowired
    TicketCreationRepository repository;
    
    @PostMapping(path = "/ticket/create")
    public ResponseEntity<String> SaveTicket(@Valid @RequestBody TicketCreationModel ticketCreationModel) {

        try{
            ticketCreationModel.setTicketAuthor(VerifyEmailFromToken(ticketCreationModel.getTicketAuthor()));
        } catch (Exception error) {
            return ResponseEntity.ok().body(ResponseFormatter.SendResponse("error", "Invalid Ticket Provided"));
        }

        try {
            repository.save(ticketCreationModel);
        } catch (Exception error) {
            return ResponseEntity.ok().body(ResponseFormatter.SendResponse("error", "Error in Data Insertion"));
        }

        return ResponseEntity.ok().body(ResponseFormatter.SendResponse("success", "Ticket Created"));
    }

    @PostMapping(path = "/ticket/addmessage")
    public ResponseEntity<String> AddMessage(@Valid @RequestBody TicketAnswerModel ticketAnswerModel) {

        return ResponseEntity.ok().body(ResponseFormatter.SendResponse("success", "Answer Added"));
    }

}
