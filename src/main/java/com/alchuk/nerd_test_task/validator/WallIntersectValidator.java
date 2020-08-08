package com.alchuk.nerd_test_task.validator;


import com.alchuk.nerd_test_task.InvalidInputException;
import com.alchuk.nerd_test_task.model.Point;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class WallIntersectValidator implements Validator {
    @Override
    public void validate(List<Point> pointList) throws InvalidInputException {
        int size = pointList.size();

        for(int i = 0; i < size; i++){
            Point p = pointList.get(i);
            Point q = i == size - 1 ? pointList.get(0) : pointList.get(i+1);

            for(int j = 0; j < size; j++){
                if(i != j){
                    Point p1 = pointList.get(j);
                    Point q1 = j == size - 1 ? pointList.get(0) : pointList.get(j+1);
                    if(!q.equals(p1) && !p.equals(q1) ){
                        if(checkIfIntersects(p, q, p1, q1)){
                            throw new InvalidInputException("Walls intersects");
                        }
                    }

                }
            }
        }


    }


    private boolean checkIfIntersects(Point p, Point q, Point p1, Point q1) {

        int a = (q.getY() - p.getY());
        int b = -(q.getX() - p.getX());
        int c = p.getY() * (q.getX() - p.getX()) - p.getX() * (q.getY() - p.getY());

        int a1 = (q1.getY() - p1.getY());
        int b1 = -(q1.getX() - p1.getX());
        int c1 = p1.getY() * (q1.getX() - p1.getX()) - p1.getX() * (q1.getY() - p1.getY());

        if (a == 0 && b1 == 0) {
            return checkBorders(p1, q1, p, q, a1, c1, b, c);


        }

        else if (a1 == 0 && b == 0) {
            return checkBorders(p, q, p1, q1, a, c, b1, c1);
        }




        return false;

    }

    private boolean checkBorders(Point p, Point q, Point p1, Point q1, int a, int c, int b1, int c1) {
        int kY = (-c1) / b1;
        int kX = (-c)/a;

        int biggerY = Math.max(p.getY(), q.getY());
        int biggerX = Math.max(p1.getX(), q1.getX());

        return biggerY > kY && biggerX == kX;
    }


}
