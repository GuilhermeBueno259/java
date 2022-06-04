package controller;

import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Aluno;

public class TelaController {

	private Alert alerta = new Alert(AlertType.WARNING);

	@FXML
	private TableView<Aluno> tabelaAluno;

	@FXML
	private TableColumn<Aluno, Long> coId;

	@FXML
	private TableColumn<Aluno, String> coNome;

	@FXML
	private TableColumn<Aluno, String> coCpf;

	@FXML
	private TableColumn<Aluno, String> coFone;

	@FXML // injeção de dependência
	private TextField txtCpf;

	@FXML
	private TextField txtFone;

	@FXML
	private TextField txtId;

	@FXML
	private TextField txtNome;

	@FXML
	private Label label;

//	Método carregado automáticamente assim que a tela é exibida!
	@FXML
	void initialize() {
		List<Aluno> alunos = Principal.dao.listar();
		ObservableList<Aluno> listaAlunos = FXCollections.observableArrayList(alunos);

		coId.setCellValueFactory(new PropertyValueFactory<Aluno, Long>("id"));
		coNome.setCellValueFactory(new PropertyValueFactory<Aluno, String>("nome"));
		coCpf.setCellValueFactory(new PropertyValueFactory<Aluno, String>("cpf"));
		coFone.setCellValueFactory(new PropertyValueFactory<Aluno, String>("fone"));

		tabelaAluno.setItems(listaAlunos);

		tabelaAluno.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Aluno>() {

			@Override
			public void changed(ObservableValue<? extends Aluno> valor, Aluno alunoAnterior, Aluno alunoAtual) {
				txtId.setText(String.valueOf(alunoAtual.getId()));
				txtNome.setText(alunoAtual.getNome());
				txtCpf.setText(alunoAtual.getCpf());
				txtFone.setText(alunoAtual.getFone());
			}

		});
	}

	void limpar() {
		txtCpf.clear();
		txtFone.clear();
		txtId.clear();
		txtNome.clear();
	}

	@FXML
	void acaoSalvar(ActionEvent event) {
		String strId = txtId.getText();
		if (strId.isEmpty()) {
			Principal.dao.inserir(new Aluno(txtNome.getText(), txtCpf.getText(), txtFone.getText()));
			label.setText("Dados Salvos");
		} else {
			long id = Long.parseLong(strId);
			Aluno aluno = Principal.dao.buscar(id);
			if (aluno.getNome() == null) {
				label.setText("ID do Aluno não encontrado para atualizar!");
			} else {
				Principal.dao.atualizar(new Aluno(Long.parseLong(txtId.getText()), txtNome.getText(), txtCpf.getText(),
						txtFone.getText()));
				label.setText("Dados atualizados!");
			}
		}
	}

	@FXML
	void acaoLimpar(ActionEvent event) {
		limpar();
	}

	@FXML
	void acaoBuscar(ActionEvent event) {
		String strId = txtId.getText();
		if (strId.isEmpty()) {
			alerta.setTitle("Aviso");
			alerta.setHeaderText("Esqueceu!");
			alerta.setContentText("Faltou digitar o id do aluno");
			alerta.showAndWait();
		} else {
			long id = Long.parseLong(strId);
			Aluno aluno = Principal.dao.buscar(id);
			if (aluno.getNome() != null) {
				txtCpf.setText(aluno.getCpf());
				txtFone.setText(aluno.getFone());
				txtNome.setText(aluno.getNome());
			} else {
				alerta.setTitle("Aviso");
				alerta.setHeaderText("Não encontrado!");
				alerta.setContentText(String.format("O aluno com o ID = %d não foi encontrado.", id));
				alerta.showAndWait();
			}
		}
	}

	@FXML
	void acaoDeletar(ActionEvent event) {
		if (Principal.dao.apagar(Long.parseLong(txtId.getText()))) {
			label.setText("Dados deletados!");
			limpar();
		} else {
			alerta.setTitle("Aviso");
			alerta.setHeaderText("Não apagou!");
			alerta.setContentText("Dados não encontrados para a deleção!");
			alerta.showAndWait();
		}
	}
	
    @FXML
    void acaoImprimir(ActionEvent event) {
    	label.setText("Imprimindo Tabela");
    	tabelaAluno.setLayoutX(0);
    	tabelaAluno.setLayoutY(0);
    	
//    	obtém impressora padrão do sistema
    	Printer impressora = Printer.getDefaultPrinter();
    	
//    	cria uma página A4, retrato com margem padrão
    	PageLayout pagina = impressora.createPageLayout(Paper.A4, PageOrientation.PORTRAIT, Printer.MarginType.DEFAULT);
    	
//    	cria uma fila de impressão baseada naimpressora padrão
    	PrinterJob fila = PrinterJob.createPrinterJob();
    	
//    	se a fila foi criada, tenet enviar o documento
    	if (fila != null) {
    		System.out.printf("\nEnviando documento para a fila de impressão...");
//    		mostra a caixa de diálogo da impressão
    		if (fila.showPrintDialog(null)) {
    			
//				Envia o documento para o spoller de impressão
    			boolean enviado = fila.printPage(pagina, tabelaAluno);
    			
//    			Se o documento foi enviado para a fila com sucesso então finaliza a fila e retorna verdadeiro se obteve sucesso
    			if (enviado && fila.endJob()) {
//					endJob() = true não significa que o documento saiu na impressoara,
//    				mas que o serviço de envio para a fila foi finalizado
    				label.setText("Documento enviado com sucesso");
				} else {
					label.setText("Não foi possível enviar o arquivo para a impressora");
				}
			} else {
				label.setText("Não foi possível mostar a caixa de impressão");
			}
		} else {
			label.setText("Não foi possível criar fila de impressão");
		}
    }
}
