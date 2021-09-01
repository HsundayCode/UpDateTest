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
import java.util.ArrayList;
import java.util.List;

public class updateServlet extends HttpServlet {
    StudentDao studentDao = new StudentDao();
    List<Students> studentsList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        int page = Integer.parseInt(req.getParameter("page"));
        System.out.println(page);


        studentsList =  studentDao.Pageshow(page);//接收数组，下一步把数组转为json
        //System.out.println(JSON.toJSONString(studentsList));



       /* int count = 0;
        int sum = studentsList.size();



        if(sum/5==0)
        {
            count = sum/5;
        }else if (sum%5!=0){
            count = (sum/5)+1;
        }*/
        PrintWriter pw = resp.getWriter();
        pw.write(JSON.toJSONString(studentsList));



    }
}
