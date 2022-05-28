package escola.beans;

public class Usuario {
    
        private String login;
	private String nome;
	private String senha;
	private String email;
        private String tipo;
        
	
	public Usuario() {
		
	}
	
	public Usuario(String nome,String login, String senha, String email) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
