package teste.Junit.ProjetoTeste.Controller;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import teste.Junit.ProjetoTeste.Dtos.AcertoDto;
import teste.Junit.ProjetoTeste.Entities.MotivoBaixa;
import teste.Junit.ProjetoTeste.Service.AcertoService;


import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class AcertoControllerTest {


    @Autowired
    private MockMvc mvc;

    @Autowired
    private JacksonTester<AcertoDto> acertoDtoJson;

    @MockBean
    private AcertoService registraBaixa;



    @Test
    @DisplayName("Deveria retornar código http 400 pois está sem corpo a requisição")
    void newBaixa_Cenario1() throws Exception {
        var response = mvc.perform(post("/acerto"))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @DisplayName("Deveria retornar código http 200 pois está correta a requisição")
    void newBaixa_Cenario2() throws Exception{
        LocalDate dataHoje = LocalDate.now();
        var motivoBaixa = MotivoBaixa.VENDIDO;
        var response = mvc.perform(
                post("/acerto")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(acertoDtoJson.write(new AcertoDto(2l,5,"Eletrônico",
                                motivoBaixa,dataHoje)).getJson())
                )
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }


}