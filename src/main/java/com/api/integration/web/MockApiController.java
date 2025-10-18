package com.api.integration.web;

import com.api.integration.data.DataRecord;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Creates an endpoint to talk to
@RestController
public class MockApiController {

    @GetMapping("/mock-api")
    public ResponseEntity<String> fetchData() {
//  public ResponseEntity<List<DataRecord>> fetchData() {

        // Create mock data for multiple people
//        List<DataRecord> mockData = List.of(
//                new DataRecord(
//                        "John Doe",
//                        "john.doe@example.com",
//                        "+1-234-567-890",
//                        "123456789",
//                        "New York, USA",
//                        "2024-10-13T10:00:00Z"
//                ),
//                new DataRecord(
//                        "Jane Smith",
//                        "jane.smith@example.com",
//                        "+1-987-654-321",
//                        "987654321",
//                        "Los Angeles, USA",
//                        "2024-09-15T15:45:00Z"
//                ),
//                new DataRecord(
//                        "Alice Johnson",
//                        "alice.j@example.com",
//                        "+1-555-123-456",
//                        "555123456",
//                        "Chicago, USA",
//                        "2024-08-20T08:30:00Z"
//                )
//        );

        String mockData = "[{\"full_name\":\"John Doe\",\"email\":\"john.doe@example.com\",\"phone_number\":\"+1-234-567-890\",\"account_id\":\"123456789\",\"location\":\"New York, USA\",\"created_at\":\"2024-10-13T10:00:00Z\"},{\"full_name\":\"Jane Smith\",\"email\":\"jane.smith@example.com\",\"phone_number\":\"+1-987-654-321\",\"account_id\":\"987654321\",\"location\":\"Los Angeles, USA\",\"created_at\":\"2024-09-15T15:45:00Z\"},{\"full_name\":\"Alice Johnson\",\"email\":\"alice.j@example.com\",\"phone_number\":\"+1-555-123-456\",\"account_id\":\"555123456\",\"location\":\"Chicago, USA\",\"created_at\":\"2024-08-20T08:30:00Z\"}]";

        // Return the mock data as a JSON response
        return ResponseEntity.ok(mockData);
    }
}
