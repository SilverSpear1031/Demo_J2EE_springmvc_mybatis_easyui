package com.szmt.sec.controller;

import com.szmt.sec.po.PageParam;
import com.szmt.sec.po.Student;
import com.szmt.sec.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015-11-12.
 */
@Controller
public class StuHandler {
    @Resource
    private StuService stuService;

    @RequestMapping("/stuIndex")    //登陆或注册成功过来，stuList.jsp在web-inf下
    public String stuIndex(){
        return "WEB-INF/stuList";
    }

    @RequestMapping("/stuList")     //easyui取数据的url
    @ResponseBody
    public PageParam stuList(Integer page,Integer rows,String sort,String order,Student student){
        PageParam pageParam=stuService.selectAllStu(page,rows,sort,order,student);
        System.out.println(student.getStuname()+"ppppppppppppppppppppppppp");
        return pageParam;
    }

    @RequestMapping("/stuDelete")       //easyui删除数据的url
    @ResponseBody
    public Integer stuDelete(String ids){
        return stuService.deleteStu(ids);
    }

    @RequestMapping("/stuInsert")       //easyui插入数据的url
    @ResponseBody
    public int stuInsert(Student stu){
        return stuService.stuInsert(stu);
    }

    @RequestMapping("/stuUpdate")       //easyui修改数据的url
    @ResponseBody
    public int stuUpdate(Student stu){
        return stuService.stuUpdate(stu);
    }
}
