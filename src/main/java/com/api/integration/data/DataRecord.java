package com.api.integration.data;

import com.fasterxml.jackson.annotation.JsonProperty;

//This class is defined using Java Records and utilizes Jackson annotations to handle JSON serialization
//and deserialization.

public record DataRecord(
        @JsonProperty("full_name") String fullName,
        @JsonProperty("email") String email,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("account_id") String accountId,
        @JsonProperty("location") String location,
        @JsonProperty("created_at") String createdAt
) {}

