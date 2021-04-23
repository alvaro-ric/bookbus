<%-- 
    Document   : companyroutes
    Created on : Apr 22, 2021, 6:16:43 AM
    Author     : Philip
--%>

<%@page import="model.Route"%>
<%@page import="java.util.List"%>
<%@page import="dao.GeneralDao"%>
<%@page import="model.Company"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="stylesheet" href="assets/tailwind.css">
    </head>
    <body class="h-screen overflow-hidden flex items-center justify-start" style="background: #edf2f7">
        <%
            GeneralDao<Route> routeDao = new GeneralDao<>();
            List<Route> routes = routeDao.findAll(new Route());
        %>
        <script
            src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js"
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
                                    href="#"  onclick="openMenu(event, 'view-routes')"
                                    >Add account</a
                                >
                                <a
                                    class="py-2 px-16 block text-sm text-gray-100 hover:bg-blue-500 hover:text-white"
                                    href="#"
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
                                    href="routes.jsp"
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
                    </nav>

                    <div class="absolute bottom-0 my-8">
                        <a
                            class="flex items-center py-2 px-8 text-gray-100 hover:text-gray-200"
                            href="#"
                            >
                            <img
                                class="h-6 w-6 rounded-full mr-3 object-cover"
                                src="https://lh3.googleusercontent.com/a-/AOh14Gi0DgItGDTATTFV6lPiVrqtja6RZ_qrY91zg42o-g"
                                alt="avatar"
                                />
                            <span>Company</span>
                        </a>
                    </div>
                </div>
            </div>
        </div>



        <!-- <div class="grid w-full min-h-screen place-items-center"> -->
        <div class="overflow-x-auto bg-white w-5/6 h-screen mt-0 md:mt-0 md:col-span-2">

            <h3 class="block text-base text-center font-medium text-gray-700 py-3"> All Routes</h3>
            <table class="min-w-max w-full table-auto">
                <thead>
                    <tr class="bg-gray-200 text-gray-600 uppercase text-sm leading-normal">
                        <th class="py-3 px-6 text-left">Route Id</th>
                        <th class="py-3 px-6 text-left">Source</th>
                        <th class="py-3 px-6 text-left">Destination</th>
                        <th class="py-3 px-6 text-center">Actions</th>
                    </tr>
                </thead>
                <tbody class="text-gray-600 text-sm font-light">
                    <%
                        for (Route route : routes) {
                    %>
                    <tr class="border-b border-gray-200 hover:bg-gray-100">
                        <td class="py-3 px-6 text-left whitespace-nowrap font-medium">#<%=route.getId()%></td>
                        <td class="py-3 px-6 text-left text-blue-600 whitespace-nowrap font-medium"><%=route.getSource()%></td>
                        <td class="py-3 px-6 text-left text-purple-600 whitespace-nowrap font-medium"><%=route.getDestination()%></td>
                        <td class="py-3 px-6 text-center">
                            <div class="flex item-center justify-center">
                                
                                <a href="RoutesControl?id=<%=route.getId()%>action=request" class="focus:outline-none text-blue-600 text-sm py-1.5 px-4 rounded-md border border-blue-600 hover:bg-blue-600 hover:text-white flex items-center">
                                    <svg class="w-4 h-4 mr-2" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 8h10M7 12h4m1 8l-4-4H5a2 2 0 01-2-2V6a2 2 0 012-2h14a2 2 0 012 2v8a2 2 0 01-2 2h-3l-4 4z" />
                                    </svg>
                                    Request
                                </a>

                            </div>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <!-- </div> -->

    </body>
</html>



