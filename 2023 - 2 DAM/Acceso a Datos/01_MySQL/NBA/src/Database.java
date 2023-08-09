import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Database {
	protected static ArrayList<String[]> getDivisionesConf(){
        try {
            //mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection (CommonVar.getDatabase(), CommonVar.getUser(), CommonVar.getPassword());
            java.sql.Statement sentencia = conexion.createStatement();
            String sql = "SELECT distinct(division), conferencia FROM equipos order by conferencia, division;";
            ResultSet resul = ((java.sql.Statement) sentencia).executeQuery(sql);
            ArrayList<String[]> resultado = new ArrayList<String[]>();
            while (resul.next()){
            	String[] consulta = new String[2];
            	consulta[0] = resul.getString("division");
            	consulta[1] = resul.getString("conferencia");
                
            	resultado.add(consulta);
            }
            return resultado;

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	protected static ArrayList<String[]> getEqConf(String conferencia){
        try {
            //mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection (CommonVar.getDatabase(), CommonVar.getUser(), CommonVar.getPassword());
            java.sql.Statement sentencia = conexion.createStatement();
            String sql = "SELECT nombre, conferencia FROM equipos where conferencia = '"+conferencia+"';";
            ResultSet resul = ((java.sql.Statement) sentencia).executeQuery(sql);
            ArrayList<String[]> resultado = new ArrayList<String[]>();
            while (resul.next()){
            	String[] consulta = new String[2];
            	consulta[0] = resul.getString("nombre");
            	consulta[1] = resul.getString("conferencia");
                
            	resultado.add(consulta);
            }
            return resultado;

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	protected static ArrayList<String[]> getJugadores(String equipo){
        try {
            //mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection (CommonVar.getDatabase(), CommonVar.getUser(), CommonVar.getPassword());
            java.sql.Statement sentencia = conexion.createStatement();
            String sql = "SELECT * FROM jugadores where nombre_equipo = '" + equipo + "';";
            ResultSet resul = ((java.sql.Statement) sentencia).executeQuery(sql);
            ArrayList<String[]> resultado = new ArrayList<String[]>();
            while (resul.next()){
            	String[] consulta = new String[7];
            	consulta[0] = String.valueOf(resul.getInt("codigo")) ;
            	consulta[1] = resul.getString("nombre");
            	consulta[2] = resul.getString("procedencia");
            	consulta[3] = resul.getString("altura");
            	consulta[4] = String.valueOf(resul.getInt("peso"));
            	consulta[5] = resul.getString("posicion");
            	consulta[6] = resul.getString("nombre_equipo");
            	
                
            	resultado.add(consulta);
            }
            return resultado;

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
	
	protected static ArrayList<String[]> getPartidos(String equipo){
        try {
            //mysql
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection (CommonVar.getDatabase(), CommonVar.getUser(), CommonVar.getPassword());
            java.sql.Statement sentencia = conexion.createStatement();
            String sql = "select concat(equipo_local, ' - ', equipo_visitante) as partido, " +
            		"if(equipo_local = '"+ equipo + "', puntos_local, puntos_visitante) as puntos, " +
            		"(select avg(puntos_local) from partidos where equipo_local = '"+ equipo + "') as avg_puntos_local, " +
            		"(select avg(puntos_visitante) from partidos where equipo_visitante = '" + equipo + "') as avg_puntos_visitante" +
            		" from partidos " + 
            		" where equipo_local = '" + equipo + "' || equipo_visitante = '" + equipo + "';";
            ResultSet resul = ((java.sql.Statement) sentencia).executeQuery(sql);
            ArrayList<String[]> resultado = new ArrayList<String[]>();
            while (resul.next()){
            	String[] consulta = new String[4];
            	consulta[0] = resul.getString("partido") ;
            	consulta[1] = resul.getString("puntos");
            	consulta[2] = String.valueOf(resul.getDouble("avg_puntos_local"));
            	consulta[3] = String.valueOf(resul.getDouble("avg_puntos_visitante"));
                
            	resultado.add(consulta);
            }
            return resultado;

        } catch (ClassNotFoundException cn) {
            cn.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
