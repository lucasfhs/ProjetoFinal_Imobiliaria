package controllers;

import controllers.ControllerMaster;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import servicos.Imovel;

public class LayoutDescricaoController extends ControllerMaster implements Initializable{

    /*
     * Variáveis da classe
     */
    @FXML
    private Button bt_Pagamento;
    @FXML
    private ImageView img_ImovelImagem;
    @FXML
    private Label lb_Caminho;
    @FXML
    private Label lb_Nome;
    @FXML
    private Label txt_VagasGaragem;
    @FXML
    private Label txt_Descricao;
    @FXML
    private Label txt_Local;
    @FXML
    private Label txt_Preco;

    private Imovel imovelEscolhido;

    private String caminho;

    /*
     * Métodos da classe
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imovelEscolhido = (Imovel)dados.get(0);
        caminho = (String)dados.get(1);

        

        //Preenche os elementos FX
        //Imagem
        Image imagem = new Image(getClass().getResourceAsStream(imovelEscolhido.getfonteImagem()));
        img_ImovelImagem.setImage(imagem);
        //Caminho
        lb_Caminho.setText(caminho + " > Detalhes do Imovel");
        //Descricao
        txt_Descricao.setText(imovelEscolhido.getDescricao());
        //Vagas de Garagem
        txt_VagasGaragem.setText(Integer.toString(imovelEscolhido.getVagasGaragem()));
        //Local
        txt_Local.setText(imovelEscolhido.getCidade() + "/" + imovelEscolhido.getEstado());
        //Preço
        double preco = imovelEscolhido.getValor();
        txt_Preco.setText("R$ " + new DecimalFormat("#,###,##0.00").format(preco));    //Formata no padrão brasileiro


    } 

    //Eventos de tratamento de clique
    @FXML
    void clickBtPagamento(ActionEvent event) {
        LayoutPagamentoController pagamentoController = new LayoutPagamentoController(); //Classe controller da proxima cena
        try {
            //Chama a próxima cena enviando a coleção de dados (com o Imovel do card) para o próximo controller
            chamaProximaCena("/GUI/fxml/LayoutPagamento.fxml", pagamentoController, dados);
            
            //Fecha a janela atual
            Stage stageLocal = (Stage) txt_Preco.getScene().getWindow();    
            stageLocal.close();
        } catch (IOException e) {
            Alert alert = new Alert(AlertType.INFORMATION);     //Alerta de erro caso não seja
            alert.setTitle("Erro");                       //possível carregar o arquivo
            alert.setHeaderText(null);  
            alert.setContentText("Tivemos problemas ao carregar as informações...");
            alert.showAndWait();
            e.printStackTrace();
        }
    }
    
     


}
