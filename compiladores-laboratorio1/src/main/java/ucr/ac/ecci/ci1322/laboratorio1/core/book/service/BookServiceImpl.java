package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

public class BookServiceImpl implements BookService
{
    private BookDao dao;

    /**
     * Crea una nueva instancia del dao
     */
    public BookServiceImpl()
    {
        dao = new JdbcBookService();
    }

    /**
     * Devuelve un estudiante de acuerdo con la identificacion proporcionada
     * @param id
     * @return La instancia del estudiante o null si el estudiante no existe
     */
    public Book findById(String id)

    {
        return dao.findById(id);
    }

    /**
     * Crea un nuevo estudiante en la base de Datos
     * @param entity Instancia del estudiante a crear
     * @return La identificacion del estudiante creado
     */
    public String create(Book entity)
    {

        return dao.create(entity);
    }

    /**
     * Actualiza los datos de un estudiante en la base de datos
     * @param entity Instancia del estudiante con sus datos nuevos
     */
    public void update(Book entity)
    {

        dao.update(entity);
    }

    /**
     * Elimina un estudiante de la base de datos
     * @param entity Instancia del estudiante a eliminar
     */
    public void remove(Book entity)
    {
        dao.remove(entity);
    }
}
