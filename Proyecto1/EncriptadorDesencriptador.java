package Proyecto1;
import java.util.List;

import java.util.Scanner;

public class EncriptadorDesencriptador {
    Scanner scanner = new Scanner(System.in);
    List<Character> alfabeto = Alfabeto.getAlfabeto();
    int tamanoAlfabeto = alfabeto.size();
    String textoLeido;
    String textoEncriptado1;
    int claveDeDesplazamiento;
    String textoEncriptado2;
    String GuardarTexto;

    public EncriptadorDesencriptador(String textoLeido, int claveDeDesplazamiento) {

        this.textoLeido = textoLeido.toLowerCase();
        this.claveDeDesplazamiento= claveDeDesplazamiento;

    }

    public String encriptar() {


        //código para encriptar con clave y con ruta de archivo


        System.out.println("Seleccionaste la opción: Encriptar");

        StringBuilder textoEncriptado = new StringBuilder();


        for (int i = 0; i < textoLeido.length(); i++) {
            char posicionActual = textoLeido.charAt(i);
            boolean esParteAlfabeto = false;
            for (int a = 0; a < tamanoAlfabeto; a++) {
                if (posicionActual == alfabeto.get(a)) {
                    int nuevaPosicion = (a + claveDeDesplazamiento) % tamanoAlfabeto;
                    textoEncriptado.append(alfabeto.get(nuevaPosicion));
                    esParteAlfabeto = true;
                    break;
                }
            }
            if (!esParteAlfabeto) {
                textoEncriptado.append(posicionActual);
            }


        }
         return textoEncriptado.toString();

    }



    public String desencriptar() {

//código para desencriptar con clave y con ruta de archivo

        System.out.println("Seleccionaste la opción: Desencriptar");

        StringBuilder textoDesencriptado = new StringBuilder();


            for (int i = 0; i < textoLeido.length(); i++) {
                char posicionActual = textoLeido.charAt(i);
                boolean esParteAlfabeto = false;
                for (int a = 0; a < tamanoAlfabeto; a++) {
                    if (posicionActual == alfabeto.get(a)) {
                        int nuevaPosicion = (a - claveDeDesplazamiento) % tamanoAlfabeto;

                        if (nuevaPosicion < 0) {
                            nuevaPosicion += tamanoAlfabeto;
                        }
                        textoDesencriptado.append(alfabeto.get(nuevaPosicion));
                        esParteAlfabeto = true;
                        break;
                    }
                }
                if (!esParteAlfabeto) {
                    textoDesencriptado.append(posicionActual);
                }

            }

            return textoDesencriptado.toString();


        }
    }





