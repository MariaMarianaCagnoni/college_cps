package dev.mariamariana.college_cps.controller;

import dev.mariamariana.college_cps.dto.CreateCursoDTO;
import dev.mariamariana.college_cps.dto.CursoDTO;
import dev.mariamariana.college_cps.dto.UpdateCursoDTO;
import dev.mariamariana.college_cps.model.Curso;
import dev.mariamariana.college_cps.service.ICursoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private final ICursoService cursoService;
    private final ModelMapper modelMapper;

    public CursoController(ICursoService cursoService, ModelMapper modelMapper) {
        this.cursoService = cursoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<CursoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "${spring.data.web.pageable.default-page-size}") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort
    ) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sort).ascending());
        var cursos = this.cursoService.findPageable(pageable)
                .map(curso -> this.modelMapper.map(curso, CursoDTO.class));

        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CursoDTO> findById(@PathVariable Long id) {
        Curso curso = this.cursoService.findById(id);
        return new ResponseEntity<>(this.modelMapper.map(curso, CursoDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CursoDTO> create(@RequestBody CreateCursoDTO createCursoDTO) {
        var curso = this.cursoService.create(this.modelMapper.map(createCursoDTO, Curso.class));
        return new ResponseEntity<>(this.modelMapper.map(curso, CursoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<CursoDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateCursoDTO updateCursoDTO) {
        var curso = this.cursoService.update(id, this.modelMapper.map(updateCursoDTO, Curso.class));
        return new ResponseEntity<>(this.modelMapper.map(curso, CursoDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.cursoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
