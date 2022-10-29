package com.softgraf.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.softgraf.farmacia.controller.Modo;
import com.softgraf.farmacia.dominio.Estados;
import com.softgraf.farmacia.entity.Cliente;
import com.softgraf.farmacia.repositorio.RepositorioClientes;

// Managed Bean JSF (faces)
// @ManagedBean(name="cadcliMB")   // javax.faces.bean.ManagedBean
// escopo de vista, pacote javax.faces.bean
// @ViewScoped                     // javax.faces.bean.ViewScoped;

// Managed Bean CDI
@Named("cadcliMB")
@ViewScoped // usar pacote javax.faces.view.ViewScoped
public class CadastraClienteMB implements Serializable {

	private static final long serialVersionUID = 6238709037594224645L;
	private Integer paramId;
	private Modo modo; // INCLUSÃO, EDIÇÃO, CONSULTA

	@Inject
	private Cliente cliente;

	@Inject // subsitui new RepositorioClientes(EntityManager em)
	private RepositorioClientes repositorioClientes;

	// construtor padrão
	public CadastraClienteMB() {
		this.modo = Modo.INCLUSAO;
	}
	

	// inicializa os valores padrões
	private void inicializar() {
		// não salvava por causa do id já atribuido!
		//this.cliente.setId(1111);
		this.cliente.setPessoa('F');
		this.cliente.setNome("");
		this.cliente.setCpf_cnpj("");
		this.cliente.setFone("");
		this.cliente.setEmail("");
		this.cliente.setEstado("Paraná");
		this.cliente.setCidade("");
//		this.cliente.setBairro("");
		this.cliente.setRua("");
		this.cliente.setCep("");
	}

	public Integer getParamId() {
		return paramId;
	}

	public void setParamId(Integer paramId) {
		this.paramId = paramId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<String> getEstados() {
		return Estados.listar();
	}

	// lista todas as cidade que tenham o nome parecido com o parâmetro passado
	public List<String> pesquisarCidades(String cidade) {
		return repositorioClientes.pesquisarCidades(cidade);
	}

	public void salvar() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage mensagem;
		System.out.println("============ SALVOU 1");

		try {
			System.out.println("============ SALVOU 2");
			repositorioClientes.adicionar(cliente);
			System.out.println("============ SALVOU 3");
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão:", "Cliente cadastrado com sucesso!");

		} catch (Exception e) {
			mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inclusão:",
					"Erro ao cadastrar cliente: " + e.getMessage());
		}

		contexto.addMessage(null, mensagem);
	}

	public void atualizar() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage mensagem;

		try {
			repositorioClientes.atualizar(cliente);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Edição:", "Cliente atualizado com sucesso!");

		} catch (Exception e) {
			mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Edição:",
					"Erro ao atualizar cliente: " + e.getMessage());
		}

		contexto.addMessage(null, mensagem);
	}

	public String guardar() {
		if (modo == Modo.EDICAO)
			atualizar();
		else
			salvar();

		// armazena mensagens
		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		return "/cadastraCliente?faces-redirect=true";

	}

	public void editar() {
		// modo edição
		if (paramId != null) {
			FacesContext contexto = FacesContext.getCurrentInstance();
			FacesMessage mensagem;

			try {
				// recupera o cliente do banco através do id
				Cliente c = repositorioClientes.buscarPorId(paramId);
				if (c == null)
					mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edição:",
							"Cliente com id=" + paramId + " não encontrado.");

				else {
					this.cliente = c; // carrega o cliente
					this.modo = Modo.EDICAO;
					mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modo Edição:", "Atualização de Cadastro");
				}

			} catch (Exception e) {
				mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Edição:",
						"Erro ao editar cliente: " + e.getMessage());
			}

			contexto.addMessage(null, mensagem);

			// novo cadastro, inicializa os campos
		} else {
			inicializar();
		}
	}

}