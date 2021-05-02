<%-- 
    Document   : register
    Created on : Apr 12, 2021, 10:02:15 AM
    Author     : Philip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
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
                                                <li><a href="#">asdav</a></li>
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
        <div class="flex flex-col items-center justify-start">
            <div class="min-h-screen p-12 bg-white sm:w-8/12 md:w-full lg:w-8/12">
                <h1 class="text-xl font-semibold">Hello there 👋, <span class="font-normal">please fill in your information to continue</span></h1>
                <form class="mt-6" action="CompanyControl" method="POST">
                    <div class="flex justify-between gap-3">
                        <span class="w-1/2">
                            <label for="firstName" class="block text-xs font-semibold text-gray-600 uppercase">Firstname</label>
                            <input id="firstName" type="text" name="firstName" placeholder="John" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                        <span class="w-1/2">
                            <label for="lastName" class="block text-xs font-semibold text-gray-600 uppercase">Lastname</label>
                            <input id="lastName" type="text" name="lastName" placeholder="Doe" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                    </div>
                    <div class="flex justify-between gap-3">
                        <span class="w-1/2">
                            <label for="email" class="block mt-2 text-xs font-semibold text-gray-600 uppercase">E-mail</label>
                            <input id="email" type="email" name="email" placeholder="john.doe@company.com" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                        <span class="w-1/2">
                            <label for="phoneNumber" class="block mt-2 text-xs font-semibold text-gray-600 uppercase">Phone Number</label>
                            <input id="phoneNumber" type="tel" name="phoneNumber" placeholder="+250788888888" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                    </div>
                    <div class="flex justify-between gap-3">
                        <span class="w-1/2">
                            <label for="companyName" class="block mt-2 text-xs font-semibold text-gray-600 uppercase">Company Name</label>
                            <input id="companyName" type="text" name="companyName" placeholder="Company A" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                        <span class="w-1/2">
                            <label for="companySize" class="block mt-2 text-xs font-semibold text-gray-600 uppercase">company Size</label>
                            <select name="companySize" id="companySize" class="block w-full border-gray-300 rounded-lg mt-2 shadow-sm bg-gray-200 focus:outline-none focus:bg-gray-300 focus:shadow-inner" required >
                                <option value="-1">How many cars?</option>
                                <option value="1-10">1 - 10</option>
                                <option value="11-50">11 - 50</option>
                                <option value="51-250">51 - 250</option>
                            </select>
                        </span>

                    </div>

                    <div class="flex justify-between gap-3">
                        <span class="w-1/2">
                            <label for="password" class="block mt-2 text-xs font-semibold text-gray-600 uppercase">Password</label>
                            <input id="password" type="password" name="password" placeholder="********" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                        <span class="w-1/2">
                            <label for="passwordConfirm" class="block mt-2 text-xs font-semibold text-gray-600 uppercase">Confirm password</label>
                            <input id="passwordConfirm" type="password" name="passwordConfirm" placeholder="********" class="block w-full border-gray-300 rounded-lg mt-2 text-gray-700 bg-gray-200 appearance-none focus:outline-none focus:bg-gray-300 focus:shadow-inner" required />
                        </span>
                    </div>


                    <input id="hidden" type="text" name="action" value="addcompany" hidden />
                    <button type="submit" class="w-full py-3 mt-6 font-medium tracking-widest text-white uppercase bg-black shadow-lg focus:outline-none hover:bg-gray-900 hover:shadow-none">
                        Sign up
                    </button>
                    <div class="text-center text-sm text-grey-dark mt-4">
                        By signing up, you agree to the 
                        <a class="no-underline border-b border-grey-dark text-blue-400" href="#">
                            Terms of Service
                        </a> and 
                        <a class="no-underline border-b border-grey-dark text-blue-400" href="#">
                            Privacy Policy
                        </a>
                        <div class="text-grey-dark mt-4">
                            Already have an account? 
                            <a class="no-underline border-b border-blue text-blue" href="../login/">
                                Log in
                            </a>.
                        </div>
                </form>
            </div>
        </div>
    </div>
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


    <!--<script src="./assets/js/plugins.js"></script>-->
    <script src="./assets/js/main.js"></script>
</body>
</html>