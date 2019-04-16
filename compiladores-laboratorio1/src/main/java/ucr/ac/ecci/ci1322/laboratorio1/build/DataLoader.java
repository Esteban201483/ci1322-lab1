package ucr.ac.ecci.ci1322.laboratorio1.build;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookService;
import ucr.ac.ecci.ci1322.laboratorio1.core.book.service.BookServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentService;
import ucr.ac.ecci.ci1322.laboratorio1.core.student.service.StudentServiceImpl;
import ucr.ac.ecci.ci1322.laboratorio1.model.Book;
import ucr.ac.ecci.ci1322.laboratorio1.model.Student;

import java.io.FileInputStream;
import java.io.IOException;

public class DataLoader
{
    BookService servicioLibro;
    StudentService servicioEstudiante;

    public DataLoader() {

    }

    /**
     * Este método se encarga de tomar una hoja de cálculo, comprueba que tenga una hoja llamada Book y
     * empieza a leer los datos de prueba. Asume que la primer fila de la hoja se usa para listar los atributos
     * @param hoja
     * @return Un valor entero que indica si la operación se realizo exitosamente.
     */
    public int cargarLibro(HSSFSheet hoja){
        int resultado = 1;

        int indice = 1;
        HSSFRow fila = hoja.getRow(indice); //Omite la primer fila, que es donde estan los atributos.

        String codigo;
        String nombre;
        String autor;
        String editorial;
        String pais;
        String idioma;
        String detalles;
        String propietario;

        Book nuevoLibro;
        servicioLibro = new BookServiceImpl();

        while(fila != null)
        {
            //Extrae cada celda de la fila para poder crear una nueva instancia de libro.

            codigo = fila.getCell(0).getStringCellValue();
            nombre = fila.getCell(1).getStringCellValue();
            autor = fila.getCell(2).getStringCellValue();
            editorial = fila.getCell(3).getStringCellValue();
            pais = fila.getCell(4).getStringCellValue();
            idioma = fila.getCell(5).getStringCellValue();
            detalles = fila.getCell(6).getStringCellValue();
            propietario = fila.getCell(7).getStringCellValue();

            nuevoLibro = new Book(codigo,nombre,autor,editorial,pais,idioma,detalles,propietario);
            servicioLibro.create(nuevoLibro);

            //Recorre la próxima fila
            ++indice;
            fila = hoja.getRow(indice);

        }


        return resultado;
    }

    /**
     * Este método se encarga de tomar una hoja de cálculo, comprueba que tenga una hoja llamada Student y
     * empieza a leer los datos de prueba. Asume que la primer fila de la hoja se usa para listar los atributos
     * @param hoja
     * @return Un valor entero que indica si la operación se realizo exitosamente.
     */
    public int cargarEstudiante(HSSFSheet hoja){
        int resultado = 1;

        int indice = 1;
        HSSFRow fila = hoja.getRow(indice); //Omite la primer fila, que es donde estan los atributos.

        String id;
        String nombre;
        String ciudad;
        String telefono;
        String correo;
        String universidad;

        Student nuevoEstudiante;
        servicioEstudiante = new StudentServiceImpl();

        while(fila != null)
        {
            id = fila.getCell(0).getStringCellValue();
            nombre = fila.getCell(1).getStringCellValue();
            ciudad = fila.getCell(2).getStringCellValue();
            telefono = fila.getCell(3).getStringCellValue();
            correo = fila.getCell(4).getStringCellValue();
            universidad = fila.getCell(5).getStringCellValue();

            nuevoEstudiante = new Student(id,nombre,ciudad,telefono,correo,universidad);
            servicioEstudiante.create(nuevoEstudiante);

            //Avanza a la próxima fila
            ++indice;
            fila = hoja.getRow(indice);
        }



        return resultado;
    }

    /**
     * Método ejecutable sencargado de abrir una hoja de excel encontrada en el directorio main/resources
     * Luego, llama a los metodos cargarEstudiante y cargarLibro respectivamente.
     * @param nombre Corresponde al nombre de la hoja de calculo. Debe encontrarse en el directorio main/resources
     */
    public  void cargarHoja(String nombre)  throws IOException {

        FileInputStream entrada = null;

        try {

            entrada = new FileInputStream("../../resources/" + nombre);
            POIFSFileSystem pfs = new POIFSFileSystem(entrada);
            HSSFWorkbook wb = new HSSFWorkbook(pfs);

            HSSFSheet hojaLibros=  wb.getSheetAt(0);
            HSSFSheet hojaEstudiantes = wb.getSheetAt(1);

            cargarEstudiante(hojaEstudiantes);
            cargarEstudiante(hojaLibros);

        }
        finally{
            if(entrada != null)
                entrada.close();
        }


    }


}
