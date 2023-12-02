package teste.Junit.ProjetoTeste.Validacoes;

import org.springframework.stereotype.Component;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;

import java.time.Duration;
import java.time.LocalDate;


@Component
public class ValidarData implements ValidadorDeAcerto{
    @Override
    public void validar(AcertoDto dados) {
        if(!dados.data().equals(LocalDate.now())){
            throw new ValidacaoException("Data de Baixa inválida");
        }
    }
}
