package servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import servicos.manipulacaoarquivos.ManipulaArquivo;

/**
 * Classe responsável por anunciar e comprar/alugar imóveis na plataforma JotaImoveis.
 * @author lucas
 */
public class JotaImoveisGerencia {
    
    private ArrayList<Imovel> imoveisCadastrados;
    private ArrayList<Imovel> imoveisSelecionados;
    private GeraCasas gerador = new GeraCasas();
    private ManipulaArquivo manArquivosImoveis;
    private boolean alugar = false;
    
    /**
     * 
     */
    private void geraArquivoDosImoveis(){
        manArquivosImoveis.abrirArquivoParaGravacao();
        manArquivosImoveis.gravarImovel(gerador.geraArquivo());
        manArquivosImoveis.fechaArquivoGravacao();
    }

    /**
     * 
     */
    private void leArquivosDosImoveis(){
        manArquivosImoveis.abrirArquivoParaLeitura();
        imoveisCadastrados = new ArrayList<>(manArquivosImoveis.lerArquivo());
  
        manArquivosImoveis.fecharArquivoLeitura();
    }

    /**
     * 
     */
    public void obtemImoveisSelecionados(boolean alugar, String casa_ou_apartamento, String estado, String cidade) {
        if (alugar == true) {
            this.alugar = true;
        }
        if (casa_ou_apartamento.equalsIgnoreCase("Casa")) {
            for (Imovel temp_imovel : this.imoveisCadastrados) {
                if (temp_imovel instanceof Casa && temp_imovel.getCidade().equalsIgnoreCase(estado) && temp_imovel.getEstado().equalsIgnoreCase(estado)) {
                    this.imoveisSelecionados.add(temp_imovel);
                }
                if (this.imoveisSelecionados.size() == 10) {
                    break;
                }
            }
        }
        if (casa_ou_apartamento.equalsIgnoreCase("Apartamento")) {
            for (Imovel temp_imovel : this.imoveisCadastrados) {
                if (temp_imovel instanceof Apartamento && temp_imovel.getCidade().equalsIgnoreCase(estado) && temp_imovel.getEstado().equalsIgnoreCase(estado)) {
                    this.imoveisSelecionados.add(temp_imovel);
                }
                if (this.imoveisSelecionados.size() == 10) {
                    break;
                }
            }
        }
        gerarImagemImovel();    //Associa uma imagem aleatória à cada Imovel da coleção
    }

    /**
     * Inicializa e lê o arquivo de imóveis
     */
    public JotaImoveisGerencia() {
        manArquivosImoveis = new ManipulaArquivo("ListaDeImoveis");
        geraArquivoDosImoveis();
        leArquivosDosImoveis();
    }
    

    public ArrayList<Imovel> getImoveisCadastrados() {
        return imoveisCadastrados;
    }

    public void setImoveisCadastrados(ArrayList<Imovel> imoveisCadastrados) {
        this.imoveisCadastrados = imoveisCadastrados;
    }

    public ArrayList<Imovel> getImoveisSelecionados() {
        return imoveisSelecionados;
    }

    public void setImoveisSelecionados(ArrayList<Imovel> imoveisSelecionados) {
        this.imoveisSelecionados = imoveisSelecionados;
    }

    public void getGerador() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    /**
     * Atribui à um String  caminho da imagem associada a cada imóvel selecionado da Lista
     * 
     */
    public void gerarImagemImovel(){
        ArrayList<Integer> numerosSorteados = new ArrayList<Integer>();

        //Preenche o ArrayList com uma sequência de numeros de 1 a 30
        for (int i = 1; i<31; i++)
            numerosSorteados.add(i);

        //Embaralha a ordem dos elementos do Array de números
        Collections.shuffle(numerosSorteados);

        for (int i = 0; i<10; i++){
            //Concatena um número aleatório da ArrayList de numeros sorteados entre 1 a 30 a cada loop
            //com o caminho relativo da imagem
            if(this.imoveisCadastrados.get(i) instanceof Casa)
                this.imoveisSelecionados.get(i).setfonteImagem("residencia" + numerosSorteados.get(i)); //se for do tipo Casa
            else
                this.imoveisSelecionados.get(i).setfonteImagem("apartamento" + numerosSorteados.get(i)); //se for Apartamento
        }
    }
}
