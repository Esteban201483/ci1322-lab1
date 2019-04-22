package ucr.ac.ecci.ci1322.laboratorio1.build;

import ucr.ac.ecci.ci1322.laboratorio1.core.book.dao.JdbcBookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;

import java.io.IOException;
import java.util.Scanner;

public class DataReader {

    /**
     * Lee un id del del usuario e imprime la información del libro correspondiente
     */
    public static void readId()
    {
        String id;
        System.out.println("Ingrese el ID del libro:");

        Scanner s = new Scanner(System.in);
        id = s.nextLine();

        BookServiceImpl servicioLibro = new BookServiceImpl();


        Book libro = servicioLibro.findById(id);

        if(libro != null)
            libro.print();
        else
            System.out.println("Error: El libro especificado no existe.");
    }

    public static void main(String args[])
    {
        readId();

    }
}
