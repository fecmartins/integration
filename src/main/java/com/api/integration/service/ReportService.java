package com.api.integration.service;

import com.api.integration.data.DataRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Arrays;

@Service
public class ReportService {

    public void pollReportService () {
        System.out.println("Polling API" + LocalDateTime.now());
        RestTemplate rt = new RestTemplate();

        ResponseEntity<DataRecord[]> response = rt.getForEntity("http://localhost:8080/mock-api", DataRecord[].class);
        System.out.println(Arrays.toString(response.getBody()));

        // 1. Iterate through response
        // 2. check to see if account_id already exists.
        // 2a. if account_id exists, and it was sent >15m of the querying date ignore it.
        // 2b. if account_id doesn't exist, then persist in the db and post message to other app.


    }


}
