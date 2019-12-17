package com.cafe24.radev.pyw.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cafe24.radev.pyw.mapper.EmployeeMapper;
import com.cafe24.radev.pyw.mapper.UserMapper;
import com.cafe24.radev.pyw.vo.CarFactory;
import com.cafe24.radev.pyw.vo.Employee;
import com.cafe24.radev.pyw.vo.ImageFile;

@Service
public class UserService {

	@Value("${static.file.upload.path}")
	private String location;
	
	@Autowired
	private UserMapper userMapper;	 
	@Autowired
	private EmployeeMapper employeeMapper;
	
	String bsCode = null;
	
	public int addCarFactory(CarFactory carFactory){
		System.out.println("이때는 코드값이 없쥬?" + carFactory);
		int max = userMapper.bsCodeMax();
		max = max + 1;
		String code = "bs00";
		bsCode = code + max;
		carFactory.setBsCode(bsCode);
		System.out.println("코드증가하나요ㅠㅠ--------->" + carFactory.toString());
		return userMapper.addCarFactory(carFactory);
	}
	
	public int addDocumentFile(MultipartFile bs_docu) {
		ImageFile imageFile = new ImageFile();
		
		int max = userMapper.imageCodeMax();
		max = max + 1;
		String code = "image0";
		String imgeCode = code + max;
		imageFile.setImageCode(imgeCode);
		
		if(bs_docu != null) {			
			String filename = StringUtils.cleanPath(bs_docu.getOriginalFilename());				
		
			try (InputStream inputStream = bs_docu.getInputStream()) {
				
				Files.copy(inputStream, Paths.get(location).resolve(filename),
						StandardCopyOption.REPLACE_EXISTING);				
				imageFile.setBsCode(bsCode);
				imageFile.setFileSize(bs_docu.getSize());
				imageFile.setRealFileName(bs_docu.getOriginalFilename());
				
				System.out.println(imageFile.getRealFileName() + " << 실제 업로드된 파일명");
				System.out.println(bs_docu.getContentType() + " << 실제 업로드된 파일명");	
				System.out.println(imageFile.getFileSize() + " << 실제 업로드된 사이즈");				
				System.out.println("/" + location + "/ " +filename+ " <<<<<<<<<<<< 저장 경로");//고정으로 할꺼면 파일명,사이즈만 필요
				
			} catch (IOException e) {
				e.printStackTrace();				
				try {
					Files.delete(Paths.get(location).resolve(filename));
				}catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
		System.out.println(bsCode);
		System.out.println("imageFile객체에 담겼나요====>" + imageFile.toString());
		return userMapper.addDocumentFile(imageFile);
	}
	
	public List<CarFactory> carFactoryList(){
		return userMapper.carFactoryList();
	}
	
	public String selectImage(String bsCode) {
		return userMapper.selectImage(bsCode);
	}
	
	public int approvalCheck(String[] bsCode) {
		for(int i=0;i<bsCode.length;i++) {
			System.out.println("코드값--------->"+bsCode[i]);
		}
		return userMapper.approvalCheck(bsCode);
	}
/********************************************************************************************************로그인*/

	public Map<String,Object> adminLogin(CarFactory carFactory) {
		CarFactory c = userMapper.adminLogin(carFactory);
		String re = null;
		Map<String,Object> map = new HashMap<String,Object>();

		if(c != null && !"".equals(c.getBossId())) {
			if(carFactory.getBossPw().equals(c.getBossPw())){
				re="login";
				map.put("login", c);
			}else {
				re = "비밀번호 불일치";
			}
		}else {
			re = "아이디가 존재하지 않습니다";			
		}		
		map.put("re",re);
		return map;
	}
	
	public Map<String,Object> employeeLogin(Employee employee) {
		Employee e = employeeMapper.employeeLogin(employee);
		String re = null;
		Map<String,Object> map = new HashMap<String,Object>();
		
		if(e != null && !"".equals(e.getEmployeeCode())) {
			if(employee.getEmployeePass().equals(e.getEmployeePass())){
				re="login";
				map.put("login", e);
			}else {
				re = "비밀번호 불일치";
			}
		}else {
			re = "아이디가 존재하지 않습니다";			
		}		
		map.put("re",re);
		return map;
	}
}
