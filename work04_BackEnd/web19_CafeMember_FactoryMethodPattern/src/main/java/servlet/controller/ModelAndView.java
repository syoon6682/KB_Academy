package servlet.controller;
/*
 * Controller 역할
 * 가장 마지막 역할이 결과 페이지
 * 무조건 페이지 이동 방식 -> forward
 * 
 * 결과페이지 이름도 String으로 저장
 * 페이지 이동방식도 저장
 * 위 2가지 정보가 네비게이션 과정에서 필요한 정보들이다.
 * 
 * 
 */
public class ModelAndView {
	private String path; // 결과페이지 이름
	private boolean isRedirect;
	public ModelAndView(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public ModelAndView() {
		
	}
	
	public ModelAndView(String path) {
		this.path = path;
	}
	
}
