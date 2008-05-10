/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaNegocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Administrador
 */
public class Controller {

    private static Operations operacion;

    /**
     * 
     * @param tipoDeOperacion 1 Suma, 2 Resta, 3 Multiplicacion, 4 Divsion
     * @param tipoDeDato 1 Entero, 2 Doble, 3 Complejo
     * @param argumentos Dos o mas argumentos sobre los que se realiza la operacion 
     * @return
     */
    public static Object execute(int tipoDeOperacion, int tipoDeDato, List<Object> argumentos) {
        Number resultado = null;

        switch (tipoDeDato) {
            case 1:
                operacion = new IntegerOperations();
                resultado = new Integer(0);
                break;
            case 2:
                operacion = new DoubleOperations();
                resultado = new Double(0.0);
                break;
            case 3:
                operacion = new ComplexOperations();
                resultado = new Integer(0);
                break;
        }

        switch (tipoDeOperacion) {
            case 1:
                for (int i = 0; i < argumentos.size() - 1; i++) {
                    resultado = (Number) operacion.sum(argumentos.get(i), argumentos.get(i + 1));
                }
                break;
            case 2:
                for (int i = 0; i < argumentos.size() - 1; i++) {
                    resultado = (Number) operacion.substraction(argumentos.get(i), argumentos.get(i + 1));
                }
                break;
            case 3:
                for (int i = 0; i < argumentos.size() - 1; i++) {
                    resultado = (Number) operacion.mult(argumentos.get(i), argumentos.get(i + 1));
                }
                break;
            case 4:
                for (int i = 0; i < argumentos.size() - 1; i++) {
                    resultado = (Number) operacion.div(argumentos.get(i), argumentos.get(i + 1));
                }
                break;
        }

        return resultado;
    }
    
    public static void main(String args[]){
        Stack<Object> pilaDeArgumentos = new Stack<Object>();
        pilaDeArgumentos.push(new Double(6));
        pilaDeArgumentos.push(new Double(3));
        System.out.println(Controller.execute(1, 2, pilaDeArgumentos));
    }
}
