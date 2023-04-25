package org.data.linking.model.dto.etablissement;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UniteLegale {
    private String etatAdministratifUniteLegale;
    private String statutDiffusionUniteLegale;
    private String dateCreationUniteLegale;
    private String categorieJuridiqueUniteLegale;
    private String denominationUniteLegale;
    private String sigleUniteLegale;
    private String denominationUsuelle1UniteLegale;
    private String denominationUsuelle2UniteLegale;
    private String denominationUsuelle3UniteLegale;
    private String sexeUniteLegale;
    private String nomUniteLegale;
    private String nomUsageUniteLegale;
    private String prenom1UniteLegale;
    private String prenom2UniteLegale;
    private String prenom3UniteLegale;
    private String prenom4UniteLegale;
    private String prenomUsuelUniteLegale;
    private String pseudonymeUniteLegale;
    private String activitePrincipaleUniteLegale;
    private String nomenclatureActivitePrincipaleUniteLegale;
    private String identifiantAssociationUniteLegale;
    private String economieSocialeSolidaireUniteLegale;
    private String societeMissionUniteLegale;
    private String caractereEmployeurUniteLegale;
    private String trancheEffectifsUniteLegale;
    private String anneeEffectifsUniteLegale;
    private String nicSiegeUniteLegale;

    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date dateDernierTraitementUniteLegale;
    private String categorieEntreprise;
    private String anneeCategorieEntreprise;
}
