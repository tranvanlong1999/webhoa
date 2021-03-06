<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- sử dụng tiếng việt -->
<html>
<head>
 <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Page Title - Shop Milk Admin</title>
    <link href="static/css/styles.css" rel="stylesheet" type="text/css" media="all" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body class="bg-primary">
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">

                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-7">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header">
                                    <h3 class="text-center font-weight-light my-4">Create Account</h3>
                                </div>
                                <div class="card-body">
                                    <form:form method="POST">
                                        <div class="form-row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="inputFirstName">First Name</label>
                                                    <form:input class="form-control py-4" id="inputFirstName" type="text" path="firstName" placeholder="Enter first name" />
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="inputLastName">Last Name</label>
                                                    <form:input class="form-control py-4" id="inputLastName" type="text" path="lastName" placeholder="Enter last name" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="small mb-1" for="inputEmailAddress">Email</label>
                                            <form:input path="email" class="form-control py-4" id="inputEmailAddress" type="email" aria-describedby="emailHelp" placeholder="Enter email address" />
                                        </div>
                                        <div class="form-row">
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="inputPassword">Password</label>
                                                    <form:input path="pass" class="form-control py-4" id="inputPassword" type="password" placeholder="Enter password" />
                                                </div>
                                            </div>
                                            <div class="col-md-6">
                                                <div class="form-group">
                                                    <label class="small mb-1" for="inputConfirmPassword">Confirm Password</label>
                                                    <form:input path="RepeatPass" class="form-control py-4" id="inputConfirmPassword" type="password" placeholder="Confirm password" />
                                                </div>
                                            </div>
                                        </div>
                                        <div class="form-group mt-4 mb-0" align="center"><input type="submit" class="btn btn-success btn-send"
									value="Send message"></div>
                                    </form:form>
                                </div>
                                <div class="card-footer text-center">
                                    <div class="small"><a href="login.html">Have an account? Go to login</a></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

        </div>
        <div id="layoutAuthentication_footer">
            <footer class="py-4 bg-light mt-auto">
                <div class="container-fluid">
                    <div class="d-flex align-items-center justify-content-between small">
                        <div class="text-muted">Copyright &copy; Website Shop Milk 2021</div>
                        <div>
                            <a href="#">Privacy Policy</a> &middot;
                            <a href="#">Terms &amp; Conditions</a>
                        </div>
                    </div>
                </div>
            </footer>
        </div>
    </div>

 
</body>
</html>