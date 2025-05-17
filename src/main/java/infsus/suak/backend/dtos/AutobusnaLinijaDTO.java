package infsus.suak.backend.dtos;

import infsus.suak.backend.models.*;
import jakarta.persistence.*;

import java.util.List;

public class AutobusnaLinijaDTO {

    private Long autobusnaLinijaId;
    private String vrijemeDolaska;
    private String vrijemePolaska;
    private double cijena;

    private Integer odredisteId;
    private Integer autobusId;
    private Integer peronId;

    private List<PutnikDTO> putnici;

    public Long getAutobusnaLinijaId() {
        return autobusnaLinijaId;
    }

    public void setAutobusnaLinijaId(Long autobusnaLinijaId) {
        this.autobusnaLinijaId = autobusnaLinijaId;
    }

    public String getVrijemeDolaska() {
        return vrijemeDolaska;
    }

    public void setVrijemeDolaska(String vrijemeDolaska) {
        this.vrijemeDolaska = vrijemeDolaska;
    }

    public String getVrijemePolaska() {
        return vrijemePolaska;
    }

    public void setVrijemePolaska(String vrijemePolaska) {
        this.vrijemePolaska = vrijemePolaska;
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        this.cijena = cijena;
    }

    public Integer getOdredisteId() {
        return odredisteId;
    }

    public void setOdredisteId(Integer odredisteId) {
        this.odredisteId = odredisteId;
    }

    public Integer getAutobusId() {
        return autobusId;
    }

    public void setAutobusId(Integer autobusId) {
        this.autobusId = autobusId;
    }

    public Integer getPeronId() {
        return peronId;
    }

    public void setPeronId(Integer peronId) {
        this.peronId = peronId;
    }

    public List<PutnikDTO> getPutnici() {
        return putnici;
    }

    public void setPutnici(List<PutnikDTO> putnici) {
        this.putnici = putnici;
    }
}
