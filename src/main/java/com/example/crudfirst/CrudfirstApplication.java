package com.example.crudfirst;

import com.example.crudfirst.dao.Studentdao;
import com.example.crudfirst.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudfirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudfirstApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(Studentdao sdao){	//executed after spring beans are loaded
		return runner->{
			//System.out.println("hello");
			//createStudents(sdao);
			//getStudent(sdao);
			//findAllStudents(sdao);
			//findbyFirst(sdao);
			 //UpdateStudent(sdao);
			//delete(sdao);
			deleteall(sdao);
		};
	}

	private void deleteall(Studentdao sdao) {
		int numrows=sdao.deleteAll();
		System.out.println(numrows);
	}

	private void delete(Studentdao sdao) {
		sdao.deleteStudent(3);

	}

	private void UpdateStudent(Studentdao sdao) {
		Student s=sdao.getById(1);		//findby id who we want to update
		s.setFirstName("Vebsterr");			//set first name
		sdao.updateStudent(s);			//update in db
		Student news=sdao.getById(1);		//fetch from db
		System.out.println(news);
	}

	private void findbyFirst(Studentdao sdao) {
		List<Student> list=sdao.findbyfirstName("vaibhav1");
		for (Student s: list){
			System.out.println(s);
		}

	}

	private void findAllStudents(Studentdao sdao) {
		List<Student> list=sdao.findAll();
		for (Student s: list){
			System.out.println(s);
		}
	}

	private void getStudent(Studentdao sdao) {
		System.out.println(sdao.getById(3));

	}

	private void createStudents(Studentdao sdao) {

		Student newStud=new Student("vaibhav","mittal5","mitt@gmail.com");
		//Student newStud2=new Student("vaibhav1","mittal1","mitt1@gmail.com");
		//Student newStud3=new Student("vaibhav2","mittal2","mitt2@gmail.com");



		sdao.save(newStud);
		//sdao.save(newStud2);
		//sdao.save(newStud3);

		System.out.println(newStud.getId());
	}

}
