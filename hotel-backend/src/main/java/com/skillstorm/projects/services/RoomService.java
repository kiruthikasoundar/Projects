package com.skillstorm.projects.services;

import com.skillstorm.projects.dtos.RoomDto;
import com.skillstorm.projects.models.Room;
import com.skillstorm.projects.repositories.RoomRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class RoomService {

	@Autowired
    private RoomRepository roomRepository;

    public RoomDto createRoom(RoomDto roomData) {
        Room room = new Room(roomData.getId(), roomData.getRoomType(), roomData.getRoomNumber(), roomData.getNightlyRate());
        return roomRepository.save(room).toDto();
    }

    public List<RoomDto> getAllRooms() {
        return roomRepository.findAll()
                .stream()
                .map(Room::toDto)
                .toList();
    }

    public RoomDto getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow()
                .toDto();
    }

    public RoomDto updateRoom(Long id, RoomDto roomData) {
    	Room room = new Room(roomData.getId(), roomData.getRoomType(), roomData.getRoomNumber(), roomData.getNightlyRate());
        return roomRepository.save(room).toDto();
    }

    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}

