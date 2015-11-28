package com.szmt.sec.service;

import com.szmt.sec.po.PageParam;
import com.szmt.sec.po.Student;

import java.util.List;

/**
 * Created by Administrator on 2015-11-10.
 */
public interface StuService {
    PageParam selectAllStu(int page,int numOfList,String sort,String order,Student student);
    int deleteStu(String ids);
    int stuInsert(Student stu);
    int stuUpdate(Student stu);
}
