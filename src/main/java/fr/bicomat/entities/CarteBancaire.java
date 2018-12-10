package fr.bicomat.entities;
// default package
// Generated 8 déc. 2018 07:10:38 by Hibernate Tools 5.2.11.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * CarteBancaire generated by hbm2java
 */
@Entity
@Table(name = "carte_bancaire", uniqueConstraints = @UniqueConstraint(columnNames = "numcarte"))
public class CarteBancaire implements java.io.Serializable {

	private Integer idCarte;
	private String numcarte;
	private String codecrypto;
	private Date echeance;
	private String typecarte;
	private Set<Client> clients = new HashSet<Client>(0);

	public CarteBancaire() {
	}

	public CarteBancaire(String numcarte, String codecrypto, Date echeance, String typecarte) {
		this.numcarte = numcarte;
		this.codecrypto = codecrypto;
		this.echeance = echeance;
		this.typecarte = typecarte;
	}

	public CarteBancaire(String numcarte, String codecrypto, Date echeance, String typecarte, Set<Client> clients) {
		this.numcarte = numcarte;
		this.codecrypto = codecrypto;
		this.echeance = echeance;
		this.typecarte = typecarte;
		this.clients = clients;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_carte", unique = true, nullable = false)
	public Integer getIdCarte() {
		return this.idCarte;
	}

	public void setIdCarte(Integer idCarte) {
		this.idCarte = idCarte;
	}

	@Column(name = "numcarte", unique = true, nullable = false, length = 16)
	public String getNumcarte() {
		return this.numcarte;
	}

	public void setNumcarte(String numcarte) {
		this.numcarte = numcarte;
	}

	@Column(name = "codecrypto", nullable = false, length = 3)
	public String getCodecrypto() {
		return this.codecrypto;
	}

	public void setCodecrypto(String codecrypto) {
		this.codecrypto = codecrypto;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "echeance", nullable = false, length = 19)
	public Date getEcheance() {
		return this.echeance;
	}

	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}

	@Column(name = "typecarte", nullable = false, length = 15)
	public String getTypecarte() {
		return this.typecarte;
	}

	public void setTypecarte(String typecarte) {
		this.typecarte = typecarte;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "carte_bancaire_client", catalog = "m_db", joinColumns = {
			@JoinColumn(name = "carte_idcarte", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "client_idclient", nullable = false, updatable = false) })
	public Set<Client> getClients() {
		return this.clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

}
