package com.cafe24.radev.controller;

import java.io.*;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class fileController {
	//HttpServletRequest request
	@SuppressWarnings("resource")
	@GetMapping("/download/fileDownload")
	public String fileDown(
			//@RequestParam(name = "filename", required = false)String file_e,
			//@RequestParam(name = "filename_h", required = false)String file_h, 
			HttpServletRequest request, 
			HttpServletResponse response) throws IOException {
		//System.out.println(file_e + "file_e");
		System.out.println("호출");
//		System.out.println(file_e + " <-file_e");
//		System.out.println(file_h + " <-file_h");
		String filename = request.getParameter("filename") + ".hwp";
//		String filename_h = request.getParameter("filename_h") + ".hwp";
//		String filename = file_e + ".hwp";
//		String filename_h = file_h + ".hwp";
		System.out.println(filename + " <-잉?");
//		System.out.println(filename_h + " <-잉????");
			
		ClassPathResource resource = new ClassPathResource("download/완료_보고서_최종.hwp");
//		System.out.println(resource + " <-resource");
//		System.out.println(resource.getFile() + " <-파일");
//		System.out.println(resource.getFilename() + " <-파일 이름");
//		System.out.println(resource.getURI() + " <-uri");
//		System.out.println(resource.getURL() + " <-url");
		
		File file = null;
		BufferedInputStream fin = null;
		BufferedOutputStream outs = null;
//		PrintWriter re;
//		Object inputStream;
		try{
			file = new File(resource.getFile(), "");
			System.out.println(file + " <-file~~");
			System.out.println(file + " <-file");
			response.reset();

			//다운로드상 파일 이름과 확장자 setting
			response.setHeader("Content-Type","application/hwp");
			response.setHeader("Content-Disposition","attachment;filename="+filename+";");
			
			if(file != null){
				fin = new BufferedInputStream(new FileInputStream(file));
//				System.out.println(fin + " <-fin");
				outs = new BufferedOutputStream(response.getOutputStream());
//				System.out.println(outs + " <-outs");
				int read = 0;

				while((read = fin.read()) != -1 ){
					outs.write(read);
				}
			}
		}catch(Exception e){
			response.setContentType("text/html;charset=utf-8");
			System.out.println("<script type='text/javascript'>");
			System.out.println("alert('파일 오픈 중 오류가 발생하였습니다.');");
			System.out.println("</script>");
			return "/index";
		}finally{
			
			if(outs != null) fin.close();
			if(fin != null) outs.close();
			
		}
//		inputStream = new FileInputStream(file);  //read the file
//		int c;
//		while ((c = ((BufferedInputStream) inputStream).read()) != -1) {
//			response.getWriter().write(c);
//		}
		return "/index";
	}
}
