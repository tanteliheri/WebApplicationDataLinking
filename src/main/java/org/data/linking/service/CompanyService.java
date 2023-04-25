package org.data.linking.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.data.linking.model.domain.Company;
import org.data.linking.model.dto.etablissement.Etablissement;
import org.data.linking.model.dto.etablissement.Root;
import org.data.linking.repository.CompanyRepository;
import org.data.linking.utils.ApiMessage;
import org.data.linking.utils.CompanyMapper;
import org.data.linking.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private static final Logger logger = LoggerFactory.getLogger(CompanyService.class);

    private final RestTemplate restTemplate;

    private final CompanyMapper companyMapper;

    private final CompanyRepository companyRepository;

    @Value("${api-insee.authorization-bearer}")
    private String authorizationBearer;

    @Value("${api-insee.endpoint-sirene}")
    private String endPointSirene;


    /**
     * Retrieve info company with siret from api insee and update local database
     *
     * @param siretIds
     * @return
     */
    public List<Company> createCompanies(List<String> siretIds) {
        List<Company> companies = siretIds
                .stream()
                .map(siret -> mapToCompany(siret))
                .filter(company -> Objects.nonNull(company))
                .collect(Collectors.toList());

        return CollectionUtils.isNotEmpty(companies) ? companyRepository.saveAll(companies) : null;
    }

    /**
     * Call api and map result to Company Objects
     *
     * @param siret
     * @return
     */
    private Company mapToCompany(String siret) {
        String url = endPointSirene + "/siret/" + siret;
        try {
            logger.info("Process get company info with siret : " + siret);
            ResponseEntity<Root> rootResponseEntity = restTemplate.exchange(
                    url,
                    HttpMethod.GET,
                    Utils.getHttpEntity(authorizationBearer),
                    Root.class);

            Etablissement etablissement = rootResponseEntity.getBody().getEtablissement();
            String denominationUniteLegale = etablissement.getUniteLegale().getDenominationUniteLegale();
            logger.info(String.format("The company with siret %s is well recovered and its fullName is: %s ", siret, denominationUniteLegale));

            return companyMapper.toCompany(etablissement);
        } catch (HttpClientErrorException ex) {
            ApiMessage.Error(logger, ex);
            return null;
        }
    }
}
