package com.app;



import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AttendanceDAO attendanceDAO;

    public void init() {
        attendanceDAO = new AttendanceDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/new":
                    showNewForm(request, response);
                    break;
                case "/insert":
                    insertAttendance(request, response);
                    break;
                case "/delete":
                    deleteAttendance(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response);
                    break;
                case "/update":
                    updateAttendance(request, response);
                    break;
                default:
                    listAttendance(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAttendance(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Attendance> listAttendance = attendanceDAO.listClassAttendance();
        request.setAttribute("listattend", listAttendance);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AttendanceList.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AttendanceForm.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        String rno = request.getParameter("rno");
        Attendance existingrecord = attendanceDAO.getAttendance(rno);
        RequestDispatcher dispatcher = request.getRequestDispatcher("AttendanceForm.jsp");
        request.setAttribute("attendance", existingrecord);
        dispatcher.forward(request, response);
    }

    private void insertAttendance(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String rno = request.getParameter("rno");
        String subname = request.getParameter("subname");
        String name = request.getParameter("name");
        int pdays= Integer.parseInt(request.getParameter("pdays"));
        int adays= Integer.parseInt(request.getParameter("adays"));
        int totdays= Integer.parseInt(request.getParameter("totdays"));

        Attendance attendance = new Attendance(rno, subname, name,pdays,adays,totdays);
        attendanceDAO.insertAttendance(attendance);
        response.sendRedirect("list");
    }

    private void updateAttendance(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String rno = request.getParameter("rno");
        int pdays= Integer.parseInt(request.getParameter("pdays"));
        int adays= Integer.parseInt(request.getParameter("adays"));


        Attendance attendance = new Attendance(pdays,adays,rno);
        attendanceDAO.updateAttendance(attendance);
        response.sendRedirect("list");
    }

    private void deleteAttendance(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String rno = request.getParameter("rno");
        Attendance attendance = new Attendance(rno);
        attendanceDAO.deleteAttendance(attendance);
        response.sendRedirect("list");
    }





}
