package com.alchuk.nerd_test_task.service;

import com.alchuk.nerd_test_task.model.Point;
import com.alchuk.nerd_test_task.model.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomService {

    void addRoom(Room room);


    List<Room> getAllRooms();
}
