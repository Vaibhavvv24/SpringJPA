package com.example.crudfirst.dao;

import com.example.crudfirst.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository  //it acts as a component and helps in comp-scanning
public class StudentDaoimpl implements Studentdao{

    private EntityManager emanager;     //helps to connect with db
@Autowired
    public StudentDaoimpl(EntityManager em){            //injecting entity mangager using constructor injection
        this.emanager=em;
    }

    @Override
    @Transactional          //since it will take time
    public void save(Student student) {
    emanager.persist(student);
    }       //saving the student in the database .persist is a method of the emanager class

    @Override
    public Student getById(int id) {
        return emanager.find(Student.class,id);
    }       //getting student by id

    public List<Student> findAll(){
        TypedQuery<Student> query=emanager.createQuery("From Student",Student.class);       //quary like sql will get all students in db(we will use name of entity not name of table and also the attr of the class not the table)
        return query.getResultList();               //gets the list of all students from  the db
        //we can put any sql query just remember that while putting the qury we have to use the classname in java(entity) and the attributes should be the attr of the class not the attr of the table

    }
    public List<Student> findbyfirstName(String fname){
        TypedQuery<Student> query=emanager.createQuery("From Student where firstName=:theData",Student.class);
        query.setParameter("theData",fname);            //theData is a variable used in query so that we can dynamically set it using the setParameter method on the query and it is replaced by the value given by us
        return query.getResultList();
    }

    @Override
    @Transactional          //since we are changing the db
    public void updateStudent(Student s) {
        emanager.merge(s);          //merge the changes to db
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        Student s=emanager.find(Student.class,id);          //find student
        emanager.remove(s);     //delete it
    }

    @Override
    @Transactional
    public int deleteAll() {
        return emanager.createQuery("DELETE FROM Student").executeUpdate();       //this query will delete all students from the db and execute the update
    }


}
