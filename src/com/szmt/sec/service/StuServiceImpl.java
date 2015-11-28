package com.szmt.sec.service;

import com.szmt.sec.mapper.StudentMapper;
import com.szmt.sec.po.PageParam;
import com.szmt.sec.po.Student;
import com.szmt.sec.po.StudentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015-11-10.
 */
@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StudentMapper studentMapper;

    @Override   //rows转换了类型和含义
    public PageParam selectAllStu(int page, int numOfList, String sort, String order, Student student) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        System.out.println("********000000000**************");
//        根据sort字段和顺序查询
        if (sort != null && !sort.trim().isEmpty()) {
            studentExample.setOrderByClause(sort + " " + order);
        }
//        根据学生学号或姓名模糊查询
        if (student.getStuid() != null && !student.getStuid().trim().isEmpty()) {
            criteria.andStuidLike("%" + student.getStuid() + "%");
        }
        if (student.getStuname() != null && !student.getStuname().trim().isEmpty()) {
            criteria.andStunameLike("%" + student.getStuname() + "%");
        }
        System.out.println("********1111111111**************");
        Integer total = studentMapper.countByExample(studentExample);
        studentExample.setStartNum(numOfList * (page - 1));  //第一个数据起始点
        studentExample.setAddNum(numOfList);
        System.out.println("********222222222222**************");
        List rows = studentMapper.selectByExample(studentExample);   //select中添加了limit
        for (Object object : rows) {
            Student stu = (Student) object;
            System.out.println("********" + stu.getStuname() + "**************");
        }
        return new PageParam(rows, total);   //返回页面参数
    }

    @Override
    public int deleteStu(String ids) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

//        ids.substring(1,ids.length());
        System.out.println(ids + "*****************");
        List idsList = Arrays.asList(ids.split(","));        //字符串到数组再到list

        criteria.andStuidIn(idsList);

        return studentMapper.deleteByExample(studentExample);
//        criteria.andStuidIn(ids);
//        return studentMapper.deleteByPrimaryKey(ids);      //*********改动了mapper.xml，将删除方法的=改为了in
    }

    @Override
    public int stuInsert(Student stu) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
//        System.out.println(stus.getStuid() + "####################");

        System.out.println(stu.getStuid() + "####################");
        return studentMapper.insert(stu);
    }

    @Override
    public int stuUpdate(Student stu) {
        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();

        criteria.andStuidEqualTo(stu.getStuid());
        return studentMapper.updateByExample(stu,studentExample);
    }
}
