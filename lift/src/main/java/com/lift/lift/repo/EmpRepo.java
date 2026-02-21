package com.lift.lift.repo;

import org.springframework.stereotype.Component;

@Component
public class EmpRepo {
//
//    private static Connection conn() throws SQLException {
//        String url = "jdbc:mysql://localhost:3306/employeeDB";
//        String username = "root";
//        String password = "Abhishek@1234";
//        Connection con = DriverManager.getConnection(url, username, password);
//        return con;
//    }
//
//
//
//    public List<Employee> getEmployeesInfo() throws Exception{
//        Connection con = EmpRepo.conn();
//
//        String query = "insert into employeeinfo(employeeID, employeeFloor) values (002,56), (003, 12), (004,28)";
//        PreparedStatement st = con.prepareStatement(query);
//        ResultSet rs = st.executeQuery();
//        rs.next();
//    }
//
//
//
//    public int getEmpFloorById(int id) throws Exception{
//        Connection con = EmpRepo.conn();
//
//        String query = "SELECT employeeFloor FROM employeeInfo WHERE employeeID = ?";
//        PreparedStatement st = con.prepareStatement(query);
//        st.setInt(1, id);
//        ResultSet rs = st.executeQuery();
//        rs.next();
//        return rs.getInt(1);
//    }



}
