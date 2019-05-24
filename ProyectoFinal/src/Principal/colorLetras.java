package Principal;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class colorLetras extends DefaultTableCellRenderer{
    
    public int[]filasColorear; //VEctor para verificar las celdas a colorear
    public int[]columnasColorear;
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
//      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      super.getTableCellRendererComponent(table,value,isSelected,
             hasFocus,row,column);
      if(validarFila(row)&&validarColumna(column)){//Se verfican las celdas en el vector para colorearlas 
          
          this.setForeground(colorLetra); //Se le asigna un color
                
      }else{
          this.setBackground(null);
      }
      
      return this;
   }
   //Validar celdas en la matriz
   private boolean validarFila (int Row/*, int Column*/){
       boolean resultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: filasColorear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
             //Condicional para obtener la celda selecionada
               //for(Integer arrayColorearCeldass: columnasColorear ){
                   if(arrayColorearCeldas==Row/*&&arrayColorearCeldass==Column*/){
                   resultado = true;
                   break;
              // }
               
           }
       }
       
       return resultado;
   }
   private boolean validarColumna (int Row/*, int Column*/){
       boolean resultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: columnasColorear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
             //Condicional para obtener la celda selecionada
               //for(Integer arrayColorearCeldass: columnasColorear ){
                   if(arrayColorearCeldas==Row/*&&arrayColorearCeldass==Column*/){
                   resultado = true;
                   break;
              // }
               
           }
       }
       
       return resultado;
   }
   

}