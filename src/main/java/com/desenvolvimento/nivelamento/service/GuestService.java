package com.desenvolvimento.nivelamento.service;

import com.desenvolvimento.nivelamento.model.Guest;

public interface GuestService {
    Guest save(Guest body);

    void deleteGuest(Long id);


}
