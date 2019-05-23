package Principal;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.datatransfer.*;
import java.util.*;
import java.io.IOException;

public class Pegado implements ActionListener {
    
    //Declaracion de una variable tipo privada declarada tipo Clipboard la cual se encargara de habilitar la funcionalidad del Copiado y Pegado en la Tabla
    private Clipboard Auxiliar;
    //Declaracion de variable que manejara los datos internos de la Tabla
    private JTable Hoja_Excel ;
    //Declaracion de una variable tipo StringSelection la cual se encargara de obtener los datos en el metodo ProcedimientoCopiado y luego ser usados por la Variable Auxiliar
    //para su aplicacion en el Clipboard
    private StringSelection Aux_Copiar;
    
    //Metodo que declara los eventos keypress en la Tabla
    public Pegado(JTable Tabla){
        //Se iguala la variable a myJTable para que esta obtenga todos los datos existentes en la Hoja de Excel
        Hoja_Excel = Tabla;
        //Declaracion del Evento KeyPress para copiar con la combinacion de teclas Ctrl+C
        KeyStroke copiar = KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK,false);
        //Declaracion del Evento KeyPress para pegar con la combinacion de teclas Ctrl+V
        KeyStroke pegar = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
        //Se indica que la variable Hoja_Excel hara la accion de copiar 
        Hoja_Excel.registerKeyboardAction(this,"Copy",copiar,JComponent.WHEN_FOCUSED);
        //Se indica que la variable Hoja_Excel hara la accion de pegar 
        Hoja_Excel.registerKeyboardAction(this,"Paste",pegar,JComponent.WHEN_FOCUSED);
        //Se iguala la variable auxiliar para que esta se diriga al Clipboard y efectue el proceso de copiar y pegar
        Auxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
        
    }//fin Pegado

    //Metodo necesario para el funcionamiento del Clipboard, 
    public JTable getJTable() {
        return Hoja_Excel;
    }
    
    //Metodo necesario para el funcionamiento del Clipboard
    public void setJTable(JTable Hoja){
        this.Hoja_Excel=Hoja;
    }

    void ProcedimientoPegado(){
        //se inicializa la variable para eliminar posible cache que exista de un copiado y pegado anterior
        Auxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
    try{
        //declaracion de variable que se encargara de almacenar el dato a copiar del clipboard(portapapeles)
        String dato= (String)Auxiliar.getData(DataFlavor.stringFlavor);
        //Verificacion que exista un dato para pegar en una celda)
     
    //Declaracion de variables que obtendran la posicion final para hacer el pegado en la Tabla 
    int Dato_Col=Hoja_Excel.getSelectedColumn();
    int Dato_Fila=Hoja_Excel.getSelectedRow();

    //Condicion if cuando no se ha seleccionado una celda 
    if(Dato_Col<0||Dato_Fila<0) {   
         JOptionPane.showMessageDialog(null, "No ha Seleccionado una Celda para Pegar el Contenido","Aviso",JOptionPane.ERROR_MESSAGE);
        return;
    }//fin ciclo if

    //Declaracion de Variables para utilizar los tokens
    StringTokenizer Token1,Token_de_pegado;
    //la variable Token1 se encargara de almacenar el contenido de cada variable "dato" y la separara con un "\n"  
    Token1=new StringTokenizer(dato,"\n");
    //Se declara una variable que hara el conteo de filas por medio de tokens del area seleccionada a pegar por el usuario
    int Filas_a_Pegar=Token1.countTokens ();
    //la variable Token1 se encargara de almacenar y separar cada dato siguiente de Token1 por medio de un "\t"
    Token1=new StringTokenizer(Token1.nextToken ().trim (),"\t");
    //Se declara una variable que hara el conteo de columnas por medio de tokens del area seleccionada a pegar por el usuario
    int Col_a_Pegar=Token1.countTokens ();
    //variable que se encargara de obtener los datos entre todas las columnas existentes y le resta la columna seleccionada por el usuario
    int MargenCol=Hoja_Excel.getColumnCount()-Dato_Col;
      //variable que se encargara de obtener los datos entre todas las filas existentes y le resta la fila seleccionada por el usuario
    int MargenFila=Hoja_Excel.getRowCount()-Dato_Fila;
    //verificacion en caso el usuario desee pegar los datos en un area de la Tabla donde no existan columnas o filas suficientes
    if(MargenCol<Col_a_Pegar || MargenFila<Filas_a_Pegar){
        
        JOptionPane.showMessageDialog(null,"La Tabla NO Posee el Espacio Suficiente para Pegar los Datos","Aviso",JOptionPane.ERROR_MESSAGE);
        return;
    }    
    //la variable Token1 se encargara de almacenar el contenido de cada variable "dato" y la separara con un "\n"  
        Token1=new StringTokenizer (dato,"\n");
    //Declaracion de variables usadas para el contador en el siguiente ciclo while
    int Contador_Fila=0,Contador_Col;

    //ciclo que extrae los tokens obtenidos anteriormente por la variable "Token1"
    while(Token1.hasMoreTokens()){
        
        //divide cada token que tenga una coincidencia de "\t" hasta llegar a la posicion final (celda donde se desea colocar el dato)
        Token_de_pegado=new StringTokenizer (Token1.nextToken (),"\t");
        
        Contador_Col=0; 
        //ciclo para iniciar la transferencia de datos de una celda a la otra("pegado")
        while(Token_de_pegado.hasMoreTokens ()){
        //Sentencia que se encargara de obtener el dato a pegar y la posicion 
        Hoja_Excel.setValueAt(Token_de_pegado.nextToken (),Contador_Fila+Dato_Fila,Contador_Col+Dato_Col);
       //Autosuma de 1 a la variable Contador_Col
        Contador_Col++;
        
        }//fin del segundo ciclo while
        //Autosuma de 1 a la variable Contador_Fila
        Contador_Fila++;
        
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
        StringBuffer Copiar=new StringBuffer();
         
         //Declaracion de variables las cuales comprueban si se ha seleccionado un bloque de celdas para copiar o solamente una unica celda
         //variable que obtendra el numero de columnas
         int num_col=Hoja_Excel.getSelectedColumnCount();
         //variable que obtendra el numero de filas
         int num_filas=Hoja_Excel.getSelectedRowCount();
         //Declaracion de vectores para que el programa conozca el tamaño del bloque seleccionado
         //vector para las filas
         int[] rowsselected=Hoja_Excel.getSelectedRows();
         //vector para las columnas
         int[] colsselected=Hoja_Excel.getSelectedColumns();
         
         //ciclo for para obtener el o los valores a copiar del bloque de celdas seleccionadas por el usuario
         for (int ciclo_fil=0;ciclo_fil<num_filas;ciclo_fil++){
            for (int ciclo_col=0;ciclo_col<num_col;ciclo_col++){
                //.append se encarga de guardar en la variable "copiar" el contenido que esta entre los ( ) en tipo cadena, esto por declarar la variable tipo StringBuffer
                //la variable se encarga de guardar los datos que se encuentran en la 
                Copiar.append(Hoja_Excel.getValueAt(rowsselected[ciclo_fil],colsselected[ciclo_col]));        
                //ciclo if el cual se encargara de colocar los datos copiados en columnas y luego en el metodo ProcedimientoPegado se agregaran de la forma ingresada por el usuario      
               if (ciclo_col<num_col-1) Copiar.append("\t");
                        
            }//fin segundo ciclo for
            //
            Copiar.append("\n");
         }//fin primer ciclo for
         
         //La variable "Aux_Copiar" guardara la matriz de los datos a copiar(el bloque de celdas seleccionadas por el usuario)
         Aux_Copiar  = new StringSelection(Copiar.toString());
         //Se vuelve a inicializar la variable en caso se hagan multiples copiados
         Auxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
         //Auxiliar obtendra los valores de "Aux_Copiar" y son declarados tipo matriz para al momento de pegar tener el bloque de celdas creado correctamente
         Auxiliar.setContents(Aux_Copiar,Aux_Copiar);
    
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
