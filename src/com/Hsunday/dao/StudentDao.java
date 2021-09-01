package com.Hsunday.dao;

import com.Hsunday.DBconnct.DBconnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StudentDao  {



    public void add(Students students){

        Date data = new Date();


        String sql = "insert into students values(null,?,?,?,?,?,?,?,?)";
        try(Connection connection = new DBconnect().getConnect(); PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setInt(1,students.getStudentid());
            ps.setString(2,students.getName());
            ps.setString(3,students.getSex());
            ps.setString(4,students.getTime());
            ps.setInt(5,students.getAge());
            ps.setString(6,students.getGrade());
            ps.setString(7,students.getBirthday());

            ps.setTimestamp(8,new Timestamp(data.getTime()));
            ps.execute();


        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public Students CheckById(int student_id){
        Students students = new Students();

        String CheckId = "select * from students where studentid = "+student_id;

        try(Connection connection = new DBconnect().getConnect();Statement st = connection.createStatement())
        {
            ResultSet rs = st.executeQuery(CheckId);
            if(rs.next())
            {
                //根据id在数据库里查找
                int studentid = rs.getInt("studentid");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                String time = rs.getString("time");
                int age = rs.getInt("age");
                String grade  = rs.getString("garde");
                String birthday = rs.getString("birthday");
                //将数据封装成对象

                students.setStudentid(studentid);
                students.setName(name);
                students.setSex(sex);
                students.setTime(time);
                students.setAge(age);
                students.setGrade(grade);
                students.setBirthday(birthday);
            }




        }catch (SQLException e){
            e.printStackTrace();
        }
        //返回给调用
        return students;
    }


    public void delete(int studentid){
        String sql ="delete from students where studentid=?";

        try(Connection connection = new DBconnect().getConnect();PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1,studentid);
            ps.execute();
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Students> Pageshow(int page){
        //Students students = new Students();
        List<Students> StudentsList = new ArrayList<>();
        int page1=page-1;

        String sql = "select * from students order by studentid desc limit ?,?";
        try(Connection connection = new DBconnect().getConnect();PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1,5*page1);
            ps.setInt(2,5*page);


             ResultSet resultSet = ps.executeQuery();


                while (resultSet.next())
                {
                    Students students = new Students();
                    //System.out.println(resultSet.getString("name"));
                    int studentid = resultSet.getInt("studentid");

                    String name = resultSet.getString("name");
                    String sex = resultSet.getString("sex");
                    String time = resultSet.getString("time");
                    int age = resultSet.getInt("age");
                    String grade  = resultSet.getString("garde");
                    String birthday = resultSet.getString("birthday");
                //将数据封装成对象
                    students.setStudentid(studentid);
                    students.setName(name);
                    students.setSex(sex);
                    students.setTime(time);
                    students.setAge(age);
                    students.setGrade(grade);
                    students.setBirthday(birthday);


                    StudentsList.add(students);
                 //   System.out.println(StudentsList.get(0));
//                    for (Students s:StudentsList) {
//                        System.out.println(s);
//                    }


            }
        }catch (SQLException e){
            e.printStackTrace();
        }

        for (Students s:StudentsList) {
            System.out.println(s);
        }
        return StudentsList;
    }

}
