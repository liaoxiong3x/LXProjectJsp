package cn.sxt.project.dao.imp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import cn.sxt.project.dao.AdminDao;
import cn.sxt.project.entity.Admin;
import cn.sxt.project.entity.Sex;
import cn.sxt.project.util.DBUtil;

public class AdminDaoImpl implements AdminDao{
	@Override
	public Admin findAdmin(String userID, String password)  {
		Admin admin = new Admin();
		//创建连接
		Connection connection = null;
		//建立命令发射器
		PreparedStatement ps = null;
		//创建sql语句
		String sql = "select * from admin where userid=? and passworld=?";
		//发送命令并去的结果
		ResultSet resultSet = null;
		try {
			connection = DBUtil.getConn();
			ps = DBUtil.getPreparedStatement(connection, sql);
			ps.setString(1, userID);
			ps.setString(2, password);
			resultSet = ps.executeQuery();
			if (resultSet.next()) {
				admin.setUsername(resultSet.getString("USERNAME")) ;
				admin.setPassword(resultSet.getString("PASSWORLD")) ;
				admin.setEmal(resultSet.getString("EMAL")) ;
				admin.setHobby(resultSet.getString("HOBBY")) ;
				admin.setBirthday(resultSet.getDate("BIRTHDAY")) ;
				admin.setAge(resultSet.getInt("AGE")) ;
				if (resultSet.getInt("SEX")==1) {
					admin.setSex(Sex.male) ;					
				}else {
					admin.setSex(Sex.female) ;	
				}
			}
		} catch (SQLException e) {
			
		}finally{
			DBUtil.closeAll(connection, ps, resultSet);
		}
		return admin;
	}
	@Test
	public void test() throws ParseException{
		Date date = null;
		String datestr = "2012/12/12";
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
//		format.format(date);
		System.out.println(format.parse(datestr));
//		date=format.;
//		new java.sql.Date(emp.getHiredate().getTime());
//		saveAdmin(new Admin("xiao", "xiao","xiao","adsd",Sex.female,11,date));
	}
	@Override
	public int saveAdmin(Admin admin) {
		admin = new Admin();
		//创建连接
		Connection connection = null;
		//建立命令发射器
		PreparedStatement ps = null;
		//创建sql语句
		String sql = "insert into admin values(?,?,?,?,?,?,?,?)";
		//发送命令并去的结果
		ResultSet resultSet = null;
		int flag = 0;
		try {
			connection = DBUtil.getConn();
			ps = DBUtil.getPreparedStatement(connection, sql);
			ps.setString(1, admin.getUsername());
			ps.setString(2, admin.getUsername());
			ps.setString(3, admin.getPassword());
			if (admin.getSex().equals(Sex.female)) {
				ps.setInt(4, 1);
			}else{
				ps.setInt(4, 2);
			}
			ps.setInt(5, admin.getAge());
			ps.setString(6, admin.getEmal());
			ps.setString(7, "");
			ps.setDate(8, null);
			flag = ps.executeUpdate();
		} catch (SQLException e) {
//			e.
		}finally{
			DBUtil.closeAll(connection, ps, resultSet);
		}
		
		return flag;
	}

}
