package com.github.controller;

import com.github.dto.rest.SearchResultDTO;
import com.github.service.SearchGitHubReposService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api/search")
@RestController
@Slf4j
public class RepositoryController {

    private final SearchGitHubReposService repositoriesService;

    @Operation(summary = "Gets a list of repositories with optional filters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found repositories",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class))
            }),
            @ApiResponse(responseCode = "400", description = "Invalid parameter supplied",
                    content = @Content)
            })
    @GetMapping(path = "/repositories", produces = {"application/json"})
    public ResponseEntity<SearchResultDTO> searchRepositories(
            @RequestParam(required = false, name = "limit") Long limit,
            @RequestParam(required = false, name = "from") String from,
            @RequestParam(required = false, name = "lang") String lang) {

        log.info("GET /search repositories triggered");

        return ResponseEntity.ok(repositoriesService.searchRepositories(limit, from, lang));
    }

}
