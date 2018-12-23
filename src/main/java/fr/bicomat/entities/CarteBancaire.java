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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.bicomat.Auth.entities.UserQuestion;

/**
 * CarteBancaire generated by hbm2java
 */
@Entity
@Table(name = "carte_bancaire", uniqueConstraints = @UniqueConstraint(columnNames = "numcarte"))
public class CarteBancaire implements java.io.Serializable {

	/**
	 * Identifiant de la table.
	 */
	private static final long serialVersionUID = 1L;
	private Integer idCarte;
	private String numcarte;
	private String codecrypto;
	private Date echeance;
	private String typecarte = TypeCarte.CARTE_BLEU.getType();
	private Client client ;
	private boolean opposition ;
	
	public CarteBancaire() {
	}

	public CarteBancaire(String numcarte, String codecrypto, Date echeance, String typecarte) {
		this.numcarte = numcarte;
		this.codecrypto = codecrypto;
		this.echeance = echeance;
		this.typecarte = typecarte;
	}

	public CarteBancaire(String numcarte, String codecrypto, Date echeance, String typecarte, Client client) {
		this.numcarte = numcarte;
		this.codecrypto = codecrypto;
		this.echeance = echeance;
		this.typecarte = typecarte;
		this.client = client;
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
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client")
	public Client getClient() {
		return this.client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	@Column(name = "opposition", nullable = false, columnDefinition = "TINYINT", length = 1)
	public boolean getOpposition() {
		return this.opposition;
	}

	public void setOpposition(boolean opposition) {
		this.opposition = opposition;
	}
	

}
