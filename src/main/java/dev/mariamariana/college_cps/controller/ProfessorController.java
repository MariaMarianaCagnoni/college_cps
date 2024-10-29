package dev.mariamariana.college_cps.controller;

import dev.mariamariana.college_cps.dto.CreateProfessorDTO;
import dev.mariamariana.college_cps.dto.CursoDTO;
import dev.mariamariana.college_cps.dto.ProfessorDTO;
import dev.mariamariana.college_cps.dto.UpdateProfessorDTO;
import dev.mariamariana.college_cps.model.Professor;
import dev.mariamariana.college_cps.service.IProfessorService;
import dev.mariamariana.college_cps.service.IProfessorServiceAggregator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/professores")
public class ProfessorController {
    private final IProfessorService professorService;
    private final IProfessorServiceAggregator professorServiceAggregator;
    private final ModelMapper modelMapper;

    public ProfessorController(IProfessorService professorService, IProfessorServiceAggregator professorServiceAggregator, ModelMapper modelMapper) {
        this.professorService = professorService;
        this.professorServiceAggregator = professorServiceAggregator;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ProfessorDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "${spring.data.web.pageable.default-page-size}") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort,
            @RequestParam(value = "nome", required = false) String nome
    ) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sort).ascending());

        var professores = this.professorService.findAllByNomePageable(nome, pageable)
                .map(professor -> this.modelMapper.map(professor, ProfessorDTO.class));

        return new ResponseEntity<>(professores, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfessorDTO> findById(@PathVariable Long id) {
        Professor professor = this.professorService.findById(id);
        return new ResponseEntity<>(this.modelMapper.map(professor, ProfessorDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> create(@RequestBody @Valid CreateProfessorDTO createProfessorDTO) {
        var professor = this.professorService.create(this.modelMapper.map(createProfessorDTO, Professor.class));
        return new ResponseEntity<>(this.modelMapper.map(professor, ProfessorDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfessorDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateProfessorDTO updateProfessorDTO) {
        var professor = this.professorService.update(id, this.modelMapper.map(updateProfessorDTO, Professor.class));
        return new ResponseEntity<>(this.modelMapper.map(professor, ProfessorDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.professorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("{id}/cursos")
    public ResponseEntity<Page<CursoDTO>> findAllCursos(
            @PathVariable Long id,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "${spring.data.web.pageable.default-page-size}") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort
    ) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sort).ascending());
        var cursos = this.professorServiceAggregator.findAllCursosByProfessorId(id, pageable)
                .map(curso -> this.modelMapper.map(curso, CursoDTO.class));

        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }
}
