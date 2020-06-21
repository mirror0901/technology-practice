package com.mirror.ormtransaction.domain;

import com.mirror.ormtransaction.annotation.MColumn;
import com.mirror.ormtransaction.annotation.MId;
import com.mirror.ormtransaction.annotation.MTable;
import lombok.Data;
import lombok.ToString;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-22 01:53
 **/
@Data
@MTable(tableName = "student")
@ToString
public class StudentDTO {

    @MId(idName = "id")
    private Integer id;

    @MColumn(columnName = "name")
    private String name;

    @MColumn(columnName = "age")
    private Integer age;

    @MColumn(columnName = "sex")
    private String sex;

}
