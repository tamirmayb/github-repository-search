package com.github.utils;

import com.github.exceptions.CustomInvalidQueryException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GitHubQueryBuilder {
    private static final String CREATED = "created:";
    private static final String LANGUAGE = "language:";
    private static final String PER_PAGE = "&per_page=";
    private static final String SORT_AND_ORDER_BY_STARS_DESC = "&sort=stars&order=desc";

    /**
     * Builds a string query for repository search.
     * At least from or language should be provided or the process will fail
     * @param limit - limits the results
     * @param from - creation date parameter
     * @param language - language date parameter
     * @return - query string
     */
    public static String buildSearchRepositoriesQuery(Long limit, String from, String language) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean queryValid = false;

        if (from != null) {
            stringBuilder.append(CREATED)
                    .append(from);
            queryValid = true;
        }

        if (language != null) {
            if (queryValid) {
                stringBuilder.append("+");
            }
            stringBuilder.append(LANGUAGE)
                    .append(language);
            queryValid = true;
        }

        if (queryValid) {
            if (limit != null && limit > 0) {
                stringBuilder.append(PER_PAGE)
                        .append(limit);
            }
            stringBuilder.append(SORT_AND_ORDER_BY_STARS_DESC);
        } else {
            log.error("[GitHubQueryBuilder] Error: Language or From fields must contain valid values");
            throw new CustomInvalidQueryException();
        }

        return stringBuilder.toString();
    }
}
