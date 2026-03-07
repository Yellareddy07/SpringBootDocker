package com.example.DockerSpringbootEx;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Studentjparepo extends JpaRepository<Student,Integer> {
}
