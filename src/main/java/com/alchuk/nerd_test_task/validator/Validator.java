package com.alchuk.nerd_test_task.validator;

import com.alchuk.nerd_test_task.InvalidInputException;
import com.alchuk.nerd_test_task.model.Point;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public interface Validator {

    void validate(List<Point> pointList) throws InvalidInputException;
}
