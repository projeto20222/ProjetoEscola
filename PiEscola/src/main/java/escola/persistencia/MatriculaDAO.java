package escola.persistencia;

import escola.beans.Matricula;
import escola.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MatriculaDAO {
    Connection conn;
    public MatriculaDAO()throws Exception{
        try {
            this.conn = Conexao.getConnection( );
        } catch( Exception e ) {
            throw new Exception( "Erro: " +  ":\n" + e.getMessage( ) );
        }
    }


    public void salvar(Matricula matricula)  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        if (matricula == null)
            throw new Exception("O valor passado no pode ser nulo");
        try {
            
            String SQL = "INSERT INTO matricula (dataMatricula, valorPago, alunoCod, periodo) "+ "values (?, ?, ?, ?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            //revisar data
            //ps.setDate(1, matricula.getDate());
            ps.setDouble(2, matricula.getValorPago());
            ps.setInt(3, matricula.getAlunoCod());
            ps.setString(4, matricula.getPeriodo());
            //chave estrangeira de disciplina
            //ps.setInt(2, matricula.);
            
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new
                    Exception("Erro ao inserir dados "+ sqle);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
    }

    
    public void excluir(Matricula matricula) throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (matricula == null)
            throw new
                    Exception("O valor passado no pode ser nulo");
        try {
            conn = this.conn;
            ps = conn.prepareStatement("delete from matricula where idmatricula=?");
            ps.setInt(1, matricula.getCodigo( ));
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao excluir dados:" + sqle);
        } finally {
            Conexao.closeConnection(conn, ps);
        }
        
    }

    
    public void atualizar(Matricula matricula)  throws Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        if (matricula == null)
            throw new Exception("O valor passado no pode ser nulo");
        
        try {
            String SQL = "UPDATE matricula SET dataMatricula=?, " + "valorPago=?, alunoCod=?, periodo=? " + "where idmatricula=?";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            // data 
            
            ps.setDouble(2, matricula.getValorPago());
            ps.setInt(3, matricula.getAlunoCod());
            ps.setString(4, matricula.getPeriodo());
            ps.setInt(5, matricula.getCodigo());
            ps.executeUpdate( );
        } catch (SQLException sqle) {
            throw new Exception("Erro ao atualizar dados: "+ sqle);
        } finally {
            Conexao.closeConnection(conn, ps);
            
        }
    }


      public List todosMatricula( )  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from matricula");
            rs = ps.executeQuery( );
            List<Matricula> list = new ArrayList<Matricula>();
            while( rs.next( ) ) {
                Integer codigo = rs.getInt(1);
                Integer disciplinaCod = rs.getInt(2);
                Date dataMatricula = rs.getDate(3);
                Double valorPago = rs.getDouble(4);
                Integer alunoCod = rs.getInt(5);
                String periodo = rs.getString(6);
             
                list.add(new Matricula(codigo,disciplinaCod,dataMatricula,valorPago, alunoCod, periodo) );
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }

     
    public Matricula procurarMatricula(Integer id) throws  Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from matricula where idmatricula=?");
            ps.setInt(1, id);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "No foi encontrado nenhum" + " registro com o ID: " + id );
            }
            Integer disciplinaCod = rs.getInt(2);
            Date dataMatricula = rs.getDate( 3 );
            Double valorPago = rs.getDouble(4);
            Integer alunoCod = rs.getInt(5);
            String periodo = rs.getString(6);
            
            
            
            return new Matricula(id, disciplinaCod, dataMatricula, valorPago, alunoCod, periodo);
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }   











}
