package week05.starter;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SchoolAutoConfiguration.class)
public class SchoolTest {

    @Autowired
    private School school;

    @Test
    public void test() {
        System.out.println(school);
    }
}
