package week05.starter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;


@ConfigurationProperties(prefix = "school")
@Data
public class SchoolProperties {

    private List<Integer> studentIds;
    private List<String> studentNames;
    private List<Integer> classIds;
    private List<String> classNames;
    private List<Map<String, Integer>> studentOfClass;
}
