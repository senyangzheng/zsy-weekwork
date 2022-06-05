package week05.starter;

import lombok.Data;

import java.util.List;

/**
 * @projectName: zsy-weekwork
 * @package: week05.school
 * @className: School
 * @author: senyang.zheng
 * @description:
 * @date: 2022/6/5 11:27
 */
public class School {
    private List<ZClass> classes;

    public School(List<ZClass> classes) {
        this.classes = classes;
    }
}
