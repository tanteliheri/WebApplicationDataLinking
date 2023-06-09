package org.data.linking.controller;

import org.apache.commons.collections4.CollectionUtils;
import org.data.linking.model.domain.Company;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyControllerTest extends AbstractTest {

    @Test
    public void saveCompaniesInformationSuccess() throws Exception {
        String uri = "/api/company";
        List<String> sirets = Arrays.asList("31302979500017", "41339442000033", "41339442000090", "41339442000116",
                "41776304200013", "43438147100011");

        // save companies information
        String siretJson = super.mapToJson(sirets);
        System.out.println(mvc);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(siretJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status);

        String content = mvcResult.getResponse().getContentAsString();
        Company[] companies = super.mapFromJson(content, Company[].class);
        Arrays.asList(companies)
                .stream()
                .map(company -> company.getSiret())
                .collect(Collectors.toList())
                .forEach(siret -> assertTrue(CollectionUtils.containsAny(sirets, siret)));
    }

    @Test
    public void saveCompaniesInformationFailed() throws Exception {
        String uri = "/api/company";
        List<String> sirets = Arrays.asList("31302979500017", "41339442000033", "47962817400042");
        // save companies information
        String siretJson = super.mapToJson(sirets);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(siretJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.CREATED.value(), status);

        String content = mvcResult.getResponse().getContentAsString();
        Company[] companies = super.mapFromJson(content, Company[].class);
        List<String> siretExpected = Arrays.asList(companies)
                .stream()
                .map(company -> company.getSiret())
                .collect(Collectors.toList());

        assertFalse(CollectionUtils.containsAny(siretExpected, "47962817400042"));
    }
}
