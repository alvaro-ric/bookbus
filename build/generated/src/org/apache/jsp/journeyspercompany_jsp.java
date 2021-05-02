package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.JourneyDao;
import model.Journey;
import model.ManagerAccount;
import model.Account;
import model.Route;
import java.util.List;
import model.Company;

public final class journeyspercompany_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\" />\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n");
      out.write("        <link rel=\"stylesheet\" href=\"assets/tailwind.css\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"h-screen overflow-hidden flex items-center justify-start\" style=\"background: #edf2f7\">\n");
      out.write("        ");

            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            List<Journey> journeylist = null;
            if (session.getAttribute("user") == null) {
                session.setAttribute("trigger", "journeyspercompany");
                response.sendRedirect("login.jsp");
            } else {
                ManagerAccount account = (ManagerAccount) session.getAttribute("user");
                request.setAttribute("email", account.getEmail());
                request.setAttribute("role", account.getAccountRole());
                JourneyDao journeyDao = new JourneyDao();
                journeylist = journeyDao.getCompanyJourneys(account.getCompany().getId());
            }
            //            request.setAttribute("genderlist", ds.getGenderList());

        
      out.write("\n");
      out.write("        <script\n");
      out.write("            src=\"https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js\"\n");
      out.write("            defer\n");
      out.write("        ></script>\n");
      out.write("\n");
      out.write("        <div class=\"bg-gray-200 font-sans\">\n");
      out.write("            <div class=\"flex flex-col sm:flex-row sm:justify-around\">\n");
      out.write("                <div class=\"w-64 h-screen bg-gray-800\">\n");
      out.write("                    <div class=\"flex items-center justify-center mt-10\">\n");
      out.write("                        <!--<img class=\"h-6\" src=\"https://premium-tailwindcomponents.netlify.app/assets/svg/tailwindcomponent-light.svg\">--> \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <nav class=\"mt-10\">\n");
      out.write("                        <div x-data=\"{ open: false }\">\n");
      out.write("                            <button\n");
      out.write("                                @click=\"open = !open\"\n");
      out.write("                                class=\"w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none\"\n");
      out.write("                                >\n");
      out.write("                                <span class=\"flex items-center\">\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-5 w-5\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        d=\"M19 11H5M19 11C20.1046 11 21 11.8954 21 13V19C21 20.1046 20.1046 21 19 21H5C3.89543 21 3 20.1046 3 19V13C3 11.8954 3.89543 11 5 11M19 11V9C19 7.89543 18.1046 7 17 7M5 11V9C5 7.89543 5.89543 7 7 7M7 7V5C7 3.89543 7.89543 3 9 3H15C16.1046 3 17 3.89543 17 5V7M7 7H17\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("\n");
      out.write("                                    <span class=\"mx-4 font-medium\">Dashboard</span>\n");
      out.write("                                </span>\n");
      out.write("\n");
      out.write("                                <span>\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-4 w-4\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"! open\"\n");
      out.write("                                        d=\"M9 5L16 12L9 19\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        style=\"display: none\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"open\"\n");
      out.write("                                        d=\"M19 9L12 16L5 9\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("                                </span>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <div x-show=\"open\" class=\"bg-gray-700\">\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"#\"  onclick=\"openMenu(event, 'view-routes')\"\n");
      out.write("                                    >Add account</a\n");
      out.write("                                >\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"#\"\n");
      out.write("                                    >Manage Accounts</a\n");
      out.write("                                >\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div x-data=\"{ open: false }\">\n");
      out.write("                            <button\n");
      out.write("                                @click=\"open = !open\"\n");
      out.write("                                class=\"w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none\"\n");
      out.write("                                >\n");
      out.write("                                <span class=\"flex items-center\">\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-5 w-5\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        d=\"M16 7C16 9.20914 14.2091 11 12 11C9.79086 11 8 9.20914 8 7C8 4.79086 9.79086 3 12 3C14.2091 3 16 4.79086 16 7Z\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    <path\n");
      out.write("                                        d=\"M12 14C8.13401 14 5 17.134 5 21H19C19 17.134 15.866 14 12 14Z\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("\n");
      out.write("                                    <span class=\"mx-4 font-medium\">Routes</span>\n");
      out.write("                                </span>\n");
      out.write("\n");
      out.write("                                <span>\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-4 w-4\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"! open\"\n");
      out.write("                                        d=\"M9 5L16 12L9 19\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        style=\"display: none\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"open\"\n");
      out.write("                                        d=\"M19 9L12 16L5 9\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("                                </span>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <div x-show=\"open\" class=\"bg-gray-700\">\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"requestroute.jsp\"\n");
      out.write("                                    >Request Route</a\n");
      out.write("                                >\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"routespercompany.jsp\"\n");
      out.write("                                    >All Routes</a\n");
      out.write("                                >\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div x-data=\"{ open: false }\">\n");
      out.write("                            <button\n");
      out.write("                                @click=\"open = !open\"\n");
      out.write("                                class=\"w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none\"\n");
      out.write("                                >\n");
      out.write("                                <span class=\"flex items-center\">\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-5 w-5\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        d=\"M16 7C16 9.20914 14.2091 11 12 11C9.79086 11 8 9.20914 8 7C8 4.79086 9.79086 3 12 3C14.2091 3 16 4.79086 16 7Z\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    <path\n");
      out.write("                                        d=\"M12 14C8.13401 14 5 17.134 5 21H19C19 17.134 15.866 14 12 14Z\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("\n");
      out.write("                                    <span class=\"mx-4 font-medium\">Journey</span>\n");
      out.write("                                </span>\n");
      out.write("\n");
      out.write("                                <span>\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-4 w-4\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"! open\"\n");
      out.write("                                        d=\"M9 5L16 12L9 19\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        style=\"display: none\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"open\"\n");
      out.write("                                        d=\"M19 9L12 16L5 9\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("                                </span>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <div x-show=\"open\" class=\"bg-gray-700\">\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"addjourney.jsp\"\n");
      out.write("                                    >Add Journey</a\n");
      out.write("                                >\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"journeyspercompany.jsp\"\n");
      out.write("                                    >All Journey</a\n");
      out.write("                                >\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div x-data=\"{ open: false }\">\n");
      out.write("                            <button\n");
      out.write("                                @click=\"open = !open\"\n");
      out.write("                                class=\"w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none\"\n");
      out.write("                                >\n");
      out.write("                                <span class=\"flex items-center\">\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-5 w-5\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        d=\"M15 5V7M15 11V13M15 17V19M5 5C3.89543 5 3 5.89543 3 7V10C4.10457 10 5 10.8954 5 12C5 13.1046 4.10457 14 3 14V17C3 18.1046 3.89543 19 5 19H19C20.1046 19 21 18.1046 21 17V14C19.8954 14 19 13.1046 19 12C19 10.8954 19.8954 10 21 10V7C21 5.89543 20.1046 5 19 5H5Z\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("\n");
      out.write("                                    <span class=\"mx-4 font-medium\">Tickets</span>\n");
      out.write("                                </span>\n");
      out.write("\n");
      out.write("                                <span>\n");
      out.write("                                    <svg\n");
      out.write("                                        class=\"h-4 w-4\"\n");
      out.write("                                        viewBox=\"0 0 24 24\"\n");
      out.write("                                        fill=\"none\"\n");
      out.write("                                        xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                                        >\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"! open\"\n");
      out.write("                                        d=\"M9 5L16 12L9 19\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        style=\"display: none\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    <path\n");
      out.write("                                        x-show=\"open\"\n");
      out.write("                                        d=\"M19 9L12 16L5 9\"\n");
      out.write("                                        stroke=\"currentColor\"\n");
      out.write("                                        stroke-width=\"2\"\n");
      out.write("                                        stroke-linecap=\"round\"\n");
      out.write("                                        stroke-linejoin=\"round\"\n");
      out.write("                                        ></path>\n");
      out.write("                                    </svg>\n");
      out.write("                                </span>\n");
      out.write("                            </button>\n");
      out.write("\n");
      out.write("                            <div x-show=\"open\" class=\"bg-gray-700\">\n");
      out.write("                                <a\n");
      out.write("                                    class=\"py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white\"\n");
      out.write("                                    href=\"#\"\n");
      out.write("                                    >All Tickets</a\n");
      out.write("                                >\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <div class=\"absolute bottom-0 my-8\">\n");
      out.write("                        <a\n");
      out.write("                            class=\"flex items-center py-2 px-8 text-gray-300 mx-1 rounded-full bg-gray-600 hover:text-gray-200\"\n");
      out.write("                            href=\"#\"\n");
      out.write("                            >\n");
      out.write("                            <div class=\"flex justify-between items-center\">\n");
      out.write("                                <img\n");
      out.write("                                    class=\"h-6 w-6 rounded-full mr-2 object-cover\"\n");
      out.write("                                    src=\"https://lh3.googleusercontent.com/a-/AOh14Gi0DgItGDTATTFV6lPiVrqtja6RZ_qrY91zg42o-g\"\n");
      out.write("                                    alt=\"avatar\"\n");
      out.write("                                    />\n");
      out.write("                                <div class=\"flex flex-col justify-between\">\n");
      out.write("                                    <div class=\"text-sm font-thin\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                    <div class=\"text-xs\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${role}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- <div class=\"grid w-full min-h-screen place-items-center\"> -->\n");
      out.write("        <div class=\"overflow-x-auto bg-white w-5/6 h-screen mt-0 md:mt-0 md:col-span-2\">\n");
      out.write("\n");
      out.write("            ");
                if (request.getAttribute("message") != null) {
                    String message = (String) request.getAttribute("message");
            
      out.write("\n");
      out.write("            <div class=\"container px-1 py-1\" id=\"alertbox\">\n");
      out.write("                <div class=\"container bg-blue-500 flex items-center text-white text-sm font-bold px-4 py-3 relative\"\n");
      out.write("                     role=\"alert\">\n");
      out.write("                    <svg class=\"fill-current w-4 h-4 mr-2\" xmlns=\"http://www.w3.org/2000/svg\" viewBox=\"0 0 20 20\">\n");
      out.write("                    <path\n");
      out.write("                        d=\"M12.432 0c1.34 0 2.01.912 2.01 1.957 0 1.305-1.164 2.512-2.679 2.512-1.269 0-2.009-.75-1.974-1.99C9.789 1.436 10.67 0 12.432 0zM8.309 20c-1.058 0-1.833-.652-1.093-3.524l1.214-5.092c.211-.814.246-1.141 0-1.141-.317 0-1.689.562-2.502 1.117l-.528-.88c2.572-2.186 5.531-3.467 6.801-3.467 1.057 0 1.233 1.273.705 3.23l-1.391 5.352c-.246.945-.141 1.271.106 1.271.317 0 1.357-.392 2.379-1.207l.6.814C12.098 19.02 9.365 20 8.309 20z\" />\n");
      out.write("                    </svg>\n");
      out.write("                    <p class=\"text-sm text-white\">");
      out.print(message);
      out.write("</p>\n");
      out.write("\n");
      out.write("                    <span class=\"absolute top-0 bottom-0 right-0 px-4 py-3 closealertbutton\">\n");
      out.write("                        <svg class=\"fill-current h-6 w-6 text-white\" role=\"button\" xmlns=\"http://www.w3.org/2000/svg\"\n");
      out.write("                             viewBox=\"0 0 20 20\">\n");
      out.write("                        <title>Close</title>\n");
      out.write("                        <path\n");
      out.write("                            d=\"M14.348 14.849a1.2 1.2 0 0 1-1.697 0L10 11.819l-2.651 3.029a1.2 1.2 0 1 1-1.697-1.697l2.758-3.15-2.759-3.152a1.2 1.2 0 1 1 1.697-1.697L10 8.183l2.651-3.031a1.2 1.2 0 1 1 1.697 1.697l-2.758 3.152 2.758 3.15a1.2 1.2 0 0 1 0 1.698z\" />\n");
      out.write("                        </svg>\n");
      out.write("                    </span>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("            <h3 class=\"block text-base text-center font-medium text-gray-700 py-3\"> All Routes</h3>\n");
      out.write("            <table class=\"min-w-max w-full table-auto\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr class=\"bg-gray-200 text-gray-600 uppercase text-sm leading-normal\">\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Source</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Destination</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Created At</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Scheduled on</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">plateNo</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">price</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Seats</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Taken</th>\n");
      out.write("                        <th class=\"py-3 px-6 text-left\">Status</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody class=\"text-gray-600 text-sm font-light\">\n");
      out.write("                    ");

                        for (Journey journey : journeylist) {
                            
                            
                            
                            
                            
                            
                            
                            
                            
                            
                    
      out.write("\n");
      out.write("                    <tr class=\"border-b border-gray-200 hover:bg-gray-100\">\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getRoute().getSource());
      out.write("</td>\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getRoute().getDestination());
      out.write("</td>\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getCreatedAt());
      out.write("</td>\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getDepartureDate());
      out.write(' ');
      out.print(journey.getDepartureTime());
      out.write("</td>\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getPlateNo());
      out.write("</td>\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getSeats());
      out.write("</td>\n");
      out.write("                        <td class=\"py-3 px-6 text-left whitespace-nowrap font-medium\">");
      out.print(journey.getTaken());
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            ");

                                if (journey.getJourneyStatus().toString().equals("BOOKING")) {
                            
      out.write("\n");
      out.write("                            <span class=\"mx-auto bg-green-200 text-green-800 py-1 px-3 rounded-full text-xs\">");
      out.print(journey.getJourneyStatus());
      out.write("</span>\n");
      out.write("                            ");
} else {
      out.write("\n");
      out.write("                            <span class=\"mx-auto bg-red-200 text-red-800 py-1 px-3 rounded-full text-xs\">");
      out.print(journey.getJourneyStatus());
      out.write("</span>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("        </div>\n");
      out.write("        <!-- </div> -->\n");
      out.write("        <script src=\"./assets/js/vendor/jquery-1.12.4.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                                        $(\".closealertbutton\").click(function (e) {\n");
      out.write("\n");
      out.write("                                            pid = $(this).parent().parent().hide(500)\n");
      out.write("                                            console.log(pid)\n");
      out.write("                                        })\n");
      out.write("                                        if (window.history.replaceState) {\n");
      out.write("                                            window.history.replaceState(null, null, window.location.href);\n");
      out.write("                                        }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
