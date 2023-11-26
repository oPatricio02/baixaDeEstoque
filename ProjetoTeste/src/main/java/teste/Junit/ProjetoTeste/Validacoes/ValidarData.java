package teste.Junit.ProjetoTeste.Validacoes;

import org.springframework.stereotype.Component;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidarData implements ValidadorDeAcerto{
    @Override
    public void validar(AcertoDto dados) {
        var dataBaixa = dados.data();
        var dataAtual = LocalDateTime.now();
        var diferenca = Duration.between(dataBaixa,dataAtual).toDays();
        if(diferenca != 0){
            throw new ValidacaoException("Data de Baixa incompatível");
        }

    }
}
