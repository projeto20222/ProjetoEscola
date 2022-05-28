package escola.beans;

import java.util.Date;

public class Matricula {
        private Integer codigo;
	private Integer disciplinaCod;
	private Date dataMatricula;
	private Double valorPago;
	private Integer alunoCod;
	private String periodo;
	
	public Matricula() {
		
	}
	
	public Matricula(Integer codigo, Integer disciplinaCod, Date dataMatricula, Double valorPago, Integer alunoCod,
			String periodo) {
		super();
		this.codigo = codigo;
		this.disciplinaCod = disciplinaCod;
		this.dataMatricula = dataMatricula;
		this.valorPago = valorPago;
		this.alunoCod = alunoCod;
		this.periodo = periodo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getNome() {
		return disciplinaCod;
	}

	public void setNome(Integer disciplinaCod) {
		this.disciplinaCod = disciplinaCod;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public Integer getAlunoCod() {
		return alunoCod;
	}

	public void setAlunoCod(Integer alunoCod) {
		this.alunoCod = alunoCod;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

        public Integer getDisciplinaCod() {
            return disciplinaCod;
        }

        public void setDisciplinaCod(Integer disciplinaCod) {
            this.disciplinaCod = disciplinaCod;
        }
}
