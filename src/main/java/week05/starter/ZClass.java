package week05.starter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: zsy-weekwork
 * @package: week05.school
 * @className: Zclass
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/5 11:26
 */
@Data
public class ZClass {

    private int id;
    private String name;
    private List<Student> students = new ArrayList<>();

    public ZClass(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

}
