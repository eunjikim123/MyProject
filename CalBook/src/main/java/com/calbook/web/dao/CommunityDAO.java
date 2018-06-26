package com.calbook.web.dao;

import java.util.List;

import com.calbook.web.vo.Community;

public interface CommunityDAO {
   /* COMMUNITY �� ����Ʈ �������� */
   public List<Community> getCommunityList(String email, String query, int pg);
   
   /* COMMUNITY �� �� ���� �������� */
   public int getCommunityCount(String email, String query);
   
   /* COMMUNITY �� ���� �������� */
   public Community getCommunity(int seq);
   
   /* ��ȸ�� �����ϱ� */
   public int updateHit(int seq);
   
   /* COMMUNITY �� ����ϱ� */
   public int addCommunity(Community c);
   
   /* COMMUNITY �� �����ϱ� */
   public int delCommunity(int seq);
   
   /* COMMUNITY �� �����ϱ� */
   public int updateCommunity(Community c);
}