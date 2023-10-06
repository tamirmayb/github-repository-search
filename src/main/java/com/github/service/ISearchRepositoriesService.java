package com.github.service;

import com.github.dto.rest.SearchResultDTO;

public interface ISearchRepositoriesService {

    SearchResultDTO searchRepositories(Long limit, String fromStr, String languageStr);
}
