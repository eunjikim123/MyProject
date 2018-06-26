package com.calbook.web.dao;

import java.util.List;

import com.calbook.web.vo.Members;
import com.calbook.web.vo.TmpMember;

public interface Group_MembersDAO {
	// �׷������ ��� �߰� ajax
	public int addGroupMember(int g_num, String m_email, int status_accept);
	
	// �׷������ ��� �߰� ��� ajax
	public int cancelGroupMember(int g_num, String m_email);
	
	// �׷������ ����߰��� ģ������Ʈ �ҷ�����  ajax 
	public List<TmpMember> getGroupFriendsList(String email, int g_num);
	
	// �׷������ ����߰��� �˻� ģ������Ʈ �ҷ�����  ajax 
	public List<TmpMember> getSearchGroupFriendsList(String email, int g_num, String searchSelect, String search);
	
	// �׷������ �׷�������Ʈ �ҷ�����
	public List<Members> getGroupMemberList(int g_num);
	
	// �׷���� �ϷḦ ���� �׷��� ���º���
	public int updateMembersStatusAccept(int g_num);
	
	//�׷� ģ���߰� ���
	public int addFriendsCancel(int g_num);
	
	//�ʴ���� �׷찡�ԿϷ�ajax
	public int updateAcceptGroup(String email, int g_num);
	
	//�ʴ���� �׷찡�԰���ajax
	public int deleteRefuseGroup(String email, int g_num);
	
	//�׷� Ż�� ajax
	public int signOutGroup(String email, int g_num);
	
	//�׷� ���������� ��� ��� Ż�� SignOut all members for delete the group1
	public int signOutGroupMembers1(int g_num);
	
	//�׷� ���������� ��� ��� Ż�� SignOut all members for delete the group2
	public int signOutGroupMembers2(int g_num);
	
	//social page groupMemberList print
	public List<TmpMember> getGroupsMemberList(String email);
}
