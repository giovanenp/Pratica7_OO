package br.com.pratica7;

import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Main {
  public static void main(String[] args) throws SQLException {
    int opcao = 0;

    while (opcao != 5) {
      opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
          "<1> Cadastrar Livro \n<2> Pesquisar Livro por Preço  \n<3> Pesquisar Livro por Título  \n<4> Excluir Livro  \n<5> Sair "));

      switch (opcao) {
        case 1:
          InsereLivro iLivro = new InsereLivro();
          iLivro.insertRecord();
          break;
        case 2:
          double vl_preco = Double
              .parseDouble(JOptionPane.showInputDialog(null, "Qual o valor do livro que deseja pesquisar?"));
          PesquisaLivroPorPreco pesquisaLivroPorPreco = new PesquisaLivroPorPreco(vl_preco);
          JOptionPane.showMessageDialog(null, pesquisaLivroPorPreco.selectRecordByPreco());
          break;
        case 3:
          break;

        case 4:
          String id_isbm = JOptionPane.showInputDialog(null, "Informe o código ISBM do livro");
          ExcluirLivro eLivro = new ExcluirLivro(id_isbm);
          eLivro.deleteRecord();
          break;
        default:
          opcao = 5;
          break;
      }
    }
  }
}
