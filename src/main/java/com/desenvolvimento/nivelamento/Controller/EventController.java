package com.desenvolvimento.nivelamento.Controller;

import com.desenvolvimento.nivelamento.model.Event;
import com.desenvolvimento.nivelamento.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/event")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class EventController {
    private final EventService service;

    @PostMapping
    public Event createEvent(@RequestBody @Valid Event event) {
        return this.service.save(event);
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        this.service.delete(id);
    }

    @GetMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Event> findAll() {
        return this.service.findAll();
    }
}
