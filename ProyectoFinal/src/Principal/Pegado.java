package Principal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
import java.io.IOException;

public class Pegado implements ActionListener {
    
    //Declaracion de una variable tipo privada declarada tipo Clipboard la cual se encargara de habilitar la funcionalidad del Copiado y Pegado en la Tabla
    private Clipboard CbdAuxiliar;
    //Declaracion de variable que manejara los datos internos de la Tabla
    private JTable JTblHojaExcel ;
    //Declaracion de una variable tipo StringSelection la cual se encargara de obtener los datos en el metodo ProcedimientoCopiado y luego ser usados por la Variable Auxiliar
    //para su aplicacion en el Clipboard
    private StringSelection StrStnAuxCopiar;
    
    //Metodo que declara los eventos keypress en la Tabla
    public Pegado(JTable JTableTabla){
        //Se iguala la variable a myJTable para que esta obtenga todos los datos existentes en la Hoja de Excel
        JTblHojaExcel = JTableTabla;
        //Declaracion del Evento KeyPress para copiar con la combinacion de teclas Ctrl+C
        KeyStroke KSkCopiar = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);
        //Declaracion del Evento KeyPress para pegar con la combinacion de teclas Ctrl+V
        KeyStroke KSkPegar = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
        //Se indica que la variable Hoja_Excel hara la accion de copiar 
        JTblHojaExcel.registerKeyboardAction(this,"Copy",KSkCopiar,JComponent.WHEN_FOCUSED);
        //Se indica que la variable Hoja_Excel hara la accion de pegar 
        JTblHojaExcel.registerKeyboardAction(this,"Paste",KSkPegar,JComponent.WHEN_FOCUSED);
        //Se iguala la variable auxiliar para que esta se diriga al Clipboard y efectue el proceso de copiar y pegar
        CbdAuxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
        
    }//fin Pegado

    //Metodo necesario para el funcionamiento del Clipboard, 
    public JTable getJTable() {
        return JTblHojaExcel;
    }
    
    //Metodo necesario para el funcionamiento del Clipboard
    public void setJTable(JTable JtblHoja){
        this.JTblHojaExcel=JtblHoja;
    }

    void ProcedimientoPegado(){
        //se inicializa la variable para eliminar posible cache que exista de un copiado y pegado anterior
        CbdAuxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
    try{
        //declaracion de variable que se encargara de almacenar el dato a copiar del clipboard(portapapeles)
        String Strdato= (String)CbdAuxiliar.getData(DataFlavor.stringFlavor);
        //Verificacion que exista un dato para pegar en una celda)
     
    //Declaracion de variables que obtendran la posicion final para hacer el pegado en la Tabla 
    int intDatoCol=JTblHojaExcel.getSelectedColumn();
    int intDatoFila=JTblHojaExcel.getSelectedRow();

    //Condicion if cuando no se ha seleccionado una celda 
    if(intDatoCol<0||intDatoFila<0) {   
         JOptionPane.showMessageDialog(null, "No ha Seleccionado una Celda para Pegar el Contenido","Aviso",JOptionPane.ERROR_MESSAGE);
        return;
    }//fin ciclo if

    //Declaracion de Variables para utilizar los tokens
    StringTokenizer StrTknToken1,StrTknTokenPegado;
    //la variable Token1 se encargara de almacenar el contenido de cada variable "dato" y la separara con un "\n"  
    StrTknToken1=new StringTokenizer(Strdato,"\n");
    //Se declara una variable que hara el conteo de filas por medio de tokens del area seleccionada a pegar por el usuario
    int intPegarFilas=StrTknToken1.countTokens ();
    //la variable Token1 se encargara de almacenar y separar cada dato siguiente de Token1 por medio de un "\t"
    StrTknToken1=new StringTokenizer(StrTknToken1.nextToken ().trim (),"\t");
    //Se declara una variable que hara el conteo de columnas por medio de tokens del area seleccionada a pegar por el usuario
    int intPegarCol=StrTknToken1.countTokens ();
    //variable que se encargara de obtener los datos entre todas las columnas existentes y le resta la columna seleccionada por el usuario
    int intMargenCol=JTblHojaExcel.getColumnCount()-intDatoCol;
      //variable que se encargara de obtener los datos entre todas las filas existentes y le resta la fila seleccionada por el usuario
    int intMargenFila=JTblHojaExcel.getRowCount()-intDatoFila;
    //verificacion en caso el usuario desee pegar los datos en un area de la Tabla donde no existan columnas o filas suficientes
    if(intMargenCol<intPegarCol || intMargenFila<intPegarFilas){
        
        JOptionPane.showMessageDialog(null,"La Tabla NO Posee el Espacio Suficiente para Pegar los Datos","Aviso",JOptionPane.ERROR_MESSAGE);
        return;
    }    
    //la variable Token1 se encargara de almacenar el contenido de cada variable "dato" y la separara con un "\n"  
        StrTknToken1=new StringTokenizer (Strdato,"\n");
    //Declaracion de variables usadas para el contador en el siguiente ciclo while
    int intContadorFila=0,intContadorCol;

    //ciclo que extrae los tokens obtenidos anteriormente por la variable "Token1"
    while(StrTknToken1.hasMoreTokens()){
        
        //divide cada token que tenga una coincidencia de "\t" hasta llegar a la posicion final (celda donde se desea colocar el dato)
        StrTknTokenPegado=new StringTokenizer (StrTknToken1.nextToken (),"\t");
        
        intContadorCol=0; 
        //ciclo para iniciar la transferencia de datos de una celda a la otra("pegado")
        while(StrTknTokenPegado.hasMoreTokens ()){
        //Sentencia que se encargara de obtener el dato a pegar y la posicion 
        JTblHojaExcel.setValueAt(StrTknTokenPegado.nextToken (),intContadorFila+intDatoFila,intContadorCol+intDatoCol);
       //Autosuma de 1 a la variable Contador_Col
        intContadorCol++;
        
        }//fin del segundo ciclo while
        //Autosuma de 1 a la variable Contador_Fila
        intContadorFila++;
        
    }//fin del primer ciclo while

    }//fin del try

    //Excepcion cuando los datos ya no sean soportados
    catch(UnsupportedFlavorException uf){
    //Impresion de mensaje en la consola
        System.out.println ("uf="+uf.getMessage ());

    }//fin catch
    
    catch(IOException io){
            //Impresion de mensaje en la consola

        System.out.println ("io="+io.getMessage ());

    }//fin catch

    }//fin ProcedimientoPegado

    void ProcedimientoCopiado(){
        //Declaracion de la variable "Copiar"tipo StringBuffer debido al tamaño y contenido modificable de los datos que se manipularan,
        //esto por el hecho de que la variable va a tener su contenido modificado muchas veces dependiendo la cantidad de datos a copiar
        StringBuffer StrBfrCopiar=new StringBuffer();
         
         //Declaracion de variables las cuales comprueban si se ha seleccionado un bloque de celdas para copiar o solamente una unica celda
         //variable que obtendra el numero de columnas
         int intNumCol=JTblHojaExcel.getSelectedColumnCount();
         //variable que obtendra el numero de filas
         int intNumFilas=JTblHojaExcel.getSelectedRowCount();
         //Declaracion de vectores para que el programa conozca el tamaño del bloque seleccionado
         //vector para las filas
         int[] intFilaSeleccionada =JTblHojaExcel.getSelectedRows();
         //vector para las columnas
         int[] intColSeleccionada =JTblHojaExcel.getSelectedColumns();
         
         //ciclo for para obtener el o los valores a copiar del bloque de celdas seleccionadas por el usuario
         for (int intCicloFil=0;intCicloFil<intNumFilas;intCicloFil++){
            for (int intCicloCol=0;intCicloCol<intNumCol;intCicloCol++){
                //.append se encarga de guardar en la variable "copiar" el contenido que esta entre los ( ) en tipo cadena, esto por declarar la variable tipo StringBuffer
                //la variable se encarga de guardar los datos que se encuentran en la 
                StrBfrCopiar.append(JTblHojaExcel.getValueAt(intFilaSeleccionada [intCicloFil],intColSeleccionada [intCicloCol]));        
                //ciclo if el cual se encargara de colocar los datos copiados en columnas y luego en el metodo ProcedimientoPegado se agregaran de la forma ingresada por el usuario      
               if (intCicloCol<intNumCol-1) StrBfrCopiar.append("\t");
                        
            }//fin segundo ciclo for
            //
            StrBfrCopiar.append("\n");
         }//fin primer ciclo for
         
         //La variable "Aux_Copiar" guardara la matriz de los datos a copiar(el bloque de celdas seleccionadas por el usuario)
         StrStnAuxCopiar  = new StringSelection(StrBfrCopiar.toString());
         //Se vuelve a inicializar la variable en caso se hagan multiples copiados
         CbdAuxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
         //Auxiliar obtendra los valores de "Aux_Copiar" y son declarados tipo matriz para al momento de pegar tener el bloque de celdas creado correctamente
         CbdAuxiliar.setContents(StrStnAuxCopiar,StrStnAuxCopiar);
    
        }//fin ProcediminetoCopiado
        

    public void actionPerformed(ActionEvent e){
    //verificacion de cual evento se esta realizando
    if (e.getActionCommand().compareTo("Copy")==0){
        ProcedimientoCopiado();
      return;
      }//fin if
    
    if(e.getActionCommand ().compareTo ("Paste")==0){
        ProcedimientoPegado();
    return;
            }//fin if

        }//fin metodo
}