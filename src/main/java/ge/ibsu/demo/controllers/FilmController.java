package ge.ibsu.demo.controllers;

import ge.ibsu.demo.dto.FilmInfo;
import ge.ibsu.demo.dto.RequestData;
import ge.ibsu.demo.dto.SearchFilm;
import ge.ibsu.demo.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/film")
public class FilmController {

    private final FilmService filmService;

    @Autowired
    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST, produces = {"application/json"})
    public Page<FilmInfo> search(@RequestBody RequestData<SearchFilm> rd) {
        return filmService.search(rd.getData(), rd.getPaging());
    }
}