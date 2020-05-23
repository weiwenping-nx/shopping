package com.awen.shopping.service;

import com.awen.shopping.dao.StudentTestDao;
import com.awen.shopping.entity.StudentTest;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Iservice {
    @Autowired
    private StudentTestDao studentTestDao;

    public String getIdName(){
        LambdaQueryWrapper<StudentTest> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(StudentTest::getId,"2");
        return studentTestDao.selectOne(queryWrapper).getName();
    }
}
