package escola.persistencia;




import escola.beans.Usuario;
import escola.util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    Connection conn;
    PreparedStatement pstm;
    
    
    public ResultSet authenticateUser(Usuario user) throws Exception{
        conn = new Conexao().getConnection();
        
        try {
            String sql = "SELECT * FROM usuario where login = ? AND senha = ?";
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getLogin());
            pstm.setString(2, user.getSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO" + error);
            return null;
        }
    }
    
    public void cadastrarUser(Usuario userCad) throws Exception{
        String sqlInsert = "INSERT INTO usuario (login,nome,senha,email) values(?,?,?,?)";
        conn = new Conexao().getConnection();
        
        try {
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(1, userCad.getLogin());
            pstm.setString(2, userCad.getNome());
            
            pstm.setString(3, userCad.getSenha());
            pstm.setString(4, userCad.getEmail());
           
            
            
            pstm.execute();
            pstm.close();
                   
            
        } catch (Exception error) {
            JOptionPane.showMessageDialog(null,"UsuarioDAO" + error);
        }
    }
    
    
}
