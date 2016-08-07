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
		//先把格式全部写好
		request.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//得到请求路径
		String currentURL=request.getServletPath();
		//得到具体请求
		String path=currentURL.substring(currentURL.lastIndexOf("/"),currentURL.lastIndexOf("."));
		//先定义好输出流
		PrintWriter out = response.getWriter();
		if("/login".equals(path)){
			//得到请求里的用户名密码
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			//去数据库匹配，若成功返回1，失败返回0
			SqlSession session = 
					MyBatisUtil.getSqlSession();
			CUser user=session.selectOne("findUserByName",username);
			String result="";
			if(user==null){
				result="";
			}else if(user.getPassword().equals(password)){
				result="1";
				//response.sendRedirect("main.html");//重定向
			}else{
				result="0";
				//response.sendRedirect("error.html");//重定向
			}
			
			 Map<String, String> map=new HashMap<String, String>();
			 if("1".equals(result)){
				 map.put(result, user.getUid().toString());
			}else{
				map.put("0", null);
			}
			  //将对象转换为json字符串
			JSONObject json=JSONObject.fromObject(map);
			  //
			  String json_str=json.toString();
				//将json字符串输出
				out.println(json_str);
				out.flush();
				out.close();
		}
		if("/showMsg".equals(path)){
			//获取请求对象
			String fromUserId=request.getParameter("fromUserId");
			String toUserId=request.getParameter("toUserId");
			//将请求对象信息插入到新对象里
			Messages m=new Messages();
			m.setFromUserId(Integer.parseInt(fromUserId));
			m.setToUserId(Integer.parseInt(toUserId));
			//去数据库查找列表
			SqlSession session=MyBatisUtil.getSqlSession();
			List messageList=new ArrayList<Messages>();
			messageList=session.selectList("showMessages", m);
			 
			JSONArray json=JSONArray.fromObject(messageList);
			String json_str=json.toString();
			//将json字符串输出
			out.println(json_str);
			out.flush();
			out.close();
		}
		if("/showNewMsg".equals(path)){
			//获取请求对象
			String fromUserId=request.getParameter("fromUserId");
			String toUserId=request.getParameter("toUserId");
			//将请求对象信息插入到新对象里
			Messages m=new Messages();
			m.setFromUserId(Integer.parseInt(fromUserId));
			m.setToUserId(Integer.parseInt(toUserId));
			//去数据库查找列表
			SqlSession session=MyBatisUtil.getSqlSession();
			List messageList=new ArrayList<Messages>();
			messageList=session.selectList("showNewMessages", m);
			//找到之后把状态置为1
			if(messageList.size()>0){
				session.update("upMessageState",m);
				session.commit();//提交事务,增删改操作必须做事务提交
			}
			JSONArray json=JSONArray.fromObject(messageList);
			String json_str=json.toString();
			//将json字符串输出
			out.println(json_str);
			out.flush();
			out.close();
		}
		if("/sendMsg".equals(path)){
			//获取请求对象
			String fromUserId=request.getParameter("fromUserId");
			String toUserId=request.getParameter("toUserId");
			String message=request.getParameter("message");
			//将请求对象信息插入到新对象里
			Messages m=new Messages();
			m.setFromUserId(Integer.parseInt(fromUserId));
			m.setToUserId(Integer.parseInt(toUserId));
			m.setMessage(message);
			m.setMessageState(0);
			Date date=new Date();
			m.setMessageTime(date);
			//插入到数据库中
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
			//获取请求对象
			String fromUserId=request.getParameter("fromUserId");
			SqlSession session=MyBatisUtil.getSqlSession();
			List<CUser> list=session.selectList("showUsers",Integer.parseInt(fromUserId));
			JSONArray json=JSONArray.fromObject(list);
			String json_str=json.toString();
			//将json字符串输出
			out.println(json_str);
			out.flush();
			out.close();
			
		}
		if("/showUserById".equals(path)){
			//获取请求对象
			String uid=request.getParameter("fromUserId");
			
			SqlSession session=MyBatisUtil.getSqlSession();
			CUser user=session.selectOne("findUserById",Integer.parseInt(uid));
			String json_str="";
			if(user!=null){
				 //将对象转换为json字符串
				JSONObject json=JSONObject.fromObject(user);

				json_str=json.toString();	
			}
			out.println(json_str);
			out.flush();
			out.close();
			
		}
		
	}

}
