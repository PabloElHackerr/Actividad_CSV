import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeCSV {
    public static void main(String[] args) {
        String rutaArchivo = "datos.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                for (String celda : columnas) {
                    System.out.print(celda + "\t");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}
