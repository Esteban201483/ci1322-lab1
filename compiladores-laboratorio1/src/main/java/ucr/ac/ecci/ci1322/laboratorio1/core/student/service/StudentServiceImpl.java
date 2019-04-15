package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public class StudentServiceImpl implements StudentService
{
    private StudentDao dao;

    StudentServiceImpl()
    {

    }

    public Student findById(String id)
    {
        return dao.findById(id);
    }

    public String create(Student entity)
    {
        return  dao.create(entity);
    }

    public void update(Student entity)
    {
        dao.update(entity);
    }

    public void remove(Student entity)
    {
        dao.remove(entity);
    }
}
