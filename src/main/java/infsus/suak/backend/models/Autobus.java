package infsus.suak.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "autobus")
public class Autobus {

    @Id
    @Column(name = "autobus_id")
    private Integer autobusId;

    @Column(name = "broj_sjedala", nullable = false)
    private Integer brojSjedala;

    @Column(nullable = false, length = 50)
    private String model;

    @Column(precision = 5, scale = 2)
    private BigDecimal visina;

    public Autobus(Integer autobusId, Integer brojSjedala, String model, BigDecimal visina) {
        this.autobusId = autobusId;
        this.brojSjedala = brojSjedala;
        this.model = model;
        this.visina = visina;
    }

    public Autobus() {
    }

    public Integer getAutobusId() {
        return autobusId;
    }

    public void setAutobusId(Integer autobusId) {
        this.autobusId = autobusId;
    }

    public Integer getBrojSjedala() {
        return brojSjedala;
    }

    public void setBrojSjedala(Integer brojSjedala) {
        this.brojSjedala = brojSjedala;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getVisina() {
        return visina;
    }

    public void setVisina(BigDecimal visina) {
        this.visina = visina;
    }
}
