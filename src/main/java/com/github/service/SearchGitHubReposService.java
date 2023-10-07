package com.github.service;

import com.github.adapters.SearchRepositoriesApiAdapter;
import com.github.dto.rest.SearchResultDTO;
import com.github.utils.GitHubQueryBuilder;
import com.github.utils.SearchParamsValidators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SearchGitHubReposService implements ISearchGitHubReposService {

    private final SearchRepositoriesApiAdapter adapter;

    public SearchGitHubReposService(SearchRepositoriesApiAdapter adapter) {
        this.adapter = adapter;
    }

    /**
     * This method validates input parameters and creates a search query used by the api adapter
     * @param limit - limits the search
     * @param fromStr - creation date of repositories to be searched
     * @param languageStr - filters language of repositories to be searched
     * @return
     */
    public SearchResultDTO searchRepositories(Long limit, String fromStr, String languageStr) {
        String from = SearchParamsValidators.validateInputAsLocalDate(fromStr);
        String language = SearchParamsValidators.validateInputAsLanguage(languageStr);

        String query = GitHubQueryBuilder.buildSearchRepositoriesQuery(limit, from, language);

        return adapter.searchRepositories(query);
    }
}