package nl.hu.v1ipass.test.servlets;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import nl.hu.v1ipass.test.servlets.Codes;

@WebServlet(urlPatterns = "/StandClub.java")

public class StandClub extends HttpServlet {
 protected void doGet(HttpServletRequest req, HttpServletResponse resp)
 throws ServletException, IOException {
		Codes dao = new Codes();
		
 String id = req.getParameter("comp");
 int id1 = Integer.parseInt(id);

 
 
// try {
//	dao.Stand(id1);
//} catch (Exception e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
 
try {
	ResultSet result = dao.Stand(id1);

 

 PrintWriter out = resp.getWriter();
 resp.setContentType("text.html");
 out.println("<!DOCTYPE html>");
 out.println("<html>");
 out.println(" <link rel='stylesheet' href='ipass.css'> ");
 out.println("  <title>Team toevoegen</title>");
 out.println(" <body>");
 out.println(" <p><img src='vep1.jpg' alt='vep1' width='700' height='100'></p>");
 out.println(" <ul>");
 out.println(" <li><a class='active' href='http://localhost:1555/test/home_club.html'>Home</a></li>");
 out.println("  <li><a href='http://localhost:1555/test/stand_club.html'>Stand</a></li>");
 out.println("  <li><a href='http://localhost:1555/test/prog_club.html'>Programmma</a></li>");
 out.println("  <li><a href='http://localhost:1555/test/uitslag_club.html'>Uitslag doorgeven</a></li>");
 out.println("</ul>");
 out.println(" <h1>De stand van competitie "+ id1 +"</h1>");
 out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"+"<tr> <th>Pl</th> <th>Team</th>  <th>GS</th> <th>WN</th> <th>GL</th> <th>VL</th> <th>DV</th><th>DT</th> <th>PN</th></tr>");
int i = 0;
while(result.next()){
	i=i+1;
out.println("<tr>"
		+ "<td><center>"+i+"</center></td>"
          + "<td><center>"+result.getString("Teamnaam")+"</center></td>"
          		+ "<td><center>"+result.getInt("Gespeelde_wedstrijden")+"</center></td>"
          		+ "<td><center>"+result.getInt("Gewonnen")+"</center></td>"
          		+ "<td><center>"+result.getInt("Gelijk")+"</center></td>"
          		+ "<td><center>"+result.getInt("Verloren")+"</center></td>"
          		+ "<td><center>"+result.getInt("Doelpunten_V")+"</center></td>"
          		+ "<td><center>"+result.getInt("Doelpunten_T")+"</center></td>"
                + "<td><center>"+result.getInt("Punten")+"</center></td>"

          		+ "</tr>");
}
out.println("</table>");
 out.println("<form class='ann', action='http://localhost:1555/test/home_club.html'>");
 out.println("    <input type='submit' value='Ga terug' />");



 out.println(" </body>");
 out.println("</html>");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
 
 }}