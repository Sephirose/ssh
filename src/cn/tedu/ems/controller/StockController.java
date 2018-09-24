package cn.tedu.ems.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.tedu.ems.dao.StockDAO;
import cn.tedu.ems.entity.Stock;
import cn.tedu.ems.service.ApplicationException;

@Controller
public class StockController {

	@Resource(name = "stockDAO")
	private StockDAO stockDAO;

	@RequestMapping("/toStock.do")
	public String toStock() {
		return "stock";

	}

	@RequestMapping("/quoto.do")
	public void listAllstocks(HttpServletResponse response,HttpServletRequest request) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		List<Stock> stocks = stockDAO.findAll();
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("stock", stocks);
		data.put("name", "john");
		data.put("value", 123);
		request.setAttribute("data", data);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(stocks);
		System.out.println(json);
		out.println(json);

	}

	@ExceptionHandler
	public String handleException(Exception e, HttpServletRequest request) {
		System.out.println("handleException()");
		if (e instanceof ApplicationException) {
			// 应用异常，明确提示用户
			request.setAttribute("login_failed", e.getMessage());
			return "login";
		}
		// 系统异常，提示用户稍后重试
		return "error";
	}

}
