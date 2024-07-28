package controller.client;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import connect.Dao;
import jakarta.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class CliAddImgPro
 */
@WebServlet("/CliAddImgPro")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
	    maxFileSize = 1024 * 1024 * 10,      // 10 MB
	    maxRequestSize = 1024 * 1024 * 50    // 50 MB
	)
public class CliAddImgPro extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Dao dao = new Dao();
		InputStream inputStream;
		System.out.println("yyyyyy");
		javax.servlet.http.HttpSession session = request.getSession();
		Integer idProduct = (Integer) session.getAttribute("idProduct");
		for (Part part : request.getParts()) {
            if (part.getName().equals("imageFiles") && part.getSize() > 0) {
                String fileName = part.getSubmittedFileName();
                inputStream = part.getInputStream();
                System.out.println("có lấy dc hình k");
               dao.insertImgProduct(idProduct, inputStream);
            }
        }
		session.removeAttribute("idProduct");
	}

}
