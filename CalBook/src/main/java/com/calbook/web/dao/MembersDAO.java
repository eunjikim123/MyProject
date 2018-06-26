package com.calbook.web.dao;

import com.calbook.web.vo.Members;

public interface MembersDAO {
   
   // ȸ������(�������� ����)
   public int addMembers(Members m);
   
   // �������� �ҷ�����(�г���)
   public Members getMembersNick(String nick);
   
   // �������� �ҷ�����(�̸���)
   public Members getMembersEmail(String email);
   
   // �������� �����ϱ�
   public int updateMembers(Members m);
   
   // �ߺ�üũ(��ȭ��ȣ)
   public Members checkMembersPhone(String email, String phone);
   
   // �ߺ�üũ(�г���)
   public Members checkMembersNick(String email, String nick);
}