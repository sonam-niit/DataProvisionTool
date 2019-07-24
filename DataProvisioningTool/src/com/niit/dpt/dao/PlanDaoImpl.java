package com.niit.dpt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.niit.dpt.config.DBConfig;
import com.niit.dpt.dataplan.DataPlan;

public class PlanDaoImpl implements PlanDao{

	Connection connection=null;
	PreparedStatement pst;
	
	public PlanDaoImpl()
	{
		connection = DBConfig.connect();
	}
	@Override
	public boolean addPlan(DataPlan plan,int userid) {
		
		int count=0;
		try {
			pst = connection.prepareStatement("insert into dataplan(pack,validity,price,description,userid) values(?,?,?,?,?)");
			pst.setString(1, plan.getPack());
			pst.setString(2, plan.getValidity());
			pst.setString(3, plan.getPrice());
			pst.setString(4, plan.getDescription());
			pst.setInt(5, userid);
			count=pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(count>0)
			return true;
		else
			return false;
	}

	@Override
	public List<DataPlan> findPlanByName(int userid) {
		List<DataPlan> list=new ArrayList<DataPlan>();
		try {
			pst = connection.prepareStatement("select * from dataplan where userid=?");
			pst.setInt(1, userid);
			
			ResultSet rs=pst.executeQuery();
			DataPlan plan=new DataPlan();
			while(rs.next())
			{
				plan.setId(rs.getInt(1));
				plan.setPack(rs.getString(2));
				plan.setValidity(rs.getString(3));
				plan.setDescription(rs.getString(5));
				plan.setPrice(rs.getString(4));
				list.add(plan);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
