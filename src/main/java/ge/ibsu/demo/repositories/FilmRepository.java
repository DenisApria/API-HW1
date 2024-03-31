package ge.ibsu.demo.repositories;

import ge.ibsu.demo.dto.CustomerInfo;
import ge.ibsu.demo.dto.FilmInfo;
import ge.ibsu.demo.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmRepository {
    @Query("SELECT new ge.ibsu.demo.dto.FilmInfo(f.title, f.description, f.rating) " +
            "FROM film f " +
            "WHERE (:searchText IS NULL OR f.title LIKE %:searchText% OR f.description LIKE %:searchText%) " +
            "AND (:releaseYear IS NULL OR f.release_year = :releaseYear) " +
            "AND (:language IS NULL OR f.language.language = :language)")
    Page<FilmInfo> searchFilms(@Param("searchText") String searchText, @Param("releaseYear") Integer releaseYear, @Param("language") String language, Pageable pageable);
}
