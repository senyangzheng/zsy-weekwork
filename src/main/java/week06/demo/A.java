package week06.demo;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
@Builder
@Getter
@Setter
@Data
public class A {

    private int age;

    private String name;

//    public void test(){
//        log.info("this message is logged by lombok");
//        System.out.println(this.toString());
//    }

}
