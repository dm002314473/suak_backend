package infsus.suak.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "odrediste")
public class Odrediste {

    @Id
    @Column(name = "odrediste_id")
    private Integer odredisteId;

    @Column(nullable = false, length = 50)
    private String grad;

    @Column(nullable = false, length = 50)
    private String drzava;

    @Column(length = 100)
    private String autobusniKolodvor;

    public Odrediste(Integer odredisteId, String grad, String drzava, String autobusniKolodvor) {
        this.odredisteId = odredisteId;
        this.grad = grad;
        this.drzava = drzava;
        this.autobusniKolodvor = autobusniKolodvor;
    }

    public Odrediste() {
    }

    public Integer getOdredisteId() {
        return odredisteId;
    }

    public void setOdredisteId(Integer odredisteId) {
        this.odredisteId = odredisteId;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public String getAutobusniKolodvor() {
        return autobusniKolodvor;
    }

    public void setAutobusniKolodvor(String autobusniKolodvor) {
        this.autobusniKolodvor = autobusniKolodvor;
    }
}
