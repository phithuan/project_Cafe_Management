/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Dao {

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
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
