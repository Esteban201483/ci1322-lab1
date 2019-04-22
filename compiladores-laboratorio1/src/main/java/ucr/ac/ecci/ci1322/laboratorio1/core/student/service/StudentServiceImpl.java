package ucr.ac.ecci.ci1322.laboratorio1.core.student.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.JdbcStudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.dao.StudentDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

public class StudentServiceImpl implements StudentService
{
    private StudentDao dao;

    public StudentServiceImpl() {
        dao = new JdbcStudentService();
    }

    /** Llama al método del dao de estudiante encargado de buscar los datos de un estudiante
     *
     * @param id llave primaria del estudiante
     * @return
     */
    public Student findById(String id) {
        return dao.findById(id);
    }

    /**Llama al metodo del dao de estudiante encargado de crear un estudiante en la base de datos
     *
     * @param entity
     * @return
     */
    public String create(Student entity) {
        return  dao.create(entity);
    }

    /**Llama al método del dao de estudiante encargado de actualizar lso datos de un estudiante
     * @param entity  Instancia del estudiante a actualizar
     */
    public void update(Student entity) {
        dao.update(entity);
    }

    /**
     * Llama al método de estudiante encargado de eliminar un estudiante
     * @param entity Instancia del estudiante a eliminar
     */
    public void remove(Student entity) {
        dao.remove(entity);
    }
}
