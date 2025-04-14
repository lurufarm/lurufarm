package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application3 {
    public static void main(String[] args) {
        /** [직원의 성씨를 입력받아 해당하는 직원들의 모든 정보를 DTO 객체에 담고, 이를 ArrayList에 담아 출력하기] */

        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        ArrayList<EmployeeDTO> employees = null;
        Scanner sc = new Scanner(System.in);
        System.out.print("성씨를 입력하세요: ");
        String lastName = sc.nextLine();

        String query = "SELECT * FROM employee WHERE emp_name LIKE CONCAT(?, '%')";
        System.out.println(query);

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, lastName);
            rset = pstmt.executeQuery();
            employees = new ArrayList<>();
            while (rset.next()) {
                EmployeeDTO emp = new EmployeeDTO();
                emp.setEmpId(rset.getString("emp_id"));
                emp.setEmpName(rset.getString("emp_name"));
                emp.setEmpNo(rset.getString("emp_no"));
                emp.setEmail(rset.getString("email"));
                emp.setPhone(rset.getString("phone"));
                emp.setDeptCode(rset.getString("dept_code"));
                emp.setJobCode(rset.getString("job_code"));
                emp.setSalLevel(rset.getString("sal_level"));
                emp.setSalary(rset.getInt("salary"));
                emp.setBonus(rset.getDouble("bonus"));
                emp.setManagerId(rset.getString("manager_id"));
                emp.setHireDate(rset.getDate("hire_date"));
                emp.setEntDate(rset.getDate("ent_date"));
                emp.setEntYn(rset.getString("ent_yn"));

                employees.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally
        {
            close(rset);
            close(pstmt);
            close(con);
        }

        for (EmployeeDTO emp : employees)
        {
            System.out.println(emp.toString());
        }

    }
}
