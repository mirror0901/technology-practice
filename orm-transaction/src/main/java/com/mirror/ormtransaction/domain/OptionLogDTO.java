package com.mirror.ormtransaction.domain;

import com.mirror.ormtransaction.annotation.MColumn;
import com.mirror.ormtransaction.annotation.MId;
import com.mirror.ormtransaction.annotation.MTable;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-22 01:53
 **/
@Data
@ToString
@MTable(tableName = "option_log")
public class OptionLogDTO {

    @MId(idName = "log_id")
    private Integer logId;

    @MColumn(columnName = "log_content")
    private String logContent;

    @MColumn(columnName = "log_time")
    private Date logTime;

}
