/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Parcial2;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Oscar
 */
public class P2 {
    static Scanner tipo = new Scanner (System.in);


   
public static void BuscarNiv(){
       System.out.println("ingresar el niv para buscalo");
      String niv = tipo.next();
        String url = "jdbc:mysql://localhost:3306/bdcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
         
            Connection conexion = DriverManager.getConnection(url,"root","oscarlemus18");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "SELECT * FROM tb_comision where niv = " +niv;
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                System.out.println("\nNiv   ="+resultado.getInt(1));
                System.out.println("Nombre  = "+resultado.getString(2));
                System.out.println("Enero   ="+resultado.getInt(3));
                System.out.println("Febrero ="+resultado.getInt(4));
                System.out.println("Marzo   ="+resultado.getInt(5));
                System.out.println("Abril   ="+resultado.getInt(6));
                System.out.println("Mayo    ="+resultado.getInt(7));
                System.out.println("Junio ="+resultado.getInt(8));
                System.out.println("\n");
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}


public static void ConsultasSuma(){
         System.out.println("Suma  de los empleados");

        String url = "jdbc:mysql://localhost:3306/bdcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","oscarlemus18");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "Select Niv, nombre, (enero+febrero+marzo+abril+mayo+junio) from tb_comision;";
             
          
            ResultSet resultado = sentencia.executeQuery(sql);
       
            while(resultado.next()){
                 System.out.println("\nNiv ="+resultado.getInt(1));
                System.out.println("Nombre = "+resultado.getString(2));
                System.out.println("TOTAL ="+resultado.getInt(3));
               
                
              
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}


public static void CambiarNombre(){
    System.out.println("ingrese el Niv: ");
  String niv = tipo.next();
    System.out.println("ingrese el nuevo nombre: ");
    String nuevonombre = tipo.next();
    
     String url = "jdbc:mysql://localhost:3306/bdcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","oscarlemus18");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "update tb_comision set nombre = '"+nuevonombre+"' where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}
      


public static void Eliminar(){
   
    System.out.println("ingrese el Niv a eliminar: ");
String niv = tipo.next();
int elec;
 System.out.println("Quieres Eliminarlo?: ");
  System.out.println("1. SI ");
  System.out.println("2. NO ");
  
elec=tipo.nextInt();
    switch(elec){
        case 1:
            
            break;
            
       case 2:
        
            break;
      
         
    }
     String url = "jdbc:mysql://localhost:3306/bdcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            
            Connection conexion = DriverManager.getConnection(url,"root","oscarlemus18");
           
            Statement sentencia = conexion.createStatement();
          
            String sql = "delete from tb_comision  where niv = '"+niv+"' ";
             
          
            sentencia.executeUpdate(sql);
                      
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
}


public static void main(String[] args) {
    int menu;
         System.out.println("1. BuscarNiv");
          System.out.println("2. Total de las Sumas ");
          System.out.println("3. Cambiar Nombre ");
          System.out.println("4. Eliminar ");
    menu=tipo.nextInt();
    switch(menu){
        case 1:
            BuscarNiv();
            break;
            
       case 2:
        ConsultasSuma();
            break;
       case 3:
           CambiarNombre();
            break;
       case 4:
            Eliminar();
            break;  
         
    }


}
}

