/**
 * Esta clase se encarga de manejar todas las operaciones con la base de datos relacionadas con
 * el IMEC de la clase libro.
 * @author Esteban Rojas
 */

package ucr.ac.ecci.ci1322.laboratorio1.core.book.dao;

import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import java.sql.*;

public class JdbcBookService implements BookDao {

    public JdbcBookService(){

    }

    /** Abre una conexion con la base de datos que contiene la tabla Libro. Utiliza usuario y contraseña por defecto.
     *  Es responsabilidad de la función llamadora cerrar la conexión.
     * @return Una instancia de Connection, o null si no se pudo conectar con la base de datos.
     */
    public Connection abrirConexion()
    {
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

    /** Busca un libro en la base de datos
     *
     * @param id
     * @return Una instancia del libro correspondiente al id, o null si no existe.
     */
    public Book findById(String id){
        Book b = null;

        try {
            Connection conn = abrirConexion();

            if(conn != null) {
                Statement statement = conn.createStatement();

                ResultSet tupla = statement.executeQuery("SELECT * from LIBRO WHERE CODIGO = '" + id + "'");

                //Solo lee si la tupla no esta vacia
                if (tupla.next()) {
                    b = new Book(tupla.getString(1), tupla.getString(2), tupla.getString(3),
                            tupla.getString(4), tupla.getString(5), tupla.getString(6),
                            tupla.getString(7), tupla.getString(8));
                }

                conn.close();
            }
        }
        catch(Exception e)
        {
            System.out.println("Error: No se pudo realizar la busqueda.");
        }

        return b;
    }

    /**
     * Se encarga de crear un nuevo libro en la base de datos
     * @param entity La instancia del nuevo libro a crear
     */
    public String create(Book entity){
        String codigo = "";
        try {
            Connection conn = abrirConexion();

            if(conn != null) {
                Statement statement = conn.createStatement();

                statement.executeUpdate("INSERT INTO LIBRO(codigo,nombre,autor,editor,pais,lenguaje,detalles,propietario) VALUES " +
                        "('" + entity.getCodigo() + "','" + entity.getNombre() + "','" + entity.getAutor() + "','" + entity.getEditorial() +
                        "','" + entity.getPais() + "','" + entity.getIdioma() + "','" + entity.getDetalles() +
                        "','" + entity.getPropietario() + "')");

                conn.close();
                codigo = entity.getCodigo();
            }

        }
        catch(SQLException e)
        {
            System.out.println("Error: No se pudo agregar el libro.");
        }


        return codigo;
    }

    /**
     * Se encarga de actualizar un libro
     * @param entity Una instancia del libro a actualizar.
     */
    public void update(Book entity) {
        try
        {
            Connection conn = abrirConexion();

            if(conn != null)
            {
                Statement statement = conn.createStatement();

                statement.executeUpdate("UPDATE libro set nombre = '"+entity.getNombre()+"', autor = '"+entity.getAutor()+"'" +
                        ",editor = '"+entity.getEditorial()+", pais= '"+entity.getPais()+"', lenguaje= '"+entity.getIdioma()+"'" +
                        ", detalles= '"+entity.getDetalles()+"', propietario = '"+entity.getPropietario()+"''" +
                        "WHERE codigo = '"+entity.getCodigo()+"' ");

                conn.close();
            }
        }
        catch(SQLException e)
        {
            System.out.println("Errror: No se pudo actualizar los datos del libro.");
        }

    }

    /**
     * Se encarga de eliminar un libro de la base de datos
     * @param entity Una instancia del libro a eliminar.
     */
    public void remove(Book entity) {
        try
        {
            Connection conn = abrirConexion();

            if(conn != null)
            {
                Statement statement = conn.createStatement();
                statement.executeUpdate("DELETE FROM libro WHERE codigo = '"+entity.getCodigo()+"'");

                conn.close();
            }
        }
        catch(SQLException e)
        {

        }
    }
}
