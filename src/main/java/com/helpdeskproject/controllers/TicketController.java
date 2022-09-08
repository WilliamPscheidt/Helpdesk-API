package com.helpdeskproject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.helpdeskproject.models.TicketCreationModel;
import com.helpdeskproject.repository.TicketCreationRepository;
import com.helpdeskproject.utils.ResponseFormatter;

@RestController
public class TicketController {

    @Autowired
    TicketCreationRepository repository;
    
    @PostMapping(path = "/ticket/create")
    public ResponseEntity<String> SaveTicket(@Valid @RequestBody TicketCreationModel ticketCreationModel) {

        repository.save(ticketCreationModel);

        return ResponseEntity.ok().body(ResponseFormatter.SendResponse("success", "Ticket Created"));
    }
}
