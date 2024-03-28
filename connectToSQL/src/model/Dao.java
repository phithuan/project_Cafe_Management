/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Dao {

    Connection con; //con: Đây là một đối tượng của lớp Connection, được sử dụng để kết nối với cơ sở dữ liệu. Trong trường hợp này, nó được khởi tạo bằng MyConnection.getConnection().
    PreparedStatement ps; //ps: Đây là một đối tượng của lớp PreparedStatement, được sử dụng để thực hiện các truy vấn SQL đã được chuẩn bị trước. Chúng ta có thể sử dụng ps để thêm tham số vào truy vấn và thực hiện các thao tác với cơ sở dữ liệu.
    Statement st;//st: Đây là một đối tượng của lớp Statement, được sử dụng để thực hiện các truy vấn SQL không có tham số. Trong ví dụ này, st được sử dụng để thực hiện truy vấn “SELECT MAX(id) FROM admin”.
    ResultSet rs;//rs: Đây là một đối tượng của lớp ResultSet, được sử dụng để lưu trữ kết quả của truy vấn. Trong ví dụ này, rs chứa kết quả của truy vấn “SELECT MAX(id) FROM admin”.

    public boolean insertProduct(Product p) {//Đây là phương thức được sử dụng để chèn một sản phẩm mới vào cơ sở dữ liệu. Phương thức này nhận một đối tượng Product làm đối số, đại diện cho thông tin về sản phẩm cần chèn.
        String sql = "INSERT INTO product (name, price, image) VALUES (?, ?, ?)";
        try {
            Connection con = MyConnection.getConnection();//tạo một đối tượng kết nối Connection đến cơ sở dữ liệu bằng cách gọi phương thức getConnection() của lớp MyConnection. Đây là một phương thức static trong lớp MyConnection, nó trả về một đối tượng kết nối được thiết lập trước đó.
            PreparedStatement ps = con.prepareStatement(sql);//tạo một đối tượng PreparedStatement từ đối tượng kết nối đã được thiết lập trước đó (con). Đối tượng PreparedStatement này được sử dụng để thực hiện một câu lệnh SQL đã được chuẩn bị trước, trong trường hợp này là câu lệnh sql.
            //Việc sử dụng PreparedStatement thường được ưa chuộng hơn so với Statement vì nó cho phép sử dụng tham số định vị (placeholders), giúp ngăn chặn các cuộc tấn công SQL Injection và tăng hiệu suất thực thi câu lệnh SQL.

            ps.setString(1, p.getName());
            ps.setDouble(2, p.getPrice());
            ps.setBytes(3, p.getImage());
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public void getallProducts(JTable table) {
        String sql = "SELECT * FROM product ORDER BY id DESC";
        try {
            con = MyConnection.getConnection(); // Khởi tạo đối tượng Connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            DefaultTableModel model = (DefaultTableModel) table.getModel();

            Object[] row;

            while (rs.next()) {
                row = new Object[4];
                row[0] = rs.getInt(1);
                row[1] = rs.getString(2);
                row[2] = rs.getDouble(3);
                row[3] = rs.getBytes(4);

                model.addRow(row); // Thêm dòng vào mô hình của bảng

            }

            model.fireTableDataChanged(); // Cập nhật mô hình của bảng

        } catch (Exception ex) {
            Logger.getLogger(Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
