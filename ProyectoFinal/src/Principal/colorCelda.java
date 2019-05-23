package Principal;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class colorCelda extends DefaultTableCellRenderer{
    
    public Integer[]filasColorear; //VEctor para verificar las celdas a colorear
    //public Integer[]columnasColorear;
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
      super.getTableCellRendererComponent (table, value, isSelected, hasFocus, row, column);
      
      if(validarCelda(row/*, column*/)){//Se verfican las celdas en el vector para colorearlas 
          
          this.setBackground(Color.yellow); //Se le asigna un color
                
      }
      
      return this;
   }
   //Validar celdas en la matriz
   private boolean validarCelda (int Row/*, int Column*/){
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
}