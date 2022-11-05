package com.softgraf.farmacia.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import com.softgraf.farmacia.repositorio.RepositorioClientes;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/*
 * Passos para gerar o relatório com JasperReport
 * 
 * 1. Criar o arquivo jasper report xm -> jrxml
 * 	 A melhor forma de fazer isso e com o Jaspersoft Studio (plugin para o eclipse)
 * 	 http://marketplace.eclipse/org/content/jaspersoft-studio
 * 
 * 2. Compilar o arquivo .jrxml com JasperCompilerManager gerando um objeto JasperPrint
 * 
 * 3. Preencher os dados do relatório com JasperFillManager gerando um objeto JasperPrint
 * 
 * 4. exportar o JasperPrint para outro formato, como PDF, usando JasperExportManager
 * 
 *  Resumindo: jrxml -> JasperCompilerManager -> JasperReport -> JasperFillManager -> JasperPrint ->
 *  		JasperExportManager -> pdf
 */

// Managed Bean CDI
@Named
@ViewScoped
public class RelatorioClienteBean implements Serializable {
	private static final long serialVersionUID = 5280604806505749725L;

	// jrxml é um arquivo externo ao projeto
	String jrxml = "E:\\Curso Java Guilherme Bueno\\FarmaciaEE\\src\\main\\java\\relatorios\\clientes.jrxml";

	@Inject
	private RepositorioClientes repositorioClientes;

	public void gerarPDF() {
		// obtém o contexto atual do JSF
		FacesContext contexto = FacesContext.getCurrentInstance();

		try {
			// compila o jrxml criando o relatório
			JasperReport jasperReport = JasperCompileManager.compileReport(jrxml);

			// cria um data source (fonte de dados) contendo uma coleção de clientes
			JRBeanCollectionDataSource collectionDataSource = new JRBeanCollectionDataSource(
					repositorioClientes.todos());

			// preenche os dados do relatório gerando o arquivo de impressão
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, collectionDataSource);

			HttpServletResponse resposta = (HttpServletResponse) contexto.getExternalContext().getResponse();
			resposta.setHeader("Content-Disposition", "attachment; filename=clientes.pdf");
			resposta.setContentType("application/pdf");

			// exporta o arquivo de impressão para o formato PDF e envia para o fluxo
			// de saída
			JasperExportManager.exportReportToPdfStream(jasperPrint, resposta.getOutputStream());
			contexto.responseComplete();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
