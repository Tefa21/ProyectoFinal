package Principal;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class colorLetras extends DefaultTableCellRenderer{
    
    public int[]intFilasColorear; //VEctor para verificar las celdas a colorear
    public int[]intColumnasColorear;
    Color colorLetra;
   @Override 
   
             
   //Funcion para render de color
   public Component getTableCellRendererComponent(JTable table,
                                                  Object value,
                                                  boolean isSelected,
                                                  boolean hasFocus,
                                                  int row,
                                                  int column)
   {
       //Llamada al constructor padre
      super.getTableCellRendererComponent(table,value,isSelected,
             hasFocus,row,column);
      if(validarFila(row)&&validarColumna(column)){//Se verfican las celdas en el vector para colorearlas 
          
          this.setForeground(colorLetra); //Se le asigna un color
                
      }else{
          this.setForeground(null);
      }
      
      return this;
   }
   //Validar celdas en la matriz
   private boolean validarFila (int Row){
       boolean blnResultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: intFilasColorear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
            if(arrayColorearCeldas==Row){
                blnResultado = true;
                break;
               
           }
       }
       
       return blnResultado;
   }
   private boolean validarColumna (int Column){
       boolean blnResultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: intColumnasColorear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
                   if(arrayColorearCeldas==Column){
                   blnResultado = true;
                   break;
               
           }
       }
       
       return blnResultado;
   }
   

}
