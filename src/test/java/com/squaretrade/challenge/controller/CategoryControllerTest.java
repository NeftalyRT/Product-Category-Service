package com.squaretrade.challenge.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    private static final String CATEGORY_PATH = "/categories";
    private static final String CATEGORY_KEYWORDS_PATH = CATEGORY_PATH + "/{id}/keywords";
    private static final String CATEGORY_LEVEL_PATH = CATEGORY_PATH + "/{id}/level";

    @Autowired
    private transient MockMvc mockMvc;

    @Test
    void shouldFetchAllCategories() throws Exception {
        this.mockMvc.perform(get(CATEGORY_PATH))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", Is.is(1)))
                .andExpect(jsonPath("$[0].name", Is.is("Home Appliances")));
    }

    @Test
    void shouldFetchCategoryKeywords() throws Exception {
        this.mockMvc.perform(get(CATEGORY_KEYWORDS_PATH, 4))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", Is.is(5)))
                .andExpect(jsonPath("$[0].name", Is.is("Cooking")));
    }

    @Test
    void shouldFetchRootParentCategoryKeywords() throws Exception {
        this.mockMvc.perform(get(CATEGORY_KEYWORDS_PATH, 5))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", Is.is(4)))
                .andExpect(jsonPath("$[0].name", Is.is("Cleaning")));
    }

    @Test
    void shouldFetchCategoryLevel() throws Exception {
        String response = this.mockMvc.perform(get(CATEGORY_LEVEL_PATH, 1))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(1, Integer.valueOf(response));

        String response2 = this.mockMvc.perform(get(CATEGORY_LEVEL_PATH, 5))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();

        assertEquals(3, Integer.valueOf(response2));
    }
}
