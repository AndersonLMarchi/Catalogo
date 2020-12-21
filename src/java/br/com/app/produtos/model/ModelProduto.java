package br.com.app.produtos.model;

import java.sql.Date;

/**
 *
 * @author Anderson Luis Marchi
 */
public class ModelProduto {

    private Integer codigo;
    private String nome;
    private String produto;
    private String veiculo;
    private Date dataInclusao;
    private Double pesoLiquido;
    private Double pesoBruto;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataInclusao() {
        return dataInclusao;
    }

    public void setDataInclusao(Date dataInclusao) {
        this.dataInclusao = dataInclusao;
    }

    public Double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(Double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public Double getPesoBruto() {
        return pesoBruto;
    }

    public void setPesoBruto(Double pesoBruto) {
        this.pesoBruto = pesoBruto;
    }

}

/*
DROP TABLE IF EXISTS app.produtos;
CREATE TABLE app.produtos (
	prodcodigo integer not null,
	prodnome varchar(200) not null,
	prodveiculo varchar(200),
	proddatainclusao date default current_date,
	prodpesoliquido numeric(15,2) not null,
	prodpesobruto numeric(15,2) not null,
	CONSTRAINT check_peso_produtos CHECK (prodpesoliquido <= prodpesobruto),
	CONSTRAINT pk_produtos PRIMARY KEY (prodcodigo)
);
*/