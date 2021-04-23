<%-- 
    Document   : addjourney
    Created on : Apr 12, 2021, 8:52:22 PM
    Author     : Philip
--%>

<%@page import="model.Account"%>
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
    <body class="h-screen overflow-hidden flex items-center justify-between bg-gray-300">


        <%
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

            if (session.getAttribute("user") == null) {
                response.sendRedirect("login.jsp?trigger=dashboard");
            } else {
                Account account = (Account) session.getAttribute("user");
                request.setAttribute("email", account.getEmail());
                request.setAttribute("role", account.getAccountRole());

            }
            //            request.setAttribute("genderlist", ds.getGenderList());
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


        <div class="w-full flex flex-col items-center">

            <div class="">

                <form action="#" method="POST" class="block">

                    <div class="shadow-lg overflow-hidden sm:rounded-md">

                        <div class="px-4 py-5 bg-white sm:p-6">
                            <h2 class="py-6 text-blue-400 font-bold text-center">Add Journey</h2>
                            <div class="grid grid-cols-6 gap-6">
                                <div class="col-span-6 sm:col-span-6">
                                    <label for="country" class="block text-sm font-medium text-gray-700">Country / Region</label>
                                    <select id="country" name="country" autocomplete="country" class="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                        <option>United States</option>
                                        <option>Canada</option>
                                        <option>Mexico</option>
                                    </select>
                                </div>
                                <div class="col-span-6 sm:col-span-3">
                                    <label for="first_name" class="block text-sm font-medium text-gray-700">Date</label>
                                    <input type="date" name="first_name" id="first_name" autocomplete="given-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                                </div>

                                <div class="col-span-6 sm:col-span-3">
                                    <label for="last_name" class="block text-sm font-medium text-gray-700">Time</label>
                                    <input type="time" name="last_name" id="last_name" autocomplete="family-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                                </div>

                                <div class="col-span-6 sm:col-span-6 lg:col-span-2">
                                    <label for="city" class="block text-sm font-medium text-gray-700">Plate No:</label>
                                    <input type="text" name="city" id="city" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                                </div>

                                <div class="col-span-6 sm:col-span-3 lg:col-span-2">
                                    <label for="state" class="block text-sm font-medium text-gray-700">Seats</label>
                                    <input type="text" name="state" id="state" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                                </div>

                                <div class="col-span-6 sm:col-span-3 lg:col-span-2">
                                    <label for="postal_code" class="block text-sm font-medium text-gray-700">Price</label>
                                    <input type="text" name="postal_code" id="postal_code" autocomplete="postal-code" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                                </div>

                                <div class="col-span-6 sm:col-span-6">
                                    <label for="country" class="block text-sm font-medium text-gray-700">Journey Status</label>
                                    <select id="country" name="country" autocomplete="country" class="mt-1 block w-full py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 sm:text-sm">
                                        <option>United States</option>
                                        <option>Canada</option>
                                        <option>Mexico</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="px-4 py-3 bg-gray-50 text-right sm:px-6">
                            <button type="submit" class="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
                                Save
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <!-- </div> -->

    </body>
</html>


