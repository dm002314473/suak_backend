package infsus.suak.backend.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autobusnalinija")
public class AutobusnaLinija {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "autobusna_linija_id")
    private Integer autobusnaLinijaId;

    @Column(name = "vrijeme_dolaska", nullable = false)
    private LocalTime vrijemeDolaska;

    @Column(name = "vrijeme_polaska", nullable = false)
    private LocalTime vrijemePolaska;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal cijena;

    @ManyToOne
    @JoinColumn(name = "peron_id")
    private Peron peron;

    @ManyToOne
    @JoinColumn(name = "odrediste_id")
    private Odrediste odrediste;

    @ManyToOne
    @JoinColumn(name = "administrator_id")
    private Administrator administrator;

    @ManyToOne
    @JoinColumn(name = "autobus_id")
    private Autobus autobus;

    @ManyToMany
    @JoinTable(
            name = "putnik_autobusnalinija",
            joinColumns = @JoinColumn(name = "autobusna_linija_id"),
            inverseJoinColumns = @JoinColumn(name = "putnik_id")
    )
    private Set<Putnik> putnici = new HashSet<>();

    public AutobusnaLinija(Integer autobusnaLinijaId, LocalTime vrijemeDolaska, LocalTime vrijemePolaska, BigDecimal cijena, Peron peron, Odrediste odrediste, Administrator administrator, Autobus autobus, Set<Putnik> putnici) {
        this.autobusnaLinijaId = autobusnaLinijaId;
        this.vrijemeDolaska = vrijemeDolaska;
        this.vrijemePolaska = vrijemePolaska;
        this.cijena = cijena;
        this.peron = peron;
        this.odrediste = odrediste;
        this.administrator = administrator;
        this.autobus = autobus;
        this.putnici = putnici;
    }

    public AutobusnaLinija(LocalTime vrijemeDolaska, LocalTime vrijemePolaska, BigDecimal cijena, Peron peron, Odrediste odrediste, Administrator administrator, Autobus autobus, Set<Putnik> putnici) {
        this.vrijemeDolaska = vrijemeDolaska;
        this.vrijemePolaska = vrijemePolaska;
        this.cijena = cijena;
        this.peron = peron;
        this.odrediste = odrediste;
        this.administrator = administrator;
        this.autobus = autobus;
        this.putnici = putnici;
    }

    public AutobusnaLinija() {
    }

    public Integer getAutobusnaLinijaId() {
        return autobusnaLinijaId;
    }

    public void setAutobusnaLinijaId(Integer autobusnaLinijaId) {
        this.autobusnaLinijaId = autobusnaLinijaId;
    }

    public LocalTime getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(LocalTime vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public LocalTime getVrijemePolaska() {
        return vrijemePolaska;
    }

    public void setVrijemePolaska(LocalTime vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    public BigDecimal getCijena() {
        return cijena;
    }

    public void setCijena(BigDecimal cijena) {
        this.cijena = cijena;
    }

    public Peron getPeron() {
        return peron;
    }

    public void setPeron(Peron peron) {
        this.peron = peron;
    }

    public Odrediste getOdrediste() {
        return odrediste;
    }

    public void setOdrediste(Odrediste odrediste) {
        this.odrediste = odrediste;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }

    public Set<Putnik> getPutnici() {
        return putnici;
    }

    public void setPutnici(Set<Putnik> putnici) {
        this.putnici = putnici;
    }
}
