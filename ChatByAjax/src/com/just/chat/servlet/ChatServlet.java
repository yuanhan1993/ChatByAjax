package com.just.chat.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.just.chat.entity.CUser;
import com.just.chat.entity.Messages;
import com.just.chat.entity.Note;
import com.just.chat.util.MyBatisUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ChatServlet extends HttpServlet {

	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//�ȰѸ�ʽȫ��д��
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//�õ�����·��
		String currentURL=request.getServletPath();
		//�õ���������
		String path=currentURL.substring(currentURL.lastIndexOf("/"),currentURL.lastIndexOf("."));
		//�ȶ���������
		PrintWriter out = response.getWriter();
		if("/login".equals(path)){
			//�õ���������û�������
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//ȥ���ݿ�ƥ�䣬���ɹ�����1��ʧ�ܷ���0
			SqlSession session = 
					MyBatisUtil.getSqlSession();
			CUser user=session.selectOne("findUserByName",username);
			String result="";
			if(user==null){
				result="";
			}else if(user.getPassword().equals(password)){
				result="1";
				//response.sendRedirect("main.html");//�ض���
			}else{
				result="0";
				//response.sendRedirect("error.html");//�ض���
			}
			
			 Map<String, String> map=new HashMap<String, String>();
			 if("1".equals(result)){
				 map.put(result, user.getUid().toString());
			}else{
				map.put("0", null);
			}
			  //������ת��Ϊjson�ַ���
			JSONObject json=JSONObject.fromObject(map);
			  //
			  String json_str=json.toString();
				//��json�ַ������
				out.println(json_str);
				out.flush();
				out.close();
		}
		if("/showMsg".equals(path)){
			//��ȡ�������
			String fromUserId=request.getParameter("fromUserId");
			String toUserId=request.getParameter("toUserId");
			//�����������Ϣ���뵽�¶�����
			Messages m=new Messages();
			m.setFromUserId(Integer.parseInt(fromUserId));
			m.setToUserId(Integer.parseInt(toUserId));
			//ȥ���ݿ�����б�
			SqlSession session=MyBatisUtil.getSqlSession();
			List messageList=new ArrayList<Messages>();
			messageList=session.selectList("showMessages", m);
			 
			JSONArray json=JSONArray.fromObject(messageList);
			String json_str=json.toString();
			//��json�ַ������
			out.println(json_str);
			out.flush();
			out.close();
		}
		if("/showNewMsg".equals(path)){
			//��ȡ�������
			String fromUserId=request.getParameter("fromUserId");
			String toUserId=request.getParameter("toUserId");
			//�����������Ϣ���뵽�¶�����
			Messages m=new Messages();
			m.setFromUserId(Integer.parseInt(fromUserId));
			m.setToUserId(Integer.parseInt(toUserId));
			//ȥ���ݿ�����б�
			SqlSession session=MyBatisUtil.getSqlSession();
			List messageList=new ArrayList<Messages>();
			messageList=session.selectList("showNewMessages", m);
			//�ҵ�֮���״̬��Ϊ1
			if(messageList.size()>0){
				session.update("upMessageState",m);
				session.commit();//�ύ����,��ɾ�Ĳ��������������ύ
			}
			JSONArray json=JSONArray.fromObject(messageList);
			String json_str=json.toString();
			//��json�ַ������
			out.println(json_str);
			out.flush();
			out.close();
		}
		if("/sendMsg".equals(path)){
			//��ȡ�������
			String fromUserId=request.getParameter("fromUserId");
			String toUserId=request.getParameter("toUserId");
			String message=request.getParameter("message");
			//�����������Ϣ���뵽�¶�����
			Messages m=new Messages();
			m.setFromUserId(Integer.parseInt(fromUserId));
			m.setToUserId(Integer.parseInt(toUserId));
			m.setMessage(message);
			m.setMessageState(0);
			Date date=new Date();
			m.setMessageTime(date);
			//���뵽���ݿ���
			SqlSession session=MyBatisUtil.getSqlSession();
			int r=session.insert("insertMessage",m);
			if(r>0){
				out.println("1");
				session.commit();
			}else{
				out.println("0");
			}
			out.flush();
			out.close();
			
		}
		if("/showUsers".equals(path)){
			//��ȡ�������
			String fromUserId=request.getParameter("fromUserId");
			SqlSession session=MyBatisUtil.getSqlSession();
			List<CUser> list=session.selectList("showUsers",Integer.parseInt(fromUserId));
			JSONArray json=JSONArray.fromObject(list);
			String json_str=json.toString();
			//��json�ַ������
			out.println(json_str);
			out.flush();
			out.close();
			
		}
		if("/showUserById".equals(path)){
			//��ȡ�������
			String uid=request.getParameter("fromUserId");
			
			SqlSession session=MyBatisUtil.getSqlSession();
			CUser user=session.selectOne("findUserById",Integer.parseInt(uid));
			String json_str="";
			if(user!=null){
				 //������ת��Ϊjson�ַ���
				JSONObject json=JSONObject.fromObject(user);

				json_str=json.toString();	
			}
			out.println(json_str);
			out.flush();
			out.close();
			
		}
		
	}

}
