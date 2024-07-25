package org.example.servlets;

import dao.ScenarioDAO;
import models.Scenario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/scenarios")
public class ScenarioServlet extends HttpServlet {
    private ScenarioDAO scenarioDAO;

    @Override
    public void init() {
        scenarioDAO = new ScenarioDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Scenario> scenarios = scenarioDAO.getAllScenarios();
        request.setAttribute("scenarios", scenarios);
        request.getRequestDispatcher("/WEB-INF/jsp/scenarios.jsp").forward(request, response);
    }
}