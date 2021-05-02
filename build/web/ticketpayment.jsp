<%-- 
    Document   : ticketpayment
    Created on : May 1, 2021, 7:45:46 PM
    Author     : Philip
--%>

<%@page import="model.Passenger"%>
<%@page import="model.Journey"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zxx">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Ticket Deatils | Ticket Booking</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.png">

		<!-- CSS here -->
            <link rel="stylesheet" href="assets/css/bootstrap.min.css">
            <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
            <link rel="stylesheet" href="assets/css/flaticon.css">
            <link rel="stylesheet" href="assets/css/slicknav.css">
            <link rel="stylesheet" href="assets/css/animate.min.css">
            <link rel="stylesheet" href="assets/css/magnific-popup.css">
            <link rel="stylesheet" href="assets/css/fontawesome-all.min.css">
            <link rel="stylesheet" href="assets/css/themify-icons.css">
            <link rel="stylesheet" href="assets/css/slick.css">
            <link rel="stylesheet" href="assets/css/nice-select.css">
            <link rel="stylesheet" href="assets/css/style.css">
   </head>

   <body>
       <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            Journey journey = null;
            Passenger passenger = null;
            if (session.getAttribute("journey") == null || session.getAttribute("passenger") == null) {
                response.sendRedirect("homepage.jsp");
            } else {
                journey = (Journey)session.getAttribute("journey");
                passenger = (Passenger)session.getAttribute("passenger");
            }
        %>
    <!-- Preloader Start -->
    <div id="preloader-active">
        <div class="preloader d-flex align-items-center justify-content-center">
            <div class="preloader-inner position-relative">
                <div class="preloader-circle"></div>
                <div class="preloader-img pere-text">
                    <img src="assets/img/logo/logo.png" alt="">
                </div>
            </div>
        </div>
    </div>
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
                                    <li>Info@ticket.rw</li>
                                    <li>+250 788 888 888</li>
                                    <li>Kigali, Rwanda</li>
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

    <main>

  
        <!-- Our Services Start -->
        <div class="our-services ">
            <div class="container">
            	<!-- Section Tittle -->
                <div class="row">
                    <div class="col-lg-12">
                        <h3 class="mb-30">Ticket Details</h3>
                    </div>
                    <div class="col-lg-6">
                        <blockquote class="generic-blockquote">
                             <b>Company:</b> <%=journey.getCompany().getName()%><br>
                             <b>Route:</b> <%=journey.getRoute().getSource()%> - <%=journey.getRoute().getDestination()%><br>
                             <b>Time:</b> <%=journey.getDepartureDate()%> <%=journey.getDepartureTime()%><br>
                             <b>Price:</b> <%=journey.getPrice()%><br>
                        </blockquote>
                    </div>
                     <div class="col-lg-6">
                        <blockquote class="generic-blockquote">
                             <b>First Name</b> <%=passenger.getFirstName()%><br>
                             <b>Last Name</b> <%=passenger.getLastName()%><br>
                             <b>Phone Number</b> <%=journey.getDepartureDate()%> <%=journey.getDepartureTime()%><br> 
                        </blockquote>
                    </div>
                    <div class="col-lg-12 col-md-12" style="text-align: center;">
                        <a href="#" class="genric-btn danger radius" >Cancel</a><br><br>
                            <div class="mt-10"><p>Pay with:
                                <a href="PassengerControl?action=payticket" class="genric-btn warning"> MOMO</a>
                                <a href="#" class="genric-btn info">PayPal</a>
                                <a href="#" class="genric-btn success">Debit / Credit Card</a></p>

                            </div>
                       </div>
                </div>
                
                 <div class="row">
                    <div class="col-lg-12">
                        <div class="section-tittle text-center">
                            <h2></h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
         <!-- Our Services End -->
        
     

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
		<!-- One Page, Animated-HeadLin -->
        <script src="./assets/js/wow.min.js"></script>
		<script src="./assets/js/animated.headline.js"></script>
        <script src="./assets/js/jquery.magnific-popup.js"></script>

		<!-- Scrollup, nice-select, sticky -->
        <script src="./assets/js/jquery.scrollUp.min.js"></script>
        <script src="./assets/js/jquery.nice-select.min.js"></script>
		<script src="./assets/js/jquery.sticky.js"></script>
        
        <!-- contact js -->
        <script src="./assets/js/contact.js"></script>
        <script src="./assets/js/jquery.form.js"></script>
        <script src="./assets/js/jquery.validate.min.js"></script>
        <script src="./assets/js/mail-script.js"></script>
        <script src="./assets/js/jquery.ajaxchimp.min.js"></script>
        
		<!-- Jquery Plugins, main Jquery -->	
        <script src="./assets/js/plugins.js"></script>
        <script src="./assets/js/main.js"></script>
        
    </body>
</html>
