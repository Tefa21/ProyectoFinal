package Principal;

import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Main extends javax.swing.JFrame {
    DefaultTableModel hoja = new DefaultTableModel(); //Declarar el modelo de la Tabla
//    Object [] row = new Object[];
    int columna_1, fila_1, columna_2, fila_2;
    Nodo cima = null;
    String a;
    
    public void PosicionInicial(){
        columna_1 = this.JTB_Hoja.getSelectedColumn();
        fila_1 = this.JTB_Hoja.getSelectedRow();
        System.out.print("####Inicial####\n"+"Columna:"+columna_1+" Fila:"+fila_1+"\n");
        
    }
    
    public void PosicionFinal(){
        columna_2 = this.JTB_Hoja.getSelectedColumn();
        fila_2 = this.JTB_Hoja.getSelectedRow();
        System.out.print("####Final####\n"+"Columna:"+columna_2+" Fila:"+fila_2+"\n");
    }
    public void mostrarpos(){
        JOptionPane.showMessageDialog(null,"PosicionInicial\n"+" Columna: "+columna_1+"Fila: "+fila_1+"\nPosicionFinal\n"
        +" Columna: "+columna_2+"Fila: "+fila_2);
    }
  
    
    public void agregar_datos(Lista lista){
        Nodo nodo=new Nodo(lista);
	if (cima==null){
            cima=nodo;
        }
        else{
            Nodo puntero=cima;
            while (puntero.Siguiente!=null) {
                puntero=puntero.Siguiente;
                }
            puntero.Siguiente=nodo;
	}
    }
    
//    public void Mostrar(){
//        
//        String Datos [] = new String[1];
//        Nodo aux = cima;
//        while (aux!=null)
//            {
//                Datos[0] = String.valueOf(aux.info);
//                System.out.print("\n###Datos Lista###\n"+Datos[0]);
//                aux=aux.Siguiente;
//            }
//    }
    public void GuardarTabla(String dato, int fila, int columna){
        String Dato = dato;
        int Fila = fila, Columna = columna;
        Lista Nueva = new Lista(Dato,Fila,Columna);
        agregar_datos(Nueva);
    }
    
    
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);

        JTB_Hoja.setModel(hoja);
        for(int a=1; a<=3; a++){
            hoja.addColumn(a);
            for(int b=1; b<=3; b++)
                hoja.addRow(new Object[]{});
        }
        
        
    } 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenu1 = new javax.swing.JMenu();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTB_Hoja = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        jMenuItem3.setText("jMenuItem3");

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JTB_Hoja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        JTB_Hoja.setCellSelectionEnabled(true);
        JTB_Hoja.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JTB_HojaMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                JTB_HojaMouseMoved(evt);
            }
        });
        JTB_Hoja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTB_HojaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                JTB_HojaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                JTB_HojaMouseReleased(evt);
            }
        });
        JTB_Hoja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTB_HojaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(JTB_Hoja);
        JTB_Hoja.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        jMenu2.setText("Archivo");

        jMenuItem1.setText("Guardar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Abrir");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Funciones");

        jMenuItem4.setText("Leer celda seleccionada");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem4);

        jMenuItem5.setText("Cambiar Color");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuItem6.setText("GuardarTabla");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
             
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String b = String.valueOf(hoja.getValueAt(JTB_Hoja.getSelectedRow(), JTB_Hoja.getSelectedColumn()));
        JOptionPane.showMessageDialog(null, b);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        
        JTB_Hoja.setBackground(Color.yellow);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JTB_HojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_HojaMouseClicked
        int fila, columna;
        fila = this.JTB_Hoja.getRowCount();
        columna = this.JTB_Hoja.getColumnCount();
        System.out.print("####Tamaño####\n"+"Columna:"+columna+" Fila:"+fila+"\n");
        
    }//GEN-LAST:event_JTB_HojaMouseClicked

    private void JTB_HojaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_HojaMouseReleased
        
        
    }//GEN-LAST:event_JTB_HojaMouseReleased

    private void JTB_HojaMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_HojaMouseDragged
        PosicionFinal();
    }//GEN-LAST:event_JTB_HojaMouseDragged

    private void JTB_HojaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_HojaMousePressed
         PosicionInicial();
    }//GEN-LAST:event_JTB_HojaMousePressed

    private void JTB_HojaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_HojaMouseMoved
        
    }//GEN-LAST:event_JTB_HojaMouseMoved

    private void JTB_HojaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTB_HojaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_C){
            
                for(int i = fila_2; i<= fila_1; i++){
                    for (int j = columna_2; j <= columna_1; j++) {
                        a = String.valueOf(hoja.getValueAt(i, j));
//                        agregar_datos(a);
                    }//fin for j
                }//fin for i                               
        }//if ctrl + C
        if (evt.getKeyCode() == KeyEvent.VK_V){
//            Mostrar();
        }//if ctrl + v
    }//GEN-LAST:event_JTB_HojaKeyPressed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        int fila, columna;
        String dato;
        fila = this.JTB_Hoja.getRowCount();
        columna = this.JTB_Hoja.getColumnCount(); 
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                dato = String.valueOf(hoja.getValueAt(i, j));
                GuardarTabla(dato, i, j);
            }
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTB_Hoja;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
