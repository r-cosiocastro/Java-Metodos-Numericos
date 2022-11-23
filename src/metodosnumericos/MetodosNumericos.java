/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;

import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author krawz
 */
public class MetodosNumericos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
//        double x[][] = new double[100][100];
//        
//        double a,b,c;
//        
//        for(int v=0; v<3; v++){
//        
//        a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de A para la ecuación " + v + ":"));
//        
//        b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de B para la ecuación " + v + ":"));
//        
//        c = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de C para la ecuación " + v + ":"));
//        
//        for(int z=0;z<=8;z++){
//        x[z][0]=z-4;
//        }
//        
//        System.out.println(a+"x^2 + " + b + "x + " + c + "\n");
//        for(int z=0;z<=8;z++){
//        x[z][1] = (Math.pow(a,2)*z) + (b*z) + c;
//        System.out.println("x= "+ x[z][0] + " | f(x)= " + (a*(Math.pow(x[z][0],2)) + (b*x[z][0]) + c));
//        }
//        JOptionPane.showMessageDialog(null, "Tabla de la ecuación " + v + " terminada");
//        }

        
        
        
//        int c=4;
//        double result;
//        while(c<=20){
//            result = (9.8*(68.1))/(c) * (1-Math.pow(Math.E,-(c/68.1)*10))-40;
//            System.out.println(result);
//            c+=4;
//        }
        
        
        
//        double result;
//        double c = 14.78020383164403;
//        result = (9.8*(68.1))/(c) * (1-Math.pow(Math.E,-(c/68.1)*10))-40;
//        
//        System.out.println(result);

        boolean terminar = false;
        
        double a = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor para A:"));
    
        double b = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor para B:"));
            
        if((f(a)*f(b))>0){
            JOptionPane.showMessageDialog(null, "No se puede realizar la operación");
        }else{
            double xn,xm;
            int iteracion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de iteraciones:"));
            double tolerancia = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la tolerancia:"));
            for(int x=0;x<iteracion;x++){
                xn = (a+b)/2;
                if(f(a)*f(xn) < 0){
                    b = xn;
                }
                
                if(f(a)*f(xn) > 0){
                    a = xn;
                }
                
                if(f(a)*f(xn) == 0){
                    System.out.println(xn + " es la raíz");
                    terminar = true;
                }
                
                xm = (a+b)/2;
                
                System.out.println("Iteración: "+x+"\t " + "Xa: "+doubleToString(a) +"\t " + "Xb: " + doubleToString(b) + "\t" + "Xm: "+doubleToString(xn) + "\t"
                        + "f(a): " + doubleToString(f(a)) + "\t" + "f(b): " + doubleToString(f(b)) + "\t" + "f(xm): " + doubleToString(f(xn)) + "\t"
                                + "f(Xa)*f(Xm): "+ doubleToString(f(a)*f(xn)) + "\t" + "f(Xb)*f(Xm): " + doubleToString(f(b)*f(xn))+ "\t"
                                        + "Ea: " + ((Math.abs(xm-xn)/xn)*100));
                
                if(terminar==true){
                    break;
                }
                
                if(Math.abs((xm-xn)/xm) < tolerancia){
                    System.out.println(xm + " es la raíz");
                    break;
                }
            }
            
        }
        
        /*
        for(int c=4;c<=20;c+=4){
            result = (9.8*(68.1))/(c) * (1-Math.pow(Math.E,-(c/68.1)*10))-40;
            System.out.println(result);
        }
        */
    }
    
    public static String doubleToString(Double d) {
    if (d == null)
        return null;
    if (d.isNaN() || d.isInfinite())
        return d.toString();

    // pre java 8, a value of 0 would yield "0.0" below
    if (d.doubleValue() == 0)
        return "0";
    return new BigDecimal(d.toString()).stripTrailingZeros().toPlainString();
}
    
    public static double f(double c){
        double result = (9.8*(68.1))/(c) * (1-Math.pow(Math.E,-(c/68.1)*10))-40;
        return result;
    }
}
