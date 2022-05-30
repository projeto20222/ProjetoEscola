package escola.persistencia;

import escola.beans.PessoaBeans;
import escola.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {
    
        Connection conn;
        PreparedStatement ps;
    public PessoaDAO() throws Exception{
        try {
            this.conn = Conexao.getConnection();
        } catch (Exception e) {
            throw new Exception("Erro:"+"\n"+e.getMessage());
        }
    
    }
    // INSERT PESSOA
    public void salvarPessoa(PessoaBeans pess) throws Exception {
        ps = null;
        conn = null;
        if(pess == null){
            throw new Exception("O valor pasado não pode ser nulo!");
        
        }
        
        try {
            String SQL = "INSERT INTO pessoa(nomePessoa,endereco,uf,telefone,cpf,email)"+"values(?,?,?,?,?,?)";
            conn = this.conn;
            ps = conn.prepareStatement(SQL);
            
            ps.setString(1, pess.getNomePessoa());
            ps.setString(2, pess.getEndereco());
            ps.setString(3, pess.getUf());
            ps.setString(4, pess.getTelefone());
            ps.setString(5, pess.getCpf());
            ps.setString(6, pess.getEmail());
            
            ps.executeUpdate();
            
        } catch (Exception e) {
            throw new Exception("Erro ao inserir dados" + e);
            
        }finally{
        
            Conexao.closeConnection(conn, ps);
        }
    }
        // DELETE PESSOA 
        
        public void Excluir(PessoaBeans pess) throws Exception{
            ps = null;
            conn = null;
            if(pess == null){
                throw new Exception("O valor passado não pode ser nulo!");
            }
            try {
                conn = this.conn;
                
                ps = conn.prepareStatement("DELETE FROM pessoa where codigo =?");
                ps.setInt(1, pess.getCodigo());
                ps.executeUpdate();
            } catch (Exception e) {
                throw new Exception("Erro ao excluir dados"+e);
                
            } finally {
                Conexao.closeConnection(conn,ps);
            }
        }
        
        public void atualizar(PessoaBeans pess) throws Exception{
            ps = null;
            conn = null;
            
            if(pess == null){
                throw new Exception("o valor passado não pode ser nullo");
            }
            try{
                
                String SQLupd = ("UPDATE pessoa "
                        + "SET nomePessoa = ?"+
                        "endereco = ?"+"telefone = ?"
                        +"email = ?"+"cpf = ?"+"uf = ?"+"WHERE codigo =?");
                
                conn = this.conn;
                ps = conn.prepareStatement(SQLupd);
                
                ps.setString(1, pess.getNomePessoa());
                ps.setString(2, pess.getEndereco());
                ps.setString(3, pess.getTelefone());
                ps.setString(5, pess.getEmail());
                ps.setString(5, pess.getCpf());
                ps.setString(5, pess.getUf());
                
                
                ps.executeUpdate( );
                
            }catch (SQLException sqle) {
                throw new Exception("Erro ao atualizar dados: "+ sqle);
            } finally {
                Conexao.closeConnection(conn, ps);
            
            } 
        }
        
        
    public List todosPessoa( )  throws Exception{
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from pessoa");
            rs = ps.executeQuery( );
            List<PessoaBeans> list = new ArrayList<PessoaBeans>();
            while( rs.next( ) ) {
                Integer codigo = rs.getInt(1);
                String nomePessoa = rs.getString(2);
                String endereco = rs.getString(3);
                String uf = rs.getString(4);
                String telefone = rs.getString(5);
                String cpf = rs.getString(6);
                String email = rs.getString(7);
               
             
                list.add(new PessoaBeans(codigo,nomePessoa, endereco, uf, telefone, cpf, email) );
            }
            return list;
        } catch (SQLException sqle) {
            throw new Exception(sqle);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }
        
    public PessoaBeans procurarPessoa(Integer id) throws  Exception {
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            conn = this.conn;
            ps = conn.prepareStatement("select * from pessoa where idpessoa=?");
            ps.setInt(1, id);
            rs = ps.executeQuery( );
            if( !rs.next( ) ) {
                throw new Exception( "No foi encontrado nenhum" + " registro com o ID: " + id );
            }
            String nomePessoa = rs.getString(2);
            String endereco = rs.getString(3);
            String uf = rs.getString(4);
            String telefone = rs.getString(5);
            String cpf = rs.getString(6);
            String email = rs.getString(7);
            
            
            
            return new PessoaBeans(id ,nomePessoa, endereco, uf, telefone, cpf, email);
        } catch (SQLException sqle) {
            throw new  Exception(sqle);
        } finally {
            Conexao.closeConnection(conn, ps, rs);
        }
    }   
   
        
}