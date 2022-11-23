/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;

/**
 *
 * @author krawz
 */
public class Ecuacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Reemplazar x por numeros
        String funcion = "x^2-5x+3";
        double x = -4;
        String numero = Double.toString(x);
        funcion = funcion.replace("x", "*("+numero+")");
        if(funcion.charAt(0)=='*'){
            System.out.println("Asterisco");
            funcion = funcion.substring(1, funcion.length());
        }
        System.out.println(evaluar(funcion));
    }

    public static double evaluar(final String str) {
        return new Object() {
            int pos = -1, ch;

            void siguienteCaracter() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;     //Medirá la longitud del string y sacará el caracter en una variable
            }

            boolean caracterActual(int caracterAEliminar) {
                while (ch == ' ') {
                    siguienteCaracter();        //Mientras no se termine el string de la fórmula se continuará analizando
                }
                if (ch == caracterAEliminar) {
                    siguienteCaracter();
                    return true;
                }
                return false;                   //Al terminar de analizar el string se detendrá la función
            }

            double analizar() {
                siguienteCaracter();
                double x = analizarExpresion();
                if (pos < str.length()) {
                    throw new RuntimeException("Error en la ecuación: " + (char) ch);
                }
                return x;
            }

            double analizarExpresion() {
                double x = analizarOperacion();
                for (;;) {
                    if (caracterActual('+')) {
                        x += analizarOperacion();                     //Suma
                    } else if (caracterActual('-')) {
                        x -= analizarOperacion();                     //Resta
                    } else {
                        return x;
                    }
                }
            }

            double analizarOperacion() {
                double x = analizarSigno();
                for (;;) {
                    if (caracterActual('*')) {
                        x *= analizarSigno();                      // Multiplicación
                    } else if (caracterActual('/')) {
                        x /= analizarSigno();                      // División
                    } else {
                        return x;
                    }
                }
            }

            double analizarSigno() {
                if (caracterActual('+')) {
                    return analizarSigno();
                }
                if (caracterActual('-')) {
                    return -analizarSigno();
                }

                double x;
                int posInicial = this.pos;
                if (caracterActual('(')) {                               //Dar prioridad a los parentésis
                    x = analizarExpresion();
                    caracterActual(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {      //Analizar decimales
                    while ((ch >= '0' && ch <= '9') || ch == '.') {
                        siguienteCaracter();
                    }
                    x = Double.parseDouble(str.substring(posInicial, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {                     //Si es una letra, dar por hecho que es una función
                    while (ch >= 'a' && ch <= 'z') {
                        siguienteCaracter();
                    }
                    String funcion = str.substring(posInicial, this.pos);
                    x = analizarSigno();
                    if (funcion.equals("raiz")) {
                        x = Math.sqrt(x);               //Raíz cuadrada
                    } else if (funcion.equals("sen")) {
                        x = Math.sin(Math.toRadians(x));    //Seno
                    } else if (funcion.equals("cos")) {
                        x = Math.cos(Math.toRadians(x));    //Coseno
                    } else if (funcion.equals("tan")) {
                        x = Math.tan(Math.toRadians(x));    //Tangente
                    } else {
                        throw new RuntimeException("Función desconocida: " + funcion); //Si las letras no corresponden a ninguna
                    }                                                                  //función mostrar una excepción
                } else {
                    throw new RuntimeException("Error en la ecuación: " + (char) ch);
                }

                if (caracterActual('^')) {
                    x = Math.pow(x, analizarSigno());           //Potencia
                }
                return x;
            }
        }.analizar();
    }

}
