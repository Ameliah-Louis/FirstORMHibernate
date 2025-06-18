package com.hb.cours.repository.interfaces;

import com.hb.cours.model.Student;

public interface StudentRepository extends GenericRepository<Student, Integer>{
    // hérite de findAll, findById, persist, update, delete
}
