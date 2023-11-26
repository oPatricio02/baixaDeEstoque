package teste.Junit.ProjetoTeste.Validacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;
import teste.Junit.ProjetoTeste.Entities.Produto;
import teste.Junit.ProjetoTeste.Repositories.ProdutoRepository;

@Component
public class ValidarQuantidade implements ValidadorDeAcerto{

    @Autowired
    ProdutoRepository repository;
    @Override
    public void validar(AcertoDto dados) {
        Produto prod = repository.getReferenceById(dados.codigoProduto());
        if(dados.quantidade()> prod.getQuantidade()){
            throw new ValidacaoException("Quantidade de produtos acima dos disponiveis");
        }
    }
}
