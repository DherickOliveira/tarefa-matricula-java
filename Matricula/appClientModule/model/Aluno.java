package model;

public class Aluno {
	
	private int id;
    private String nome;
    private String nomeSocial;
    private String cpf;
    private String genero;
    private boolean afrodescendente;
    private boolean escolaridadePublica;
    private String nacionalidade;
    private String responsavelLegal;
    private boolean habilitacao;
    private String serieModulo;
    private String periodo;
    
	public Aluno(int int1, String nome2, String nomeSocial2, String cpf2, String genero2, boolean boolean1,
			boolean boolean2, String nacionalidade2, String serieModulo2, String periodo2) {
		// TODO Auto-generated constructor stub
	}
	public Aluno() {
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeSocial() {
		return nomeSocial;
	}
	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public boolean isAfrodescendente() {
		return afrodescendente;
	}
	public void setAfrodescendente(boolean afrodescendente) {
		this.afrodescendente = afrodescendente;
	}
	public boolean isEscolaridadePublica() {
		return escolaridadePublica;
	}
	public void setEscolaridadePublica(boolean escolaridadePublica) {
		this.escolaridadePublica = escolaridadePublica;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	public String getResponsavelLegal() {
		return responsavelLegal;
	}
	public void setResponsavelLegal(String responsavelLegal) {
		this.responsavelLegal = responsavelLegal;
	}
	public boolean isHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(boolean habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getSerieModulo() {
		return serieModulo;
	}
	public void setSerieModulo(String serieModulo) {
		this.serieModulo = serieModulo;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}