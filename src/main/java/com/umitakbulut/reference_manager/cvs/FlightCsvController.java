package com.umitakbulut.reference_manager.cvs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightCsvController {

    private final FlightCsvService flightCsvService;

    @PostMapping("/import")
    public ResponseEntity<?> importFlights(@RequestParam("file") MultipartFile file) {
        try {
            flightCsvService.importFlightsFromCsv(file.getInputStream()); // ✅ Hata buradan çözülür
            return ResponseEntity.ok("CSV içeri aktarıldı");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hata: " + e.getMessage());
        }
    }
}