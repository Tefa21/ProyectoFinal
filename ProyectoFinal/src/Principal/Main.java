package Principal;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Main extends javax.swing.JFrame {
    DefaultTableModel hoja = new DefaultTableModel(); //Declarar el modelo de la Tabla
//    Object [] row = new Object[];
    int columna_1, fila_1, columna_2, fila_2;
    Nodo cima = null;
    String a;
    int dif_col, dif_fil;
    
    
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
  
    //Metodo para convertir ArrayList en vector
    public static Integer[] convertirArrayList(ArrayList<Integer> alDatos){
        Integer[] arrResultante = new Integer[alDatos.size()]; //Vector al que se le va a pasar el Array List
        
        for (int i = 0; i < alDatos.size(); i++) {  //Ciclo para Recorrer el Array List e ingresarlo al vector
            arrResultante[i]=alDatos.get(i); 
        }
        
        return arrResultante; //Retorna el nuevo Vector
    }
    void celdasColoreadas(){ //Metodo para asignarle al ArrayList las celdas a colorear
    
        ArrayList obtenerFilas = new ArrayList<Integer>(); //Se crea el ArrayList
        ArrayList obtenerColumnas = new ArrayList<Integer>(); //Se crea el ArrayList

        obtenerFilas.add(JTB_Hoja.getSelectedRow()); //Se ingresan las celdas selecionadas al ArrayList
        obtenerColumnas.add(JTB_Hoja.getSelectedColumn());
        
        if(!obtenerFilas.isEmpty()&&!obtenerColumnas.isEmpty()){ //Se verifica que se hayan selecionado celdas
            
            colorCelda pintar = new colorCelda(); //Variable de tipo colorCelda
            pintar.filasColorear=convertirArrayList(obtenerFilas); //Se envia el vector a la clase colorear
            pintar.columnasColorear=convertirArrayList(obtenerColumnas);
            JTB_Hoja.setDefaultRenderer(Object.class, pintar); //Se asigna el Render a la tabla
            
        }
    }
    /*
    public void Mostrar(){
        
        String Datos [] = new String[1];
        Nodo aux = cima;
        while (aux!=null)
            {
                Datos[0] = String.valueOf(aux.info);
                System.out.print("\n###Datos Lista###\n"+Datos[0]);
                aux=aux.Siguiente;
            }
    }
   
    public void pegar(){
        dif_col = Math.abs((columna_1-columna_2));
        dif_fil = Math.abs((fila_1-fila_2));
        System.out.print("\n Resta Col: "+dif_col+" Resta fila: "+dif_fil);
        
        String Datos [] = new String[1];
        Nodo aux = cima;
        for (int i = fila_2; i <= fila_2+dif_fil; i++) {
            for (int j = columna_2; j <= columna_2+dif_col; j++) {
                Datos[0] = String.valueOf(aux.info);
                hoja.addRow(Datos);
                aux=aux.Siguiente;
            }
    
        }
        
            
        
        
    }
    */
    
    public Main() {
        initComponents();
        this.setLocationRelativeTo(null);
        JTB_Hoja.setModel(hoja);
        TamañoHoja();
        new Pegado(JTB_Hoja);
        
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
        JMI_Nuevo = new javax.swing.JMenuItem();
        JMI_Guardar = new javax.swing.JMenuItem();
        JMI_Abrir = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

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
        JTB_Hoja.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        JTB_Hoja.setCellSelectionEnabled(true);
        JTB_Hoja.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
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

        JMI_Nuevo.setText("Nuevo");
        JMI_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_NuevoActionPerformed(evt);
            }
        });
        jMenu2.add(JMI_Nuevo);

        JMI_Guardar.setText("Guardar");
        JMI_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_GuardarActionPerformed(evt);
            }
        });
        jMenu2.add(JMI_Guardar);

        JMI_Abrir.setText("Abrir");
        jMenu2.add(JMI_Abrir);

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
        jMenuItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuItem5MouseClicked(evt);
            }
        });
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem5);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMI_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_GuardarActionPerformed
             
     
             
    }//GEN-LAST:event_JMI_GuardarActionPerformed

    private void JTB_HojaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTB_HojaMouseClicked
       
        
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
        /*
        if (evt.getKeyCode() == KeyEvent.VK_C){
            
                for(int i = fila_2; i<= fila_1; i++){
                    for (int j = columna_2; j <= columna_1; j++) {
                        a = String.valueOf(hoja.getValueAt(i, j));
                        agregar_datos(a);
                    }//fin for j
                }//fin for i                               
        }//if ctrl + C
        if (evt.getKeyCode() == KeyEvent.VK_V){
            Mostrar();
            pegar();
        }//if ctrl + v
        */
        
    }//GEN-LAST:event_JTB_HojaKeyPressed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        String b = String.valueOf(hoja.getValueAt(JTB_Hoja.getSelectedRow(), JTB_Hoja.getSelectedColumn()));
        JOptionPane.showMessageDialog(null, b);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
                        celdasColoreadas();
                        
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void JMI_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_NuevoActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro desea abrir otra Hoja Electronica, los cambios no se guardarán?",
        "Nueva Hoja", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
         Limpiar();
        }
    }//GEN-LAST:event_JMI_NuevoActionPerformed

    private void jMenuItem5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem5MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuItem5MouseClicked

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
    
    public void agregar_datos(String dato){
        String dat;
        dat = dato;
        Nodo nodo=new Nodo(dat);
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
    
    public void TamañoHoja(){
        for(int a=1; a<=27; a++){
            hoja.addColumn(a);
            for(int b=1; b<=100; b++)
                hoja.addRow(new Object[]{});
        }
    }
    
    public void Limpiar(){
        DefaultTableModel Nuevo = (DefaultTableModel) JTB_Hoja.getModel();
        int a = JTB_Hoja.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
            Nuevo.removeRow(Nuevo.getRowCount()-1);
        }
        for(int b=1; b<=100; b++){
            hoja.addRow(new Object[]{});           
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem JMI_Abrir;
    private javax.swing.JMenuItem JMI_Guardar;
    private javax.swing.JMenuItem JMI_Nuevo;
    private javax.swing.JTable JTB_Hoja;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
