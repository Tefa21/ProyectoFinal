package Principal;
import java.awt.Color;
import java.sql.*;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
//import say.swing.JFontChooser;


public class Main extends javax.swing.JFrame {
    DefaultTableModel hoja = new DefaultTableModel(); //Declarar el modelo de la Tabla
    Nodo cima = null;
//    JFontChooser font;
               
    public Main() {
        initComponents();
//        RemoverNull();
        this.setLocationRelativeTo(null);
        Conexion();
        JTB_Hoja.setModel(hoja);
        TamañoHoja();
        new Pegado(JTB_Hoja);
//       RemoverNull();
        
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
        jPanel2 = new javax.swing.JPanel();
        JBT_cambiarFuenteColor = new javax.swing.JButton();
        JBT_cambarFondo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        JBT_alineadoIzq = new javax.swing.JButton();
        JBT_alineadoCent = new javax.swing.JButton();
        JBT_alineadoDerc = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        JMI_Nuevo = new javax.swing.JMenuItem();
        JMI_Guardar = new javax.swing.JMenuItem();
        JMI_Abrir = new javax.swing.JMenuItem();

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
        jScrollPane1.setViewportView(JTB_Hoja);
        JTB_Hoja.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        JBT_cambiarFuenteColor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/font-symbol-of-letter-a_icon-icons.com_73556.png"))); // NOI18N
        JBT_cambiarFuenteColor.setText("Cambiar Color Fuente");
        JBT_cambiarFuenteColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_cambiarFuenteColorActionPerformed(evt);
            }
        });

        JBT_cambarFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/software_paintbucket_39795 (1).png"))); // NOI18N
        JBT_cambarFondo.setText("Cambiar Fondo");
        JBT_cambarFondo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_cambarFondoActionPerformed(evt);
            }
        });

        jLabel1.setText("Alineado");

        JBT_alineadoIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/text-align-left_icon-icons.com_48215.png"))); // NOI18N
        JBT_alineadoIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_alineadoIzqActionPerformed(evt);
            }
        });

        JBT_alineadoCent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/text-align-center_icon-icons.com_48217.png"))); // NOI18N
        JBT_alineadoCent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_alineadoCentActionPerformed(evt);
            }
        });

        JBT_alineadoDerc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/text-align-right_icon-icons.com_48214.png"))); // NOI18N
        JBT_alineadoDerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBT_alineadoDercActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JBT_cambarFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_cambiarFuenteColor)
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_alineadoIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_alineadoCent, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JBT_alineadoDerc, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(309, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(JBT_cambarFondo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(JBT_cambiarFuenteColor, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(JBT_alineadoCent, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(JBT_alineadoDerc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JBT_alineadoIzq, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(9, 9, 9)))
                .addContainerGap())
        );

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
        JMI_Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMI_AbrirActionPerformed(evt);
            }
        });
        jMenu2.add(JMI_Abrir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JMI_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_GuardarActionPerformed
        //Se Obtiene la cantidad de filas y columnas, luego procede a recorrer toda la tabla
        //obteniendo el dato que se encuentra en cada celda, el No. de fila y el No. de columna en la que se encuentra
        //y estos datos los envia al metodo GuardarTabla.
        int fila, columna;
        String dato;
        fila = this.JTB_Hoja.getRowCount();
        columna = this.JTB_Hoja.getColumnCount(); 
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                dato = String.valueOf(hoja.getValueAt(i, j));
                if (dato!="null" || dato!="") {
                 GuardarTabla(dato, i, j);   
                }
                
            }
        }         
        GuardarBD();
    }//GEN-LAST:event_JMI_GuardarActionPerformed

    private void JMI_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_NuevoActionPerformed
        RemoverNull();
        if (JOptionPane.showConfirmDialog(rootPane, "¿Seguro desea abrir otra Hoja Electronica, los cambios no se guardarán?",
        "Nueva Hoja", JOptionPane.WARNING_MESSAGE, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
         Limpiar();
        RemoverNull();
        }
    }//GEN-LAST:event_JMI_NuevoActionPerformed
     void textAlign(int a){ //Metodo para asignarle al ArrayList las celdas a colorear
    
 
        int []obtenerFilas=JTB_Hoja.getSelectedRows(); //Se ingresan las celdas selecionadas al ArrayList
        int []obtenerColumnas=JTB_Hoja.getSelectedColumns();
            
            textAlignment align = new textAlignment(); //Variable de tipo colorCelda
            align.intFilasAlinear=obtenerFilas; //Se envia el vector a la clase colorear
            align.intColumnasAlinear=obtenerColumnas;
            align.intTipoTexto=a;
            JTB_Hoja.setDefaultRenderer(Object.class, align); //Se asigna el Render a la tabla
            
    }
    void celdasColoreadas(){ //Metodo para asignarle al ArrayList las celdas a colorear
    
 
        int []obtenerFilas=JTB_Hoja.getSelectedRows(); //Se ingresan las celdas selecionadas al ArrayList
        int []obtenerColumnas=JTB_Hoja.getSelectedColumns();
        Color c = JColorChooser.showDialog(this, "Seleccion color" , Color.white); 
            
            colorCelda pintar = new colorCelda(); //Variable de tipo colorCelda
            pintar.intfilasColorear=obtenerFilas; //Se envia el vector a la clase colorear
            pintar.intcolumnasColorear=obtenerColumnas;
            pintar.colorCelda=c;
            JTB_Hoja.setDefaultRenderer(Object.class, pintar); //Se asigna el Render a la tabla
            
    }
    
    
    
    void letrasColor(){ //Metodo para asignarle al ArrayList las celdas a colorear
    
 
        int []obtenerFilas=JTB_Hoja.getSelectedRows(); //Se ingresan las celdas selecionadas al ArrayList
        int []obtenerColumnas=JTB_Hoja.getSelectedColumns();
        Color c = JColorChooser.showDialog(this, "Seleccion color" , Color.white); 

            
            colorLetras pintar = new colorLetras(); //Variable de tipo colorCelda
            pintar.intFilasColorear=obtenerFilas; //Se envia el vector a la clase colorear
            pintar.intColumnasColorear=obtenerColumnas;
            pintar.colorLetra=c;

            JTB_Hoja.setDefaultRenderer(Object.class, pintar); //Se asigna el Render a la tabla
            
    }
    private void JMI_AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMI_AbrirActionPerformed
        AbrirFile();
        DatosTabla();
    }//GEN-LAST:event_JMI_AbrirActionPerformed

    private void JBT_alineadoIzqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_alineadoIzqActionPerformed
        textAlign(1);
    }//GEN-LAST:event_JBT_alineadoIzqActionPerformed

    private void JBT_alineadoCentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_alineadoCentActionPerformed
        textAlign(2);

    }//GEN-LAST:event_JBT_alineadoCentActionPerformed

    private void JBT_alineadoDercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_alineadoDercActionPerformed
        
        textAlign(3);

    }//GEN-LAST:event_JBT_alineadoDercActionPerformed

    private void JBT_cambarFondoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_cambarFondoActionPerformed
        celdasColoreadas();

    }//GEN-LAST:event_JBT_cambarFondoActionPerformed

    private void JBT_cambiarFuenteColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBT_cambiarFuenteColorActionPerformed
        letrasColor();
    }//GEN-LAST:event_JBT_cambiarFuenteColorActionPerformed

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
    
    
    public void TamañoHoja(){
        for(int a=1; a<=20; a++)
            hoja.addColumn(a);          
        for(int b=1; b<=40; b++)
            hoja.addRow(new Object[]{});
    }
    
    public void Limpiar(){
        DefaultTableModel Nuevo = (DefaultTableModel) JTB_Hoja.getModel();
        int a = JTB_Hoja.getRowCount()-1;
        for (int i = a; i >= 0; i--) {           
            Nuevo.removeRow(Nuevo.getRowCount()-1);
        }
        for(int b=1; b<=40; b++)
            hoja.addRow(new Object[]{});
    }
    
    public void Conexion(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/hojae", "root", "");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "No se conecto"+ e);
        }
    }
    
    public void DatosTabla(){
        String Nombre;
        Nombre=JOptionPane.showInputDialog("Ingrese El Nombre de La Tabla");
        if ("".equals(Nombre)){
            JOptionPane.showMessageDialog(null,"Campo vacio");
        }else{
            try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/hojae", "root", "");
            PreparedStatement pst = cn.prepareStatement("select dato, fila, columna from archivos where nombre = ?");
            pst.setString(1, Nombre);
            ResultSet ConsultaHoja = pst.executeQuery();
            
            
            while(ConsultaHoja.next()){
               String dato = ConsultaHoja.getString("Dato");
               int fila =  Integer.parseInt(ConsultaHoja.getString("fila"));
               int columna =  Integer.parseInt(ConsultaHoja.getString("columna"));        
               
               this.JTB_Hoja.setValueAt(dato, fila, columna);
           }
              
           }catch (Exception e){
           JOptionPane.showMessageDialog(null, "No Se Cargo la Hoja");
           }
        }        
    }
    
    public void AbrirFile(){    
        JFileChooser AbrirFile=new JFileChooser();
        AbrirFile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter Filtro = new FileNameExtensionFilter("*.sql", "sql");
        AbrirFile.setFileFilter(Filtro);
        int seleccion=AbrirFile.showOpenDialog(this);
    }
    
    public void GuardarTabla(String dato, int fila, int columna){
        //Datos Obtenidos al seleccionar la opcion guarda del JMenuBar
        //Usando la clase lista crea un objeto lista donde se guardan los datos enviados.
        String Dato = dato;
        int Fila = fila, Columna = columna;
        Lista Nueva = new Lista(Dato,Fila,Columna);
        agregar_datos(Nueva);
    }
    
    public void agregar_datos(Lista lista){
        //Obtiene el objeto tipo lista y lo guarda en un nodo.
        //Cada dato se inserta al final
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
    
    public void GuardarBD(){
        if (cima==null) {
           JOptionPane.showMessageDialog(null,"Tabla Vacia"); 
        }else{
            String Nombre,ID_Tabla;
        
            Nombre=JOptionPane.showInputDialog("Ingrese El Nombre de La Tabla");
            ID_Tabla=JOptionPane.showInputDialog("Ingrese El ID de La Tabla");
            boolean Numero = EsNumero(ID_Tabla);
        
            if (Numero==true) {
                String Dato, Fila, Columna;
		Nodo aux=cima;
                
		while (aux!=null){
                        Dato= String.valueOf(aux.lista.strDato);
                        
                     if (Dato=="null"){
                        aux=aux.Siguiente; 
                     }else{
                        
                        Fila= String.valueOf(aux.lista.intFila);
                        Columna= String.valueOf(aux.lista.intColumna);
                        try{
                            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/hojae", "root", "");
                            PreparedStatement pst = cn.prepareStatement("insert into archivos values(?,?,?,?,?)");

                            pst.setString(1,Nombre);
                            pst.setString(2,ID_Tabla);
                            pst.setString(3,Dato);
                            pst.setString(4,Fila);
                            pst.setString(5,Columna);

                            pst.executeUpdate();
                             
                            
                        }catch (Exception e){
                            JOptionPane.showMessageDialog(null,"Error al acceder a la Base de Datos");
                        }
			aux=aux.Siguiente;
                     }       
		}
                JOptionPane.showMessageDialog(null,"Tabla Guardada"); 
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ingrese Un Número Válido", "ERROR", HEIGHT);
            }
        }   
    }
    
    public static boolean EsNumero(String ID_Tabla) {
        boolean resultado;
        try {
            Integer.parseInt(ID_Tabla);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }
    
      public void RemoverNull(){
        //Se obtiene la cantidad de filas y columnas de la tabla y luego se recorre la tabla
        //Asignando "" a cada celda y asi remover el dato null
        int fila, columna;
        fila = this.JTB_Hoja.getRowCount();
        columna = this.JTB_Hoja.getColumnCount(); 
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                this.JTB_Hoja.setValueAt(" ", i, j);
            }
        }         
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBT_alineadoCent;
    private javax.swing.JButton JBT_alineadoDerc;
    private javax.swing.JButton JBT_alineadoIzq;
    private javax.swing.JButton JBT_cambarFondo;
    private javax.swing.JButton JBT_cambiarFuenteColor;
    private javax.swing.JMenuItem JMI_Abrir;
    private javax.swing.JMenuItem JMI_Guardar;
    private javax.swing.JMenuItem JMI_Nuevo;
    private javax.swing.JTable JTB_Hoja;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
