package fr.bicomat.entities;
// default package
// Generated 8 déc. 2018 07:10:38 by Hibernate Tools 5.2.11.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Virement generated by hbm2java
 */
@Entity
@Table(name = "virement", catalog = "m_db")
public class Virement implements java.io.Serializable {

	private Long idvirement;
	private Client client;
	private Compte compteByCompteCrediteur;
	private Compte compteByCompteDebiteur;
	private String dateCreation;
	private String typeVirement;
	private String dateEcheance;

	public Virement() {
	}

	public Virement(Client client, Compte compteByCompteCrediteur, Compte compteByCompteDebiteur, String dateCreation,
			String typeVirement, String dateEcheance) {
		this.client = client;
		this.compteByCompteCrediteur = compteByCompteCrediteur;
		this.compteByCompteDebiteur = compteByCompteDebiteur;
		this.dateCreation = dateCreation;
		this.typeVirement = typeVirement;
		this.dateEcheance = dateEcheance;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idvirement", unique = true, nullable = false)
	public Long getIdvirement() {
		return this.idvirement;
	}

	public void setIdvirement(Long idvirement) {
		this.idvirement = idvirement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_idclient", nullable = false)
	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compte_Crediteur", nullable = false)
	public Compte getCompteByCompteCrediteur() {
		return this.compteByCompteCrediteur;
	}

	public void setCompteByCompteCrediteur(Compte compteByCompteCrediteur) {
		this.compteByCompteCrediteur = compteByCompteCrediteur;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "compte_Debiteur", nullable = false)
	public Compte getCompteByCompteDebiteur() {
		return this.compteByCompteDebiteur;
	}

	public void setCompteByCompteDebiteur(Compte compteByCompteDebiteur) {
		this.compteByCompteDebiteur = compteByCompteDebiteur;
	}

	@Column(name = "dateCreation", nullable = false, length = 45)
	public String getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Column(name = "typeVirement", nullable = false, length = 5)
	public String getTypeVirement() {
		return this.typeVirement;
	}

	public void setTypeVirement(String typeVirement) {
		this.typeVirement = typeVirement;
	}

	@Column(name = "dateEcheance", nullable = false, length = 45)
	public String getDateEcheance() {
		return this.dateEcheance;
	}

	public void setDateEcheance(String dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

}
