package web.servlet.controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;

public class ItemListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		////////// 브라우저에서 전달되는 모든 쿠키 정보를 받는 로직을 작성 //////////
		//requst.getCookies()...그 중에서 "fruitshop" 사이트의 쿠키 정보만 받아오도록
		ArrayList<String> fruits = new ArrayList();
		
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) { //어떤 브라우저는 쿠키를 차단하기도 하고, 쿠키는 저장 제한시간이 있어서 아예 없어지기도 함
			for (Cookie c:cookies) {
				if(c.getName().startsWith("fruitshop")) fruits.add(c.getValue());
			}//for
		}//if
		
		request.setAttribute("fruits", fruits);
		////////////////////////////////////////
		
		ArrayList<Item> list=ItemDao.getInstance().getAllItem();
		System.out.println(list);
		request.setAttribute("list", list);
		return new ModelAndView("itemList.jsp");
	}
}
