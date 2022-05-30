package escola.persistencia;

import escola.beans.DisciplinaBeans;
import escola.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
   
    public DisciplinaDAO()throws Exception{
        try {
            this.conn = Conexao.getConnection( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +  ":\n" + e.getMessage( ) );
        }
    }
    
    
    public void salvar(DisciplinaBeans disciplina)  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        if (disciplina == null)
            throw new Exception("O valor passado no pode ser nulo");
        try {
            
            String SQL = "INSERT INTO disciplina (nome,  cargaHoraria, limiteAlunos) "+ "values (?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getCargaHoraria());
            ps.setInt(3, disciplina.getLimiteAlunos());
            //ps.setString(2, disciplina);
            
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao inserir dados "+ sqle);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }
    
    
    public void excluir(DisciplinaBeans disciplina) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (disciplina == null)
            throw new
                    Exception("O valor passado no pode ser nulo");
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from disciplina where iddisciplina=?");
            ps.setInt(1, disciplina.getCodigo( ));
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
    }
    
    public void atualizar(DisciplinaBeans disciplina)  throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (disciplina == null)
            throw new Exception("O valor passado no pode ser nulo");
        
        try {
            String SQL = "UPDATE disciplina SET nome=?, " + "cargaHoraria=?, limiteAlunos=? " + "where iddisciplina=?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            ps.setString(1, disciplina.getNome());
            ps.setInt(2, disciplina.getCargaHoraria());
            ps.setInt(3, disciplina.getLimiteAlunos());
            ps.setInt(4, disciplina.getProfessorCod());
            ps.setInt(5, disciplina.getCodigo());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: "+ sqle);
        } finally {
            Conexao.closeConnection(conn, ps);
            
        }
    }
    
    
    public List todosDisciplina( )  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from disciplina");
            rs = ps.executeQuery( );
            List<DisciplinaBeans> list = new ArrayList<DisciplinaBeans>();
            while( rs.next( ) ) {
                Integer codigo = rs.getInt(1);
                Integer pessoaCod = rs.getInt(2);
                String nome = rs.getString(3);
                Integer cargaHoraria = rs.getInt(4);
                Integer limiteAlunos = rs.getInt(5);
             
                list.add(new DisciplinaBeans(codigo,pessoaCod,nome,cargaHoraria, limiteAlunos) );
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }
    
    
        public DisciplinaBeans procurarDisciplina(Integer id) throws  Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from disciplina where iddisciplina=?");
            ps.setInt(1, id);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "No foi encontrado nenhum" + " registro com o ID: " + id );
            }
            Integer pessoaCod = rs.getInt(2);
            String nome = rs.getString( 3 );
            Integer cargaHoraria = rs.getInt(4);
            Integer limiteAlunos = rs.getInt(4);
            
            
            return new DisciplinaBeans(id, pessoaCod, nome, cargaHoraria, limiteAlunos) ;
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }   
}
