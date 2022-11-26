package com.softgraf.primavera.data.projection;

// Usada por Query do repositório
public interface ClienteProjection {

	// criar os métodos na ordem da Query
	Long getId();

	String getNome();

	String getEmail();

}
