package com.Hsunday.ServletTool;

import com.Hsunday.DBconnct.DBconnect;
import com.Hsunday.dao.StudentDao;
import com.Hsunday.dao.Students;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

public class addServlet extends HttpServlet {

    StudentDao studentDao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Students students = new Students();

        //通过网页表单里得name属性取得数据
        int studentid = Integer.parseInt(req.getParameter("studentid"));
        String studntname = req.getParameter("studentname");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        String time = req.getParameter("time");
        String grade = req.getParameter("grade");
        String birthday = req.getParameter("birthday");
        System.out.println(studentid);
        System.out.println(studntname);
        System.out.println(sex);
        System.out.println(time);
        System.out.println(grade);
        System.out.println(birthday);
        //把数据封装进对象
        students.setStudentid(studentid);
        students.setName(studntname);
        students.setSex(sex);
        students.setAge(age);
        students.setTime(time);
        students.setGrade(grade);
        students.setBirthday(birthday);
        //把数据存进数据库
        studentDao.add(students);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
