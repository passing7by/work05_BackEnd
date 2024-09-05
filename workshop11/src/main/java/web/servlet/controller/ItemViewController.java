package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = null;
		
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);
		
		try {
			ItemDao.getInstance().updateRecordCount(id);
			Item item = ItemDao.getInstance().getItem(id);
			request.setAttribute("item", item);
			System.out.println("dao 호출 성공");
			modelAndView = new ModelAndView("itemView.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("dao 호출 실패");
			modelAndView = new ModelAndView("itemList.jsp");
		}
		return modelAndView;
	}

}
