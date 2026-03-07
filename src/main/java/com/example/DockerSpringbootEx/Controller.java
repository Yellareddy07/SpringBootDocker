package com.example.DockerSpringbootEx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    Studentjparepo repo;
    @RequestMapping("/")
    public List<Student> getAllStudents(){
       /* return List.of(
             new Student("RAJU",1,20,"raju@gmail.com"),
             new Student("Ramesh",2,24,"ramesh@gmail.com"),
             new Student("Ajay",3,20,"raju@gmail.com")
        ); */

        return repo.findAll();
    }

    @RequestMapping("/addstudent")
    public void addStudent(){
        Student s=new Student();
        s.setName("SANJU");
        s.setAge(34);
        s.setEmail("DHWOEILDJKEWD");

        repo.save(s);
    }
}
