package sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Ahorcado {

    protected int IntentosMax = 8;
    static ArrayList<String> palabras = new ArrayList<>(Arrays.asList("Adolescente", "Adulto", "Agua", "Aire", "Alberca",
            "Alcalde",
            "Amor",
            "Anciano",
            "Árbol",
            "Asfalto",
            "Avión",
            "Azúcar",
            "Azul",
            "Balón",
            "Barrio",
            "Blanco",
            "Boca",
            "Bolsa",
            "Botón",
            "Brocha",
            "Cabello",
            "Cabeza",
            "Café",
            "Carta",
            "Calle",
            "Cámara",
            "Camino",
            "Camión",
            "Camisa",
            "Cansar",
            "Cara",
            "Caramelo",
            "Carne",
            "Casa",
            "Cepillo",
            "Cerveza",
            "Chocolate",
            "Cigarro",
            "Ciudad",
            "Clavo",
            "Coche",
            "Comida",
            "Cortina",
            "Cuaderno",
            "Cuchara",
            "Dedos",
            "deporte",
            "Disco",
            "Dulce",
            "Edificio",
            "Ejército",
            "Electricidad",
            "Espejo",
            "Flor",
            "Forma",
            "Fuego",
            "Gato",
            "Goma",
            "Gorra",
            "Guante",
            "Habitar",
            "Hombre",
            "Jabón",
            "Jardín",
            "Joven",
            "Labios",
            "Lámpara",
            "Lápiz",
            "leña",
            "Libreta",
            "Libro",
            "Llave",
            "Luz", "Manguera",
            "Mano",
            "Manta",
            "Mar",
            "Mesa",
            "Mujer",
            "Negro", "Ocupar", "Pantalón", "Perro", "Pescar", "Piedra", "Pierna", "Pintura", "Pistola", "Placa", "Planta", "Plato", "Pluma", "Poner",
            "Pueblo", "Puerta", "Radio", "Sal", "Sartén",
            "Silencio", "Silla", "Símbolo", "Sol", "Tierra", "Tornillo",
            "Trapo", "Tren", "Vaso", "Vecino", "Ventana", "Verde", "Vino", "Zapato"));

    private int contadorIntentos;

    public String getPalabra() {
        return palabra;
    }

    private String palabra;
    private String palabra_oculta = "";

    
    
    public Ahorcado(int IntentosMax) {
        this.IntentosMax = IntentosMax;

    }
    
    

    public String getPalabra_oculta() {
        return palabra_oculta;
    }

    public void setPalabra_oculta(String palabra_oculta) {
        this.palabra_oculta = palabra_oculta;
    }

    public Ahorcado() {
    }

    public void obtenerPalabraAleatoria() {
        int n = (int) (Math.random() * palabras.size());
        palabra = palabras.get(n);

    }

    public String ocultarPalabraSimbolo() {
        String ast = "*";

        for (int i = 0; i < palabra.length(); i++) {
            palabra_oculta = palabra_oculta + ast;

        }
        return palabra_oculta;
    }

    public boolean comprobarPalabra() {
        if (palabra_oculta.toLowerCase().equals(palabra.toLowerCase())) {
            return true;
        } else {
            return false;
        }

    }
    
    public boolean cambiarSimbolosPorLetra (char letra ){
        boolean sustitucion=false;
       char[] letras =  palabra_oculta.toCharArray();
        for (int i = 0; i < palabra.length(); i++) {
            if(Character.toLowerCase(letra)==palabra.toLowerCase().charAt(i)){
                letras[i] =letra;
                sustitucion=true;
            }            
        }
        palabra_oculta = String.valueOf(letras);
        return sustitucion;
    }
    
    public int intentosRestantes(){
        contadorIntentos ++;
         return IntentosMax - contadorIntentos; 
    }

}
