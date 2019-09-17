package com.dao;

import com.model.User;
import com.util.DBUtil;
import com.util.UserException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao implements IUser{

	@Override
	public boolean addUser(String name,String pwd) {
		//获得链接对象
				Connection connection=DBUtil.getConnection();
				String sql="select count(*) from \"USER\" where \"username\"= '"+name+"'";
				System.out.println("0  ==="+sql);
				PreparedStatement preparedStatement=null;
				ResultSet resultSet =null;
				try {
					preparedStatement=connection.prepareStatement(sql);
					//接收结果集
					resultSet=preparedStatement.executeQuery();
					//遍历结果集
					while(resultSet.next())
					{
						if(resultSet.getInt(1)>0)
						{
							/*throw new UserException("用户已存在");*/
							return false;
						}
					}
					System.out.println("1  ==="+sql);
					sql="insert into \"USER\"(\"username\",\"password\") VALUES ('"+ name +"','"+pwd+"')";
					System.out.println(sql);
					preparedStatement=connection.prepareStatement(sql);
					preparedStatement.executeUpdate();
					return true;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}
		
	}

	@Override
	public User loadUser(String username, String password) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from \"USER\" WHERE \"username\"= ? and \"password\"= ?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		User user=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				user=new User();
				user.setId(resultSet.getInt("ID"));
				user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//查询失败
		return user;
	}

}
