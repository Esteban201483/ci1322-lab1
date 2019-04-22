package model;





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

    public String getCodigo(){return codigo;}
    public String getNombre(){return nombre;}
    public String getAutor(){return autor;}
    public String getEditorial(){return editorial;}
    public String getPais(){return pais;}
    public String getIdioma(){return idioma;}
    public String getDetalles(){return detalles;}
    public String getPropietario(){return propietario;}



}
