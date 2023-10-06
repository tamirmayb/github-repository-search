package com.github.service;

import com.github.adapters.GitHubFetcherApiAdapter;
import com.github.dto.rest.SearchResultDTO;
import com.github.utils.GitHubQueryBuilder;
import com.github.utils.Validators;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class GitHubRepoFetcherService implements ISearchRepositoriesService {

    private final GitHubFetcherApiAdapter adapter;

    public SearchResultDTO searchRepositories(Long limit, String fromStr, String languageStr) {
        String from = Validators.validateInputAsLocalDate(fromStr);
        String language = Validators.validateInputAsLanguage(languageStr);

        String query = GitHubQueryBuilder.buildSearchRepositoriesQuery(limit, from, language);

        return adapter.searchRepositories(query);
    }
}