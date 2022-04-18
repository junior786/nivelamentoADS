package com.desenvolvimento.nivelamento.service.implement;

import com.desenvolvimento.nivelamento.model.Guest;
import com.desenvolvimento.nivelamento.repository.GuestRepository;
import com.desenvolvimento.nivelamento.service.GuestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuestImpl implements GuestService {
    private final GuestRepository guestRepository;

    @Override
    public Guest save(Guest body) {
        return this.guestRepository.save(body);
    }

    @Override
    public void deleteGuest(Long id) {
        Guest guest = this.guestRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        this.guestRepository.delete(guest);
    }

    @Override
    public List<Guest> findAll() {
        return this.guestRepository.findAll();
    }
}
