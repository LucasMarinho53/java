<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="br.com.cursoja.agendacurso.model.dao.Conexao" %>
<%@ page import="br.com.cursoja.agendacurso.model.dao.CursoDao" %>
<%@ page import="br.com.cursoja.agendacurso.model.dao.ProfessorDao" %>

<%@ page import="br.com.cursoja.agendacurso.model.entidade.Curso" %>
<%@ page import="br.com.cursoja.agendacurso.model.entidade.Professor" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página inicial</title>
 
</head>

      <form action="CreateAndFind" method="GET" class="d-flex">
        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite o Nome" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Buscar</button>
      </form>
   
					<form action="ProfessorServlet" method="POST">
				<div class="form-floating mb-3">
						<input name="valorhora" maxlength="11" type="number" class="form-control" id="floatingInput1" required> 
						<label>Valor Hora</label>
					</div>
					<div class="form-floating mb-3">
						<input name="nome" maxlength="40" type="text" class="form-control" required> 
						<label>Nome:</label>
					</div>
					<div class="form-floating mb-3">
						<input name="celular" type="text" class="form-control" required>
						<label>Celular:</label>
					</div>
					
					<button class="btn btn-primary" type="submit">Cadastrar
						Professor</button>
					<button class="btn btn-secondary" type="reset">Limpar
						Cadastro</button>
			</form>			
			
</body>
</html>