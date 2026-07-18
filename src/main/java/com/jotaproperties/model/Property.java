package com.jotaproperties.model;
/**
 * Classe abstrata responsável por definir uma entidade padrão (imóvel) para que seja herdado pela classe casa ou apartamento
 * 
 * @author Lucas Henrique
 */
public abstract class Property {
  
    private int numeroDoAnuncio;
    private String fonteImagem;
    private String cidade;
    private String estado;
    private String descricao;
    private Double valor;
    private Integer vagasGaragem;
    private double area;
    
    /**
     * Construtor da classe
     */
    public Property(int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area) {
        this.numeroDoAnuncio = numeroDoAnuncio;
        this.descricao = descricao;
        this.valor = valor;
        this.cidade = cidade;
        this.estado = estado;
        this.vagasGaragem = vagasGaragem;
        this.area = area;
    }

    /* Getters e setters */
    public int getNumeroDoAnuncio() {
        return numeroDoAnuncio;
    }

    public String getfonteImagem() {
        return fonteImagem;
    }

    public void setfonteImagem(String fonteImagem) {
        this.fonteImagem = fonteImagem;
    }

    public void setNumeroDoAnuncio(int numeroDoAnuncio) {
        this.numeroDoAnuncio = numeroDoAnuncio;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getVagasGaragem() {
        return vagasGaragem;
    }

    public void setVagasGaragem(int vagasGaragem) {
        this.vagasGaragem = vagasGaragem;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
