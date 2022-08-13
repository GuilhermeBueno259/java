<%@page import="com.softgraf.dao.Contato"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%--
	Instancia um objeto ContatoDAO
			menor escopo		  maior escopo
	scope = "request|page|session|application"
	scope padrão = "page"
 --%>
<jsp:useBean id="dao" scope="session"
	class="com.softgraf.dao.ContatoDAO" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeiro JSP</title>
</head>
<body>

	<%@ include file="cabecalho.jsp"%>

	Bem vindo
	<%
	out.println("Guilherme");
	%>
	à página principal
	<br>

	<%-- comentário jsp: abaixo é uma declaração JSP --%>
	<%!public final double PI = 3.14;%>
	<!-- comentário HTML: abaixo é um scriplet -->
	<%
	String mensagem = "Este é um scriptlet";
	String exp = "Exemplo de expressão ou atalho";
	%>

	<%
	out.println(mensagem);
	%><br>

	<%
	System.out.println("Essa mensagem de scriplet sai apenas no console");
	%><br>

	<%=exp%><br> Valor de PI =
	<%=PI%> <br><br>

	<ul>
	<%
	List<Contato> contatos = dao.getLista();
	for (Contato c : contatos) {	
	%>

	<li><%=c.getId()%> | <%=c.getNome()%> | <%=c.getFone()%> | <%=c.getEmail()%> | <%=c.getData()%></li>

	<%} %>
	
	</ul>

	<h4>Parâmetro origem = ${param.origem}</h4>

	<br>
	<a href="entrar.jsp">Editar Parametros</a>
	<br>
	<a href="taglibs.jsp">Exemplo Taglibs</a>
	<br>
	<a href="index.jsp?logout">Logout</a>
	
	<%
		if (request.getParameter("logout") != null) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
	%>

	<%@ include file="rodape.jsp"%>
</body>
</html>