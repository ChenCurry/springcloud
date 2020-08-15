package com.gfpz.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private Long deptNo;
    private String dName;

    //对应哪个数据库  同一个信息可能存在于不同的数据库
    private String dbSource;

    public Dept(String dName){
        this.dName = dName;
    }

    /**
     * 链式写法
     * Dept dept = new Dept();
     * dept.setxxx().setxxx();
     */
}
