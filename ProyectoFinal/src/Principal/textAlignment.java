
package Principal;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class textAlignment extends DefaultTableCellRenderer{
    
    public int[]filasAlinear; //VEctor para verificar las celdas a alinear
    public int[]columnasAlinear;
    int tipoTexto;
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
          switch(tipoTexto){
            case 1:
                this.setHorizontalAlignment(LEFT);

                break;
            case 2:
                this.setHorizontalAlignment(CENTER);

                break;
            case 3:
                this.setHorizontalAlignment(RIGHT);
                
                break;
            case 4:
                this.setVerticalAlignment(CENTER);
                
                break;
            case 5:
                this.setVerticalAlignment(TOP);
                
                break;
            case 6:
                this.setVerticalAlignment(BOTTOM);
            
            break;
          
          }
                
      }else{
          this.setBackground(null);
      }
      
      return this;
   }
   //Validar celdas en la matriz
   private boolean validarFila (int Row){
       boolean resultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: filasAlinear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
            if(arrayColorearCeldas==Row){
                resultado = true;
                break;
               
           }
       }
       
       return resultado;
   }
   private boolean validarColumna (int Column){
       boolean resultado = false; //Inicializacion de variable
       
       for(Integer arrayColorearCeldas: columnasAlinear ){ //Ciclo para recorrrer el vector y verificar si la celda se encuentra en el
           
                   if(arrayColorearCeldas==Column){
                   resultado = true;
                   break;
              // }
               
           }
       }
       
       return resultado;
   }
    
}
