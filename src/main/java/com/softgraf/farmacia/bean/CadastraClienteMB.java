package com.softgraf.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.softgraf.farmacia.controller.Modo;
import com.softgraf.farmacia.dominio.Estados;
import com.softgraf.farmacia.entity.Cliente;
import com.softgraf.farmacia.repositorio.RepositorioClientes;
import com.softgraf.farmacia.util.JpaUtil;

@ManagedBean(name = "cadCliMB")
@ViewScoped
public class CadastraClienteMB implements Serializable {
	private static final long serialVersionUID = 6238709037594224645L;
	private Integer paramId;
	private Modo modo; // INCLUSAO, EDICAO, CONSULTA

	private Cliente cliente;

	private RepositorioClientes repositorioClientes;

	public CadastraClienteMB() {
		this.cliente = new Cliente();
		this.repositorioClientes = new RepositorioClientes(JpaUtil.getEntityManager());
	}

	// inicializa os valores padrões
	private void inicializar() {
		this.cliente.setId(1);
		this.cliente.setPessoa('F');
		this.cliente.setNome("");
		this.cliente.setCpf_cnpj("");
		this.cliente.setFone("");
		this.cliente.setEmail("");
		this.cliente.setEstado("Paraná");
		this.cliente.setCidade("");
		this.cliente.setBairro("");
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

	public List<String> pesquisarCidades(String cidade) {
		return repositorioClientes.pesquisarCidades(cidade);
	}

	public void salvar() {
		FacesMessage mensagem;
		try {
			repositorioClientes.adicionar(cliente);
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Inclusão", "Cliente cadastrado com sucesso!");
		} catch (Exception e) {
			mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Inclusão",
					"Erro ao cadastrar cliente: " + e.getMessage());
		}

		FacesContext contexto = FacesContext.getCurrentInstance();
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
		if (modo == Modo.EDICAO) {
			atualizar();
		} else {
			salvar();
		}
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
				Cliente c = repositorioClientes.buscarPorId(paramId);
				if (c == null) {
					mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edição:",
							"Cliente com id = " + paramId + " não encontrado");
				} else {
					this.cliente = c;
					this.modo = Modo.EDICAO;
					mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Modo Edição: ", "Atualização de Cadastro");
				}
			} catch (Exception e) {
				mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Edição: ",
						"Erro ao editar cliente: " + e.getMessage());
			}

			contexto.addMessage(null, mensagem);

			// novo cadastro, inicializa os campos
		} else {
			inicializar();
		}
	}
}
