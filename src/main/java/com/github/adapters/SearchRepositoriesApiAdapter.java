package com.github.adapters;

import com.github.dto.rest.SearchResultDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class SearchRepositoriesApiAdapter {

    @Getter(AccessLevel.PACKAGE)
    private final RestTemplate restTemplate;

    @Value("${adapter.github.search.repositories.url}")
    private String searchURL;


    public SearchRepositoriesApiAdapter(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder
                .build();
    }

    public SearchResultDTO searchRepositories(String query) {
        log.info("[GitHubFetcherApiAdapter] is fetching GET " + searchURL + query);
        return restTemplate.getForObject(searchURL + query, SearchResultDTO.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
