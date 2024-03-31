package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.CityInfo;
import ge.ibsu.demo.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT new ge.ibsu.demo.dto.CityInfo(c.city, c.country.country) FROM City c")
    List<CityInfo> getAllCitiesWithCountry();
}
