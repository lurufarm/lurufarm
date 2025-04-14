package com.ohgiraffers.section02.preparedstatement;

import com.ohgiraffers.model.dto.EmployeeDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import static com.ohgiraffers.common.JDBCTemplate.close;
import static com.ohgiraffers.common.JDBCTemplate.getConnection;

public class Application4 {
    public static void main(String[] args) {
        Connection con = getConnection();
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        EmployeeDTO emp = null;
        List<EmployeeDTO> employees = null;
        Scanner sc = new Scanner(System.in);

        System.out.print("조회할 이름의 성을 입력하세요: ");
        String lastName = sc.nextLine();

        Properties prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/section02/preparedstatement/employee-query.xml"));
            String query = prop.getProperty("selectEmpByFamilyName");
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, lastName);
            rset = pstmt.executeQuery();
            employees = new ArrayList<>();
            while(rset.next())
            {
                emp = new EmployeeDTO();
                emp.setEmpId(rset.getString("EMP_ID"));
                employees.add(emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
            close(con);
        }

        for (EmployeeDTO dto : employees)
        {
            System.out.println(dto);
        }
    }
}
