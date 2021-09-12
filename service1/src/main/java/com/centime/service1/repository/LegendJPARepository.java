package com.centime.service1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centime.service1.entity.Legend;

@Repository
public interface LegendJPARepository extends JpaRepository<Legend, Integer> {

}
