package com.alchuk.nerd_test_task.model;

import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table( name = "points")
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pointId;

    @Digits(integer = 4, fraction = 0, message = "Coordinates must be integers")
    @NotBlank
    @Column(name = "x_coord")
    private int x;

    @Digits(integer = 4, fraction = 0, message = "Coordinates must be integers")
    @NotBlank()
    @Column(name = "y_coord")
    private int y;


    public int getX() {
        return x;
    }

    public long getPointId() {
        return pointId;
    }

    public void setPointId(long pointId) {
        this.pointId = pointId;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x &&
                y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
