package build;



import anotaciones.Entity;
import model.Student;

import java.lang.reflect.Field;

public class Lector {


    public static void main(String args[])
    {
        for(Field f: Student.class.getDeclaredFields())
        {
            Entity e = f.getAnnotation(Entity.class);
            System.out.println(f.getName());
            if (e != null)
                System.out.println(e.name());
        }



        //Imprime anotaciones de las clases
        Entity e = Student.class.getAnnotation(Entity.class);

        if(e != null)
            System.out.println(e.name());
    }
}
