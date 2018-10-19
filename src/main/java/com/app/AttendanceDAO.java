package com.app;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
    private static Connection con;

    public  void connect() throws SQLException {
        if (con == null || con.isClosed()) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/Attendance?autoReconnect=true&useSSL=false","root","qwerty123");
        }
    }

    public  void disconnect() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    public  List<Attendance> listClassAttendance() throws SQLException {
        List<Attendance> listAttendance = new ArrayList<>();

        String sql = "SELECT * FROM attendance";

        connect();

        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String rno = resultSet.getString("rno");
            String subname = resultSet.getString("subname");
            String name = resultSet.getString("name");
            int  pdays = resultSet.getInt("pdays");
            int  adays = resultSet.getInt("adays");
            int  totdays = resultSet.getInt("totdays");

            Attendance attendance = new Attendance(rno,subname,name,pdays,adays,totdays);
            listAttendance.add(attendance);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listAttendance;
    }


    public  boolean deleteAttendance(Attendance attendance) throws SQLException {
        String sql = "DELETE FROM attendance where rno = ?";

        connect();

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, attendance.getRno());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

    public  boolean updateAttendance(Attendance attendance) throws SQLException {
        String sql = "UPDATE attendance SET pdays = ?, adays = ?";
        sql += " WHERE rno = ?";
        connect();

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, attendance.getPdays());
        statement.setInt(2, attendance.getAdays());
        statement.setString(3, attendance.getRno());


        boolean rowUpdated = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowUpdated;
    }

    public  boolean insertAttendance(Attendance attendance) throws SQLException {
        String sql = "INSERT INTO attendance (rno, subname, name,pdays,adays,totdays) VALUES (?, ?, ?, ?, ?, ?)";
        connect();

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, attendance.getRno());
        statement.setString(2, attendance.getSubname());
        statement.setString(3, attendance.getName());
        statement.setInt(4, attendance.getPdays());
        statement.setInt(5, attendance.getAdays());
        statement.setInt(6, attendance.getTotdays());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public Attendance getAttendance(String rno) throws SQLException {
        Attendance attendance = null;
        String sql = "SELECT * FROM attendance WHERE rno = ?";

        connect();

        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, rno);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String rollno = resultSet.getString("rno");
            String subname = resultSet.getString("subname");
            String name = resultSet.getString("name");
            int pdays= resultSet.getInt("pdays");
            int adays= resultSet.getInt("adays");
            int totdays= resultSet.getInt("totdays");

            attendance = new Attendance(rollno, subname, name, pdays,adays,totdays);
        }

        resultSet.close();
        statement.close();

        return attendance;
    }


//    public static void main(String args[]) throws SQLException {
//        connect();
//        Attendance attend = new Attendance("16BCS002");
//        deleteAttendance(attend);
//    }


}



