package com.example.schpharm.direction.controller

import com.example.schpharm.direction.service.DirectionService
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification

class DirectionControllerTest extends Specification {

    private MockMvc mockMvc
    private DirectionService directionService = Mock()

    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(new DirectionController(directionService))
                .build()
    }

    def "GET /dir/{encodedId}"() {
        given:
        String encodedId = "r"

        String redirectURL = "https://map.kakao.com/link/map/pharmacy,38.11,128.11"

        when:
        directionService.findDirectionUrlById(encodedId) >> redirectURL
        ResultActions result = mockMvc.perform(get("/dir/{encodedId}", encodedId))

        then:
        result.andExpect(status().is3xxRedirection())  // 리다이렉트 발생 확인
                .andExpect(redirectedUrl(redirectURL)) // 리다이렉트 경로 검증
                .andDo(print())
    }
}
