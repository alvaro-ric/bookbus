<%-- 
    Document   : accountdetails
    Created on : Apr 30, 2021, 9:02:42 PM
    Author     : Philip
--%>

<%@page import="dao.GeneralDao"%>
<%@page import="model.ManagerAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/tailwind.css">
    </head>
    <body class="h-screen overflow-hidden flex items-center justify-between bg-gray-300">


        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            ManagerAccount managerAccount = null;
            if (session.getAttribute("user") == null) {
                response.sendRedirect("login.jsp?trigger=dashboard");
            } else {
                ManagerAccount account = (ManagerAccount) session.getAttribute("user");
                request.setAttribute("email", account.getEmail());
                request.setAttribute("role", account.getAccountRole());
                GeneralDao<ManagerAccount> generalDao = new GeneralDao<>();
                managerAccount = 
                        generalDao.findOne(ManagerAccount.class, 2L);
            }
            //            request.setAttribute("genderlist", ds.getGenderList());
        %>

        <script
            src="./assets/alpine.js"
            defer
        ></script>

        <div class="bg-gray-200 font-sans">
            <div class="flex flex-col sm:flex-row sm:justify-around">
                <div class="w-64 h-screen bg-gray-800">
                    <div class="flex items-center justify-center mt-10">
                        <!--<img class="h-6" src="https://premium-tailwindcomponents.netlify.app/assets/svg/tailwindcomponent-light.svg">--> 
                    </div>

                    <nav class="mt-10">
                        <div x-data="{ open: false }">
                            <button
                                @click="open = !open"
                                class="w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none"
                                >
                                <span class="flex items-center">
                                    <svg
                                        class="h-5 w-5"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        d="M19 11H5M19 11C20.1046 11 21 11.8954 21 13V19C21 20.1046 20.1046 21 19 21H5C3.89543 21 3 20.1046 3 19V13C3 11.8954 3.89543 11 5 11M19 11V9C19 7.89543 18.1046 7 17 7M5 11V9C5 7.89543 5.89543 7 7 7M7 7V5C7 3.89543 7.89543 3 9 3H15C16.1046 3 17 3.89543 17 5V7M7 7H17"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>

                                    <span class="mx-4 font-medium">Dashboard</span>
                                </span>

                                <span>
                                    <svg
                                        class="h-4 w-4"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        x-show="! open"
                                        d="M9 5L16 12L9 19"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        style="display: none"
                                        ></path>
                                    <path
                                        x-show="open"
                                        d="M19 9L12 16L5 9"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>
                                </span>
                            </button>

                            <div x-show="open" class="bg-gray-700">
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="addaccount.jsp"  onclick="openMenu(event, 'view-routes')"
                                    >Add account</a
                                >
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="accountspercompany.jsp"
                                    >Manage Accounts</a
                                >
                            </div>
                        </div>

                        <div x-data="{ open: false }">
                            <button
                                @click="open = !open"
                                class="w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none"
                                >
                                <span class="flex items-center">
                                    <svg
                                        class="h-5 w-5"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        d="M16 7C16 9.20914 14.2091 11 12 11C9.79086 11 8 9.20914 8 7C8 4.79086 9.79086 3 12 3C14.2091 3 16 4.79086 16 7Z"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    <path
                                        d="M12 14C8.13401 14 5 17.134 5 21H19C19 17.134 15.866 14 12 14Z"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>

                                    <span class="mx-4 font-medium">Routes</span>
                                </span>

                                <span>
                                    <svg
                                        class="h-4 w-4"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        x-show="! open"
                                        d="M9 5L16 12L9 19"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        style="display: none"
                                        ></path>
                                    <path
                                        x-show="open"
                                        d="M19 9L12 16L5 9"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>
                                </span>
                            </button>

                            <div x-show="open" class="bg-gray-700">
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="requestroute.jsp"
                                    >Request Route</a
                                >
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="routespercompany.jsp"
                                    >All Routes</a
                                >

                            </div>
                        </div>

                        <div x-data="{ open: false }">
                            <button
                                @click="open = !open"
                                class="w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none"
                                >
                                <span class="flex items-center">
                                    <svg
                                        class="h-5 w-5"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        d="M16 7C16 9.20914 14.2091 11 12 11C9.79086 11 8 9.20914 8 7C8 4.79086 9.79086 3 12 3C14.2091 3 16 4.79086 16 7Z"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    <path
                                        d="M12 14C8.13401 14 5 17.134 5 21H19C19 17.134 15.866 14 12 14Z"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>

                                    <span class="mx-4 font-medium">Journey</span>
                                </span>

                                <span>
                                    <svg
                                        class="h-4 w-4"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        x-show="! open"
                                        d="M9 5L16 12L9 19"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        style="display: none"
                                        ></path>
                                    <path
                                        x-show="open"
                                        d="M19 9L12 16L5 9"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>
                                </span>
                            </button>

                            <div x-show="open" class="bg-gray-700">
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="addjourney.jsp"
                                    >Add Journey</a
                                >
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="alljourneys.jsp"
                                    >All Journey</a
                                >

                            </div>
                        </div>

                        <div x-data="{ open: false }">
                            <button
                                @click="open = !open"
                                class="w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none"
                                >
                                <span class="flex items-center">
                                    <svg
                                        class="h-5 w-5"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        d="M15 5V7M15 11V13M15 17V19M5 5C3.89543 5 3 5.89543 3 7V10C4.10457 10 5 10.8954 5 12C5 13.1046 4.10457 14 3 14V17C3 18.1046 3.89543 19 5 19H19C20.1046 19 21 18.1046 21 17V14C19.8954 14 19 13.1046 19 12C19 10.8954 19.8954 10 21 10V7C21 5.89543 20.1046 5 19 5H5Z"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>

                                    <span class="mx-4 font-medium">Tickets</span>
                                </span>

                                <span>
                                    <svg
                                        class="h-4 w-4"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        x-show="! open"
                                        d="M9 5L16 12L9 19"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        style="display: none"
                                        ></path>
                                    <path
                                        x-show="open"
                                        d="M19 9L12 16L5 9"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>
                                </span>
                            </button>

                            <div x-show="open" class="bg-gray-700">
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="#"
                                    >All Tickets</a
                                >
                            </div>
                        </div>
                        <div x-data="{ open: false }">
                            <button
                                @click="open = !open"
                                class="w-full flex justify-between items-center py-3 px-6 text-gray-100 cursor-pointer hover:bg-gray-700 hover:text-gray-100 focus:outline-none"
                                >
                                <span class="flex items-center">
                                    <svg
                                        class="h-5 w-5"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        d="M15 5V7M15 11V13M15 17V19M5 5C3.89543 5 3 5.89543 3 7V10C4.10457 10 5 10.8954 5 12C5 13.1046 4.10457 14 3 14V17C3 18.1046 3.89543 19 5 19H19C20.1046 19 21 18.1046 21 17V14C19.8954 14 19 13.1046 19 12C19 10.8954 19.8954 10 21 10V7C21 5.89543 20.1046 5 19 5H5Z"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>

                                    <span class="mx-4 font-medium">Settings</span>
                                </span>

                                <span>
                                    <svg
                                        class="h-4 w-4"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        >
                                    <path
                                        x-show="! open"
                                        d="M9 5L16 12L9 19"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        style="display: none"
                                        ></path>
                                    <path
                                        x-show="open"
                                        d="M19 9L12 16L5 9"
                                        stroke="currentColor"
                                        stroke-width="2"
                                        stroke-linecap="round"
                                        stroke-linejoin="round"
                                        ></path>
                                    </svg>
                                </span>
                            </button>

                            <div x-show="open" class="bg-gray-700">
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="CompanyControl?action=logout"
                                    >Logout</a
                                >
                            </div>
                        </div>
                    </nav>

                    <div class="absolute bottom-0 my-8">
                        <a
                            class="flex items-center py-2 px-8 text-gray-300 mx-1 rounded-lg bg-gray-600 hover:text-gray-200"
                            href="#"
                            >
                            <div class="flex justify-between items-center">
                                <img
                                    class="h-6 w-6 rounded-full mr-3 object-cover"
                                    src="./assets/img/service/avatar.jpg"
                                    alt="avatar"
                                    />
                                <div class="flex flex-col justify-between">
                                    <div class="text-sm font-thin">${email}</div>
                                    <div class="text-xs">${role}</div>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>


        <div class="w-full flex flex-col items-center">

            <%                if (request.getAttribute("message") != null) {
                    String message = (String) request.getAttribute("message");
            %>
            <div class="container px-4 py-1" id="alertbox">
                <div class="container bg-blue-500 flex items-center text-white text-sm font-bold px-4 py-3 relative"
                     role="alert">
                    <svg class="fill-current w-4 h-4 mr-2" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path
                        d="M12.432 0c1.34 0 2.01.912 2.01 1.957 0 1.305-1.164 2.512-2.679 2.512-1.269 0-2.009-.75-1.974-1.99C9.789 1.436 10.67 0 12.432 0zM8.309 20c-1.058 0-1.833-.652-1.093-3.524l1.214-5.092c.211-.814.246-1.141 0-1.141-.317 0-1.689.562-2.502 1.117l-.528-.88c2.572-2.186 5.531-3.467 6.801-3.467 1.057 0 1.233 1.273.705 3.23l-1.391 5.352c-.246.945-.141 1.271.106 1.271.317 0 1.357-.392 2.379-1.207l.6.814C12.098 19.02 9.365 20 8.309 20z" />
                    </svg>
                    <p><%=message%></p>

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
            <div class="w-5/12">
                    <div class="shadow-lg overflow-hidden sm:rounded-md ">
                        <div class="px-4 py-5 bg-white sm:p-6">
                            <h2 class="py-6 text-blue-400 font-bold text-center">Account Details</h2>
                            <div class="grid grid-cols-6 gap-6">
                                <div class="col-span-6 sm:col-span-6">
                                    <p class="text-center">First Name <span class="px-5">:</span><%=managerAccount.getManager().getFirstName()%></p>
                                </div>
                                <div class="col-span-6 sm:col-span-6">
                                    <p class="text-center">Last Name <span class="px-5">:</span><%=managerAccount.getManager().getLastName()%></p>
                                </div>
                                <div class="col-span-6 sm:col-span-6">
                                    <p class="text-center">email <span class="px-5">:</span><%=managerAccount.getEmail()%></p>
                                </div>
                                <div class="col-span-6 sm:col-span-6">
                                    <p class="text-center">Phone Number <span class="px-5">:</span><%=managerAccount.getManager().getPhoneNumber()%></p>
                                </div>
                                <div class="col-span-6 sm:col-span-6">
                                    <p class="text-center">password <span class="px-5">:</span><%=managerAccount.getPassword()%></p>
                                </div>
                                <div class="col-span-6 sm:col-span-6">
                                    <p class="text-center">Account Status <span class="px-5">:</span><%=managerAccount.getAccountStatus()%></p>
                                </div>
                                
                            </div>
                        </div>
                    </div>
            </div>
        </div>
        <input type="hidden" id="refreshed" value="no">
        <!-- </div> -->

        <script src="./assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script>
                                        $(".closealertbutton").click(function (e) {

                                            pid = $(this).parent().parent().hide(500)
                                            console.log(pid)
                                        })
                                        if (window.history.replaceState) {
                                            window.history.replaceState(null, null, window.location.href);
                                        }

                                        if (window.history.replaceState) {
                                            window.history.replaceState(null, null, window.location.href);
                                        }
                                        //    onload = function () {
                                        //        var e = document.getElementById("refreshed");
                                        //        if (e.value == "no")
                                        //            e.value = "yes";
                                        //        else {
                                        //            e.value = "no";
                                        //            location.reload();
                                        //        }
                                        //    }
        </script>
    </body>
</html>
