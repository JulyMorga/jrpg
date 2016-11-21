package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import personaje.Personaje;

public class JugadorDAO extends DAOJUGADOR<Personaje>{
	private Connection conexion = null;
	private static final String PATH_CONNECTION = "jdbc:sqlite:src/main/resources/bd/Jugadores.bd";
	private static final String INSERTAR = "Insert into Jugador values(?,?,?);";
	private static final String BUSCAR = "select *from Jugador where Usuario = ?;";
	private static final String ACTUALIZAR = "Update Jugador set Activo = ? where Usuario = ?;";
	private static final String ELIMINAR = "delete from Jugador where Usuario = ?;";
	private static final String VER_TODOS = "select *from Jugador;";
	private static final String VER_REGISTRO = "select *from Jugador where Usuario = ?;";
	
	
	public JugadorDAO() {
//		if(conexion==null) {
//			try {
//				conexion = DriverManager.getConnection(PATH_CONNECTION);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
		conexion=SQLiteConnection.getConnection();
	}
	
	@Override
	public void insertar(String user, String pass, Personaje obj) throws SQLException {
		PreparedStatement statement=null;
		try{
		statement = conexion.prepareStatement(INSERTAR);
		
		statement.setString(1, user);
		statement.setString(2, pass);
		statement.setBoolean(3, false);
		statement.execute();
		}
		catch (Exception e) {
			System.out.println("El Servidor no ha podido insertar un usuario a la base de datos.");
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				System.out.println("No se pudo cerrar el statment.");
			}
		}
		
	}

	@Override
	public void actualizar(String usuario, boolean activo) throws SQLException {
		PreparedStatement statement=null;
		try {
			statement = conexion.prepareStatement(ACTUALIZAR);
			statement.setString(2, usuario);
			statement.setBoolean(1, activo);
			
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("El Servidor no ha podido actualizar un usuario a la base de datos.");
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

	@Override
	public boolean buscar(String user) throws SQLException {
		PreparedStatement statement=null;
		statement = conexion.prepareStatement(BUSCAR);
		statement.setString(1, user);
		ResultSet res = statement.executeQuery();
		
		if(!res.next()){
			statement.close();
			return false;
		}
		statement.close();
		return true;
	}

	@Override
	public void borrar(String user) throws SQLException {
		PreparedStatement statement=null;
		try {
			statement = conexion.prepareStatement(ELIMINAR);
			statement.setString(1, user);
			statement.executeUpdate();
		} catch (Exception e) {
			System.out.println("El Servidor no ha podido borrar al usuario "+user+" de la base de datos.");
		}finally {
			try {
				statement.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
	
	//podria devolver un ArrayList de Jugadores...
	@Override
	public void listarDatos() throws SQLException {
		PreparedStatement statement;
		ResultSet res;
		statement = conexion.prepareStatement(VER_TODOS);
		
		res = statement.executeQuery();
		
		while(res.next()) {
			System.out.println(res.getString(1) + "|" + res.getString(2) + "|"  + res.getDouble(3));
		}
		statement.close();
	}

	@Override
	public void cerrar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			System.out.println("No se ha podido cerrar la conexion.");
		}
	}


	@SuppressWarnings("finally")
	@Override
	public String seleccionarUsuario(String usuario) throws SQLException {
		PreparedStatement statement;
		ResultSet res;

		statement=conexion.prepareStatement(VER_REGISTRO);
		statement.setString(1, usuario);
		res = statement.executeQuery();

		if( res.next()){
			String result=res.getString(1) + " " + res.getString(2) + " "  + res.getDouble(3);
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			finally {
				return result;	
			}
			
		}
		statement.close();
		return null;
	}

	public Connection getConexion() {
		return conexion;
	}
	
}
