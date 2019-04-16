package ucr.ac.ecci.ci1322.laboratorio1;

import ucr.ac.ecci.ci1322.laboratorio1.build.DataLoader;

public class main {



    public static void main(String args[]){
        DataLoader loader = new DataLoader();
        loader.cargarHoja("Hoja.xlsx");
    }
}
