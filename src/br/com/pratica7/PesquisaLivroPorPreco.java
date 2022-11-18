package br.com.pratica7;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PesquisaLivroPorPreco {
  private double vl_preco;
 
  private static final String SELECT_LIVROS_BY_PRECO_SQL = "SELECT id_isbn, id_categoria, id_editora, nm_titulo, dt_publicacao, nu_edicao, nu_volume, vl_preco FROM livro WHERE vl_preco = ?";
 
  public PesquisaLivroPorPreco(double vl_preco) {
    this.vl_preco = vl_preco;
  }

  public String selectRecordByPreco() {
    Connection conn = ConexaoPostgre.connect();
    String str = "";
    try {
      PreparedStatement pstmt = conn.prepareStatement(SELECT_LIVROS_BY_PRECO_SQL);
      pstmt.setDouble(1, this.vl_preco);
      ResultSet rs = pstmt.executeQuery();
      while (rs.next()) {
        String id_isbn = rs.getString("id_isbn");
        String name_autor = rs.getString("nm_titulo");
        str = id_isbn + " - " + name_autor;
      }
    } catch (SQLException e) {
      ConexaoPostgre.printSQLException(e);
    }
    return str;
  }
  
}
