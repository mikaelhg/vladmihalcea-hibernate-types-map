package io.mikael.poc;

import com.zaxxer.hikari.HikariDataSource;
import io.mikael.poc.model.Bar;
import io.mikael.poc.model.Foo;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    private static final String POSTGRES_IMAGE = "postgres:11-alpine";

    @Autowired
    private EntityManager entityManager;

    @ClassRule
    public static PostgreSQLContainer postgres = new PostgreSQLContainer(POSTGRES_IMAGE);

    @Configuration
    @Import(Application.class)
    public static class PocTestConfiguration {

        @Bean
        public DataSource dataSource() {
            return DataSourceBuilder.create()
                    .type(HikariDataSource.class)
                    .driverClassName(postgres.getDriverClassName())
                    .url(postgres.getJdbcUrl())
                    .username(postgres.getUsername())
                    .password(postgres.getPassword())
                    .build();
        }


    }

    @Test
    @Transactional
    public void entitySave() {
        final var foo = new Foo();
        foo.setXyzzy(Map.of("bar", new Bar()));
        entityManager.persist(foo);
        entityManager.flush();
    }

}
