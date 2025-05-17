package infsus.suak.backend.mappers;

import infsus.suak.backend.dtos.PutnikDTO;
import infsus.suak.backend.models.Putnik;

public class PutnikMapper {

    public static PutnikDTO toDto(Putnik putnik) {
        if (putnik == null) {
            return null;
        }

        PutnikDTO dto = new PutnikDTO();
        dto.setPutnikId(putnik.getPutnikId());
        dto.setLoyaltyBodovi(putnik.getLoyaltyBodovi() != null ? putnik.getLoyaltyBodovi() : 0);

        if (putnik.getKorisnik() != null) {
            dto.setIme(putnik.getKorisnik().getIme());
            dto.setPrezime(putnik.getKorisnik().getPrezime());
            dto.setEmail(putnik.getKorisnik().getEmail());
        }

        return dto;
    }
}
