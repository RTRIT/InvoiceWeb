<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Send Email</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }

        .container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 8px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
        }

        input[type="text"], input[type="email"], textarea {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            resize: vertical;
            height: 100px;
        }

        button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>Send Email</h2>
    <form action="send" method="post">

        <label for="Sender">Sender:</label>
        <input type="email" id="Sender" name="sender" placeholder="" required>

        <label for="Client-email">Client-email:</label>
        <input type="email" id="Client-email" name="to" placeholder="Recipient email" required>

        <label for="CC">CC:</label>
        <input type="email" id="cc" name="cc" placeholder="">


        <label for="subject">Subject:</label>
        <input type="text" id="subject" name="subject" placeholder="Email subject" required>


        <label for="message">Body:</label>
        <textarea id="message" name="message" placeholder="Write your message here" required></textarea>

        <button type="submit">Send Email</button>
    </form>
</div>
</body>
</html>

