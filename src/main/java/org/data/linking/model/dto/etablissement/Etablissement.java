package org.data.linking.model.dto.etablissement;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Etablissement {
    private String siren;
    private String nic;
    private String siret;
    private String statutDiffusionEtablissement;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateCreationEtablissement;
    private String trancheEffectifsEtablissement;
    private String anneeEffectifsEtablissement;
    private String activitePrincipaleRegistreMetiersEtablissement;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date dateDernierTraitementEtablissement;
    private boolean etablissementSiege;
    private int nombrePeriodesEtablissement;
    private UniteLegale uniteLegale;
    private AdresseEtablissement adresseEtablissement;
    private Adresse2Etablissement adresse2Etablissement;
    private List<PeriodesEtablissement> periodesEtablissement;
}
