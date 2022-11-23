/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosnumericos;

import java.math.BigDecimal;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author krawz
 */
public class MetodoNewtonRaphson extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public MetodoNewtonRaphson() {
        initComponents();
        setTitle("Método Newton-Raphson");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnCalcular = new javax.swing.JButton();
        txtIt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iteración", "Xi", "f(Xi)", "f'(Xi)", "Xi Nueva", "Ea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel4.setText("Iteraciones:");

        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iteración", "Xi", "f(Xi)", "f'(Xi)", "Xi Nueva", "Ea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabla2);

        jLabel5.setText("Formula 2:");

        jLabel6.setText("Formula 1:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(337, 337, 337))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtIt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(244, 244, 244)
                .addComponent(btnCalcular)
                .addGap(57, 57, 57))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcular)
                    .addComponent(jLabel4)
                    .addComponent(txtIt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) tabla.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
        DefaultTableModel dm2 = (DefaultTableModel) tabla2.getModel();
        while (dm2.getRowCount() > 0) {
            dm2.removeRow(0);
        }
        int iteracion = Integer.parseInt(txtIt.getText());
        double Xi[] = new double[iteracion + 1];
        Xi[0] = 0;
        System.out.println("\n");
        System.out.println("FORMULA 1");
        System.out.println("\n");
        for (int x = 0; x < iteracion; x++) {
            Xi[x + 1] = Xi[x] - (funcion(Xi[x], 1) / derivada(Xi[x], 1));
            //System.out.println("X: "+Xi[x] + " , Función: " + funcion(Xi[x],1)+ " , Derivada: " + derivada(Xi[x],1));
            System.out.println("Iteración: " + (x + 1) + "\t Xi: " + doubleToString(Xi[x]) + "\t f(Xi): " + doubleToString(funcion(Xi[x], 1)) + "\t f'(Xi): " + doubleToString(derivada(Xi[x], 1)) + "\t Xi+1: "
                    + "" + doubleToString(Xi[x + 1]) + "\t Ea: " + doubleToString( ((Math.abs(Xi[x + 1] - Xi[x]) / Xi[x + 1]) * 100)));
            String res[] = {Integer.toString(x + 1), doubleToString(Xi[x]), doubleToString(funcion(Xi[x], 2)), doubleToString(derivada(Xi[x], 2)),doubleToString(Xi[x + 1])
            ,doubleToString(((Math.abs(Xi[x + 1] - Xi[x]) / Xi[x + 1]) * 100))};
                dm.addRow(res);
        }
        System.out.println("\n");

        double Xi2[] = new double[iteracion + 1];
        Xi2[0] = -0.8;
        System.out.println("FORMULA 2");
        System.out.println("\n");
        for (int x = 0; x < iteracion; x++) {
            Xi2[x + 1] = Xi2[x] - (funcion(Xi2[x], 2) / derivada(Xi2[x], 2));

            System.out.println("Iteración: " + (x + 1) + "\t Xi: " + doubleToString(Xi2[x]) + "\t f(Xi): " + doubleToString(funcion(Xi2[x], 2)) + "\t f'(Xi): " + doubleToString(derivada(Xi2[x], 2)) + ""
                    + "\t Xi+1: " + doubleToString(Xi2[x + 1]) + "\t Ea: " + doubleToString(((Math.abs(Xi2[x + 1] - Xi2[x]) / Xi2[x + 1]) * 100)));
        
            String res[] = {Integer.toString(x + 1), doubleToString(Xi2[x]), doubleToString(funcion(Xi2[x], 2)), doubleToString(derivada(Xi2[x], 2)),doubleToString(Xi2[x + 1])
            ,doubleToString(((Math.abs(Xi2[x + 1] - Xi2[x]) / Xi2[x + 1]) * 100))};
                dm2.addRow(res);
        }
                
                
                
                
    }//GEN-LAST:event_btnCalcularActionPerformed

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
    
    public static double funcion(double x, int formula) {
        double resultado;
        if (formula == 1) {
            resultado = Math.pow(Math.E, -x) - x;
        } else {
            resultado = Math.pow(Math.E, x) * Math.sin(x) - (x / 2);
        }
        return resultado;
    }

    public static double derivada(double x, int formula) {
        double resultado;
        if (formula == 1) {
            resultado = -Math.pow(Math.E, -x) - 1;
        } else {
            resultado = Math.pow(Math.E, x) * (Math.sin(x) + Math.cos(x)) - (0.5);
        }
        return resultado;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MetodoNewtonRaphson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodoNewtonRaphson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodoNewtonRaphson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodoNewtonRaphson.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetodoNewtonRaphson().setVisible(true);
            }
        });
    }
    
    public static double f(double c){
        double result = (9.8*(68.1))/(c) * (1-Math.pow(Math.E,-(c/68.1)*10))-40;
        //double result = (Math.pow(c, 10)) - 1;
        return result;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla2;
    private javax.swing.JTextField txtIt;
    // End of variables declaration//GEN-END:variables
}
