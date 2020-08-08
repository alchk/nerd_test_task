package com.alchuk.nerd_test_task.validator;

import com.alchuk.nerd_test_task.InvalidInputException;
import com.alchuk.nerd_test_task.model.Point;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class RightAnglesValidator implements Validator {
    @Override
    public void validate(List<Point> pointList) throws InvalidInputException {

        for(int i = 0; i < pointList.size(); i++){
            Point p1 = pointList.get(i);
            Point p2 = i == pointList.size()-1 ? pointList.get(0) : pointList.get(i+1);
            if(p1.getX() != p2.getX() && p1.getY() != p2.getY()){
                throw new InvalidInputException("Not all angles are right");
            }


        }

    }
}
