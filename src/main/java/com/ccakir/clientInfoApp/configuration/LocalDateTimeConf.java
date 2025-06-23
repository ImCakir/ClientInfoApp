package com.ccakir.clientInfoApp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LocalDateTimeConf {

    @Bean
    public LocalDateTime currentDateTime()
    {
        return LocalDateTime.now();
    }

}
