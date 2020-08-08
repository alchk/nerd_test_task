package com.alchuk.nerd_test_task.repository;

import com.alchuk.nerd_test_task.model.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointRepository extends JpaRepository<Point, Long> {



}
