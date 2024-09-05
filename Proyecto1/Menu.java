package Proyecto1;
import java.util.Scanner;
public class Menu {


    public void desplegarMenu() {
        Scanner scanner = new Scanner(System.in);


        int opcion;

        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("*************  Hola usuario :)  *************");
        System.out.println("************* Bienvenido al Menú ************");
        System.out.println("*********************************************");
        System.out.println("*********************************************");
        System.out.println("1. Encriptar");
        System.out.println("2. Desencriptar con clave");
        System.out.println("0. Salir");
        System.out.print("Selecciona una opción ---> ");
        opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            //opción para encriptar con ruta de texto

            System.out.print("Introduce la ruta del texto a encriptar: ");
            String rutaArchivoDeEntrada = scanner.nextLine();
            String textoLeido = ManejoDeArchivos.lectorDeArchivo(rutaArchivoDeEntrada);

            if (textoLeido == null) {
                System.out.println("*** Lo siento. El archivo que se proporcionó está vacío. : ( ***");
                return;
            }


            System.out.print("¿Cuál será el número de desplazamiento de caracteres? ");

            int claveDeDesplazamiento = scanner.nextInt();
            scanner.nextLine();

            EncriptadorDesencriptador encriptador = new EncriptadorDesencriptador(textoLeido, claveDeDesplazamiento);
            String textoEncriptado = encriptador.encriptar();


            System.out.print("¿Cuál será la ruta del archivo donde se guardará el texto encriptado? ");
            String rutaArchivoDeSalida = scanner.nextLine();


            ManejoDeArchivos.escribirArchivo(rutaArchivoDeSalida, textoEncriptado);
            System.out.println("El texto encriptado se ha guardado en: " + rutaArchivoDeSalida);

        } else if (opcion == 2) {

            //opción para desencriptar con ruta de texto


            System.out.print("Introduce la ruta del texto a desencriptar: ");
            String rutaArchivoDeEntrada = scanner.nextLine();
            String textoEncriptado = ManejoDeArchivos.lectorDeArchivo(rutaArchivoDeEntrada);


            if (textoEncriptado == null) {
                System.out.println("*** Lo siento. El archivo que se proporcionó está vacío. : ( ***");
                return;




            }
                System.out.print("Introduce el número de desplazamiento de caracteres: ");
                int claveDeDesplazamiento = scanner.nextInt();
                scanner.nextLine();

                EncriptadorDesencriptador desencriptador = new EncriptadorDesencriptador(textoEncriptado, claveDeDesplazamiento);
                String textoDesencriptado = desencriptador.desencriptar();

                System.out.print("¿Cuál será la ruta del archivo donde se guardará el texto desencriptado? ");
                String rutaArchivoDeSalida = scanner.nextLine();
                ManejoDeArchivos.escribirArchivo(rutaArchivoDeSalida, textoDesencriptado);

                System.out.println("El texto desencriptado se ha guardado en: " + rutaArchivoDeSalida);

            } else if (opcion == 0) {
                System.out.println("Hasta luego :)");


            } else {
                System.out.println("Opción inválida. Intenta otra vez :)");
                desplegarMenu(); // Volver a mostrar el menú

            }

        }

    }
