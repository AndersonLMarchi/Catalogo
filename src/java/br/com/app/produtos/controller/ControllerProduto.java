package br.com.app.produtos.controller;

import java.util.List;
import java.sql.SQLException;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import br.com.app.produtos.model.*;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Anderson Luis Marchi
 */
@ManagedBean(name="ProdutoMB")
public class ControllerProduto {

    private ModelProduto produto = new ModelProduto();
    private ProdutoDAO dao = new ProdutoDAO();

    public ModelProduto getProduto() {
        return produto;
    }

    public void setProduto(ModelProduto produto) {
        this.produto = produto;
    }

    public ProdutoDAO getDao() {
        return dao;
    }

    /**
     * Método para cadastrar o produto setado no objeto
     *
     * @throws SQLException
     */
    public void cadastraProduto() throws SQLException {

        this.getProduto().setCodigo(this.getDao().buscaSequenciaProduto());
        if (this.getDao().insereProduto(this.getProduto())) {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Sucesso!", "Produto cadastrado com Sucesso!"));
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro!", "Erro ao cadastrar o Produto!"));
        }
    }

    /**
     * Método para retornar a lista de produtos
     *
     * @return
     * @throws SQLException
     */
    public List<ModelProduto> getListaProdutos() throws SQLException {
        return this.getDao().listaProdutos();
    }

}
