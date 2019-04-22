package model;


import anotaciones.Entity;

@Entity(name = "prueba")
//@Table(name = "student")
public class Student {

  //  @Id
 //   @Column(name = "id", length = 20)

    String id;

  //  @Column(name = "nombre", length = 20)
    String nombre;

 //   @Column(name = "ciudad", length = 20)
    String ciudad;

 //   @Column(name = "telefono", length = 20)
    String telefono;

 //   @Column(name = "correo", length = 20)
    String correo;

 //   @Column(name = "universidad", length = 20)
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

    public String getId() {return id;}
    public String getNombre(){return nombre;}
    public String getCiudad(){return ciudad;}
    public String getTelefono() {return telefono;}
    public String getCorreo(){return correo;}
    public String getUniversidad() {return universidad;}
}
