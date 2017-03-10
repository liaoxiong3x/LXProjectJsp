package cn.sxt.project;

import java.sql.Connection;

import cn.sxt.project.util.ConnectPoolFactory;

public class ConnectPoolTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectPoolFactory cpfConnectPoolFactory = ConnectPoolFactory.getInstance();
		Connection connection = cpfConnectPoolFactory.getConnect();
		System.out.println(connection);
	}

}
