package cerlace.springboot.rest;

import cerlace.springboot.MockUtils;
import cerlace.springboot.service.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.defaultanswers.ReturnsMocks;
import org.mockito.invocation.InvocationOnMock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;


@AutoConfigureMockMvc
@SpringBootTest
class CityRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CityService cityService;

    @BeforeEach
    public void setup() {
        Mockito.doAnswer(new ReturnsMocks() {
            public Object answer(InvocationOnMock invocation) {
                return MockUtils.createCities();
            }
        }).when(cityService).getCities();
    }

    @Test
    void checkCities() throws Exception {
        Map<String, Object> params = new HashMap<>();
        checkPerform(params, "/cities");
    }

    private void checkPerform(Map<String, Object> params, String url) throws Exception {
        mockMvc.perform(get(getUri(params, url))
                .headers(getHttpHeaders())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
        )
                .andExpect(status().isOk());
    }

    private HttpHeaders getHttpHeaders() {
        return new HttpHeaders();
    }

    private URI getUri(Map<String, Object> params, String url) {
        return new UriTemplate(url)
                .expand(params);
    }
}