package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Book {

    String codigo;
    String nombre;
    String autor;
    String editorial;
    String pais;
    String idioma;
    String detalles;
    String propietario;

    public Book(String codigo, String nombre, String autor, String editorial, String pais, String idioma,
    String detalles, String propietario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.autor = autor;
        this.editorial = editorial;
        this.pais = pais;
        this.idioma = idioma;
        this.detalles = detalles;
        this.propietario = propietario;
    }

    public Book() {

    }
}
