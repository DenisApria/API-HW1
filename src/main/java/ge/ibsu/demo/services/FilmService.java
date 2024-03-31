package ge.ibsu.demo.services;

import ge.ibsu.demo.dto.FilmInfo;
import ge.ibsu.demo.dto.Paging;
import ge.ibsu.demo.dto.SearchFilm;
import ge.ibsu.demo.repositories.FilmRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<FilmInfo> search(SearchFilm searchFilm, Paging paging) {
        String searchText = searchFilm.getSearchText() != null ? "%" + searchFilm.getSearchText() + "%" : "";
        Pageable pageable = PageRequest.of(paging.getPage() - 1, paging.getSize());
        return filmRepository.searchFilms(searchText, searchFilm.getReleaseYear(), searchFilm.getLanguage(), pageable);
    }
}
