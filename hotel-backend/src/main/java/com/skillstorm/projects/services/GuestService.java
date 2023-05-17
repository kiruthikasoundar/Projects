package com.skillstorm.projects.services;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skillstorm.projects.dtos.GuestDto;
import com.skillstorm.projects.models.Guest;
import com.skillstorm.projects.repositories.GuestRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GuestService {

	@Autowired
    private GuestRepository guestRepository;

    public GuestDto createGuest(GuestDto guestData) {
        Guest guest = new Guest(guestData.getId(), guestData.getName(), guestData.getEmail(), guestData.getPhoneNumber(), guestData.getAddress());
        return guestRepository.save(guest).toDto();
    }

    public List<GuestDto> getAllGuests() {
        return guestRepository.findAll()
        		.stream()
                .map(g -> g.toDto())
                .toList();
    }

    public GuestDto getGuestById(Long id) {
        return guestRepository.findById(id)
        		.orElseThrow()
        		.toDto();
    }

    public GuestDto updateGuest(Long id, GuestDto guestData) {
        Guest guest = guestRepository.findById(id)
                .orElseThrow();

        guest.setName(guestData.getName());
        guest.setEmail(guestData.getEmail());
        guest.setPhoneNumber(guestData.getPhoneNumber());
        guest.setAddress(guestData.getAddress());

        Guest updatedGuest = guestRepository.save(guest);
        return updatedGuest.toDto();
    }

    public void deleteGuest(Long id) {
        guestRepository.deleteById(id);
    }
}
