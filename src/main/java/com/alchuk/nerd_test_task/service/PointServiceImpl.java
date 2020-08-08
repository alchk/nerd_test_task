package com.alchuk.nerd_test_task.service;

import com.alchuk.nerd_test_task.model.Point;
import com.alchuk.nerd_test_task.repository.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService {


    @Autowired
    private PointRepository pointRepository;

    @Override
    public void addPoint(Point point) {
        pointRepository.save(point);

    }


}
