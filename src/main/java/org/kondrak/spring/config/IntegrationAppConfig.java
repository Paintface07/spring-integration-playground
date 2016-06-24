package org.kondrak.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

import javax.sql.DataSource;

/**
 * Created by kondrak on 6/22/2016.
 */
@Configuration
@EnableIntegration
@IntegrationComponentScan("org.kondrak.spring")
public class IntegrationAppConfig {

    @Autowired DataSource dataSource;

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase db = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("db/create-db.sql")
                .build();
        return db;
    }

    @Bean
    public MessageChannel inputChannel() {
        DirectChannel inChan = new DirectChannel();
        return inChan;
    }

    @Bean
    public MessageChannel outputChannel() {
        DirectChannel outChan = new DirectChannel();
        return outChan;
    }

    @Bean
    public MessageChannel endChannel() {
        DirectChannel outChan = new DirectChannel();
        return outChan;
    }
}
