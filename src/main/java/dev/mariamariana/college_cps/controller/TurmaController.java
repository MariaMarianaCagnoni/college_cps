package dev.mariamariana.college_cps.controller;

import dev.mariamariana.college_cps.dto.CreateTurmaDTO;
import dev.mariamariana.college_cps.dto.TurmaDTO;
import dev.mariamariana.college_cps.dto.UpdateTurmaDTO;
import dev.mariamariana.college_cps.model.Turma;
import dev.mariamariana.college_cps.service.ITurmaService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turmas")
public class TurmaController {
    private final ITurmaService turmaService;
    private final ModelMapper modelMapper;

    public TurmaController(ITurmaService turmaService, ModelMapper modelMapper) {
        this.turmaService = turmaService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<TurmaDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "${spring.data.web.pageable.default-page-size}") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort
    ) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sort).ascending());
        var turmas = this.turmaService.findPageable(pageable)
                .map(turma -> this.modelMapper.map(turma, TurmaDTO.class));

        return new ResponseEntity<>(turmas, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TurmaDTO> findById(@PathVariable Long id) {
        Turma turma = this.turmaService.findById(id);
        return new ResponseEntity<>(this.modelMapper.map(turma, TurmaDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TurmaDTO> create(@RequestBody CreateTurmaDTO createTurmaDTO) {
        var turma = this.turmaService.create(this.modelMapper.map(createTurmaDTO, Turma.class));
        return new ResponseEntity<>(this.modelMapper.map(turma, TurmaDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<TurmaDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateTurmaDTO updateTurmaDTO) {
        var turma = this.turmaService.update(id, this.modelMapper.map(updateTurmaDTO, Turma.class));
        return new ResponseEntity<>(this.modelMapper.map(turma, TurmaDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.turmaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
