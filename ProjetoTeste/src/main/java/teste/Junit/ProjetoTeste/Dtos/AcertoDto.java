package teste.Junit.ProjetoTeste.Dtos;

import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import teste.Junit.ProjetoTeste.Entities.MotivoBaixa;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AcertoDto(

        @NonNull
        Long codigoProduto,
        @NonNull
        int quantidade,
        @NonNull
        String tipo,
        @NonNull
        MotivoBaixa motivo,
        @NonNull
        LocalDate data
) {
}
