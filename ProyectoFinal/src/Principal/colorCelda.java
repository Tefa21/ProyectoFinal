package Principal;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class colorCelda extends DefaultTableCellRenderer{
    
    //Vector para verificar las celdas a colorear
    public int[]filasColorear; 
    public int[]columnasColorear;
    Color colorCelda;
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
          

          this.setBackground(colorCelda); //Se le asigna un color
                
      }else{
          this.setBackground(null);
      }
      
      return this;
   }
   //Validar celdas en la matriz
   private boolean validarFila (int Row){
       boolean resultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: filasColorear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
      
            if(arrayColorearCeldas==Row){
                
                resultado = true;
                break;
               
           }
       }
       
       return resultado;
   }
   private boolean validarColumna (int Column){
       boolean resultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: columnasColorear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
            if(arrayColorearCeldas==Column){
                resultado = true;
                break;  
           }
       }
       
       return resultado;
   }
   

}

