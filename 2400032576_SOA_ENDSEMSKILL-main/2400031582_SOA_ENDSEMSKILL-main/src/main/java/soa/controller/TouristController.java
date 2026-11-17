
package soa.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import soa.service.TouristService;
import soa.Entity.Tourists;

@RestController
@RequestMapping("/api/tourists")
public class TouristController {

    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping
    public ResponseEntity<List<Tourists>> getAllTourists(
            @RequestHeader(
                value = "X-Auth-Token",
                required = false
            ) String token) {

        List<Tourists> tourists =
                touristService.getAllTourists();

        return ResponseEntity.ok(tourists);
    }
}
