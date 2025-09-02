import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeCSV {
    public static void main(String[] args) {
        double promedio = calcularPromedioEdad("datos.csv");
System.out.println("Promedio de edad: " + promedio);
        String rutaArchivo = "datos.csv";
        int contadorNotasAltas = contarNotasAltas(rutaArchivo, 90);
System.out.println("Estudiantes con nota mayor o igual a 90: " + contadorNotasAltas);
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            // Saltar la primera línea (cabecera)
            
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




    

  public static double calcularPromedioEdad(String rutaArchivo) {
        int sumaEdades = 0;
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Saltar la primera línea (cabecera)
           
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 2) {
                    try {
                        int edad = Integer.parseInt(columnas[1].trim());
                        sumaEdades += edad;
                        contador++;
                    } catch (NumberFormatException e) {
                        // Ignorar si la edad no es un número válido
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return contador > 0 ? (double) sumaEdades / contador : 0.0;
    }





public static int contarNotasAltas(String rutaArchivo, double notaMinima) {
    
        int contador = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            // Saltar la primera línea (cabecera)
           
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] columnas = linea.split(",");
                if (columnas.length >= 3) {
                    try {
                        double nota = Double.parseDouble(columnas[2].trim());
                        if (nota >= notaMinima) {
                            contador++;
                        }
                    } catch (NumberFormatException e) {
                        // Ignorar si la nota no es un número válido
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }
        return contador;
    }
}
