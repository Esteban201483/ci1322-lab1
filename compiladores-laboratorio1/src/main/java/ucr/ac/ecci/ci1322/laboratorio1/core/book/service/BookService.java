package ucr.ac.ecci.ci1322.laboratorio1.core.book.service;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

public interface BookService
{
    Book findById(String id);

    String create(Book entity);

    void update(Book entity);

    void remove(Book entity);

}
