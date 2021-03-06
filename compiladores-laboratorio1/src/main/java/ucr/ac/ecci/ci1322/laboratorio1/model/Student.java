package ucr.ac.ecci.ci1322.laboratorio1.model;

public class Student {

    String id;
    String nombre;
    String ciudad;
    String telefono;
    String correo;
    String universidad;

    public Student(){

    }

    /**
     *
     * @param id Identificacion del estudiante.
     * @param nombre Nombre del estudiante.
     * @param ciudad Ciudad del estudiante.
     * @param telefono Telefono del estudiante.
     * @param correo Correo del estudiante.
     * @param universidad Universidad del estudiante.
     */
    public Student(String id, String nombre, String ciudad, String telefono, String correo, String universidad){
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.universidad = universidad;
    }


    public String getId() {return id;}
    public String getNombre(){return nombre;}
    public String getCiudad(){return ciudad;}
    public String getTelefono() {return telefono;}
    public String getCorreo(){return correo;}
    public String getUniversidad() {return universidad;}
}
