package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoDAO {

	private String driver = "org.postgresql.Driver";
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	

	public ConexaoDAO() {
		url = "jdbc:postgresql://localhost:5432/postgres";
		usuario = "postgres";
		senha = "1234";

		try {
			Class.forName(driver);

			this.con = (Connection) DriverManager.getConnection(url, usuario, senha);
			
			
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
	}

	public Connection getConexao() {
		return this.con;
	}

	public void fecharConexao() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
