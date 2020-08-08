package com.alchuk.nerd_test_task.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rooms")
public class Room {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private long roomId;

    @OneToMany(targetEntity = Point.class)
    @JoinColumn(name = "roomId", referencedColumnName = "roomId")
    List<Point> pointList;



    public void setPointList(List<Point> pointList) {
        this.pointList = pointList;
    }

    public List<Point> getPointList() {
        return pointList;
    }
}
