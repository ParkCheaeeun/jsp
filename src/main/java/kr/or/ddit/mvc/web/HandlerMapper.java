package kr.or.ddit.mvc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.mvc.model.IUrlMappingDao;
import kr.or.ddit.mvc.model.UrlMapping;
import kr.or.ddit.mvc.model.UrlMappingDao;

public class HandlerMapper {
	
	private Map<String, IController> uriMapping;
	
	public HandlerMapper() {
		uriMapping = new HashMap<String, IController>();
		IUrlMappingDao dao = new UrlMappingDao();
		
		// url, controller의 full name--> 인스턴스 생성
		List<UrlMapping> urlMappingList = dao.getUrlMapping();
		
		for(UrlMapping urlMapping : urlMappingList) {
		  	String controllerStr = urlMapping.getController();
		  	
		  	try {
				Class clazz = Class.forName(controllerStr);
				IController controller = (IController) clazz.newInstance();
				uriMapping.put(urlMapping.getUrl(), controller);
				
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
//		uriMapping.put("/mvc/userList.do", new UserListController());
//		uriMapping.put("/mvc/memberList.do", new MemberListController());
	}
	
	/**
	* Method : getController
	* 작성자 : PC-09
	* 변경이력 :
	* @param uri
	* @return
	* Method 설명 : uri를 처리해주는 컨트롤러 리턴
	*/
	public IController getController(String uri) {
		return uriMapping.get(uri);
	}

}
