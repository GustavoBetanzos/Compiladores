import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Betanzos Reyes Gustavo Noel
 * Clase principal que ejecuta el programa.
 * Lee la entrada desde un archivo de texto llamado "entrada.txt" y realiza el análisis léxico.
 */
public class Main {
    public static void main(String[] args) {
        // Asignar el nombre del archivo (se asume que está en la misma carpeta)
        String rutaArchivo = "entrada.txt";
        
        // Leer el contenido del archivo
        try {
            // Leer todo el archivo como una cadena
            String input = new String(Files.readAllBytes(Paths.get(rutaArchivo)));
            
            // Crear el lexer y analizar el contenido del archivo
            Lexer lexer = new Lexer(input);
            List<Token> tokens = lexer.analizar();
            
            // Imprimir los tokens obtenidos
            for (Token token : tokens) {
                System.out.println(token);
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}

