package escola.beans;

public class Pessoa {
        private Integer codigo;
	private String nomePessoa;
	private String endereco;
	private String uf;
	private String telefone;
	private String cpf;
	private String email;
	
	public Pessoa() {
		
	}
	
	public Pessoa(Integer codigo, String nomePessoa, String endereco, String uf, String telefone, String cpf,
			String email) {
		super();
		this.codigo = codigo;
		this.nomePessoa = nomePessoa;
		this.endereco = endereco;
		this.uf = uf;
		this.telefone = telefone;
		this.cpf = cpf;
		this.email = email;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nomePessoa=" + nomePessoa + ", endereco=" + endereco + ", uf=" + uf
				+ ", telefone=" + telefone + ", cpf=" + cpf + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
  
}
