package org.data.linking.model.dto.etablissement;

import lombok.Data;

@Data
public class PeriodesEtablissement {
    private String dateFin;
    private String dateDebut;
    private String etatAdministratifEtablissement;
    private boolean changementEtatAdministratifEtablissement;
    private String enseigne1Etablissement;
    private String enseigne2Etablissement;
    private String enseigne3Etablissement;
    private boolean changementEnseigneEtablissement;
    private String denominationUsuelleEtablissement;
    private boolean changementDenominationUsuelleEtablissement;
    private String activitePrincipaleEtablissement;
    private String nomenclatureActivitePrincipaleEtablissement;
    private boolean changementActivitePrincipaleEtablissement;
    private String caractereEmployeurEtablissement;
    private boolean changementCaractereEmployeurEtablissement;
}
