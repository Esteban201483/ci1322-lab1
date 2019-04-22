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


    /**
     * Crea una nueva instancia de un libro con todos sus atributos cargados con valores.
     * @param codigo Codigo del libro.
     * @param nombre Nombre del libro.
     * @param autor Autor del libro.
     * @param editorial Editorial del libro.
     * @param pais Pais del libro.
     * @param idioma Idioma del libro.
     * @param detalles Detalles del libro.
     * @param propietario Llave foranea: Identificación del estudiante que es dueño de este libro.
     */
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

    /**
     * Imprime en consola todos los atributos del libro
     */
    public void print()
    {
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.println("Autor: " + autor);
        System.out.println("Editorial: " + editorial);
        System.out.println("Pais: " + pais);
        System.out.println("Idioma: " + idioma);
        System.out.println("Detalles: " + detalles);
        System.out.println("Propietario: " + propietario);
    }



}
