package tech.wetech.admin3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationListener;

@EnableConfigurationProperties(Admin3Properties.class)
@SpringBootApplication
@Slf4j
public class Admin3ServerApplication implements ApplicationListener<ApplicationReadyEvent> {
    @Value("${springdoc.api-docs.enabled}")
    private boolean apiDocsEnabled;
    @Value("${server.port}")
    private int port;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    public static void main(String[] args) {
        SpringApplication.run(Admin3ServerApplication.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        if (apiDocsEnabled) {
            log.info("文档: http://localhost:" + port + contextPath + "/swagger-ui/index.html");
        }
        log.info("### 启动完成 ###");
    }
}
