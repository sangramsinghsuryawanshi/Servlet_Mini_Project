package com.servlet.operation.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.servlet.operation.been.EncapsulateInsertion;

public class QueryOperation 
{
	public static int isInsert(EncapsulateInsertion ob)
	{
		int stataus=0;
		try 
		{
			Connection con = CreateConnectionOperation.isConnected();
			String insert = "insert into student(id,name,email,password)values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(insert);
			ps.setInt(1, ob.getId());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getEmail());
			ps.setString(4, ob.getPassword());
			
			stataus=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stataus;
	}
	public static int isUpdate(EncapsulateInsertion ob)
	{
		int stataus=0;
		try 
		{
			Connection con = CreateConnectionOperation.isConnected();
			String update = "update student set id=?,name=?,email=?,password=? where id=?";
			PreparedStatement ps = con.prepareStatement(update);
			ps.setInt(1, ob.getId());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getEmail());
			ps.setString(4, ob.getPassword());
			ps.setInt(5,ob.getId());
			
			stataus=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stataus;
	}
	public static int isDelete(EncapsulateInsertion ob)
	{
		int stataus=0;
		try 
		{
			Connection con = CreateConnectionOperation.isConnected();
			String delete = "delete from student where id=?";
			PreparedStatement ps = con.prepareStatement(delete);
			ps.setInt(1, ob.getId());
			stataus=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return stataus;
	}
	public static List<EncapsulateInsertion> DataFetch()
	{
		List<EncapsulateInsertion> li = new ArrayList<EncapsulateInsertion>();
		try 
		{
			Connection con =CreateConnectionOperation.isConnected();
			String select = "select * from student";
			PreparedStatement ps = con.prepareStatement(select);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EncapsulateInsertion en = new EncapsulateInsertion();
				en.setId(rs.getInt(1));
				en.setName(rs.getString(2));
				en.setEmail(rs.getString(3));
				en.setPassword(rs.getString(4));
				li.add(en);
			}
			
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return li;
	}
}
