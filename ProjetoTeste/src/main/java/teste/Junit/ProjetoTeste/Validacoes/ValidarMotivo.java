package teste.Junit.ProjetoTeste.Validacoes;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;
import teste.Junit.ProjetoTeste.Entities.MotivoBaixa;

@Component
public class ValidarMotivo implements ValidadorDeAcerto{
    @Override
    public void validar(AcertoDto dados) {
        if(dados.motivo() != MotivoBaixa.VENDIDO ||
                dados.motivo() != MotivoBaixa.QUEBRADO ||
                dados.motivo() != MotivoBaixa.OUTROS){
            throw new ValidacaoException("Motivo especificado não existente");

        }
    }
}
