/**
 * Esta clase se encarga de manejar todas las operaciones con la base de datos relacionadas con
 * el IMEC de la clase estudiante..
 * @author Esteban Rojas
 */
package ucr.ac.ecci.ci1322.laboratorio1.core.student.dao;

import org.apache.poi.sl.draw.geom.SqrtExpression;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.sql.*;

public class JdbcStudentService implements StudentDao {

    public JdbcStudentService() {

    }

    /** Abre una conexion con la base de datos que contiene la tabla Estudiante. Utiliza usuario y contraseña por defecto.
     *  Es responsabilidad de la función llamadora cerrar la conexión.
     * @return Una instancia de Connection, o null si no se pudo conectar con la base de datos.
     */
    public Connection abrirConexion() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/ci1322_lab1";
            conn = DriverManager.getConnection(url, "root", "");
        }
        catch(Exception e)
        {
            System.out.println("Error: No se pudo realizar la conexión con la base de datos.");
        }

        return conn;
    }

    /**
     * Obtiene la instancia de un estudiante corresponde a la id indicada
     * @param id Identificación del estudiante
     * @return Instancia del estudiante correspondiente, o null si no existe
     */
    public Student findById(String id) {
        Student estudiante = null;

        try
        {
            Connection conn = abrirConexion();

            if(conn != null)
            {

                PreparedStatement statement = conn.prepareStatement("SELECT * from ESTUDIANTE WHERE ID = ?");
                statement.setString(1,id);

                ResultSet tupla = statement.executeQuery();

                //Solo lee si la tupla no esta vacia
                if (tupla.next()) {
                    estudiante = new Student(tupla.getString(1), tupla.getString(2), tupla.getString(3),
                            tupla.getString(4), tupla.getString(5), tupla.getString(6));
                }

                conn.close();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: No se pudo buscar el estudiante");
        }

        return estudiante;
    }

    /**
     * Esta función se encarga de crear un estudiante en la base de datos, en base a una instancia de estudiate
     * @param entity Instancia de estudiante
     * @return Id del estudiante; o cadena vacia si hubo un error
     */
    public String create(Student entity) {
        String id = "";
        try {

            Connection conn = abrirConexion();

            if(conn != null) {
                PreparedStatement statement = conn.prepareStatement("INSERT INTO ESTUDIANTE(ID,NOMBRE,CIUDAD,TELEFONO," +
                        "CORREO,UNIVERSIDAD) VALUES (?,?,?,?,?,?)");

                statement.setString(1,entity.getId());
                statement.setString(2,entity.getNombre());
                statement.setString(3,entity.getCiudad());
                statement.setString(4,entity.getTelefono());
                statement.setString(5,entity.getCorreo());
                statement.setString(6,entity.getUniversidad());

                if(statement.executeUpdate() > 0)
                    System.out.println("Se ha agregado el estudiante");


                conn.close();
                id = entity.getId();
            }

        }
        catch(SQLException e)
        {
            System.out.println("Error: No se pudo crear al estudiante.");
        }


        return id;
    }

    /**
     * Esta función se encarga de actualizar la información de un estudiante, basado en una instancia de estudiante
     * @param entity La instancia de estudiante
     */
    public void update(Student entity) {
        try
        {
            Connection conn = abrirConexion();

            if(conn != null)
            {
                PreparedStatement statement = conn.prepareStatement("UPDATE ESTUDIANTE SET NOMBRE = ?, CIUDAD = ?," +
                        "CORREO = ?, UNIVERSIDAD = ? WHERE ID = ?");


                statement.setString(1,entity.getNombre());
                statement.setString(2,entity.getCiudad());
                statement.setString(3,entity.getTelefono());
                statement.setString(4,entity.getCorreo());
                statement.setString(5,entity.getUniversidad());
                statement.setString(6,entity.getId());


                statement.execute();
                conn.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: No se pudo actualizar la información del estudiante");
        }
    }

    /**
     * Elimina un estudiante de la base de datos.
     * @param entity Instancia del estudiante a eliminar.
     */
    public void remove(Student entity) {
        try
        {
            Connection conn = abrirConexion();

            if(conn != null)
            {
                PreparedStatement statement = conn.prepareStatement("DELETE FROM ESTUDIANTE WHERE ID = ?");
                statement.setString(1, entity.getId());

                conn.close();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Error: No se pudo eliminar al estudiante");
        }

    }

}
