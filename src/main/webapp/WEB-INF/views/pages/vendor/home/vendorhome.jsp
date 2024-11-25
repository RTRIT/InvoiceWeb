<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vendor List</title>
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />">
</head>
<body>

    <!-- Header -->
    <header>
        <h1>Vendor Management</h1>
        <nav>
            <ul>
                <li><a href="<c:url value='/vendors/home' />">Home</a></li>
                <li><a href="<c:url value='/vendors/create' />">Create Vendor</a></li>
            </ul>
        </nav>
    </header>

    <!-- Vendor List Section -->
    <section id="vendor-list">
        <h2>All Vendors</h2>

        <!-- Displaying Vendor Table -->
        <table border="1">
            <thead>
                <tr>
                    <th>Vendor ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Phone Number</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="vendor" items="${vendors}">
                    <tr>
                        <td>${vendor.vendorid}</td>
                        <td>${vendor.firstname}</td>
                        <td>${vendor.lastname}</td>
                        <td>${vendor.email}</td>
                        <td>${vendor.phonenumber}</td>
                        <td>
                            <!-- Action buttons -->
                            <a href="<c:url value='/vendors/profile/${vendor.vendorid}' />">View</a>
                            <a href="<c:url value='/vendors/edit/${vendor.vendorid}' />">Edit</a>
                            <form action="<c:url value='/vendors/delete/${vendor.vendorid}' />" method="post" style="display:inline;">
                                <button type="submit" onclick="return confirm('Are you sure you want to delete this vendor?')">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>

    <!-- Footer -->
    <footer>
        <p>&copy; 2024 Vendor Management System</p>
    </footer>

</body>
</html>
