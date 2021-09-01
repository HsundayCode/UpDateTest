package com.Hsunday.ServletTool;

import com.Hsunday.dao.StudentDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteServlet extends HttpServlet {
    StudentDao studentDao = new StudentDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        String delete_id = req.getParameter("delete_id");

       // System.out.println(delete_id);

        PrintWriter pw = resp.getWriter();

        //System.out.println(studentDao.CheckById(Integer.parseInt(delete_id)));
        if(studentDao.CheckById(Integer.parseInt(delete_id)).getStudentid()==0)//判断数据库时候有该对象
        {
            System.out.println(studentDao.CheckById(Integer.parseInt(delete_id)));
            System.out.println("不存在该学生");
            pw.write("不存在该学生");
        }else {
            studentDao.delete(Integer.parseInt(delete_id));
            System.out.println("成功删除");
            pw.write("成功删除");
        }


    }
}
