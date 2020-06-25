package com.mirror.ormtransaction.service;

import com.mirror.ormtransaction.annotation.MTransction;
import com.mirror.ormtransaction.domain.OptionLogDTO;
import com.mirror.ormtransaction.domain.StudentDTO;
import com.mirror.ormtransaction.mapper.LogMapper;
import com.mirror.ormtransaction.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author: mirror_huang
 * @qq: 1755496180
 * @description:
 * @create: 2020-06-25 11:19
 **/
@Service
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private LogMapper logMapper;

    /**
     * 保存实体
     *
     * @param studentDTO
     * @return
     */
    @MTransction
    public boolean saveDataByOrm(StudentDTO studentDTO) {
        final boolean add = studentMapper.add(studentDTO);
        OptionLogDTO optionLogDTO = new OptionLogDTO();
        optionLogDTO.setLogContent("新增学生数据:" + studentDTO.toString());
        optionLogDTO.setLogTime(new Date());
        logMapper.add(optionLogDTO);
        //int i=1/0; 如果这里打开 则事务全部回滚
        return add;
    }

    /**
     * 保存编辑实体
     *
     * @param studentDTO
     * @return
     */
    @MTransction
    public boolean update(StudentDTO studentDTO) {
        final boolean update = studentMapper.update(studentDTO);
        OptionLogDTO optionLogDTO = new OptionLogDTO();
        optionLogDTO.setLogContent("变更学生数据:" + studentDTO.toString());
        optionLogDTO.setLogTime(new Date());
        logMapper.add(optionLogDTO);
        return update;
    }

    /**
     * 根据id删除实体
     *
     * @param id
     * @return
     */
    @MTransction
    public boolean delete(int id) {
        final boolean delete = studentMapper.delete(id);
        OptionLogDTO optionLogDTO = new OptionLogDTO();
        optionLogDTO.setLogContent("删除ID为:" + id + "的学生数据");
        optionLogDTO.setLogTime(new Date());
        logMapper.add(optionLogDTO);
        return delete;
    }

    /**
     * 根据ID查询student实体
     *
     * @param id
     * @return
     */
    public StudentDTO query(int id) {
        StudentDTO studentDTO = (StudentDTO) studentMapper.query(id);
        return studentDTO;
    }

    /**
     * 查询所有的学生列表
     *
     * @return
     */
    public List<StudentDTO> queryAll() {
        List<StudentDTO> list = studentMapper.queryAll();
        return list;
    }

}
