package cn.tedu.ems.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileUpLoadController {

	@RequestMapping("/fileupload.do")
	public String fileUpLoad(HttpServletRequest request) {
		String adjunctname;
//		String fileDir = request.getRealPath("upload/");
		String fileDir ="D:"+File.separator+"upload"+File.separator;
		String message = "fileUpLoad success";
		String address = "";
		if (ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(20 * 1024);
			factory.setRepository(factory.getRepository());
			ServletFileUpload upload = new ServletFileUpload(factory);
			int size = 2 * 1024 * 1024;
			List<FileItem> formlists = null;

			try {
				formlists = upload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}

			Iterator<FileItem> iter = formlists.iterator();
			while (iter.hasNext()) {
				FileItem formitem = (FileItem) iter.next();
				if (!formitem.isFormField()) {
					String name = formitem.getName();
					if (formitem.getSize() > size) {
						message = "您上传的文件太大，请选择不超过2M的文件";
						break;
					}
					String adjunctsize = new Long(formitem.getSize()).toString();
					if ((name == null) || ((name.equals("")) && (adjunctsize.equals("0")))) {
						continue;
					}
					adjunctname = name.substring(name.lastIndexOf("\\") + 1, name.length());
					address = fileDir  + adjunctname;
					File saveFile = new File(address);
					if(!saveFile.exists()) {
						try {
							saveFile.createNewFile();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					try {
						formitem.write(saveFile);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		request.setAttribute("result", message);
		return "fileUpLoad";
	}

}
