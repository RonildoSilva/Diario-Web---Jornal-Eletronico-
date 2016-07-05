package ufc.web.diario.models;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity (name = "CLASSIFICADO")
@Table(name = "CLASSIFICADO")
public class Classificado {

	@Id
	@Column (name = "CLASSIFICADO_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long classificadoId;
	
	@Column (name = ("TITULO"), nullable = false)
	private String titulo;
	
	@Column (name = ("TEXTO"), nullable = false)
	private String texto;
	
	@Column (name = ("PRECO"), nullable = false)
	private Float preco;
	
	@Column (name = ("TELEFONE"), nullable = false)
	private String telefone;
	
	@Column (name = ("MELHOR_OFERTA"), nullable = false)
	private Float melhor_oferta;
	
	@Version
	@Column (name = ("DATA_OFERTA"), nullable = false)
	private Timestamp data_oferta;
	
	/******************/
	@Column(name = "NOME_ARQUIVO")
	private String nomeArquivo;
	
	@Lob
	@Column(name = "DADO_ARQUIVO")	
	private byte[] conteudoArquivo;
	
	@Column(name="TIPO_ARQUIVO")
	private String tipoArquivo;

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public byte[] getConteudoArquivo() {
		return conteudoArquivo;
	}


	public void setConteudoArquivo(byte[] conteudoArquivo) {
		this.conteudoArquivo = conteudoArquivo;
	}


	public String getTipoArquivo() {
		return tipoArquivo;
	}


	public void setTipoArquivo(String tipoArquivo) {
		this.tipoArquivo = tipoArquivo;
	}


	/******************/
	
	// Relacionamentos
	
	// Vários pedidos em um classificado pode ter só um autor
	@ManyToOne(optional = false, cascade = CascadeType.REMOVE)
	@JoinColumn(name = "autor_id", referencedColumnName = "usuario_id")
	private Usuario autorOferta;
	
	
	public Long getClassificadoId() {
		return classificadoId;
	}

	public void setClassificadoId(Long classificadoId) {
		this.classificadoId = classificadoId;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Float getMelhor_oferta() {
		return melhor_oferta;
	}

	public void setMelhor_oferta(Float melhor_oferta) {
		this.melhor_oferta = melhor_oferta;
	}

	public Timestamp getData_oferta() {
		return data_oferta;
	}

	public void setData_oferta(Timestamp data_oferta) {
		this.data_oferta = data_oferta;
	}

	public Usuario getAutorOferta() {
		return autorOferta;
	}

	public void setAutorOferta(Usuario autorOferta) {
		this.autorOferta = autorOferta;
	}
	
}
