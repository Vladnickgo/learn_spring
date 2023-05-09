package org.example.controller;

import org.example.config.JdbcConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ExtendWith(SpringExtension.class)
//@WebMvcTest(TagController.class)
@WebAppConfiguration
@ContextConfiguration(classes = {JdbcConfig.class})
@Testcontainers
class TagControllerTest extends AbstractContainerDatabaseTest {
    MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @BeforeEach
    public void setMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    void testConnection() throws SQLException {
        Integer expected = 18;
        try (
                MySQLContainer<?> mysql = new MySQLContainer<>()
                        .withDatabaseName("certificate_test")
                        .withUsername("root")
                        .withPassword("admin")
                        .withInitScript("create_test_db.sql")
        ) {
            mysql.start();
            ResultSet resultSet = performQuery(mysql, "SELECT count(*) as count FROM tag");
            int actual = resultSet.getInt("count");
            Assertions.assertEquals(expected, actual);

        }
    }

    @Test
    void testGetRequest() throws SQLException {
        try (
                MySQLContainer<?> mysql = new MySQLContainer<>()
                        .withDatabaseName("certificate_test")
                        .withUsername("root")
                        .withPassword("admin")
                        .withInitScript("create_test_db.sql")
        ) {
            mysql.start();
            mockMvc.perform(get("/tag/")).andExpect(status().isOk());
        } catch (Exception exception) {
            throw new SQLException(exception);
        }
    }
}