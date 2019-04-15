package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public interface StudentDao
{
    Student findById(String id);

    String create(Student entity);

    void update(Student entity);

    void remove(Student entity);
    
}

