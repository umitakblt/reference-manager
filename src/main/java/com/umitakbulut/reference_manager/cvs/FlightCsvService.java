package com.umitakbulut.reference_manager.cvs;

import com.umitakbulut.reference_manager.entity.Flight;
import java.io.InputStream;
import java.util.List;

public interface FlightCsvService {
    List<Flight> importFlightsFromCsv(InputStream csvInputStream);

}
