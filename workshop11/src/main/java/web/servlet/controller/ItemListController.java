package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = null;
		
		try {
			ArrayList<Item> list = ItemDao.getInstance().getAllItem();
			request.setAttribute("list", list);
			System.out.println("dao 호출 성공");
			modelAndView = new ModelAndView("itemList.jsp", false);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("dao 호출 실패");
			modelAndView = new ModelAndView("index.jsp", true);
		}
		return modelAndView;
	}

}
