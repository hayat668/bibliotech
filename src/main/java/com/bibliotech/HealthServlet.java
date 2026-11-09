package com.bibliotech;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.bibliotech.dao.DatabaseConnection;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
@WebServlet("/health")
public class HealthServlet extends HttpServlet {
    @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    response.setContentType("text/plain");
   try (Connection connection = DatabaseConnection.get()) {
     try (Statement statement = connection.createStatement();
     var result = statement.executeQuery("SELECT version()")) {
        if (result.next()) {
    response.getWriter().println("OK · " + result.getString(1));
}
}
}
catch (SQLException e) {
    response.setStatus(500);
    response.getWriter().println("KO");
}
}

}