package connection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

public class ConexionDB {
	
	static Connection conexion = null;
	static Statement instruction = null;
	static ResultSet conjuntoResultados=null;

	public static void main(String[] args) {
		
		String url ="jdbc:mysql://localhost/dam";
		String user="root";
		String pw="";
		
		try {
		//controlador para esteblecer conexion con el SGBD
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//obtenemos la conexion con getConnection de la clase Driver Manager
		try {
					 //mediador entre la app y el jdbc
			conexion = DriverManager.getConnection(url,user,pw);
			System.out.println("La conexión se ha realizado usando DriverManager");
			
			
		} catch (SQLException e) {
			//informar sobre un error
			if(e.getSQLState().equals("28000"))
				System.out.println("Error de autentificación");
			else
				try {
					throw e;
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			e.printStackTrace();
		}
			
		try {
			introducirDatos();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consultarActividades();
		

	}
	
	public static void introducirDatos() throws SQLException{
		
		//pregunto con el scanner
		Scanner sc = new Scanner(System.in);  //crear un objeto Scanner
		int id;
        String nombre;
        String asignatura;
        String inicio = null;
        String fin = null;
        boolean entregada = false;
        
        System.out.println("Escriba un id: ");       
        id = sc.nextInt(); 
        sc.nextLine();
        System.out.println("Escriba un nombre: ");
        nombre = sc.nextLine();
        System.out.println("Introduzca el nombre de la asignatura: ");
        asignatura = sc.nextLine();
        System.out.println("Escriba la fecha de inicio: ");
        inicio = sc.nextLine();
        System.out.println("Escriba la fecha fin: ");
        fin = sc.nextLine();
        System.out.println("Especifique si esta entregada o no ");
        entregada = sc.nextBoolean();
			
		
		try {
			PreparedStatement preparedStmt;
			 preparedStmt = (PreparedStatement) conexion.prepareStatement("INSERT INTO datos (id,nombre,asignatura,inicio,fin,entregada) VALUES(?,?,?,?,?,?)");
			//Introducimos los datos		
			 				//posicion y el nombre de la columna
			 preparedStmt.setInt(1,id);
			 preparedStmt.setInt(1, id);
			 preparedStmt.setString(2,asignatura);
			 preparedStmt.setString(3,nombre);
			 preparedStmt.setDate(4, Date.valueOf(inicio));
			 preparedStmt.setDate(5, Date.valueOf(fin));
			 preparedStmt.setBoolean(6, entregada);
			 
			 preparedStmt.execute();
			
		} catch (SQLException e) {
			//informar sobre un error
			if(e.getSQLState().equals("1046"))
				System.out.println("No hay una base de datos seleccionada");
			else 
				throw e;
			e.printStackTrace();
		}finally{
			//por si no se cierra el statement
			try{
				if(conjuntoResultados !=null && !conjuntoResultados.isClosed()){
					conjuntoResultados.close();
				}
			}catch(SQLException e){
				//para guardar el error
				Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
			}
			
			//por si no cierra la instruccion
			try{
				if(instruction !=null && !instruction.isClosed()){
					instruction.close();
				}
			}catch(SQLException e){
				
			}
			
			//cerrar la conexion
			try{
				if(conexion !=null & !conexion.isClosed()){
					conexion.close();
				}
			}catch(SQLException e){
				
			}
		}
		
	}
	
	public static void consultarActividades(){
		
		//lanzar statement con una consulta
		try {
			instruction = conexion.createStatement();
			conjuntoResultados = instruction.executeQuery("SELECT * FROM datos");
			
			while(conjuntoResultados.next()){
				System.out.println("Nombre: "+ conjuntoResultados.getObject("nombre")+", Id: "+
									conjuntoResultados.getObject("id")+", Asignatura: "+ 
									conjuntoResultados.getObject("asignatura")+", Inicio: "+ 
									conjuntoResultados.getObject("inicio")+", Fin: "+
									conjuntoResultados.getObject("fin")+", Entregada: "+
									conjuntoResultados.getObject("entregada"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally{
			//por si no se cierra el statement
			try{
				if(conjuntoResultados !=null && !conjuntoResultados.isClosed()){
					conjuntoResultados.close();
				}
			}catch(SQLException e){
				//para guardar el error
				Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, e);
			}
			
			//por si no cierra la instruccion
			try{
				if(instruction !=null && !instruction.isClosed()){
					instruction.close();
				}
			}catch(SQLException e){
				
			}
			
			//cerrar la conexion
			try{
				if(conexion !=null & !conexion.isClosed()){
					conexion.close();
				}
			}catch(SQLException e){
				
			}
			
		}
		
		
	}

}
