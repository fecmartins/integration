package com.api.integration.service;

import com.api.integration.data.DataRecord;
import com.api.integration.entity.Account;
import com.api.integration.entity.Repository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ReportService {

    private final Repository repository;

    public ReportService(Repository repository) {
        this.repository = repository;
    }

    public void pollReportService () {
        System.out.println("Polling API" + LocalDateTime.now());
        RestTemplate rt = new RestTemplate();

        // Fetch data from the mock API and expect an array of DataRecord
        ResponseEntity<DataRecord[]> response = rt.getForEntity("http://localhost:8080/mock-api", DataRecord[].class);
        //Get the response body
        DataRecord[] dataRecords = response.getBody();
        //System.out.println(Arrays.toString(response.getBody()));

        // Check if the response and body is not null, and the array has at least one record
        if (dataRecords != null && dataRecords.length > 0) {
            System.out.println("Received " + dataRecords.length + " records");

            // Loop through each DataRecord
            for (DataRecord d : dataRecords) {
                // Process each record (for example, log it)
                System.out.println(d);

                //Query DB
                Optional<Account> byEmail = repository.findByEmail(d.email());
                byEmail.ifPresentOrElse(nd -> {
                    // 2a. if email exists
                    System.out.println("Found email " + nd.getEmail());
                        }, () -> {
                    // 2b. if email doesn't exist
                    System.out.println("Email not found");
                    //Persist on DB
                    Account accountpersist = new Account(d.fullName(), d.email(),d.phoneNumber(), d.location());
                    repository.save(accountpersist);
                });
            }
        } else {
            System.out.println("No data received from the API.");
        }


        // 2. check to see if email already exists.
        // 2a. if email exists, and it was sent >15m of the querying date ignore it.
        // 2b. if email doesn't exist, then persist in the db and post message to other app.


    }


}
