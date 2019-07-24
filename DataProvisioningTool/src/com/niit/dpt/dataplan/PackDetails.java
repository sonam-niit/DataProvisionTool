package com.niit.dpt.dataplan;

import java.util.ArrayList;
import java.util.List;

public class PackDetails {

	public static List<DataPlan> airtelPlans()
	{
		List<DataPlan> list=new ArrayList<DataPlan>();
		list.add(new DataPlan(1,"100 MB Combo 3G / 4G Data Pack","1 day","9","3G-4G Data: 100 MB, extra @Rs.0.04/10KB. Calls: Unlimited. SMS: 100 SMS"));
		list.add(new DataPlan(2,"3 GB 3G / 4G Data Pack","28 days","48","3G-4G Data: 3 GB"));
		list.add(new DataPlan(3,"6 GB Combo 3G / 4G Data Pack","28 days","98","3G-4G Data: 6 GB, extra @Rs.0.04/10KB. SMS: 10 SMS. (price per day: Rs. 3.5)"));
		
		return list;
	}
	public static List<DataPlan> jioPlans()
	{
		List<DataPlan> list=new ArrayList<DataPlan>();
		list.add(new DataPlan(1,"1 GB Combo 4G Data Pack","28 days","49","Data: 1 GB. Unlimited Data Pack. After FUP speed reduces to: 64 Kbps. All Calls (excl. Roaming Calls): Unlimited. All Roaming Calls (incl incoming): Unlimited. SMS: 50 SMS. Jio Apps Included. Only for Jiophone SIMs. (price per day: Rs. 1.8)"));
		list.add(new DataPlan(2,"150 MB Combo 4G Data Pack","1 day","19","150 MB Combo 4G Data Pack\r\n" + 
				"Data: 150 MB. Unlimited Data Pack. After FUP speed reduces to: 64 Kbps"));
		list.add(new DataPlan(3,"1.5 GB / Day Combo 4G Data Pack","28 days","149","Data: 1.5 GB / Day. Unlimited Data Pack. After FUP speed reduces to: 64 Kbps"));
		
		return list;
	}
	public static List<DataPlan> ideaPlans()
	{
		List<DataPlan> list=new ArrayList<DataPlan>();
		list.add(new DataPlan(1,"1 GB 3G Data Pack","1 day","16","2G-3G-4G Data: 1 GB, extra @Rs.0.04/10KB, Valid for 24 hours"));
		list.add(new DataPlan(2,"500 MB 3G Data Pack","28 days","33","2G-3G-4G Data: 500 MB, extra @Rs.0.04/10KB. (price per day: Rs. 1.2)"));
		list.add(new DataPlan(3,"3 GB 3G Data Pack","28 days","49","2G-3G-4G Data: 3 GB, extra @Rs.0.04/10KB. (price per day: Rs. 1.8)"));
		
		return list;
	}
}
