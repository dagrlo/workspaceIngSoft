<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Novel Category</title>
</head>
<body>
<br><br>
    Select novels by genre:<br>
    <form action="pages/workflow" method="get">
        <input type="checkbox" name="category" value="Adventure">Adventure Novels<br>
        <input type="checkbox" name="category" value="Detective">Detective Novels<br>
        <input type="checkbox" name="category" value="Dystopian">Dystopian Novels<br>
        <input type="checkbox" name="category" value="Epic">Epic Novels<br>
        <input type="checkbox" name="category" value="Fantasy">Fantasy Novels<br>
        <input type="checkbox" name="category" value="Horror">Horror Novels<br>
        <input type="checkbox" name="category" value="Mystery">Mystery Novels<br>
        <input type="checkbox" name="category" value="Psychological">Psychological Novels<br>
        <input type="checkbox" name="category" value="Romance">Romance Novels<br>
        <input type="checkbox" name="category" value="SciFi">Science Fiction Novels<br>
        <input type="checkbox" name="category" value="Spy">Spy Novels<br>
        <input type="checkbox" name="category" value="Suspense">Suspense Novels<br>
        <input type="checkbox" name="category" value="Thriller">Thriller Novels<br>
        <input type="checkbox" name="category" value="Utopian">Utopian Novels<br>
        <input type="checkbox" name="category" value="War">War Novels<br>
        <input type="checkbox" name="category" value="Western">Western Novels<br>
        <br>
        <input type="submit" value="Select">
    </form>
</body>
</html>