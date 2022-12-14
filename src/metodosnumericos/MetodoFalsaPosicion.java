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
public class MetodoFalsaPosicion extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    public MetodoFalsaPosicion() {
        initComponents();
        setTitle("Método Falsa Posición");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtTol = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtB = new javax.swing.JTextField();
        btnCalcular = new javax.swing.JButton();
        txtIt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Tolerancia:");

        txtTol.setText("0");

        jLabel2.setText("a:");

        txtA.setText("14");

        jLabel3.setText("b:");

        txtB.setText("16");

        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        jLabel4.setText("Iteraciones:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Iteración", "Xa", "Xb", "Xm", "f(a)", "f(b)", "f(xm)", "f(Xa)*f(Xm)", "f(Xb)*f(Xm)", "Ea"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabla);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTol, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
                        .addComponent(btnCalcular)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIt, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(txtIt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(txtB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCalcular)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtTol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
        // TODO add your handling code here:
        DefaultTableModel dm = (DefaultTableModel) tabla.getModel();
        double a = Double.parseDouble(txtA.getText());
    
        double b = Double.parseDouble(txtB.getText());
        
        boolean terminar = false;
        
        if(((f(a)>0)&&(f(b))<0)||((f(a)<0)&&(f(b))>0)){
            double xn,xm,xr;
            xm = 0;
            int iteracion = Integer.parseInt(txtIt.getText());
            double tolerancia = Double.parseDouble(txtTol.getText());
            xr = a - ((f(a)*(b-a))/(f(b)-f(a)));
            for(int x=0;x<iteracion;x++){
                xr = a - ((f(a)*(b-a))/(f(b)-f(a)));
                
                String res[] = {Integer.toString(x),doubleToString(a),doubleToString(b),doubleToString(xr),doubleToString(f(a)),
                    doubleToString(f(b)),doubleToString(f(xr)),doubleToString(f(a)*f(xr)),
                doubleToString(f(b)*f(xr)),doubleToString(((Math.abs(xm-xr)/xr)*100))};
                dm.addRow(res);
                
                if(f(a)*f(xr) < 0){
                    b = xr;
                }else
                
                if(f(a)*f(xr) > 0){
                    a = xr;
                }else
                    if(f(a)*f(xr) == 0){
                    System.out.println("Operación:"+f(a)*f(xr));
                    System.out.println(xr + " es la raíz");
                    System.out.println("Terminado por 0");
                    terminar=true;
                }
                
                xm = (a+b)/2;
                
//                System.out.println("Iteración: "+x+"\t " + "Xa: "+a +"\t " + "Xb: " + b + "\t" + "Xm: "+xn + "\t"
//                        + "f(a): " + f(a) + "\t" + "f(b): " + f(b) + "\t" + "f(xm): " + f(xn) + "\t"
//                                + "f(Xa)*f(Xm): "+ f(a)*f(xn) + "\t" + "f(Xb)*f(Xm): " + f(b)*f(xn)+ "\t"
//                                        + "Ea: " + ((Math.abs(xm-xn)/xn)*100));
                
//                String res[] = {Integer.toString(x),Double.toString(a),Double.toString(b),Double.toString(xn),Double.toString(f(a)),
//                    Double.toString(f(b)),Double.toString(f(xn)),Double.toString(f(a)*f(xn)),
//                Double.toString(f(b)*f(xn)),Double.toString(((Math.abs(xm-xn)/xn)*100))};
                
                if(terminar==true){
                    break;
                }
                
                if(Math.abs((xm-xr)/xm) < tolerancia){
                    System.out.println(xm + " es la raíz");
                    System.out.println("Terminado por tolerancia");
                    break;
                }
                xr = xm;
            }
            
        }else{
            JOptionPane.showMessageDialog(null, "No se puede realizar la operación");
            
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
            java.util.logging.Logger.getLogger(MetodoFalsaPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodoFalsaPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodoFalsaPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodoFalsaPosicion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetodoFalsaPosicion().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtB;
    private javax.swing.JTextField txtIt;
    private javax.swing.JTextField txtTol;
    // End of variables declaration//GEN-END:variables
}
