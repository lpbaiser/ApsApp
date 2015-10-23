package Jogo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private Connection con;
	
	public Conexao() {
		try{
			String url = "jdbc:postgresql://localhost/jdbcApp?user=root&password=root123";
		
			Class.forName("org.postgresql.Driver");
		
			con = DriverManager.getConnection(url);
		
			System.out.println("Conectou!");
			
//			insereFunc("Leonardo", 500.0f);
//			insereFunc("Fulano", 200.0f);
//			insereFunc("Siclano", 1550.0f);
//			updateFunc("Leonardo", 1000.11f);
//			deleteFunc("Siclano");
			
		
		}
		catch(ClassNotFoundException ex){
			System.out.println("Falha ao ler JDBC");
		}
		catch (SQLException ex) {
			System.out.println("Impossivel conectar");
		}
		catch(Exception ex){
			System.out.println("Erro ao conectar no postgree");
		}
	}
	
//	public boolean insereFunc(String nome, float salario){
//		try{
//			if( con == null || con.isClosed() ){
//				throw new Exception("Inicialização da conexão é requerida primeiro!");
//			}
//			
//			Statement statement = con.createStatement();
//			String sql = "INSERT INTO funcionario (nome, salario) VALUES ('"+nome+"',"+salario+")";
//			
//			statement.execute(sql);
//			
//			System.out.println("Executando consulta: "+sql);
//			System.out.println("ready");
//			
//			return true;
//		}
//		catch(Exception ex){
//			
//			System.out.println("Erro: " + ex.getMessage());
//			
//			return false;
//		}
//	}
//	
//	
//	public boolean updateFunc(String nome, float salario){
//		try{
//			if( con == null || con.isClosed() ){
//				throw new Exception("Inicialização da conexão é requerida primeiro!");
//			}
//			
//			Statement statement = con.createStatement();
//			String sql = "UPDATE funcionario SET salario = "+ salario +" WHERE nome = "+nome;
//			
//			statement.execute(sql);
//			
//			System.out.println("Executando consulta: "+sql);
//			System.out.println("ready");
//			
//			return true;
//		}
//		catch(Exception ex){
//			
//			System.out.println("Erro: " + ex.getMessage());
//			
//			return false;
//		}
//	}
//	
//	public boolean deleteFunc(String nome){
//		try{
//			if( con == null || con.isClosed() ){
//				throw new Exception("Inicialização da conexão é requerida primeiro!");
//			}
//			
//			Statement statement = con.createStatement();
//			String sql = "DELETE FROM funcionario WHERE nome = "+nome;
//			
//			statement.execute(sql);
//			
//			System.out.println("Executando consulta: "+sql);
//			System.out.println("ready");
//			
//			return true;
//		}
//		catch(Exception ex){
//			
//			System.out.println("Erro: " + ex.getMessage());
//			
//			return false;
//		}
//	}
	
	
}
