package com.softgraf.farmacia.conversores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import com.softgraf.farmacia.dominio.Cep;

// Um conversor transforma strings em objetos e objetos em strings
@FacesConverter("cepConverter")
public class CepConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent campo, String cep) {
		// faz a validação do cep
		boolean existeCep = !cep.trim().isEmpty();
		String cepFormatado = Cep.formatar(cep);

		if (existeCep && cepFormatado.isEmpty()) {
			FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_WARN, "CEP:",
					"Cep deve conter 8 digitos númericos ou nenhum!");
			throw new ConverterException(mensagem);
		} else {
			return cepFormatado;
		}
	}

	@Override
	public String getAsString(FacesContext context, UIComponent campo, Object cep) {
		return (String) cep;
	}

}
