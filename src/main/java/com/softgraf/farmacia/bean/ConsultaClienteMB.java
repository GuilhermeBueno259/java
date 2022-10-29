package com.softgraf.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.softgraf.farmacia.entity.Cliente;
import com.softgraf.farmacia.repositorio.RepositorioClientes;

// Managed Bean JSF
// @ManagedBean  // javax.faces.bean
// @ViewScoped   // javax.faces.bean

// Um bean CDI não pode ser injetado em um bean JSF

// Managed Bean CDI
@Named
@ViewScoped // javax.faces.view
public class ConsultaClienteMB implements Serializable {

	private static final long serialVersionUID = -7838925002174827018L;

	private List<Cliente> clientes;
	private Cliente clienteSelecionado;

	@Inject
	private RepositorioClientes repositorioClientes;

	// lista todos os clientes do banco
	public void consultar() {
		this.clientes = repositorioClientes.todos();
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clienteSelecionado;
	}

	public void excluir() {
		FacesContext contexto = FacesContext.getCurrentInstance();
		FacesMessage mensagem;

		try {
			repositorioClientes.removerPorId(clienteSelecionado.getId());
			// recarrega a lista do banco
			consultar();
			mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exclusão:", "Cliente removido com sucesso!");

		} catch (Exception e) {
			mensagem = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Exclusão:",
					"Erro ao excluir cliente: " + e.getMessage());
		}

		contexto.addMessage(null, mensagem);
	}

}