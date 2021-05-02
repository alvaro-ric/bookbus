package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class availablejourneys_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html class=\"no-js\" lang=\"zxx\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"x-ua-compatible\" content=\"ie=edge\">\n");
      out.write("        <title>Ticket Booking</title>\n");
      out.write("        <meta name=\"description\" content=\"\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"assets/img/favicon.png\">\n");
      out.write("\n");
      out.write("        <!-- CSS here -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/flaticon.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/fontawesome-all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/themify-icons.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/css/style.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!-- Preloader Start -->\n");
      out.write("        <!-- <div id=\"preloader-active\">\n");
      out.write("            <div class=\"preloader d-flex align-items-center justify-content-center\">\n");
      out.write("                <div class=\"preloader-inner position-relative\">\n");
      out.write("                    <div class=\"preloader-circle\"></div>\n");
      out.write("                    <div class=\"preloader-img pere-text\">\n");
      out.write("                        <img src=\"assets/img/logo/logo.png\" alt=\"\">\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div> -->\n");
      out.write("        <!-- Preloader Start -->\n");
      out.write("        <header>\n");
      out.write("            <!-- Header Start -->\n");
      out.write("            <div class=\"header-area\">\n");
      out.write("                <div class=\"main-header \">\n");
      out.write("                    <div class=\"header-top top-bg d-none d-lg-block\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row justify-content-between align-items-center\">\n");
      out.write("                                <div class=\"col-lg-8\">\n");
      out.write("                                    <div class=\"header-info-left\">\n");
      out.write("                                        <ul>                          \n");
      out.write("                                            <li>needhelp@gotrip.com</li>\n");
      out.write("                                            <li>666 569 025077</li>\n");
      out.write("                                            <li>broklyn street new york</li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-lg-4\">\n");
      out.write("                                    <div class=\"header-info-right f-right\">\n");
      out.write("\n");
      out.write("                                        <ul class=\"header-social\">    \n");
      out.write("                                            <li><a href=\"#\"><i class=\"fab fa-twitter\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fab fa-linkedin-in\"></i></a></li>\n");
      out.write("                                            <li><a href=\"#\"><i class=\"fab fa-facebook-f\"></i></a></li>\n");
      out.write("                                            <li> <a href=\"#\"><i class=\"fab fa-pinterest-p\"></i></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"header-bottom  header-sticky\">\n");
      out.write("                        <div class=\"container\">\n");
      out.write("                            <div class=\"row align-items-center\">\n");
      out.write("                                <!-- Logo -->\n");
      out.write("                                <div class=\"col-xl-2 col-lg-2 col-md-1\">\n");
      out.write("                                    <div class=\"logo\">\n");
      out.write("                                        <a href=\"index.html\"><img src=\"assets/img/logo/logo.png\" alt=\"\"></a>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"col-xl-10 col-lg-10 col-md-10\">\n");
      out.write("                                    <!-- Main-menu -->\n");
      out.write("                                    <div class=\"main-menu f-right d-none d-lg-block\">\n");
      out.write("                                        <nav>               \n");
      out.write("                                            <ul id=\"navigation\">                                                                                                                                     \n");
      out.write("                                                <li><a href=\"index.html\">Home</a></li>\n");
      out.write("                                                <li><a href=\"#\">Book</a></li>\n");
      out.write("                                                <li><a href=\"#\">Company</a></li>\n");
      out.write("                                                <li><a href=\"register.jsp\">register</a></li>\n");
      out.write("                                            </ul>\n");
      out.write("                                        </nav>\n");
      out.write("                                    </div>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                                <!-- Mobile Menu -->\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("                                    <div class=\"mobile_menu d-block d-lg-none\"></div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Header End -->\n");
      out.write("        </header>\n");
      out.write("\n");
      out.write("        <main>\n");
      out.write("\n");
      out.write("           \n");
      out.write("            \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </main>\n");
      out.write("        <footer>\n");
      out.write("            <!-- Footer Start-->\n");
      out.write("            <div class=\"footer-area footer-padding footer-bg\" data-background=\"assets/img/service/footer_bg.jpg\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <div class=\"row d-flex justify-content-between\">\n");
      out.write("                        <div class=\"col-xl-3 col-lg-3 col-md-5 col-sm-6\">\n");
      out.write("                            <div class=\"single-footer-caption mb-50\">\n");
      out.write("                                <div class=\"single-footer-caption mb-30\">\n");
      out.write("                                    <!-- logo -->\n");
      out.write("                                    <div class=\"footer-logo\">\n");
      out.write("                                        <a href=\"index.html\"><img src=\"assets/img/logo/logo.png\" alt=\"\"></a>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"footer-tittle\">\n");
      out.write("                                        <div class=\"footer-pera\">\n");
      out.write("                                            <p>skksdjksjdksjckdsjckdhcksjcnkjs js dkjsskd js dkjn jdskcksjkhdskjchjskd kjdssakdhsjakdhjak cddjsgjkdhsjjkshkj dskdhjksgjdghksgkdjhk.</p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-2 col-lg-3 col-md-3 col-sm-5\">\n");
      out.write("                            <div class=\"single-footer-caption mb-50\">\n");
      out.write("                                <div class=\"footer-tittle\">\n");
      out.write("                                    <h4>Quick Links</h4>\n");
      out.write("                                    <ul>\n");
      out.write("                                        <li><a href=\"#\"> Home</a></li>\n");
      out.write("                                        <li><a href=\"#\">About</a></li>\n");
      out.write("                                        <li><a href=\"#\">Book</a></li>\n");
      out.write("                                        <li><a href=\"#\">  Contact Us</a></li>\n");
      out.write("                                        <li><a href=\"#\">  Login</a></li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"col-xl-3 col-lg-3 col-md-5 col-sm-7\">\n");
      out.write("                            <div class=\"single-footer-caption mb-50\">\n");
      out.write("                                <div class=\"footer-tittle\">\n");
      out.write("                                    <aside class=\"single_sidebar_widget newsletter_widget\">\n");
      out.write("                                        <h4 class=\"widget_title\">Contact Us</h4>\n");
      out.write("                                        <form action=\"\">\n");
      out.write("                                            <div class=\"form-group\">\n");
      out.write("                                                <input type=\"email\" class=\"form-control\"  placeholder=\"Enter email\" required=\"\"><br>\n");
      out.write("                                                <textarea type=\"textarea\" class=\"form-control\"  placeholder=\"Message\" required=\"\"></textarea>\n");
      out.write("                                            </div>\n");
      out.write("                                            <button class=\"button rounded-0 primary-bg text-white w-100 btn_1 boxed-btn\" type=\"submit\">Send</button>\n");
      out.write("                                        </form>\n");
      out.write("                                    </aside>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- Footer bottom -->\n");
      out.write("                    <div class=\"row pt-padding\">\n");
      out.write("                        <div class=\"col-xl-12 col-lg-12 col-md-12\">\n");
      out.write("                            <div class=\"footer-copy-right\">\n");
      out.write("                                <p>Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved \t</p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!-- Footer End-->\n");
      out.write("        </footer>\n");
      out.write("\n");
      out.write("        <!-- JS here -->\n");
      out.write("\n");
      out.write("        <!-- All JS Custom Plugins Link Here here -->\n");
      out.write("        <script src=\"./assets/js/vendor/modernizr-3.5.0.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Jquery, Popper, Bootstrap -->\n");
      out.write("        <script src=\"./assets/js/vendor/jquery-1.12.4.min.js\"></script>\n");
      out.write("        <script src=\"./assets/js/popper.min.js\"></script>\n");
      out.write("        <script src=\"./assets/js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- Jquery Mobile Menu -->\n");
      out.write("        <script src=\"./assets/js/jquery.slicknav.min.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Jquery Slick , Owl-Carousel Plugins -->\n");
      out.write("        <script src=\"./assets/js/owl.carousel.min.js\"></script>\n");
      out.write("        <script src=\"./assets/js/slick.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- Scrollup, nice-select, sticky -->\n");
      out.write("        <script src=\"./assets/js/jquery.scrollUp.min.js\"></script>\n");
      out.write("        <script src=\"./assets/js/jquery.nice-select.min.js\"></script>\n");
      out.write("        <script src=\"./assets/js/jquery.sticky.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"./assets/js/plugins.js\"></script>\n");
      out.write("        <script src=\"./assets/js/main.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
