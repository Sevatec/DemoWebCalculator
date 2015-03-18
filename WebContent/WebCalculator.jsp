<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<HTML>
<HEAD>
<TITLE>Web Calculator</TITLE>
</HEAD>

<BODY>
<FORM action="/WebCalculator/WebCalculator" method="post">
<INPUT type="text" name="number" value='<%=request.getAttribute("InputNewNumber") %>' size="35" readonly><BR>
<INPUT type="submit" name="action" value="1">
<INPUT type="submit" name="action" value="2">
<INPUT type="submit" name="action" value="3"><BR>
<INPUT type="submit" name="action" value="4">
<INPUT type="submit" name="action" value="5">
<INPUT type="submit" name="action" value="6"><BR>
<INPUT type="submit" name="action" value="7">
<INPUT type="submit" name="action" value="8">
<INPUT type="submit" name="action" value="9"><BR>
<INPUT type="submit" name="action" value="0">
<INPUT type="submit" name="action" value="+">
<!-- <INPUT type="submit" name="action" value="-"> --><BR>
<INPUT type="submit" name="action" value="x">
<INPUT type="submit" name="action" value="/">
<INPUT type="submit" name="action" value="="><BR>
<INPUT type="submit" name="action" value="Clear">
</FORM>
</BODY>
</HTML>