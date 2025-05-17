package infsus.suak.backend.dtos;

public class PutnikDTO {

    private Integer putnikId;
    private String ime;
    private String prezime;
    private String email;
    private int loyaltyBodovi;

    public Integer getPutnikId() {
        return putnikId;
    }

    public void setPutnikId(Integer putnikId) {
        this.putnikId = putnikId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoyaltyBodovi() {
        return loyaltyBodovi;
    }

    public void setLoyaltyBodovi(int loyaltyBodovi) {
        this.loyaltyBodovi = loyaltyBodovi;
    }
}
