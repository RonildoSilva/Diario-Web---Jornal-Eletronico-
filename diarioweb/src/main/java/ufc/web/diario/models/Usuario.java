package ufc.web.diario.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "USUARIO")
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@Column(name = ("USUARIO_ID"), nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = ("LOGIN"), nullable = false, length = 50)
	private String login;

	//
	@Column(name = ("SENHA"), nullable = false, length = 100)
	private String senha;

	@Column(name = ("NOME"), nullable = false, length = 50)
	private String nome;

	@Column(name = ("EMAIL"), nullable = false)
	private String email;

	// Usuário => Role
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "USUARIO_REGRA", 
	joinColumns = @JoinColumn(name = "usuario_id" ,referencedColumnName = "usuario_id" ), 
	inverseJoinColumns = @JoinColumn(name = "regra_id", referencedColumnName = "regra_id" ) )
	private List<RegraUsuario> regras;

	public List<RegraUsuario> getRegras() {
		return regras;
	}

	public void setRegras(List<RegraUsuario> regras) {
		this.regras = regras;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}