package com.alchuk.nerd_test_task.service;

import com.alchuk.nerd_test_task.model.Point;
import org.springframework.stereotype.Service;


@Service
public interface PointService {

    void addPoint(Point point);

    Point createPoint(String x, String y);

}
