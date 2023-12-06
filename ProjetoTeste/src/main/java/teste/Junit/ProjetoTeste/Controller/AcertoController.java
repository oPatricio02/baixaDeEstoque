package teste.Junit.ProjetoTeste.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;
import teste.Junit.ProjetoTeste.Entities.Acerto;
import teste.Junit.ProjetoTeste.Entities.Produto;
import teste.Junit.ProjetoTeste.Repositories.AcertoRepository;
import teste.Junit.ProjetoTeste.Repositories.ProdutoRepository;
import teste.Junit.ProjetoTeste.Service.AcertoService;

import java.util.List;

@RestController
@RequestMapping("acerto")
public class AcertoController {

    @Autowired
    AcertoRepository repository;

    @Autowired
    AcertoService acerto;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity getAll()
    {
        List<Acerto> acertos = repository.findAll();
        return ResponseEntity.ok(acertos);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity newBaixa(@RequestBody AcertoDto baixa)
    {
        acerto.registrarBaixa(baixa);
        return ResponseEntity.ok().build();
    }

}
