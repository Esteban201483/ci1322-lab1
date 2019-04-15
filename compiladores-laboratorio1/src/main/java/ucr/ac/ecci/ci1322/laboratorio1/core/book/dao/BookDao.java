package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

public interface BookDao
{
    Book findById(String id);

    String create(Book entity);

    void update(Book entity);

    void remove(Book entity);
}
