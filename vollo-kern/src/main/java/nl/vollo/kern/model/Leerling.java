package nl.vollo.kern.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import nl.vollo.kern.annotation.DomainType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "leerlingen")
@DomainType(DomainEntity.LEERLING)
public class Leerling extends DomainObject {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vollo_seq")
    @SequenceGenerator(name = "vollo_seq", sequenceName = "vollo_seq", allocationSize = 1)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Version
	@Column(name = "version")
	private int version;

	@Column(nullable = false)
	@NotNull
	private String voornamen;

	@Column(nullable = false)
	@NotNull
	private String roepnaam;

	@Column
	private String tussenvoegsel;

	@Column(nullable = false)
	@NotNull
	private String achternaam;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	@NotNull
	private Date geboortedatum;

	@Enumerated(EnumType.STRING)
	private Geslacht geslacht;

	@Embedded
	private Adres adres;

	@JsonIgnore
	@OneToMany(mappedBy = "leerling", targetEntity = Inschrijving.class, fetch = FetchType.LAZY)
    @OrderBy("datumInschrijving")
	private List<Inschrijving> inschrijvingen = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int getVersion() {
        return version;
    }

    @Override
    public void setVersion(int version) {
        this.version = version;
    }

    public String getVoornamen() {
        return voornamen;
    }

    public void setVoornamen(String voornamen) {
        this.voornamen = voornamen;
    }

    public String getRoepnaam() {
        return roepnaam;
    }

    public void setRoepnaam(String roepnaam) {
        this.roepnaam = roepnaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Geslacht getGeslacht() {
        return geslacht;
    }

    public void setGeslacht(Geslacht geslacht) {
        this.geslacht = geslacht;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public List<Inschrijving> getInschrijvingen() {
        return inschrijvingen;
    }

    public void setInschrijvingen(List<Inschrijving> inschrijvingen) {
        this.inschrijvingen = inschrijvingen;
    }
}