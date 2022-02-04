package restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class Tests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void notEmptyGetResponseTest() throws Exception {

        this.mockMvc.perform(get("/")).andDo(print()).andExpect(status().isOk())
                .andExpect(status().isOk());
    }

    @Test
    public void postMethodTest() throws Exception {

        this.mockMvc.perform((post("/").param("data", "Abstract")))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void emptyPostParamTest() throws Exception {

        this.mockMvc.perform(post("/")).andDo(print()).andExpect(status().is(400));
    }
}
