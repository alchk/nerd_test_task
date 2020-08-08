package com.alchuk.nerd_test_task.service;

import com.alchuk.nerd_test_task.model.Point;
import com.alchuk.nerd_test_task.model.Room;
import com.alchuk.nerd_test_task.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {


    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void addRoom(Room room) {

        roomRepository.save(room);

    }

    @Override
    public Room createRoom(List<Point> pointList) {
        Room room = new Room();
        room.setPointList(pointList);
        return room;
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
}
