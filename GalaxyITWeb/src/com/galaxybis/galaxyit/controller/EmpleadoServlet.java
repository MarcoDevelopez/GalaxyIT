package com.galaxybis.galaxyit.controller;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.galaxybis.galaxyit.ejb.service.exception.EJBServiceException;
import com.galaxybis.galaxyit.ejb.service.inf.EmpleadoEJBServiceLocal;
import com.galaxybis.galaxyit.model.Empleado;

@WebServlet("/EmpleadoServlet")
public class EmpleadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB(lookup = "java:global/GalaxyITEAR/GalaxyITEJBService/EmpleadoEJBServiceImpl!com.galaxybis.galaxyit.ejb.service.inf.EmpleadoEJBServiceLocal")
	private EmpleadoEJBServiceLocal empleadoEJBServiceLocal;

	public EmpleadoServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<Empleado> empleados = empleadoEJBServiceLocal.lista();
			for (Empleado e : empleados) {
				System.out.println("Empleado -> " + e.toString());
			}
		} catch (EJBServiceException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
