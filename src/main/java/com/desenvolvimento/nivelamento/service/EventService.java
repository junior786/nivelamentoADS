package com.desenvolvimento.nivelamento.service;

import com.desenvolvimento.nivelamento.model.Event;

import java.util.List;

public interface EventService {
    Event save(Event body);

    void delete(Long id);

    List<Event> findAll();

}
