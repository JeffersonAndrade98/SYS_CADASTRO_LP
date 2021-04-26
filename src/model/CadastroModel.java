/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author JeffersonAndrade
 */
public class CadastroModel {

    private String status;
    private Float valorpg;
    private Float valortotal;
    private String quant;
    private String nome;
    private String telefone;
    private String cidade_origem;
    private String cidade_destino;
    private Date data_viagem;
    private String pesquisa;
    private Integer id;

    public Float getValorpg() {
        return valorpg;
    }

    public void setValorpg(Float valorpg) {
        this.valorpg = valorpg;
    }

    public Float getValortotal() {
        return valortotal;
    }

    public void setValortotal(Float valortotal) {
        this.valortotal = valortotal;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getValorPg() {
        return valorpg;
    }

    public void setValorPg(Float valor) {
        this.valorpg = valor;
    }
    
    
    public String getQuant() {
        return quant;
    }
    
    public void setQuant(String quant) {
        this.quant = quant;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade_origem() {
        return cidade_origem;
    }

    public void setCidade_origem(String cidade_origem) {
        this.cidade_origem = cidade_origem;
    }

    public String getCidade_destino() {
        return cidade_destino;
    }

    public void setCidade_destino(String cidade_destino) {
        this.cidade_destino = cidade_destino;
    }

    public Date getData_viagem() {
        return data_viagem;
    }

    public void setData_viagem(Date data_viagem) {
        this.data_viagem = data_viagem;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
}
