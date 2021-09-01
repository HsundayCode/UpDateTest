package com.Hsunday.ServletTool;

import com.Hsunday.dao.StudentDao;
import com.Hsunday.dao.Students;
import com.alibaba.fastjson.JSON;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class showServlet extends HttpServlet {
    StudentDao checkid = new StudentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String studentid = req.getParameter("student_id");//接收ajax传输的数据

        //System.out.println("studenid="+studentid);
        if(studentid==null)
        {
            System.out.println("为空");
            return;
        }
        //System.out.println("前端发送的数据="+studentid);

        Students students_id = checkid.CheckById(Integer.parseInt(studentid));;//数据库按照学号查询对象

        //System.out.println("查询到的数据="+students_id.getSex());
        //接下来要把对象发给前端
        //ajax

        String student_json = JSON.toJSONString(students_id);//对象转json格式

        System.out.println("输出json="+student_json);

        //System.out.println("后端发送数据");
        //resp.setCharacterEncoding("utf-8");
        //resp.setContentType("text/json");
        PrintWriter pw = resp.getWriter();
        pw.write(student_json);//向前端输出
    }
}
