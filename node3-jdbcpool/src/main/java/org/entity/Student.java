package org.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private  Long id;
    private String name;
    private String password;
    private  String gender;
    private Double balance;
    private Integer age;
    private Date insertTime;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", balance=" + balance +
                ", age=" + age +
                ", insertTime=" + insertTime +
                '}';
    }
}
