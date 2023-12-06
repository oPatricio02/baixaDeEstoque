package teste.Junit.ProjetoTeste.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import teste.Junit.ProjetoTeste.Entities.Produto;
import teste.Junit.ProjetoTeste.Repositories.ProdutoRepository;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository repository;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping
    public ResponseEntity getAll()
    {
        List<Produto> produtos = repository.findAll();
        return ResponseEntity.ok(produtos);
    }



}
