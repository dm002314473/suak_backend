package infsus.suak.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "peron")
public class Peron {

    @Id
    @Column(name = "peron_id")
    private Integer peronId;

    @Column(precision = 5, scale = 2)
    private BigDecimal visina;

    public Peron(Integer peronId, BigDecimal visina) {
        this.peronId = peronId;
        this.visina = visina;
    }

    public Peron() {
    }

    public Integer getPeronId() {
        return peronId;
    }

    public void setPeronId(Integer peronId) {
        this.peronId = peronId;
    }

    public BigDecimal getVisina() {
        return visina;
    }

    public void setVisina(BigDecimal visina) {
        this.visina = visina;
    }
}
