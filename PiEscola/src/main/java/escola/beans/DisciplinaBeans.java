package escola.beans;

public class DisciplinaBeans {
        private Integer codigo;
	private String nome;
	private Integer cargaHoraria;
	private Integer professorCod;
	private Integer limiteAlunos;
	
	public DisciplinaBeans() {
		
	}
	
	public DisciplinaBeans(Integer codigo, String nome, Integer cargaHoraria, Integer professorCod, Integer limiteAlunos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.professorCod = professorCod;
		this.limiteAlunos = limiteAlunos;
	}

    public DisciplinaBeans(Integer codigo, Integer pessoaCod, String nome, Integer cargaHoraria, Integer limiteAlunos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public Integer getProfessorCod() {
		return professorCod;
	}

	public void setProfessorCod(Integer professorCod) {
		this.professorCod = professorCod;
	}

	public Integer getLimiteAlunos() {
		return limiteAlunos;
	}

	public void setLimiteAlunos(Integer limiteAlunos) {
		this.limiteAlunos = limiteAlunos;
	}

	@Override
	public String toString() {
		return "Disciplina [codigo=" + codigo + ", nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", professorCod="
				+ professorCod + ", limiteAlunos=" + limiteAlunos + "]";
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
		DisciplinaBeans other = (DisciplinaBeans) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
}
