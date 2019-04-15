package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.BookDao;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

public class BookServiceImpl implements BookService
{
    private BookDao dao;

    BookServiceImpl()
    {

    }

    public Book findById(String id)
    {
        return dao.findById(id);
    }

    public String create(Book entity)
    {
        return dao.create(entity);
    }

    public void update(Book entity)
    {
        dao.update(entity);
    }

    public void remove(Book entity)
    {
        dao.remove(entity);
    }
}
