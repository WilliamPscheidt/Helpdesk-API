package com.helpdeskproject.repository;

import org.springframework.data.repository.CrudRepository;

import com.helpdeskproject.models.TicketCreationModel;

public interface TicketCreationRepository extends CrudRepository<TicketCreationModel, Integer> {
}