package com.example.demo.repsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Interest;

public interface InterestRepostory extends JpaRepository<Interest, Long> {

}
