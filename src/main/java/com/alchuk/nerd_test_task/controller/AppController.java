package com.alchuk.nerd_test_task.controller;


import com.alchuk.nerd_test_task.InvalidInputException;
import com.alchuk.nerd_test_task.model.Point;
import com.alchuk.nerd_test_task.model.Room;
import com.alchuk.nerd_test_task.service.PointService;
import com.alchuk.nerd_test_task.service.RoomService;
import com.alchuk.nerd_test_task.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class AppController {

    @Autowired
    private List<Validator> validators;

    @Autowired
    private RoomService roomService;

    @Autowired
    private PointService pointService;





    @ExceptionHandler({InvalidInputException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<String> handleException(Exception e){

        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

    }





    @PostMapping("/validateRoom")
    @ResponseBody
    public Room validateRoom(@Validated @RequestBody Room room){
        List<Point> pointList = room.getPointList();
        if(pointList.size() < 4){
            throw new InvalidInputException("Room must have at least 4 corners");
        }
        validators.forEach(validator -> validator.validate(pointList));
        pointList.forEach(point -> pointService.addPoint(point));
        roomService.addRoom(room);
        return room;
    }

    @GetMapping("/getAllRooms")
    @ResponseBody
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();

    }





}
