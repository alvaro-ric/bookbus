<%-- 
    Document   : confirmpayment
    Created on : May 1, 2021, 8:08:29 PM
    Author     : Philip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- 
    Document   : availablejourneys
    Created on : May 1, 2021, 3:53:03 PM
    Author     : Philip
--%>

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
        <link rel="stylesheet" href="./assets/tailwind.css">

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

        <main class="container" style="height: 50vh;">

            
            <div class="flex w-2/3 max-w-sm max-h-56 mx-auto overflow-hidden bg-white rounded-lg shadow-md dark:bg-gray-800">
                <div class="flex items-center justify-center w-24 bg-green-500">
                    <svg class="w-6 h-6 text-white fill-current" viewBox="0 0 40 40" xmlns="http://www.w3.org/2000/svg">
                    <path d="M20 3.36667C10.8167 3.36667 3.3667 10.8167 3.3667 20C3.3667 29.1833 10.8167 36.6333 20 36.6333C29.1834 36.6333 36.6334 29.1833 36.6334 20C36.6334 10.8167 29.1834 3.36667 20 3.36667ZM19.1334 33.3333V22.9H13.3334L21.6667 6.66667V17.1H27.25L19.1334 33.3333Z"/>
                    </svg>
                </div>

                <div class="px-4 py-2 -mx-3">
                    <div class="mx-3">
                        <span class="font-semibold text-green-500 dark:text-red-400">Success!!!</span>
                        <p class="text-base text-gray-800 dark:text-gray-200">You have successfully purchased your ticket 
                            you may check your phone for a confirmation message</p>

                        <a href="homepage.jsp" class="mt-2 focus:outline-none text-blue-600 text-sm py-1.5 px-4 rounded-md border border-blue-600 hover:bg-blue-600 hover:text-white flex items-center">
                            <svg class="w-4 h-4 mr-2" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z" />
                            </svg>
                            Go Back To Homepage
                        </a>
                    </div>
                </div>
            </div>
            
           <%
               session.removeAttribute("passenger");
               session.removeAttribute("journey");
           %> 

        </main>
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
                                        <form action="">
                                            <div class="form-group">
                                                <input type="email" class="form-control"  placeholder="Enter email" required=""><br>
                                                <textarea type="textarea" class="form-control"  placeholder="Message" required=""></textarea>
                                            </div>
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

    </body>
</html>

