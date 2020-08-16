package com.gfpz.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)//链式写法
public class Dept implements Serializable {
    private Long deptno;
    private String dname;

    //对应哪个数据库  同一个信息可能存在于不同的数据库
    private String db_source;

    public Dept(String dname){
        this.dname = dname;
    }

    /**
     * 链式写法
     * Dept dept = new Dept();
     * dept.setxxx().setxxx();
     */
}
