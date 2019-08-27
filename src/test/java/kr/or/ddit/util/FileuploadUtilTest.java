package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class FileuploadUtilTest {

	/**
	* Method : getFilenameTest
	* 작성자 : PC-09
	* 변경이력 :
	* Method 설명 : Content-disposition 헤더 문자열로 부터 파일확장자 추출 테스트
	*/
	@Test
	public void getFileExtensionTest() {
		/***Given***/
		String contentDisposision = "form-data; name=\"file\"; filename=\"냅.png\"";
		String contentDisposision2 = "form-data; name=\"file\"; filename=\"brown.png\"";
		String contentDisposision3 = "form-data; name=\"file\"; filename=\"brown\"";
		String contentDisposision4 = "form-data; name=\"file\"; filename=\"brown.xx.png\"";
		
		/***When***/
		String fileExtensionName = FileuploadUtil.getFilename(contentDisposision);
		String fileExtensionName2 = FileuploadUtil.getFilename(contentDisposision2);
		String fileExtensionName3 = FileuploadUtil.getFileExtension(contentDisposision3);
		String fileExtensionName4 = FileuploadUtil.getFileExtension(contentDisposision4);

		/***Then***/
		assertEquals("냅.png", fileExtensionName);
		assertEquals("brown.png", fileExtensionName2);
		assertEquals("", fileExtensionName3);
		assertEquals(".png", fileExtensionName4);
	}
	
	@Test
	public void getPathTest() {
		/***Given***/
		

		/***When***/
		String path = FileuploadUtil.getpath();
		
		/***Then***/
		assertEquals("e:\\upload\\2019\\08\\", path);
	}

}
