/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.awt.datatransfer.*;

import java.util.*;
import java.io.IOException;

/**
 *
 * @author TheVolts
 */
public class Pegado implements ActionListener {
    

    private Clipboard Auxiliar;
    //Declaracion de variable que manejara la Tabla de la Hoja de Excel
    private JTable Hoja_Excel ;
    
    public Pegado(JTable myJTable){
        //Se iguala la variable a myJTable para que esta obtenga todos los datos existentes en la Hoja de Excel
        Hoja_Excel = myJTable;
        //Declaracion del Evento KeyPress para pegar con la combinacion de teclas Ctrl+V
        KeyStroke pegar = KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK,false);
        //Se indica que la variable Hoja_Excel hara la accion de pegar
        Hoja_Excel.registerKeyboardAction(this,"Paste",pegar,JComponent.WHEN_FOCUSED);
        //Se iguala la variable auxiliar para que esta se diriga al Clipboard y efectue el proceso de copiar y pegar
        Auxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();
        
    }




    public JTable getJTable() {
        return Hoja_Excel;
    }
    

    public void setJTable(JTable Hoja){
        this.Hoja_Excel=Hoja;
    }

    
    void showErrorMessage(String Mensaje){
        
        JOptionPane.showMessageDialog(null, "asdasd",Mensaje,JOptionPane.ERROR_MESSAGE);
    }

    
void pasteAction(){
Auxiliar = Toolkit.getDefaultToolkit().getSystemClipboard();



try{
    
String data= (String)Auxiliar.getData(DataFlavor.stringFlavor);
//
if(data==null) {
    showErrorMessage("No data on clipboard");
    return;
}

int selectCol=Hoja_Excel.getSelectedColumn();
int selectRow=Hoja_Excel.getSelectedRow();

//Condicion if cuando 
if(selectCol<0||selectRow<0) {
    showErrorMessage("Please Select cell");
    return;
}
//devuelve clipboard contenido

StringTokenizer st,stTmp;

st=new StringTokenizer(data,"\n");

int pasteRows=st.countTokens ();

st=new StringTokenizer(st.nextToken ().trim (),"\t");

int pasteCols=st.countTokens ();

int marginCols=Hoja_Excel.getColumnCount()-selectCol;

int marginRows=Hoja_Excel.getRowCount()-selectRow;

//revisa espacio disponible
if(marginCols<pasteCols || marginRows<pasteRows){
    showErrorMessage("La tabla no posee el espacio suficiente para pegar los datos");
    return;
    }

st=new StringTokenizer (data,"\n");

int rowCount=0,colCount;


//copia a la tabla
    while(st.hasMoreTokens()){
        
    
        stTmp=new StringTokenizer (st.nextToken (),"\t");
        colCount=0;
    
        while(stTmp.hasMoreTokens ()){
    
        Hoja_Excel.setValueAt(stTmp.nextToken (),rowCount+selectRow,colCount+selectCol);
        colCount++;
        
        }

        rowCount++;
        
    }//fin ciclo while

    }//fin del try

    catch(UnsupportedFlavorException uf){
    
    System.out.println ("uf="+uf.getMessage ());

    }
    catch(IOException io){
    
    System.out.println ("io="+io.getMessage ());

    }

        }



    public void actionPerformed(ActionEvent e){
        
    if(e.getActionCommand ().compareTo ("Paste")==0){
        pasteAction();return;}

         }
    }
