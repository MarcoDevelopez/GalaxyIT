package com.galaxybis.galaxyit.ejb.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import oracle.jdbc.OracleTypes;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;

import com.galaxybis.galaxyit.ejb.dao.exception.EJBDAOException;
import com.galaxybis.galaxyit.ejb.dao.inf.EmpleadoEJBDAOLocal;
import com.galaxybis.galaxyit.model.Empleado;

@Stateless
public class EmpleadoEJBDAOImpl extends BasicEJBDAOImpl<Empleado> implements EmpleadoEJBDAOLocal {
	
	@PersistenceContext(unitName = "PUGalaxyIT")
	private EntityManager em;

	@Override
	public boolean insertar(final Empleado prmEmpleado) throws EJBDAOException {
		try {
			Session hbSession = em.unwrap(Session.class);
			hbSession.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					CallableStatement cs = null;
					
					try {
						con.setAutoCommit(false);
						cs = con.prepareCall("{CALL PKG_EMPLEADO.SP_INSERTAR(?,?,?,?,?,?,?)}");
						cs.registerOutParameter("P_ID", OracleTypes.NUMERIC);
						cs.setString("P_NOMBRES", prmEmpleado.getNombres());
						cs.setString("P_APELLIDOS", prmEmpleado.getApellidos());
						cs.setString("P_DIRECCION", prmEmpleado.getDireccion());
						cs.setString("P_PAIS", prmEmpleado.getPais());
						cs.setString("P_ESTADO", prmEmpleado.getEstado());
						cs.setString("P_SITUACION", prmEmpleado.getSituacion());
						cs.execute();
						
						prmEmpleado.setId(cs.getLong("P_ID"));
						prmEmpleado.setSw(true);
						con.commit();
						
					} catch (SQLException e) {
						prmEmpleado.setSw(false);
						con.rollback();
						e.printStackTrace();
						throw new SQLException("SQLException:EmpleadoEJBDAOImpl:insertar " + e);
					}
					
				}
				
			});
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("HibernateException:EmpleadoEJBDAOImpl:insertar " + e);
		}
		return prmEmpleado.isSw();
	}

	@Override
	public boolean actualizar(final Empleado prmEmpleado) throws EJBDAOException {
		try {
			Session hbSession = em.unwrap(Session.class);
			hbSession.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					CallableStatement cs = null;
					
					try {
						con.setAutoCommit(false);
						cs = con.prepareCall("{CALL PKG_EMPLEADO.SP_ACTUALIZAR(?,?,?,?,?,?,?)}");
						cs.setLong("P_ID", prmEmpleado.getId());
						cs.setString("P_NOMBRES", prmEmpleado.getNombres());
						cs.setString("P_APELLIDOS", prmEmpleado.getApellidos());
						cs.setString("P_DIRECCION", prmEmpleado.getDireccion());
						cs.setString("P_PAIS", prmEmpleado.getPais());
						cs.setString("P_ESTADO", prmEmpleado.getEstado());
						cs.setString("P_SITUACION", prmEmpleado.getSituacion());
						cs.execute();
						con.commit();
						prmEmpleado.setSw(true);
						
					} catch (SQLException e) {
						prmEmpleado.setSw(false);
						con.rollback();
						e.printStackTrace();
						throw new SQLException("SQLException:EmpleadoEJBDAOImpl:actualizar" + e);
					}
					
				}
				
			});
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("HibernateException:EmpleadoEJBDAOImpl:actualizar " + e);
		}
		return prmEmpleado.isSw();
	}

	@Override
	public boolean eliminar(final Empleado prmEmpleado) throws EJBDAOException {
		try {
			Session hbSession = em.unwrap(Session.class);
			hbSession.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					CallableStatement cs = null;
					
					try {
						con.setAutoCommit(false);
						cs = con.prepareCall("{CALL PKG_EMPLEADO.SP_ELIMINAR(?)}");
						cs.setLong("P_ID", prmEmpleado.getId());
						cs.execute();
						con.commit();
						prmEmpleado.setSw(true);
						
					} catch (SQLException e) {
						prmEmpleado.setSw(false);
						con.rollback();
						e.printStackTrace();
						throw new SQLException("SQLException:EmpleadoEJBDAOImpl:eliminar " + e);
					}
					
				}
				
			});
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("HibernateException:EmpleadoEJBDAOImpl:eliminar " + e);
		}
		return prmEmpleado.isSw();
	}

	@Override
	public List<Empleado> lista() throws EJBDAOException {
		final List<Empleado> empleados = new ArrayList<>();
		try {
			Session hbSession = em.unwrap(Session.class);
			hbSession.doWork(new Work() {
				
				@Override
				public void execute(Connection con) throws SQLException {
					CallableStatement cs = null;
					ResultSet rs = null;
					
					try {
						con.setAutoCommit(false);
						cs = con.prepareCall("{CALL PKG_EMPLEADO.SP_LISTA(?)}");
						cs.registerOutParameter("P_C_CURSOR", OracleTypes.CURSOR);
						cs.execute();
						
						rs = (ResultSet) cs.getObject("P_C_CURSOR");
						while (rs.next()) {
							Empleado empleado = new Empleado();
							empleado.setId(rs.getLong("ID"));
							empleado.setNombres(rs.getString("NOMBRES"));
							empleado.setApellidos(rs.getString("APELLIDOS"));
							empleado.setDireccion(rs.getString("DIRECCION"));
							empleado.setPais(rs.getString("PAIS"));
							empleado.setEstado(rs.getString("ESTADO"));
							empleado.setSituacion(rs.getString("SITUACION"));
							empleados.add(empleado);
						}
					} catch (SQLException e) {
						e.printStackTrace();
						throw new SQLException("SQLException:EmpleadoEJBDAOImpl:lista " + e);
					}
					
				}
				
			});
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new HibernateException("HibernateException:EmpleadoEJBDAOImpl:lista " + e);
		}
		return empleados;
	}

}
