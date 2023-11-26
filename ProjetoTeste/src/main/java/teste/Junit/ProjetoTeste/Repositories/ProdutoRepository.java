package teste.Junit.ProjetoTeste.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import teste.Junit.ProjetoTeste.Entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {
}
