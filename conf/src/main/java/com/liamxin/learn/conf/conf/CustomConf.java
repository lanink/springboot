package com.liamxin.learn.conf.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.stream.Stream;

/**
 * CustomConf
 *
 * @author 还不如一只猪威武 <liamxin@yeah.net>
 * @version 0.1
 * @since 2020-04-14 11:56
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "custom.conf")
public class CustomConf {

    private String name;

    private String[] alias;

    private String home = "花果山";

    private String lastName;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{name:");
        sb.append(name).append(",alias:[");
        Stream.of(alias).forEach(a -> sb.append(a).append(","));
        sb.deleteCharAt(sb.length() - 1).append("],home:").append(home);
        sb.append(",lastName:").append(lastName);
        sb.append("}");
        return sb.toString();
    }
}
