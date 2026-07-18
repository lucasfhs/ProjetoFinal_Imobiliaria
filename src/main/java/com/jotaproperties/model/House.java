package com.jotaproperties.model;

/**
 * Classe que se refere a entidade casa possui como adicional uma descrição do quintal
 * @author lucas
 */
public class House extends Property {
    private String descricaoQuintal;
    private String nomeDoCondominio;

    public House(String descricaoQuintal, String nomeDoCondominio, int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area) {
        super(numeroDoAnuncio, descricao, valor, cidade, estado, vagasGaragem, area);
        this.descricaoQuintal = descricaoQuintal;
        this.nomeDoCondominio = nomeDoCondominio;
    }

    
    
    public String getNomeDoCondominio() {
        return nomeDoCondominio;
    }

    public void setNomeDoCondominio(String nomeDoCondominio) {
        this.nomeDoCondominio = nomeDoCondominio;
    }
    
    
    public String getDescricaoQuintal() {
        return descricaoQuintal;
    }

    public void setDescricaoQuintal(String descricaoQuintal) {
        this.descricaoQuintal = descricaoQuintal;
    }

}
