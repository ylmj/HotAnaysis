package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.GoodType;
import com.model.Key;
import com.util.DBUtil;
import com.util.UserException;

public class GoodTypeDao implements IGoodType{

	@Override
	public void addType(GoodType type) {
		//������Ӷ���
		Connection connection=DBUtil.getConnection();
		String sql="SELECT COUNT(*) FROM MOON.GOODS_TYPE WHERE NAME = ?";
		//������䴫�����
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,type.getName());
		//���ս����
		resultSet=preparedStatement.executeQuery();
		while(resultSet.next())
		{
			if(resultSet.getInt(1)>0)
			{
				throw new UserException("�������Ѵ���");
			}
		}
		sql="INSERT into moon.GOODS_TYPE(name,description,num) VALUES (?,?,?)";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,type.getName());
		preparedStatement.setString(2, type.getDescription());
		preparedStatement.setInt(3, type.getNum());
		preparedStatement.executeUpdate();
		System.out.println("�������");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���Դ
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);	
		}
	}

	@Override
	public void updateType(GoodType type) {
		//������Ӷ���
		Connection connection=DBUtil.getConnection();
		//׼��sql���
		String sql="update moon.GOODS_TYPE set Description = ? , Num = ?  where name = ?";
		//������䴫�����
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,type.getDescription());
			preparedStatement.setInt(2, type.getNum());
			preparedStatement.setString(3, type.getName());
			preparedStatement.executeUpdate();
			System.out.println("���ĳɹ�");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally
			{
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
			}
	}

	@Override
	public void deleteType(int id) {
		//ɾ��
		Connection connection=DBUtil.getConnection();
		String sql="delete from MOON.GOODS_TYPE WHERE ID = ?";
		PreparedStatement preparedStatement=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
			System.out.println("ɾ���ɹ�");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
			//�ر���Դ
				DBUtil.close(preparedStatement);
		    	DBUtil.close(connection);	
		    }
	}

	@Override
	public List<GoodType> load(String name) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from MOON.GOODS_TYPE";
		if(!"".equals(name))
		{
			sql+=" where name = '"+name+"' ";
		}
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<GoodType> types=new ArrayList<GoodType>();
		GoodType type=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				type=new GoodType();
				type.setId(resultSet.getInt("ID"));
				type.setName(resultSet.getString("NAME"));
				type.setDescription(resultSet.getString("description"));
				type.setNum(resultSet.getInt("NUM"));
				types.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return types;
	}

	@Override
	public GoodType load(int id) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from MOON.GOODS_TYPE where id = ?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		GoodType type=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				type=new GoodType();
				type.setId(resultSet.getInt("ID"));
				type.setName(resultSet.getString("NAME"));
				type.setDescription(resultSet.getString("description"));
				type.setNum(resultSet.getInt("NUM"));
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return type;
	}

	@Override
	public void updateTypeNum(int id) {
		//������Ӷ���
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		int num=0;
		//׼��sql���
		String sql1="SELECT sum(num) sumNum from moon.Goods WHERE TYPE = "+id;
		System.out.println(sql1);
		System.out.println("---------------------------------------");
		try
		{
			preparedStatement=connection.prepareStatement(sql1);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
			num=resultSet.getInt("SUMNUM");
			System.out.println(num);
			}
			String sql2="update moon.GOODS_TYPE set Num = "+num+" where id = "+id;
			System.out.println(sql2);
			preparedStatement=connection.prepareStatement(sql2);
			preparedStatement.executeUpdate();
			System.out.println("���������ɹ�");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally
		{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}

	public GoodType loadOne(String name) {
		Connection connection=DBUtil.getConnection();
		String sql="select * from MOON.GOODS_TYPE where name = ?";
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		GoodType type=null;
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				type=new GoodType();
				type.setId(resultSet.getInt("ID"));
				type.setName(resultSet.getString("NAME"));
				type.setDescription(resultSet.getString("description"));
				type.setNum(resultSet.getInt("NUM"));
				return type;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return type;
	}

}
