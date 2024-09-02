package Proyecto1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ManejoDeArchivos {
//código que lanza las excepciones :)

    public static String lectorDeArchivo(String ruta) {
        StringBuilder textoALeer = new StringBuilder();
        try (Scanner textoLeido = new Scanner(Path.of(ruta))) {
            while (textoLeido.hasNextLine()) {
                textoALeer.append(textoLeido.nextLine()).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("*** Lo siento usuario. No se pudo leer el archivo :( ***");
        }
        return textoALeer.toString();
    }

    public static void escribirArchivo(String ruta, String contenido) {
        Path path = Paths.get(ruta);
        try {
            Files.write(path, contenido.getBytes());
        } catch (IOException e) {
            System.err.println("*** Lo siento usuario. No se pudo escribir en el archivo :( ***");
        }
    }
}
