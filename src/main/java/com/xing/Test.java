package com.xing;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mystery
 */
public class Test {



    private Integer id;
    private String age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public static Test buildTest(First f) {
        Test test = new Test();
        test.setAge("3");
        test.setId(1);
        return test;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", age='" + age + '\'' +
                '}';
    }
}
