package dev.mariamariana.college_cps.controller;

import dev.mariamariana.college_cps.dto.AlunoDTO;
import dev.mariamariana.college_cps.dto.CreateAlunoDTO;
import dev.mariamariana.college_cps.dto.UpdateAlunoDTO;
import dev.mariamariana.college_cps.model.Aluno;
import dev.mariamariana.college_cps.service.IAlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    private final IAlunoService alunoService;
    private final ModelMapper modelMapper;

    public AlunoController(IAlunoService alunoService, ModelMapper modelMapper) {
        this.alunoService = alunoService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public ResponseEntity<Page<AlunoDTO>> findAll(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "${spring.data.web.pageable.default-page-size}") int size,
            @RequestParam(value = "sort", defaultValue = "id") String sort
    ) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sort).ascending());
        var alunos = this.alunoService.findPageable(pageable)
                .map(aluno -> this.modelMapper.map(aluno, AlunoDTO.class));

        return new ResponseEntity<>(alunos, HttpStatus.OK);
    }

    @GetMapping("{id}")
        public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        var aluno = this.alunoService.findById(id);
        return new ResponseEntity<>(this.modelMapper.map(aluno, AlunoDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> create(@RequestBody CreateAlunoDTO createAlunoDTO) {
        var aluno = this.alunoService.create(this.modelMapper.map(createAlunoDTO, Aluno.class));
        return new ResponseEntity<>(this.modelMapper.map(aluno, AlunoDTO.class), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoDTO> update(
            @PathVariable Long id,
            @RequestBody UpdateAlunoDTO updateAlunoDTO) {
        var aluno = this.alunoService.update(id, this.modelMapper.map(updateAlunoDTO, Aluno.class));
        return new ResponseEntity<>(this.modelMapper.map(aluno, AlunoDTO.class), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        this.alunoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
