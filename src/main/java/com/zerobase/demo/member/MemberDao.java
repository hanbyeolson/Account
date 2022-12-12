package com.zerobase.demo.member;

import com.zerobase.demo.Exception.AuthenException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.regex.Pattern;
import java.sql.ResultSet;

import java.util.ArrayList;

import java.util.List;

import com.db.demo;



public class MemberDao {
    public int insertData(MemberDto dto){



        int result = 0;



        Connection conn = demo.getConnection();

        PreparedStatement pstmt = null;

        String sql;



        try {

            sql = "insert into naverMember (userId,password,userName,email,roel) ";

            sql+= "values (?,?,?,?,?,?)";



            pstmt = conn.prepareStatement(sql);



            pstmt.setString(1, dto.getUserId());

            pstmt.setString(2, dto.getUserName());

            pstmt.setString(3, dto.getPassword());

            pstmt.setString(4, dto.getPhone());

            pstmt.setString(5, dto.getRole());

            pstmt.setString(6, dto.getEmail());



            result = pstmt.executeUpdate();



            pstmt.close();



        } catch (Exception e) {

            System.out.println(e.toString());

        }



        return result;



    }





    public int updateData(MemberDto dto){



        int result = 0;



        Connection conn = demo.getConnection();

        PreparedStatement pstmt = null;

        String sql;



        try {

            sql = "update demo set password=?, email=?, phone=? ";

            sql+= "where userId=?";



            pstmt = conn.prepareStatement(sql);



            pstmt.setString(1, dto.getPassword());

            pstmt.setString(2, dto.getEmail());

            pstmt.setString(3, dto.getPhone());

            pstmt.setString(4, dto.getUserId());



            result = pstmt.executeUpdate();



            pstmt.close();



        } catch (Exception e) {

            System.out.println(e.toString());

        }



        return result;



    }






    public int deleteDate(String id, String pw){



        int result = 0;



        Connection conn = demo.getConnection();

        PreparedStatement pstmt = null;

        String sql;



        try {

            sql = "delete demo where userId=? and password=?";



            pstmt = conn.prepareStatement(sql);



            pstmt.setString(1, userId);

            pstmt.setString(2, password);



            result = pstmt.executeUpdate();



            pstmt.close();



        } catch (Exception e) {

            System.out.println(e.toString());

        }



        return result;



    }






    public List<MemberDto> getList() {



        List<MemberDto> lists = new ArrayList<MemberDto>();

        Connection conn = demo.getConnection();

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        String sql;



        try {

            sql = "select userId,password,userName,email,phone,role ";

            sql+= "from demo order by name";



            pstmt = conn.prepareStatement(sql);



            rs = pstmt.executeQuery();



            while(rs.next()){



                MemberDto dto = new MemberDto();



                dto.setUserId(rs.getString("id"));

                dto.setPassword(rs.getString("pw"));

                dto.setUserName(rs.getString("name"));

                dto.setEmail(rs.getString("email"));

                dto.setPhone(rs.getString("phone"));

                dto.setRole(rs.getString("role"));



                lists.add(dto);



            }



            rs.close();

            pstmt.close();



        } catch (Exception e) {

            System.out.println(e.toString());

        }



        return lists;



    }





    public List<MemberDto> getList(String userId){



        List<MemberDto> lists = new ArrayList<MemberDto>();

        Connection conn = demo.getConnection();

        PreparedStatement pstmt = null;

        ResultSet rs = null;

        String sql;



        try{

            sql = "select userId,password,userName,phone,email,role ";

            sql+= "from demo where userId=?";



            pstmt = conn.prepareStatement(sql);



            pstmt.setString(1, userId);



            rs = pstmt.executeQuery();



            while(rs.next()){



                MemberDto dto = new MemberDto();



                dto.setUserId(rs.getString("id"));

                dto.setPassword(rs.getString("pw"));

                dto.setUserName(rs.getString("name"));

                dto.setEmail(rs.getString("email"));

                dto.setPhone(rs.getString("phone"));

                dto.setRole(rs.getString("role"));



                lists.add(dto);



            }



            rs.close();

            pstmt.close();



        }catch (Exception e) {

            System.out.println(e.toString());

        }



        return lists;

    }



}