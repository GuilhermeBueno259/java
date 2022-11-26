package com.softgraf.primavera.data.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.softgraf.primavera.data.entity.Cliente;

public class ClienteGroupSequenceProvider implements DefaultGroupSequenceProvider<Cliente> {

	@Override
	public List<Class<?>> getValidationGroups(Cliente cliente) {
		List<Class<?>> grupos = new ArrayList<>();

		if (cliente != null && cliente.getTipoPessoa() != null) {
			grupos.add(cliente.getTipoPessoa().getGrupo());
		}

		return grupos;
	}

}
