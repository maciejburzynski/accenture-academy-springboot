package com.accenture.academy;

import com.accenture.academy.church.ChurchDao;
import com.accenture.academy.church.ChurchDto;
import com.accenture.academy.church.ChurchService;
import com.accenture.academy.priest.PriestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "ADMIN")
@Slf4j
public class BaseIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ChurchService churchService;

    @Test
    void baseTest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/hello"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("Hello World from Accenture"));
    }

    @Test
    void postTest() throws Exception {
//        given
        PriestDto priestDto = new PriestDto("Zbyszek", 180, 40);
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(MockMvcRequestBuilders
                        .post("http://localhost:9090/api/priests")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(priestDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(204));
    }

    @Test
    void deleteChurchById() throws Exception {
//        given
        ChurchDto churchDto = new ChurchDto(
                "Kościół św. LiHenia",
                "Toruń",
                250,
                10000,
                10000.00);
        ObjectMapper objectMapper = new ObjectMapper();
        log.info(String.valueOf("dupa " + System.currentTimeMillis()));
//      Adding church to be deleted
        mockMvc.perform(MockMvcRequestBuilders
                        .post("http://localhost:9090/api/churches")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(churchDto)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(200));

        String sizeOfChurchList = String.valueOf(churchService.getAllChurches().size());
        log.info("Number of Churches is: " + sizeOfChurchList);

        log.info(String.valueOf("dupa " + System.currentTimeMillis()));
        mockMvc.perform(MockMvcRequestBuilders
                        .delete("http://localhost:9090/api/churches/" + sizeOfChurchList))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(204));

        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:9090/api/churches/" + sizeOfChurchList))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().is(404));


    }


}
