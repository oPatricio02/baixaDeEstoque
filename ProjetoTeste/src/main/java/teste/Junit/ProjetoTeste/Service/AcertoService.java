package teste.Junit.ProjetoTeste.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;
import teste.Junit.ProjetoTeste.Entities.Acerto;
import teste.Junit.ProjetoTeste.Repositories.AcertoRepository;
import teste.Junit.ProjetoTeste.Repositories.ProdutoRepository;
import teste.Junit.ProjetoTeste.Validacoes.ValidadorDeAcerto;

import java.util.List;

@Service
public class AcertoService {

    @Autowired
    AcertoRepository acertoRepository;

    @Autowired
    private List<ValidadorDeAcerto> validadores;//Vai criar uma lista de todos o métodos que implementam essa interface

    public void registrarBaixa(AcertoDto dados)
    {
        validadores.forEach(v->v.validar(dados));//Vai percorrer todos os métodos da lista

        Acerto acerto = new Acerto(dados);
        acertoRepository.save(acerto);
    }

}
