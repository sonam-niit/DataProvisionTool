package com.niit.dpt.dao;

import java.util.List;

import com.niit.dpt.dataplan.DataPlan;

public interface PlanDao {

	public boolean addPlan(DataPlan plan,int userid);
	public List<DataPlan> findPlanByName(int userid);
}
