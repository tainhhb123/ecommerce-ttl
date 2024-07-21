<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
=======
>>>>>>> 3fc53370ae0a56ed70bcb01ca87d24a9257daf9d
<!DOCTYPE html>
<html lang="en"> 
<head>
    <title>TTL</title>
    
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="description" >
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
    <link rel="shortcut icon" href="favicon.ico"> 
    
    <!-- FontAwesome JS-->
    <script defer src="assets/plugins/fontawesome/js/all.min.js"></script>
    
    <!-- App CSS -->  
    <link id="theme-style" rel="stylesheet" href="assets/css/portal.css">

</head> 

<body class="app app-login p-0">    	
    <div class="row g-0 app-auth-wrapper">
	    <div class="col-12 col-md-7 col-lg-6 auth-main-col text-center p-5">
		    <div class="d-flex flex-column align-content-end">
			    <div class="app-auth-body mx-auto">	
				    <div class="app-auth-branding mb-4"><a class="app-logo" href="index.jsp"><img class="logo-icon me-2" src="assets/images/app-logo.svg" alt="logo"></a></div>
					<h2 class="auth-heading text-center mb-5">Log in to TTL</h2>
			        <div class="auth-form-container text-start">
<<<<<<< HEAD
			        
						<form class="auth-form login-form" method="post" action="LoginServlet">         
							<div class="email mb-3">
								<label class="sr-only" for="signin-email">Email</label>
								<input id="signin-email" name="signin-email" type="email" class="form-control signin-email" placeholder="Email address" required="required">
							</div><!--//form-group-->
							<div class="password mb-3">
								<label class="sr-only" for="signin-password">Password</label>
								<input id="signin-password" name="signin-password" type="password" class="form-control signin-password" placeholder="Password" required="required">
								<div class="extra mt-3 row justify-content-between">
									<div class="col-6">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value="" id="RememberPassword">
											<label class="form-check-label" for="RememberPassword">
											Remember me
											</label>
										</div>
									</div><!--//col-6-->
=======
						<form class="auth-form login-form" action="Login" method="post">  
						<c:set var="signal" value="${requestScope.signal}" />
							<c:if test="${not empty signal}">
								
								<p style="color: red;" >${signal}</p>
							
							</c:if>       
							<div class="email mb-3">
								<label class="sr-only" for="signin-email">UserName</label>
								<input id="signin-email" name="user-name" type="text" class="form-control signin-email" placeholder="UserName" ">
							</div><!--//form-group-->
							<div class="password mb-3">
								<label class="sr-only" for="signin-password">Password</label>
								<input id="signin-password" name="password" type="password" class="form-control signin-password" placeholder="Password" required="required">
								<div class="extra mt-3 row justify-content-between">
									<div class="col-6"></div><!--//col-6-->
>>>>>>> 3fc53370ae0a56ed70bcb01ca87d24a9257daf9d
									<div class="col-6">
										<div class="forgot-password text-end">
											<a href="reset-password.jsp">Forgot password?</a>
										</div>
									</div><!--//col-6-->
								</div><!--//extra-->
							</div><!--//form-group-->
							<div class="text-center">
								<button type="submit" class="btn app-btn-primary w-100 theme-btn mx-auto">Log In</button>
							</div>
						</form>
						
<<<<<<< HEAD
						
=======
>>>>>>> 3fc53370ae0a56ed70bcb01ca87d24a9257daf9d
						<div class="auth-option text-center pt-5">No Account? Sign up <a class="text-link" href="signup.jsp" >here</a>.</div>
					</div><!--//auth-form-container-->	

			    </div><!--//auth-body-->
		    
			    <footer class="app-auth-footer">

			    </footer><!--//app-auth-footer-->	
		    </div><!--//flex-column-->   
	    </div><!--//auth-main-col-->
	    <div class="col-12 col-md-5 col-lg-6 h-100 auth-background-col">
		    <div class="auth-background-holder">
		    </div>
		    <div class="auth-background-mask"></div>
		    <div class="auth-background-overlay p-3 p-lg-5">
			    <div class="d-flex flex-column align-content-end h-100">
				    <div class="h-100"></div>
				    <div class="overlay-content p-3 p-lg-4 rounded">
					    <h5 class="mb-3 overlay-title">TTL</h5>
<<<<<<< HEAD
					    <div>SÃ n thÆ°Æ¡ng máº¡i Äiá»n tá»­ vá» thá»i trang vÃ  lÃ  diá»n ÄÃ n nÆ¡i chia sáº½ cÃ¡c kiáº¿n thá»©c, quan Äiá»m hay phong cÃ¡ch thá»i trang riÃªng</div>
=======
					    <div>Sàn thương mại điện tử về thời trang và là diễn đàn nơi chia sẽ các kiến thức, quan điểm hay phong cách thời trang riêng</div>
>>>>>>> 3fc53370ae0a56ed70bcb01ca87d24a9257daf9d
				    </div>
				</div>
		    </div><!--//auth-background-overlay-->
	    </div><!--//auth-background-col-->
    
    </div><!--//row-->
<<<<<<< HEAD
 <% if (request.getParameter("error") != null) { %>
        <p style="color:red;">Invalid email or password.</p>
    <% } %>
=======

>>>>>>> 3fc53370ae0a56ed70bcb01ca87d24a9257daf9d

</body>
</html> 

