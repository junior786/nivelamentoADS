package com.desenvolvimento.nivelamento.service;

import com.desenvolvimento.nivelamento.model.Guest;

import java.util.List;

public interface GuestService {
    Guest save(Guest body);

    void deleteGuest(Long id);

    List<Guest> findAll();

}
