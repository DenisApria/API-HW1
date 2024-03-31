package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.CityInfo;
import ge.ibsu.demo.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityInfo> getAllCitiesWithCountry() {
        return cityRepository.getAllCitiesWithCountry();
    }
}
