
package soa.service;

import java.util.List;

import org.springframework.stereotype.Service;

import soa.Entity.Tourists;
import soa.Repository.TouristRepository;

@Service
public class TouristService {

    private final TouristRepository touristRepository;

    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public List<Tourists> getAllTourists() {
        return touristRepository.findAll();
    }
}
