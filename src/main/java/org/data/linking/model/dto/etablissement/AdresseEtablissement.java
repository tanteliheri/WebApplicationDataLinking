package org.data.linking.model.dto.etablissement;

import lombok.Data;

@Data
public class AdresseEtablissement {
    private String complementAdresseEtablissement;
    private String numeroVoieEtablissement;
    private String indiceRepetitionEtablissement;
    private String typeVoieEtablissement;
    private String libelleVoieEtablissement;
    private String codePostalEtablissement;
    private String libelleCommuneEtablissement;
    private String libelleCommuneEtrangerEtablissement;
    private String distributionSpecialeEtablissement;
    private String codeCommuneEtablissement;
    private String codeCedexEtablissement;
    private String libelleCedexEtablissement;
    private String codePaysEtrangerEtablissement;
    private String libellePaysEtrangerEtablissement;

    public String getFullAddress() {
        return numeroVoieEtablissement + " " +
                typeVoieEtablissement + " " +
                libelleVoieEtablissement + " " +
                codePostalEtablissement + " " +
                libelleCommuneEtablissement;
    }
}
