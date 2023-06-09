package org.data.linking.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.data.linking.exceptions.DataNotFoundException;
import org.data.linking.exceptions.InternalServerException;
import org.data.linking.model.domain.Company;
import org.data.linking.service.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
public class CompanyController {

    private static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

    private final CompanyService companyService;

    @Value("${etablissement.siret}")
    private List<String> etablissementSirets;

    @Operation(summary = "Save company information from siret id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful company save", content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid request", content = @Content),
            @ApiResponse(responseCode = "403", description = "Access to this resource is denied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Establishment does not exist", content = @Content),
            @ApiResponse(responseCode = "503", description = "Service unavailable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping(value = "/company", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Company>> saveCompaniesInformation(@RequestBody(required = false) List<String> siretList) {
        logger.info("Call controller method CompanyController.getCompaniesInformation");
        try {
            siretList = CollectionUtils.isNotEmpty(siretList) ? siretList : etablissementSirets;
            return new ResponseEntity<>(companyService.createCompanies(siretList), HttpStatus.CREATED);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            throw new InternalServerException(ex.getMessage());
        }
    }
}
