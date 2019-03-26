<%-- 
    Document   : login
    Created on : 12 Mar, 2019, 9:44:41 AM
    Author     : user
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean class="DBConnection.connection" id="obj"></jsp:useBean>
<html lang="en">
    <head>
    	<title>Login </title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100">
				<form class="login100-form validate-form p-l-55 p-r-55 p-t-178">
					<span class="login100-form-title">
						Sign In
					</span>
                                        
       <%
            if(request.getParameter("btnlogin")!=null)
            {
                String Username=request.getParameter("txtusername");  
                String Password=request.getParameter("txtpass");
                System.out.println(Username+""+Password);
                String sel="select * from  tbl_login where username='"+Username+"' and password='"+Password+"'";
                System.out.println(sel);
                ResultSet rs=obj.select(sel);
                if(rs.next())
                {
                    out.println("login sucsessful"); 
                    /*session.setAttribute("login_id",rs.getString("lid") );*/
                    response.sendRedirect("../Registration/registration.jsp");
                    
               }
                else
                {
                    out.println("failed");
                }            
            }
            
        %>
					<div class="wrap-input100 validate-input m-b-16" data-validate="Please enter username">
						<input name="txtusername" class="input100" type="text"  placeholder="Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate = "Please enter password">
						<input name="txtpass"class="input100" type="password"  placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="text-right p-t-13 p-b-23">
						<span class="txt1">
							
						</span>

						<a href="../Registration/registration.jsp" class="txt2">
							Register
						</a>
					</div>

					<div class="container-login100-form-btn">
						<button class="login100-form-btn" name="btnlogin">
							Sign in
						</button>
					</div>

					
				</form>
			</div>
		</div>
	</div>
	
	
<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>
