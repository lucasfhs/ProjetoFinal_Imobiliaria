package servicos;

/**
 * Classe referente a entidade apartamento possui como adicional o número do andar e se as instalações do apartamento possuem ou não um elevador
 * @author lucas
 */
public class Apartamento extends Imovel{
    private int andar;
    private boolean possuiElevador;

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public boolean isPossuiElevador() {
        return possuiElevador;
    }

    public void setPossuiElevador(boolean possuiElevador) {
        this.possuiElevador = possuiElevador;
    }

    public Apartamento(int andar, boolean possuiElevador, int numeroDoAnuncio, String descricao, double valor, String cidade, String estado, int vagasGaragem, double area) {
        super(numeroDoAnuncio, descricao, valor, cidade, estado, vagasGaragem, area);
        this.andar = andar;
        this.possuiElevador = possuiElevador;
    }

    @Override
    public boolean cadastraImovel() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}
