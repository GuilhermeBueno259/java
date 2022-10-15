package com.softgraf.farmacia.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.softgraf.farmacia.entity.Cliente;
import com.softgraf.farmacia.repositorio.RepositorioClientes;
import com.softgraf.farmacia.util.JpaUtil;

@ManagedBean
@ViewScoped
public class ConsultaClienteMB implements Serializable {
	private static final long serialVersionUID = -7838925002174827018L;

	private List<Cliente> clientes;
	private Cliente clienteSelecionado;

	private RepositorioClientes repositorioClientes;

	public ConsultaClienteMB() {
		this.repositorioClientes = new RepositorioClientes(JpaUtil.getEntityManager());
	}

	// lista todos os clientes do banco
	public void consultar() {
		this.clientes = repositorioClientes.todos();
	}

	public List<Cliente> getClientes() {
		return clientes;
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
					"Não foi possível remover o cliente. Erro: " + e.getMessage());
		}

		contexto.addMessage(null, mensagem);
	}
}
