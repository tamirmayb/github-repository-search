package com.github.dto.repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LicenseDTO {

    private String key;

    private String name;

    @JsonProperty("spdx_id")
    private String spdxId;

    private String url;

    @JsonProperty("node_id")
    private String nodeId;

}