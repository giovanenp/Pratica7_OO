package br.com.pratica7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluirLivro {
  private String id_isbn;
  
  private static final String DELETE_LIVROS_BY_ID_SQL = "DELETE livro WHERE id_isbn = ?";

  public ExcluirLivro(String id_isbn) {
    this.id_isbn = id_isbn;
  }

  public void deleteRecord() {
    Connection conn = ConexaoPostgre.connect();

    try {
      PreparedStatement pstmt = conn.prepareStatement(DELETE_LIVROS_BY_ID_SQL);
      pstmt.setString(1, this.id_isbn);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      ConexaoPostgre.printSQLException(e);
    }
  }
}
