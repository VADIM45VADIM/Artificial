/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.apache.commons.math3.stat.StatUtils;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;

/**
 *
 * @author sensei
 */
public class RequestVar extends javax.swing.JFrame {

    /**
     * Creates new form RequestVar
     */
    float[] B0,B1;
    float[][] xy = new float[4][200];
    JFrame frame= new JFrame("Regrsion Lineal");
    public RequestVar() {
        initComponents();
    }
    public void setForms(float[] b0,float[] b1,float[][] xay){
        B0 = b0;
        B1 = b1;
        xy = xay;
        System.out.println("Dimention: "+xay[0].length);
        for(int i=0;i<xay[1].length;i++){
            System.out.println(xay[1][i]);
        }
        System.out.println("Dimention: "+xay[0].length);
        for(int i=0;i<xay[1].length;i++){
            System.out.println(xay[1][i]);
        }
        System.out.println("Dimention: "+xay[0].length);
        for(int i=0;i<xay[1].length;i++){
            System.out.println(xay[1][i]);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Hands-on 4 to Hands-on 6: Agent-based optimizing of Learning Models");

        jButton3.setText("Run");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TV", "Radio", "Newspaper" }));

        jLabel2.setText("Input:");

        jLabel3.setText("Solution");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(jButton3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox1, 0, 211, Short.MAX_VALUE)
                                    .addComponent(jTextField1))))))
                .addContainerGap(384, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(48, 48, 48)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       String option = jComboBox1.getSelectedItem().toString();
       float result = 0;
       float input = Float.parseFloat(jTextField1.getText());
       int i=0;
       switch(option){
           case "TV":
               i=0;
               break;
           case "Radio":
               i=1;
               break;
           case "Newspaper":
               i=2;
               break;
       }
       
       
       result  = B0[i]+(B1[i]*input);
       String text = B0[i]+" + "+B1[i]+"("+input+") = "+result;
       generateGrapic(B0[i],B1[i],xy[i],xy[3],text,input);
       jLabel3.setText(B0[i]+" + "+B1[i]+"("+input+") = "+result);
       //System.out.println(option);
    }//GEN-LAST:event_jButton3ActionPerformed
    private void generateGrapic(float b0, float b1,float[] xt,float[] yt,String title,double predict){
        
        
        Plot2DPanel plot = new Plot2DPanel();
        JTextArea resultados = new JTextArea();
        
        
        
        double[] yc = new double[xt.length+1];
        double[] x,y;
        x = new double[xt.length+1];
        y = new double[yt.length+1];
        
        for(int i=0;i<yt.length;i++){
            x[i] = xt[i];
            y[i] = yt[i];
            
        }
        int i = 0;
        for(i=0;i<yt.length;i++){
            yc[i] = b0 + (b1*x[i]);
            
        }
        x[i] = predict;
        yc[i] = b0 + (b1*predict);
        y[i] = yc[i];
        double[] px = new double[1];
        px[0] = predict;
        double[] py = new double[1];
        py[0] = yc[i];
        
        plot.addLegend(title);
        plot.addScatterPlot("Datos", x,y);
        plot.addLinePlot("Regresion",x,yc);
        
        plot.addScatterPlot("Punto", px,py);
        BaseLabel titulo = new BaseLabel("Regrsion Lineal",Color.BLUE,0.5,1.1);
        plot.addPlotable(titulo);
        resultados.setBackground(Color.LIGHT_GRAY);
        resultados.append("\nValor minimo: "+StatUtils.min(y));
        resultados.append("\nValor maximo: "+StatUtils.max(y));
        resultados.append("\nValor promedio: "+StatUtils.mean(y));
        resultados.append("\nVarianza: "+StatUtils.variance(y));
        resultados.append("\nromedio geometrico: "+StatUtils.geometricMean(y));
        resultados.append("\nsuma: "+StatUtils.sum(y));
        resultados.append("\nProduto: "+StatUtils.product(y));
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900,700);
        frame.add(plot,BorderLayout.CENTER);
        frame.add(resultados,BorderLayout.SOUTH);
        frame.setVisible(true);
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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RequestVar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RequestVar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RequestVar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RequestVar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RequestVar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}