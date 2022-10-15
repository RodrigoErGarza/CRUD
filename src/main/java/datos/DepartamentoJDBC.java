/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;
import domain.Departamento;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 *
 * @author alumno
 */
public class DepartamentoJDBC {
    
    private Connection conexionTransaccional;
    
    private static final String SQL_SELECT = "SELECT * FROM departamento";
    private static final String SQL_INSERT = "INSERT INTO departamento(IT, Contabilidad, RRHH, Marketing, Produccion) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE departamento SET IT=?, Contabilidad=?, RHHH=?, Marketing=?, Produccion=? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM departamento WHERE id_departamento=?";
    
    public DepartamentoJDBC() {

    }
    public DepartamentoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }
    
    public List<Departamento> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Departamento departamento = null;
        List<Departamento> departamentos = new ArrayList<Departamento>();

        try {
            //ternario para comparar si la conexion esta activa.
            //si la transaccion esta activa, retorna la propieadad de conexion
            //si no, crea la transaccion.
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_departamento = rs.getInt("id_departamento");
                String IT = rs.getString("IT");
                String Contabilidad = rs.getString("Contabilidad");
                String RRHH = rs.getString("RRHH");
                String Marketing = rs.getString("Marketing");
                String Produccion = rs.getString("Produccion");

                departamento = new Departamento();
                departamento.setId_departamento(id_departamento);
                departamento.setIT(IT);
                departamento.setContabilidad(Contabilidad);
                departamento.setRRHH(RRHH);
                departamento.setMarketing(Marketing);
                departamento.setProduccion(Produccion);
                

                departamentos.add(departamento);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }
        return departamentos;
    }
    
    public int insert(Departamento departamento) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, departamento.getIT());
            stmt.setString(2, departamento.getContabilidad());
            stmt.setString(3, departamento.getRRHH());
            stmt.setString(4, departamento.getMarketing());
            stmt.setString(5, departamento.getProduccion());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int update(Departamento departamento) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, departamento.getIT());
            stmt.setString(2, departamento.getContabilidad());
            stmt.setString(3, departamento.getRRHH());
            stmt.setString(4, departamento.getMarketing());
            stmt.setString(5, departamento.getProduccion());
            stmt.setInt(6, departamento.getId_departamento());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    
    public int delete(Departamento departamento) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            //validacion usando un ternario
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, departamento.getId_departamento());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }
    
}
