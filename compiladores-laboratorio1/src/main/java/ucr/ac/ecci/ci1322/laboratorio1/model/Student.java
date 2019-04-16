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

    public Student(String id, String nombre, String ciudad, String telefono, String correo, String universidad){
        this.id = id;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.telefono = telefono;
        this.correo = correo;
        this.universidad = universidad;
    }
}
