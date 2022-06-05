package week05.starter;

import lombok.Data;

/**
 * @projectName: zsy-weekwork
 * @package: week05.school
 * @className: Student
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/5 11:26
 */
@Data
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
