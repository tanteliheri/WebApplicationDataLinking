package org.data.linking.utils;

import org.data.linking.model.domain.Company;
import org.data.linking.model.dto.etablissement.Etablissement;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {

    public Company toCompany(Etablissement etablissement) {
        return Company.builder()
                .siret(etablissement.getSiret())
                .nic(etablissement.getNic())
                .fullAddress(etablissement.getAdresseEtablissement().getFullAddress())
                .creationDate(etablissement.getDateCreationEtablissement())
                .fullName(etablissement.getUniteLegale().getDenominationUniteLegale())
                .build();
    }
}
