package infsus.suak.backend.mappers;

import infsus.suak.backend.dtos.AutobusnaLinijaDTO;
import infsus.suak.backend.models.AutobusnaLinija;

import java.util.stream.Collectors;

public class AutobusnaLinijaMapper {

    public static AutobusnaLinijaDTO toDto(AutobusnaLinija linija) {
        if (linija == null)
            return null;

        AutobusnaLinijaDTO dto = new AutobusnaLinijaDTO();
        dto.setAutobusnaLinijaId(linija.getAutobusnaLinijaId().longValue());
        dto.setVrijemeDolaska(linija.getVrijemeDolaska().toString());
        dto.setVrijemePolaska(linija.getVrijemePolaska().toString());
        dto.setCijena(linija.getCijena().doubleValue());
        dto.setOdredisteId(linija.getOdrediste().getOdredisteId());
        dto.setAutobusId(linija.getAutobus().getAutobusId());
        dto.setPeronId(linija.getPeron().getPeronId());

        dto.setPutnici(
                linija.getPutnici()
                        .stream()
                        .map(PutnikMapper::toDto)
                        .collect(Collectors.toList())
        );

        return dto;
    }
}
