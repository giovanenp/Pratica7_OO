package br.com.pratica7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsereLivro {
  
  private static final String INSERT_LIVROS_SQL = "INSERT INTO livro (id_isbn, id_categoria, id_editora, nm_titulo, dt_publicacao, nu_edicao, nu_volume, vl_preco) VALUES  (?,?,?,?,?,?,?,?)";

  public void insertRecord() throws SQLException {
    Connection conn = ConexaoPostgre.connect();

    try {
      PreparedStatement pstmt = conn.prepareStatement(INSERT_LIVROS_SQL);
      pstmt.setString(1, "123456676");
      pstmt.setInt(2, 1);
      pstmt.setInt(3, 2);
      pstmt.setString(4, "Mágico de Oz");
      pstmt.setString(5, "2022-11-17");
      pstmt.setInt(6, 1321);
      pstmt.setInt(7, 1);
      pstmt.setDouble(8, 12.50);
      
      pstmt.executeUpdate();
    } catch (SQLException e) {
      ConexaoPostgre.printSQLException(e);
    }
    conn.close();
  }
}
