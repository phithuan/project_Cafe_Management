/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
//import com.sun.jdi.connect.spi.Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class AdminDao {

    Connection con; //con: Đây là một đối tượng của lớp Connection, được sử dụng để kết nối với cơ sở dữ liệu. Trong trường hợp này, nó được khởi tạo bằng MyConnection.getConnection().
    PreparedStatement ps; //ps: Đây là một đối tượng của lớp PreparedStatement, được sử dụng để thực hiện các truy vấn SQL đã được chuẩn bị trước. Chúng ta có thể sử dụng ps để thêm tham số vào truy vấn và thực hiện các thao tác với cơ sở dữ liệu.
    Statement st;//st: Đây là một đối tượng của lớp Statement, được sử dụng để thực hiện các truy vấn SQL không có tham số. Trong ví dụ này, st được sử dụng để thực hiện truy vấn “SELECT MAX(id) FROM admin”.
    ResultSet rs;//rs: Đây là một đối tượng của lớp ResultSet, được sử dụng để lưu trữ kết quả của truy vấn. Trong ví dụ này, rs chứa kết quả của truy vấn “SELECT MAX(id) FROM admin”.

    public AdminDao() throws SQLException {
        con = MyConnection.getConnection();
    }

       
     /*Trả về số hàng tối đa trong bảng admin tăng thêm 1.
     * @return Số hàng tối đa + 1
     */
    public int getMaxRowAdminTable() {
        int row = 0;
        try {
            st = con.createStatement();
            rs = st.executeQuery("SELECT MAX(id) FROM admin");
            while (rs.next()) {
                row = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return row + 1;
    }

}
