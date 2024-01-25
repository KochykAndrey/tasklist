package by.kochyk.tasklist.service.props;

import lombok.Data;
import org.hibernate.annotations.Comment;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "security.jwt")
public class JwtProperties {

    private String secret;
    private long access;
    private long refresh;

}
