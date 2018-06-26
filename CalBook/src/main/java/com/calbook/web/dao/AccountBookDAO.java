package com.calbook.web.dao;

import java.util.List;

import com.calbook.web.vo.AccountBook;
import com.calbook.web.vo.SumAccountBook;

public interface AccountBookDAO {
   
   /* �Ѽ���, ������ ��������(Daily) */
   public List<SumAccountBook> getDailySumAccountBook(String email, String date);
   
   /* �Ѽ���, ������ ��������(Monthly) */
   public List<SumAccountBook> getMonthlySumAccountBook(String email, String date);
   
   /* �Ѽ���, ������  ��������(Period)*/
   public List<SumAccountBook> getPeriodSumAccountBook(String email, String startD, String endD);
   
   /* ����� ����Ʈ ��������(Daily) */
   public List<AccountBook> getDailyAccountBook(String email, String date);
   
   /* ����� ����Ʈ ��������(Monthly) */
   public List<AccountBook> getMonthlyAccountBook(String email, String date);
   
   /* ����� ����Ʈ ��������(Period) */
   public List<AccountBook> getPeriodAccountBook(String email, String startD, String endD);
   
   /* ����� �����ϱ� */
   public int saveAccountBook(AccountBook ab);
   
   /* ����� �����ϱ� */
   public int rmAccountBook(int num);
   
   /* ����� �����ϱ� */
   public int modiAccountBook(int num, String content, int amount);
   
   /* sub_kind�� ����� �������� */
   public List<SumAccountBook> getModalSumAccountBook(String email, String date);
}