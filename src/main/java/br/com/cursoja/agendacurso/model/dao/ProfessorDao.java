package br.com.cursoja.agendacurso.model.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.cursoja.agendacurso.model.entidade.Professor;

public class ProfessorDao extends Conexao {

	/*
	 * CRUD
	 * C - Create => Inserir/cadastrar
	 * R - Retrieve => Recuperar/buscar
	 * U - Update => Atualizar/Alterar
	 * D - Delete => Excluir 
	 */
	
	//C
	public void cadastrar(Professor p) {
		
		String sql = "insert into professor " +
					 " (nome, celular, valorhora) values "
					 + "(?, ?, ?)";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getCelular());
			ps.setDouble(3, p.getValorHora());
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Deu problema no insert");
			e.printStackTrace();
			
		} finally {
			fecharConexao();
		}
	}
	
	
	//U
	public void alterar(Professor p) {
		String sql = "update curso set" +
					 " nome = ?," +
					 " celular = ?" +
					 " valorhora = ?" +
					 " where idprofessor = ?";
		
 		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1,  p.getNome() );
			ps.setString(2, p.getCelular());
			ps.setDouble(3, p.getValorHora());
			ps.setLong(4, p.getId());
			ps.execute();
			
		} catch(SQLException e) {
			System.out.println("Erro no Update");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
	
	//R
	public ArrayList<Professor> listar(String nomeBusca){
		ArrayList<Professor> lista = new ArrayList<Professor>();
		
		String sql = "select * from professor " +
					 "where nome like ? " +
					 "order by nome";
						
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setString(1, "%" + nomeBusca + "%");
			
			ResultSet rs = ps.executeQuery();
			Professor p;
			while (rs.next()) {
				p = new Professor();
				p.setId(rs.getLong("idprofessor"));
				p.setNome(rs.getString("nome"));
				p.setCelular(rs.getString("celular"));
				p.setValorHora(rs.getDouble("valorhora"));
				
				lista.add(p);
			}
			
		} catch(SQLException e) { 
			System.out.println("Erro no Listar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
		return lista;
	}
	
	public Professor buscar(long id) {
		Professor professor = null;
		
		String sql = "select * from professor " +
				 "where idprofessor = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, id);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				professor = new Professor();
				professor.setId(rs.getLong("idcurso"));
				professor.setNome(rs.getString("nome"));
				professor.setCelular(rs.getString("celular"));
				professor.setValorHora(rs.getDouble("valorhora"));
			}
			
		} catch(SQLException e) { 
			System.out.println("Erro no Listar");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}

		return professor;
	}
	
	//D
	public void excluir(Professor p) {
		String sql = "delete from curso where idcurso = ?";
		
		try {
			PreparedStatement ps = getConexao().prepareStatement(sql);
			ps.setLong(1, p.getId());
			
			ps.execute();
		} catch(SQLException e) {
			System.out.println("Erro na exclus�o");
			e.printStackTrace();
		} finally {
			fecharConexao();
		}
	}
}
