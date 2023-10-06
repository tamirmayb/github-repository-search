package com.github.adapters;

import com.github.dto.repository.LanguagesEnum;
import com.github.dto.rest.SearchResultDTO;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class GitHubFetcherApiAdapter {

    @Getter(AccessLevel.PACKAGE)
    private final RestTemplate restTemplate;

    @Value("${adapter.github.search.repositories.url}")
    private String searchURL;


    public GitHubFetcherApiAdapter(@Lazy RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public SearchResultDTO searchRepositories(LanguagesEnum language) {
        log.info("[GitHubFetcherApiAdapter] is fetching GET " + searchURL + "/repositories?q=language:" + language.getName()
                + "&sort=stars&per_page=10");
        return restTemplate.getForObject(searchURL + "created:2019-01-10&sort=stars&order=desc", SearchResultDTO.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
