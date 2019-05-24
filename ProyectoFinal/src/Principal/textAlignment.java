
package Principal;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
public class textAlignment extends DefaultTableCellRenderer{
    
    public int[]intFilasAlinear; //Vector para verificar las celdas a alinear
    public int[]intColumnasAlinear;
    int intTipoTexto;
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
          switch(intTipoTexto){
            case 1:
                this.setHorizontalAlignment(LEFT);
                break;
            case 2:
                this.setHorizontalAlignment(CENTER);

                break;
            case 3:
                this.setHorizontalAlignment(RIGHT);
                
                break;          
          }
                
      }else{
           this.setHorizontalAlignment(SwingConstants.LEFT);
      }
      
      return this;
   }
   //Validar celdas en la matriz
   private boolean validarFila (int Row){
       boolean blnResultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: intFilasAlinear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
            if(arrayColorearCeldas==Row){
                blnResultado = true;
                break;
               
           }
       }
       
       return blnResultado;
   }
   private boolean validarColumna (int Column){
       boolean blnResultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: intColumnasAlinear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
                   if(arrayColorearCeldas==Column){
                   blnResultado = true;
                   break;
              // }
               
           }
       }
       
       return blnResultado;
   }
    
}
