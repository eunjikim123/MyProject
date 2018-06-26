package com.calbook.web.dao;

import java.util.List;

import com.calbook.web.vo.Schedules;

public interface SchedulesDAO {
	
	public List<Schedules> getSchedulesCal(String m_email, String start_date, String end_date);
	
	public List<Schedules> getSchedulesDates(String m_email, String start_date, String end_date);
	
	public List<Schedules> getSchedulesMonth(String m_email, String start_date, String end_date);
	
	public int delSchedule(String seq);
	
	public int addSchedule(Schedules s);
	
	public Schedules getSchedule(String seq);
	
	public int updateSchedule(Schedules s);
	
	// ���� ���� ���� �ҷ�����.
	public List<Schedules> getGroupSchedules(int g_num);
	
	//���� ���� ����ϱ�
	public int addGroupSchedules(Schedules s);
	
	// ���� ���� �ϳ��� �ҷ�����
	public Schedules getGroupSchedule(int seq);
	
	//���� ���� ����
	public int updateGroupSchedule(Schedules s);
	
	//���� ���� ����
	public int deleteGroupSchedule(int seq);
}
