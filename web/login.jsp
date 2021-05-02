<%-- 
    Document   : login
    Created on : Apr 12, 2021, 7:57:23 PM
    Author     : Philip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Ticket Booking</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

        <!-- CSS here -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/css/flaticon.css">

        <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="assets/css/themify-icons.css">

        <link rel="stylesheet" href="assets/css/style.css">
        <link rel="stylesheet" href="assets/tailwind.css">
    </head>

    <body>

        <!-- Preloader Start -->
        <!-- <div id="preloader-active">
            <div class="preloader d-flex align-items-center justify-content-center">
                <div class="preloader-inner position-relative">
                    <div class="preloader-circle"></div>
                    <div class="preloader-img pere-text">
                        <img src="assets/img/logo/logo.png" alt="">
                    </div>
                </div>
            </div>
        </div> -->
        <!-- Preloader Start -->
        <header>
            <!-- Header Start -->
            <div class="header-area">
                <div class="main-header ">
                    <div class="header-top top-bg d-none d-lg-block">
                        <div class="container">
                            <div class="row justify-content-between align-items-center">
                                <div class="col-lg-8">
                                    <div class="header-info-left">
                                        <ul>                          
                                            <li>needhelp@gotrip.com</li>
                                            <li>666 569 025077</li>
                                            <li>broklyn street new york</li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-4">
                                    <div class="header-info-right f-right">

                                        <ul class="header-social">    
                                            <li><a href="#"><i class="fab fa-twitter"></i></a></li>
                                            <li><a href="#"><i class="fab fa-linkedin-in"></i></a></li>
                                            <li><a href="#"><i class="fab fa-facebook-f"></i></a></li>
                                            <li> <a href="#"><i class="fab fa-pinterest-p"></i></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="header-bottom  header-sticky">
                        <div class="container">
                            <div class="row align-items-center">
                                <!-- Logo -->
                                <div class="col-xl-2 col-lg-2 col-md-1">
                                    <div class="logo">
                                        <a href="index.html"><img src="assets/img/logo/logo.png" alt=""></a>
                                    </div>
                                </div>
                                <div class="col-xl-10 col-lg-10 col-md-10">
                                    <!-- Main-menu -->
                                    <div class="main-menu f-right d-none d-lg-block">
                                        <nav>               
                                            <ul id="navigation">                                                                                                                                     
                                                <li><a href="index.html">Home</a></li>
                                                <li><a href="#">Book</a></li>
                                                <li><a href="#">Company</a></li>
                                                <li><a href="register.jsp">register</a></li>
                                            </ul>
                                        </nav>
                                    </div>

                                </div>
                                <!-- Mobile Menu -->
                                <div class="col-12">
                                    <div class="mobile_menu d-block d-lg-none"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Header End -->
        </header>

        <section class="flex flex-col md:flex-row w-full h-2/5 items-center">
            <div class="bg-white w-full md:max-w-md lg:max-w-full md:mx-auto md:mx-0 md:w-1/2 xl:w-1/3 h-200 px-6 lg:px-16 xl:px-12
                 flex items-center justify-center">

                <div class="w-full h-100">

                    <%
                        if (request.getAttribute("message") != null) {
                            String message = (String) request.getAttribute("message");
                    %>
                    <div class="container px-1 py-1" id="alertbox">
                        <div class="container bg-red-500 flex items-center text-white text-sm font-bold px-4 py-3 relative"
                             role="alert">
                            <svg class="fill-current w-4 h-4 mr-2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                            <path
                                d="M12.432 0c1.34 0 2.01.912 2.01 1.957 0 1.305-1.164 2.512-2.679 2.512-1.269 0-2.009-.75-1.974-1.99C9.789 1.436 10.67 0 12.432 0zM8.309 20c-1.058 0-1.833-.652-1.093-3.524l1.214-5.092c.211-.814.246-1.141 0-1.141-.317 0-1.689.562-2.502 1.117l-.528-.88c2.572-2.186 5.531-3.467 6.801-3.467 1.057 0 1.233 1.273.705 3.23l-1.391 5.352c-.246.945-.141 1.271.106 1.271.317 0 1.357-.392 2.379-1.207l.6.814C12.098 19.02 9.365 20 8.309 20z" />
                            </svg>
                            <p class="text-sm text-white"><%=message%></p>

                            <span class="absolute top-0 bottom-0 right-0 px-4 py-3 closealertbutton">
                                <svg class="fill-current h-6 w-6 text-white" role="button" xmlns="http://www.w3.org/2000/svg"
                                     viewBox="0 0 20 20">
                                <title>Close</title>
                                <path
                                    d="M14.348 14.849a1.2 1.2 0 0 1-1.697 0L10 11.819l-2.651 3.029a1.2 1.2 0 1 1-1.697-1.697l2.758-3.15-2.759-3.152a1.2 1.2 0 1 1 1.697-1.697L10 8.183l2.651-3.031a1.2 1.2 0 1 1 1.697 1.697l-2.758 3.152 2.758 3.15a1.2 1.2 0 0 1 0 1.698z" />
                                </svg>
                            </span>
                        </div>
                    </div>
                    <%}%>

                    <h1 class="text-xl md:text-2xl font-bold leading-tight mt-6">Log in to your account</h1>

                    <form class="mt-6" action="CompanyControl" method="GET">
                        <div>
                            <label class="block text-gray-700">Email Address</label>
                            <input type="email" name="email" id="" placeholder="Enter Email Address" class="w-full px-4 py-2 rounded-lg bg-gray-200 mt-2 border focus:border-blue-500 focus:bg-white focus:outline-none" autofocus autocomplete required>
                        </div>

                        <div class="mt-4">
                            <label class="block text-gray-700">Password</label>
                            <input type="password" name="password" id="" placeholder="Enter Password" minlength="6" class="w-full px-4 py-2 rounded-lg bg-gray-200 mt-2 border focus:border-blue-500
                                   focus:bg-white focus:outline-none" required>
                        </div>

                        <div class="text-right mt-2">
                            <a href="#" class="text-sm font-semibold text-gray-700 hover:text-blue-700 focus:text-blue-700">Forgot Password?</a>
                        </div>

                        <input type="text" name="action" hidden="" value="login">
                        <button type="submit" class="w-full block bg-indigo-500 hover:bg-indigo-400 focus:bg-indigo-400 text-white font-semibold rounded-lg
                                px-4 py-2 mt-6">Log In</button>
                    </form>

                    <hr class="my-6 border-gray-300 w-full">

                    <p class="mt-8">Need an account? <a href="register.jsp" class="text-blue-500 hover:text-blue-700 font-semibold">Create an
                            account</a></p>


                </div>
            </div>

        </section>
        <footer>
            <!-- Footer Start-->
            <div class="footer-area footer-padding footer-bg" data-background="assets/img/service/footer_bg.jpg">
                <div class="container">
                    <div class="row d-flex justify-content-between">
                        <div class="col-xl-3 col-lg-3 col-md-5 col-sm-6">
                            <div class="single-footer-caption mb-50">
                                <div class="single-footer-caption mb-30">
                                    <!-- logo -->
                                    <div class="footer-logo">
                                        <a href="index.html"><img src="assets/img/logo/logo.png" alt=""></a>
                                    </div>
                                    <div class="footer-tittle">
                                        <div class="footer-pera">
                                            <p>skksdjksjdksjckdsjckdhcksjcnkjs js dkjsskd js dkjn jdskcksjkhdskjchjskd kjdssakdhsjakdhjak cddjsgjkdhsjjkshkj dskdhjksgjdghksgkdjhk.</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-2 col-lg-3 col-md-3 col-sm-5">
                            <div class="single-footer-caption mb-50">
                                <div class="footer-tittle">
                                    <h4>Quick Links</h4>
                                    <ul>
                                        <li><a href="#"> Home</a></li>
                                        <li><a href="#">About</a></li>
                                        <li><a href="#">Book</a></li>
                                        <li><a href="#">  Contact Us</a></li>
                                        <li><a href="#">  Login</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-xl-3 col-lg-3 col-md-5 col-sm-7">
                            <div class="single-footer-caption mb-50">
                                <div class="footer-tittle">
                                    <aside class="single_sidebar_widget newsletter_widget">
                                        <h4 class="widget_title">Contact Us</h4>
                                        <form action="#">
                                            <div class="form-group">
                                                <input type="email" class="form-control"  placeholder="Enter email" required=""><br>
                                                <textarea type="textarea" class="form-control"  placeholder="Message" required=""></textarea>
                                            </div>
                                            <input type="text" name="action" hidden="" value="login">
                                            <button class="button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn" type="submit">Send</button>
                                        </form>
                                    </aside>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Footer bottom -->
                    <div class="row pt-padding">
                        <div class="col-xl-12 col-lg-12 col-md-12">
                            <div class="footer-copy-right">
                                <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved 	</p>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
            <!-- Footer End-->
        </footer>

        <!-- JS here -->

        <!-- All JS Custom Plugins Link Here here -->
        <script src="./assets/js/vendor/modernizr-3.5.0.min.js"></script>

        <!-- Jquery, Popper, Bootstrap -->
        <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="./assets/js/popper.min.js"></script>
        <script src="./assets/js/bootstrap.min.js"></script>
        <!-- Jquery Mobile Menu -->
        <script src="./assets/js/jquery.slicknav.min.js"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="./assets/js/owl.carousel.min.js"></script>
        <script src="./assets/js/slick.min.js"></script>


        <!-- Scrollup, nice-select, sticky -->
        <script src="./assets/js/jquery.scrollUp.min.js"></script>
        <script src="./assets/js/jquery.nice-select.min.js"></script>
        <script src="./assets/js/jquery.sticky.js"></script>


        <script src="./assets/js/plugins.js"></script>
        <script src="./assets/js/main.js"></script>

        <script>
                                    $(".closealertbutton").click(function (e) {

                                        pid = $(this).parent().parent().hide(500)
                                        console.log(pid)
                                    })
                                    if (window.history.replaceState) {
                                        window.history.replaceState(null, null, window.location.href);
                                    }
        </script>
    </body>
</html>
