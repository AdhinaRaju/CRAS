<%-- 
    Document   : registration
    Created on : 15 Mar, 2019, 12:33:52 PM
    Author     : user
--%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <jsp:useBean class="DBConnection.connection" id="obj"></jsp:useBean>   
    <html lang="en">

<head>
    <!-- Required meta tags-->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Colorlib Templates">
    <meta name="author" content="Colorlib">
    <meta name="keywords" content="Colorlib Templates">

    <!-- Title Page-->
    <title>Register </title>

    <!-- Icons font CSS-->
    <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <!-- Font special for pages-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet">

    <!-- Vendor CSS-->
    <link href="vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <link href="vendor/datepicker/daterangepicker.css" rel="stylesheet" media="all">

    <!-- Main CSS-->
    <link href="css/main.css" rel="stylesheet" media="all">
</head>

<body>
<%
            if(request.getParameter("btnreg")!=null)
            {                
                String name=request.getParameter("txtname");
                String dob=request.getParameter("txtdob");
                String gender=request.getParameter("gender");  
                String job=request.getParameter("job");  
                String phno=request.getParameter("txtphno");
                String email=request.getParameter("txtemail");
                String username=request.getParameter("txtusername");
                String pass=request.getParameter("txtpassword");
                String ins="insert into tbl_empreg(emp_name,emp_dob,emp_gender,emp_phno,emp_job,emp_email,emp_username,emp_password)values('"+name+"','"+dob+"','"+gender+"','"+phno+"','"+job+"','"+email+"','"+username+"','"+pass+"')";
                //out.println(ins);
                boolean b=obj.insert(ins);                
                if(b)
                {
                    out.println("inserted");
                    response.sendRedirect("../Login/login.jsp");
                }
                else
                {
                    out.println("not inserted");
                }                       
            }
                





%>
    
    <div class="page-wrapper bg-blue p-t-100 p-b-100 font-robo">
        <div class="wrapper wrapper--w680">
            <div class="card card-1">
                <div class="card-heading"></div>
                <div class="card-body">
                    <h2 class="title">Registration Info</h2>
    <!--  form   starts here  -->
                    <form method="POST" name="regstration">
                        <div class="input-group">
                            <input class="input--style-1" type="text" placeholder="NAME" name="txtname">
                        </div>
                        <div class="row row-space">
                            
                                <div class="input-group">
                                    <input class="input--style-1 js-datepicker" type="text" placeholder="BIRTHDATE" name="txtdob">
                                    <i class="zmdi zmdi-calendar-note input-icon js-btn-calendar"></i>
                                </div>
                            
                        </div>
                           <!-- <div class="col-2">-->
                                <div class="input-group">
                                    <div class="rs-select2 js-select-simple select--no-search">
                                        GENDER<select name="gender" >
                                            <!--<option>GENDER</option>-->
                                            <option value="male">Male</option>
                                            <option value="female">Female</option>
                                            <option value="other">Other</option>
                                        </select>
                                        <div class="select-dropdown"></div>
                                    </div>
                                </div>
                            <!--</div>-->
                        
                        <div class="input-group">
                            <div class="rs-select2 js-select-simple select--no-search">
                                <select name="job">
                                    <option>JOB POSITION</option>
                                    <option value="L1">L1</option>
                                    <option value="L2">L2</option>
                                    
                                </select>
                                <div class="select-dropdown"></div>
                            </div>
                        </div>
                            
                        <div class="input-group">
                            <input class="input--style-1" type="text" placeholder="PHONE NUMBER" name="txtphno">
                        </div> 
                        <div class="input-group">
                            <input class="input--style-1" type="email" placeholder="Email" name="txtemail">
                        </div>    
                            
                        <!--<div class="col-2">-->
                        <div class="row row-space">
                            
                                <div class="input-group">
                                    <input class="input--style-1" type="text" placeholder="USER NAME" name="txtusername">
                                </div>
                            </div>
                        
                        
                        <div class="row row-space">
                            
                                <div class="input-group">
                                    <input class="input--style-1" type="text" placeholder="PASSWORD" name="txtpassword">
                                </div>
                            
                        </div>
                        <!--</div>-->
                        <div class="p-t-20">
                            <button class="btn btn--radius btn--green" type="submit" name="btnreg">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- Jquery JS-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <!-- Vendor JS-->
    <script src="vendor/select2/select2.min.js"></script>
    <script src="vendor/datepicker/moment.min.js"></script>
    <script src="vendor/datepicker/daterangepicker.js"></script>

    <!-- Main JS-->
    <script src="js/global.js"></script>
    

</body><!-- This templates was made by Colorlib (https://colorlib.com) -->

</html>
