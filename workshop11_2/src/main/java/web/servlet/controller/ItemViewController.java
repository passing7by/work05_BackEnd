package web.servlet.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Item;
import web.servlet.model.ItemDao;
/*
 * 하나의 컴포넌트에서 두 개의 비지니스 로직이 호출될 수도 있음!!
 * 하나의 Fruit 정보 받아오기
 * +
 * 조회수 증가하기
 */
public class ItemViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int itemnum = Integer.parseInt(request.getParameter("itemnumber"));
		System.out.println("ItemViewController....execute.."+itemnum);
		
		//1. 조회수 증가가 먼저 동작해야 함...
		boolean result = ItemDao.getInstance().updateRecordCount(itemnum);
		System.out.println("count update? "+result);		
		
		//2. 조회수가 증가가 선행되어야, 2번에서 Item 데이터를 가져올 때, 증가된 조회수에 대한 데이터를 가져올 수 있음
		Item item=ItemDao.getInstance().getItem(itemnum);
		System.out.println("getItem()? "+item);		
		
		////////// 오늘 본 상품정보를 쿠키에 저장하는 로직 추가 /////////////
		
		//3. 1) 쿠키 생성...생성 시에 정보 저장   2) 생성한 쿠키를 클라이언트로 보냄
		Cookie cookie = new Cookie("fruitshop"+itemnum, item.getUrl()); //아이템id를 키로, url을 값으로
		//어떤 정보를 브라우저에 보여주고싶은지를 생각한 후 저장할 값을 생각하기!!!!!!
		//넌스트링과 스트링이 concat되면 스트링이 됨 (함수 호출보다도 성능, 속도 면에서 가장 좋은 방법)
		//쿠키는 불러올 때 모두 불러오게 됨 -> 키에 우리 사이트만의 고유한 이름을 넣어주어야 함
		cookie.setMaxAge(24*60*60);
		response.addCookie(cookie);
		
		request.setAttribute("item", item);
		return new ModelAndView("itemView.jsp");
	}

}









