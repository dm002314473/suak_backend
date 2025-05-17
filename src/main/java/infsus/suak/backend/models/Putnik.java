package infsus.suak.backend.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "putnik")
public class Putnik {

    @Id
    @Column(name = "putnik_id")
    private Integer putnikId;

    @Column(name = "loyalty_bodovi")
    private Integer loyaltyBodovi;

    @OneToOne
    @JoinColumn(name = "korisnicko_ime", referencedColumnName = "korisnicko_ime", unique = true, nullable = false)
    private Korisnik korisnik;

    @ManyToMany(mappedBy = "putnici")
    private Set<AutobusnaLinija> autobusneLinije = new HashSet<>();

    public Putnik(Integer putnikId, Integer loyaltyBodovi, Korisnik korisnik, Set<AutobusnaLinija> autobusneLinije) {
        this.putnikId = putnikId;
        this.loyaltyBodovi = loyaltyBodovi;
        this.korisnik = korisnik;
        this.autobusneLinije = autobusneLinije;
    }

    public Putnik(Integer putnikId, Integer loyaltyBodovi, Korisnik korisnik) {
        this.putnikId = putnikId;
        this.loyaltyBodovi = loyaltyBodovi;
        this.korisnik = korisnik;
    }

    public Putnik() {
    }

    public Integer getPutnikId() {
        return putnikId;
    }

    public void setPutnikId(Integer putnikId) {
        this.putnikId = putnikId;
    }

    public Integer getLoyaltyBodovi() {
        return loyaltyBodovi;
    }

    public void setLoyaltyBodovi(Integer loyaltyBodovi) {
        this.loyaltyBodovi = loyaltyBodovi;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Set<AutobusnaLinija> getAutobusneLinije() {
        return autobusneLinije;
    }

    public void setAutobusneLinije(Set<AutobusnaLinija> autobusneLinije) {
        this.autobusneLinije = autobusneLinije;
    }
}
