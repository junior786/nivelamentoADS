package com.desenvolvimento.nivelamento.service.implement;

import com.desenvolvimento.nivelamento.model.Event;
import com.desenvolvimento.nivelamento.model.Guest;
import com.desenvolvimento.nivelamento.repository.EventRepository;
import com.desenvolvimento.nivelamento.repository.GuestRepository;
import com.desenvolvimento.nivelamento.service.EventService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EventImpl implements EventService {
    private final EventRepository eventRepository;
    private final GuestRepository guestRepository;

    @Override
    public Event save(Event body) {
        List<Guest> collect = body.getGuests().stream().map(x -> this.guestRepository.findById(x.getId())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND)))
                .collect(Collectors.toList());
        Event save = this.eventRepository.save(body);
        collect.forEach(x -> {
            x.getEvents().add(save);
            this.guestRepository.saveAll(collect);
        });
        return save;
    }

    @Override
    public void delete(Long id) {
        Event event = this.eventRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        event.getGuests().forEach(x -> {
            x.getEvents().remove(event);
            this.guestRepository.save(x);
        });

        this.eventRepository.delete(event);
    }

    @Override
    public List<Event> findAll() {
        return this.eventRepository.findAll();
    }
}
