package infsus.suak.backend.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "administrator")
public class Administrator {

    @Id
    @Column(name = "administrator_id")
    private Integer administratorId;

    @Column(name = "radno_vrijeme")
    private LocalTime radnoVrijeme;

    @Column(name = "datum_zaposlenja")
    private LocalDate datumZaposlenja;

    @OneToOne
    @JoinColumn(name = "korisnicko_ime", referencedColumnName = "korisnicko_ime", unique = true, nullable = false)
    private Korisnik korisnik;

    public Administrator(Integer administratorId, LocalTime radnoVrijeme, LocalDate datumZaposlenja, Korisnik korisnik) {
        this.administratorId = administratorId;
        this.radnoVrijeme = radnoVrijeme;
        this.datumZaposlenja = datumZaposlenja;
        this.korisnik = korisnik;
    }

    public Administrator() {
    }

    public Integer getAdministratorId() {
        return administratorId;
    }

    public void setAdministratorId(Integer administratorId) {
        this.administratorId = administratorId;
    }

    public LocalTime getRadnoVrijeme() {
        return radnoVrijeme;
    }

    public void setRadnoVrijeme(LocalTime radnoVrijeme) {
        this.radnoVrijeme = radnoVrijeme;
    }

    public LocalDate getDatumZaposlenja() {
        return datumZaposlenja;
    }

    public void setDatumZaposlenja(LocalDate datumZaposlenja) {
        this.datumZaposlenja = datumZaposlenja;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
