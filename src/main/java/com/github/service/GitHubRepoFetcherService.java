package com.github.service;

import com.github.adapters.GitHubFetcherApiAdapter;
import com.github.dto.repository.LanguagesEnum;
import com.github.dto.rest.SearchResultDTO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@AllArgsConstructor
public class GitHubRepoFetcherService {

    private final ModelMapper modelMapper;

    private final GitHubFetcherApiAdapter adapter;

    public SearchResultDTO searchRepositories(Long limit, String fromStr, String language) {


        return adapter.searchRepositories(Objects.requireNonNull(LanguagesEnum.getByString(language)));
    }
}