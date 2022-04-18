package com.desenvolvimento.nivelamento.Controller;

import com.desenvolvimento.nivelamento.model.Guest;
import com.desenvolvimento.nivelamento.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/guest")
@RequiredArgsConstructor
public class GuestController {
    private final GuestService guestService;

    @PostMapping
    public Guest createGuest(@Valid @RequestBody Guest guest) {
        System.out.println("BATEU");
        return this.guestService.save(guest);
    }

    @DeleteMapping("{id}")
    public void deleteGuest(@PathVariable Long id) {
        this.guestService.deleteGuest(id);
    }

    @GetMapping
    public List<Guest> findAll() {
        System.out.println("BATEU");
        return this.guestService.findAll();
    }
}
