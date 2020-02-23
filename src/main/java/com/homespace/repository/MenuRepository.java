package com.homespace.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homespace.domain.Answer;
import com.homespace.domain.Menu;

public interface MenuRepository extends JpaRepository<Menu, Long> {



}
