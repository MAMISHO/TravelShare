/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import hibernate.Publicaciones;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author francisco
 */
public class PublicacionesDao {
    
    Session hSession = null;

    public PublicacionesDao() {
        this.hSession = HibernateUtil.getSessionFactory().openSession();
    }

    public void create(Publicaciones v) {

        hSession.beginTransaction();
        hSession.save(v);
        hSession.getTransaction().commit();
    }

    public Publicaciones get(String ciudad, String universidad) {
        hSession.clear();
//        Query i = hSession.createQuery("select idCiudad from Ciudades where nombre like '" + ciudad + "' ");
//        String idCiu = i.getQueryString();
//        hSession.clear();
//        Query j = hSession.createQuery("select idUniversidad from Universidades where nombre like'" + universidad + "' ");
//        String idUni = j.getQueryString();
//        hSession.clear();
        Query q = hSession.createQuery("from Publicaciones where idCiudad='" + ciudad + "' ");
        List<Publicaciones> lista = q.list();
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }
    

    public List<Publicaciones> getList(String ciudad, String universidad) {
        hSession.clear();
        Query q = hSession.createQuery("from Publicaciones where idCiudad like'" + ciudad + "' and idUniversidad like '" + universidad +"' ");
        List<Publicaciones> lista = q.list();
        if (!lista.isEmpty()) {
            return lista;
        }
        return null;
    }
    

    public void delete(Publicaciones v) {

        hSession.beginTransaction();
        hSession.delete(v);
        hSession.getTransaction().commit();
    }

    public void update(Publicaciones v) {

        org.hibernate.Transaction tx = hSession.beginTransaction();
        //sesion.createQuery("update Vehiculos set horaEntrada = '" + v.getFechaEntrada() + "', horaSalida = '" + v.getFechaSalida() + "', tiempoPermitido = '" + v.getTiempoPermitido() + "' where matricula = '" + v.getMatricula() + "' ").executeUpdate();
        hSession.update(v);
        hSession.getTransaction().commit();

    }
    
}
