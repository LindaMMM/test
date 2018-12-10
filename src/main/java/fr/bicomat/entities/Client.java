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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Client generated by hbm2java
 */
@Entity
@Table(name = "client")
public class Client implements java.io.Serializable {

	private Integer idclient;
	private Conseiller conseiller;
	private String numagency;
	private String nomClient;
	private String prenomClient;
	private String email;
	private String tel;
	private String telPortable;
	private String typeClient;
	private String adresse;
	private Date anneeArrive;
	private Set<Banque> banques = new HashSet<Banque>(0);
	private Set<Virement> virements = new HashSet<Virement>(0);
	private Set<Alerte> alertes = new HashSet<Alerte>(0);
	private Set<Document> documents = new HashSet<Document>(0);
	private Set<Compte> comptes = new HashSet<Compte>(0);
	private Set<CarteBancaire> carteBancaires = new HashSet<CarteBancaire>(0);

	public Client() {
	}

	public Client(Conseiller conseiller, String numagency, String nomClient, String prenomClient, Date anneeArrive) {
		this.conseiller = conseiller;
		this.numagency = numagency;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.anneeArrive = anneeArrive;
	}

	public Client(Conseiller conseiller, String numagency, String nomClient, String prenomClient, String email,
			String tel, String telPortable, String typeClient, String adresse, Date anneeArrive, Set<Banque> banques,
			Set<Virement> virements, Set<Alerte> alertes, Set<Document> documents, Set<Compte> comptes,
			Set<CarteBancaire> carteBancaires) {
		this.conseiller = conseiller;
		this.numagency = numagency;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		this.email = email;
		this.tel = tel;
		this.telPortable = telPortable;
		this.typeClient = typeClient;
		this.adresse = adresse;
		this.anneeArrive = anneeArrive;
		this.banques = banques;
		this.virements = virements;
		this.alertes = alertes;
		this.documents = documents;
		this.comptes = comptes;
		this.carteBancaires = carteBancaires;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idclient", unique = true, nullable = false)
	public Integer getIdclient() {
		return this.idclient;
	}

	public void setIdclient(Integer idclient) {
		this.idclient = idclient;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "conseiller_idconseil", nullable = false)
	public Conseiller getConseiller() {
		return this.conseiller;
	}

	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	@Column(name = "numagency", nullable = false, length = 15)
	public String getNumagency() {
		return this.numagency;
	}

	public void setNumagency(String numagency) {
		this.numagency = numagency;
	}

	@Column(name = "nom_client", nullable = false, length = 45)
	public String getNomClient() {
		return this.nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	@Column(name = "prenom_client", nullable = false, length = 45)
	public String getPrenomClient() {
		return this.prenomClient;
	}

	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

	@Column(name = "Email", length = 100)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tel", length = 10)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "tel_portable", length = 10)
	public String getTelPortable() {
		return this.telPortable;
	}

	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}

	@Column(name = "typeClient", length = 10)
	public String getTypeClient() {
		return this.typeClient;
	}

	public void setTypeClient(String typeClient) {
		this.typeClient = typeClient;
	}

	@Column(name = "adresse", length = 150)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "anneeArrive", nullable = false, length = 10)
	public Date getAnneeArrive() {
		return this.anneeArrive;
	}

	public void setAnneeArrive(Date anneeArrive) {
		this.anneeArrive = anneeArrive;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "banque_client", catalog = "m_db", joinColumns = {
			@JoinColumn(name = "client_idclient", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "banque_idbanque", nullable = false, updatable = false) })
	public Set<Banque> getBanques() {
		return this.banques;
	}

	public void setBanques(Set<Banque> banques) {
		this.banques = banques;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Virement> getVirements() {
		return this.virements;
	}

	public void setVirements(Set<Virement> virements) {
		this.virements = virements;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Alerte> getAlertes() {
		return this.alertes;
	}

	public void setAlertes(Set<Alerte> alertes) {
		this.alertes = alertes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Document> getDocuments() {
		return this.documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "client")
	public Set<Compte> getComptes() {
		return this.comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "carte_bancaire_client", catalog = "m_db", joinColumns = {
			@JoinColumn(name = "client_idclient", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "carte_idcarte", nullable = false, updatable = false) })
	public Set<CarteBancaire> getCarteBancaires() {
		return this.carteBancaires;
	}

	public void setCarteBancaires(Set<CarteBancaire> carteBancaires) {
		this.carteBancaires = carteBancaires;
	}

}
