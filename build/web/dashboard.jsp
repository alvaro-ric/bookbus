<%-- 
    Document   : dashboard
    Created on : Apr 12, 2021, 9:32:05 AM
    Author     : Philip
--%>

<%@page import="model.Account"%>
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
                            class="flex items-center py-2 px-8 text-gray-300 mx-1 rounded-lg bg-gray-600 hover:text-gray-200"
                            href="#"
                            >
                            <div class="flex justify-between items-center">
                                <img
                                    class="h-6 w-6 rounded-full mr-3 object-cover"
                                    src="https://lh3.googleusercontent.com/a-/AOh14Gi0DgItGDTATTFV6lPiVrqtja6RZ_qrY91zg42o-g"
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


        <!-- <div class="grid w-full min-h-screen place-items-center"> -->
        <div class="overflow-x-auto bg-white w-5/6 h-screen mt-0 md:mt-0 md:col-span-2">
            <form action="#" method="POST">
                <h3 class="block text-base text-center font-medium text-gray-700"> Add Route</h3>
                <div class="flex flex-col items-center shadow overflow-hidden sm:rounded-md">
                    <div class="px-4 py-5  sm:p-6">
                        <div class="grid grid-cols-6 gap-6">
                            <div class="col-span-6 sm:col-span-3">
                                <label for="first_name" class="block text-sm font-medium text-gray-700">First name</label>
                                <input type="text" name="first_name" id="first_name" autocomplete="given-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
                            </div>

                            <div class="col-span-6 sm:col-span-3">
                                <label for="last_name" class="block text-sm font-medium text-gray-700">Last name</label>
                                <input type="text" name="last_name" id="last_name" autocomplete="family-name" class="mt-1 focus:ring-indigo-500 focus:border-indigo-500 block w-full shadow-sm sm:text-sm border-gray-300 rounded-md">
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
                    <tr class="border-b border-gray-200 hover:bg-gray-100">
                        <td class="py-3 px-6 text-left whitespace-nowrap font-medium">#1</td>
                        <td class="py-3 px-6 text-left text-blue-600 whitespace-nowrap font-medium">KIGALI</td>
                        <td class="py-3 px-6 text-left text-purple-600 whitespace-nowrap font-medium">HUYE</td>
                        <td class="py-3 px-6 text-center">
                            <div class="flex item-center justify-center">
                                <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z" />
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M2.458 12C3.732 7.943 7.523 5 12 5c4.478 0 8.268 2.943 9.542 7-1.274 4.057-5.064 7-9.542 7-4.477 0-8.268-2.943-9.542-7z" />
                                    </svg>
                                </div>
                                <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15.232 5.232l3.536 3.536m-2.036-5.036a2.5 2.5 0 113.536 3.536L6.5 21.036H3v-3.572L16.732 3.732z" />
                                    </svg>
                                </div>
                                <div class="w-4 mr-2 transform hover:text-purple-500 hover:scale-110">
                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                                    </svg>
                                </div>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
        <!-- </div> -->
        <script>
            function openMenu(evt, MenuName) {
                var i, x, tablinks;
                x = document.getElementsByClassName("admin-tab");
                for (i = 0; i < x.length; i++) {
                    x[i].style.display = "none";
                }
                document.getElementById(MenuName).style.display = "block";
                evt.currentTarget.className += " w3-grey";
            }
        </script>
    </body>
</html>

