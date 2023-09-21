package com.jpa.example.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.example.project.model.SignUpModel;
@Repository

public interface SignUpRepository extends JpaRepository<SignUpModel, String> {

}
