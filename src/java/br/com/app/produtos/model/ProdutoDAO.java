package br.com.app.produtos.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anderson Luis Marchi
 */
public class ProdutoDAO {

    /**
     * Retorna o último valor do campo código da tabela de Produto
     *
     * @return Integer
     */
    public Integer buscaSequenciaProduto() {
        Statement st = null;
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();

        try {
            st = con.createStatement();
            String sql = "update app.produto set prodcodigo = prodcodigo + 1 returning prodcodigo ";
            rs = st.executeQuery(sql);
            return rs.getInt("prodcodigo");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Método para inclusão de dados de Produto no banco de dados
     *
     * @param produto
     * @return boolean Sucesso | Erro
     */
    public boolean insereProduto(ModelProduto produto) {

        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();

        try {
            //Statement st = con.createStatement();

            PreparedStatement ps = con.prepareStatement("insert into app.produto (prodcodigo, prodnome, prodveiculo, proddatainclusao, prodpesoliquido, prodpesobruto) values ( ?,  ?,  ?,  ?,  ?,  ?)");
            ps.setInt(1, produto.getCodigo());
            ps.setString(2, produto.getNome());
            ps.setString(3, produto.getVeiculo());
            ps.setDate(4, produto.getDataInclusao());
            ps.setDouble(5, produto.getPesoLiquido());
            ps.setDouble(6, produto.getPesoBruto());

            boolean retorno = ps.execute();
            conexao.Desconectar();
            return retorno;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Busca por toda a informação armazenada na tabela de Produtos
     *
     * @return List of ModelProduto
     */
    public List<ModelProduto> listaProdutos() {

        ArrayList<ModelProduto> lista = new ArrayList<>();

        Statement st = null;
        ResultSet rs = null;
        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();

        try {
            st = con.createStatement();
            String sql = "select * from app.produto ";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                ModelProduto produto = new ModelProduto();
                produto.setCodigo(rs.getInt(1));
                produto.setNome(rs.getString(2));
                produto.setVeiculo(rs.getString(3));
                produto.setDataInclusao(rs.getDate(4));
                produto.setPesoLiquido(rs.getDouble(5));
                produto.setPesoBruto(rs.getDouble(5));
                lista.add(produto);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                conexao.Desconectar();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    /**
     * Método para excluir um produto baseado no código dele
     * 
     * @param produto
     * @return boolean
     * @throws SQLException 
     */
    public boolean removeProduto(ModelProduto produto) throws SQLException {

        Conexao conexao = new Conexao();
        Connection con = conexao.getConnection();

        try {
            Statement st = con.createStatement();
            String sql = "delete from app.produto where prodcodigo = " + produto.getCodigo();
            return st.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return false;
    }

}
