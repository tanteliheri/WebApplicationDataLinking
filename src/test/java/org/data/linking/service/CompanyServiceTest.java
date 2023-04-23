package org.data.linking.service;

import org.data.linking.model.domain.Company;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class CompanyServiceTest {

    @Mock
    private CompanyService companyService;

    @Test
    void should_create_companies() {
        Calendar.getInstance().set(1978, 1, 1);
        Company company1 = Company.builder()
                .siret("31302979500017")
                .fullAddress("261 CHE DES COLLES 06140 VENCE")
                .fullName("SOC EXPL PEPINIERES GAUDISSART")
                .nic("00017")
                .creationDate(Calendar.getInstance().getTime())
                .build();
        Calendar.getInstance().set(1998, 5, 14);
        Company company2 = Company.builder()
                .siret("41339442000033")
                .fullAddress("6 RUE FORVILLE 06400 CANNES")
                .fullName("QUALITE FOOD GROUPE")
                .nic("00033")
                .creationDate(Calendar.getInstance().getTime())
                .build();
        List<Company> companies = Arrays.asList(company1, company2);

        when(companyService.createCompanies(Arrays.asList("31302979500017", "41339442000033"))).thenReturn(companies);
        List<Company> companiesExpected = companyService.createCompanies(Arrays.asList("31302979500017", "41339442000033"));

        assertTrue(companiesExpected.size() == 2);
        assertThat(companies).usingRecursiveComparison().isEqualTo(companiesExpected);
    }
}
