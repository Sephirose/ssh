package cn.tedu.ems.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class View {

	@RequestMapping("/test.do")
	public void login(HttpServletResponse response) throws Exception {
		String templatePath = "D:\\template2.doc";  
	      InputStream is = new FileInputStream(templatePath);  
	      HWPFDocument doc = new HWPFDocument(is);  
	      Range range = doc.getRange();  
	      //把range范围内的${reportDate}替换为当前的日期  
	      range.replaceText("${reportDate}", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));  
	      range.replaceText("${appleAmt}", "100.00");  
	      range.replaceText("${bananaAmt}", "200.00");  
	      range.replaceText("${totalAmt}", "300.00"); 
	      range.replaceText("${price}", "10.00");
	      OutputStream os=response.getOutputStream();
	      //OutputStream os = new FileOutputStream("D:\\write2.doc");  
	      //把doc输出到输出流中  
	      doc.write(os);
	}
	
}
