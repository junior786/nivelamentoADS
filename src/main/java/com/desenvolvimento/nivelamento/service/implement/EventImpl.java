package com.desenvolvimento.nivelamento.service.implement;

import com.desenvolvimento.nivelamento.model.Event;
import com.desenvolvimento.nivelamento.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventImpl implements EventService {
    @Override
    public Event save(Event body) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Event> findAll() {
        return null;
    }
}
