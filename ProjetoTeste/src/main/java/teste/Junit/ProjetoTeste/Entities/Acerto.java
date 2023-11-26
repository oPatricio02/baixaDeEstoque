package teste.Junit.ProjetoTeste.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;

import java.time.LocalDateTime;

@Table(name = "acerto")
@Entity(name = "acerto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Acerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idacerto")
    private Long id;

    private Long codigoProduto;
    private int quantidade;
    private String tipo;

    @Enumerated(EnumType.STRING)
    private MotivoBaixa motivo;

    private LocalDateTime data;

    public Acerto(AcertoDto dados){
        this.codigoProduto = dados.codigoProduto();
        this.quantidade = dados.quantidade();
        this.tipo = dados.tipo();
        this.motivo = dados.motivo();
        this.data = dados.data();
    }
}
