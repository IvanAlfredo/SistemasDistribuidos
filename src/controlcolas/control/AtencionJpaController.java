/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.control; 

import controlcolas.control.exceptions.NonexistentEntityException;
import controlcolas.control.exceptions.PreexistingEntityException;
import controlcolas.modelo.Atencion;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import controlcolas.modelo.Caja;
import controlcolas.modelo.Cajero;
import controlcolas.modelo.Ficha;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author RDuran
 */
public class AtencionJpaController implements Serializable {

    public AtencionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Atencion atencion) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caja caja = atencion.getCaja();
            if (caja != null) {
                caja = em.getReference(caja.getClass(), caja.getId());
                atencion.setCaja(caja);
            }
            Cajero cajero = atencion.getCajero();
            if (cajero != null) {
                cajero = em.getReference(cajero.getClass(), cajero.getId());
                atencion.setCajero(cajero);
            }
            Ficha ficha = atencion.getFicha();
            if (ficha != null) {
                ficha = em.getReference(ficha.getClass(), ficha.getId());
                atencion.setFicha(ficha);
            }
            em.persist(atencion);
            if (caja != null) {
                caja.getAtencionList().add(atencion);
                caja = em.merge(caja);
            }
            if (cajero != null) {
                cajero.getAtencionList().add(atencion);
                cajero = em.merge(cajero);
            }
            if (ficha != null) {
                ficha.getAtencionList().add(atencion);
                ficha = em.merge(ficha);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAtencion(atencion.getId()) != null) {
                throw new PreexistingEntityException("Atencion " + atencion + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Atencion atencion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atencion persistentAtencion = em.find(Atencion.class, atencion.getId());
            Caja cajaOld = persistentAtencion.getCaja();
            Caja cajaNew = atencion.getCaja();
            Cajero cajeroOld = persistentAtencion.getCajero();
            Cajero cajeroNew = atencion.getCajero();
            Ficha fichaOld = persistentAtencion.getFicha();
            Ficha fichaNew = atencion.getFicha();
            if (cajaNew != null) {
                cajaNew = em.getReference(cajaNew.getClass(), cajaNew.getId());
                atencion.setCaja(cajaNew);
            }
            if (cajeroNew != null) {
                cajeroNew = em.getReference(cajeroNew.getClass(), cajeroNew.getId());
                atencion.setCajero(cajeroNew);
            }
            if (fichaNew != null) {
                fichaNew = em.getReference(fichaNew.getClass(), fichaNew.getId());
                atencion.setFicha(fichaNew);
            }
            atencion = em.merge(atencion);
            if (cajaOld != null && !cajaOld.equals(cajaNew)) {
                cajaOld.getAtencionList().remove(atencion);
                cajaOld = em.merge(cajaOld);
            }
            if (cajaNew != null && !cajaNew.equals(cajaOld)) {
                cajaNew.getAtencionList().add(atencion);
                cajaNew = em.merge(cajaNew);
            }
            if (cajeroOld != null && !cajeroOld.equals(cajeroNew)) {
                cajeroOld.getAtencionList().remove(atencion);
                cajeroOld = em.merge(cajeroOld);
            }
            if (cajeroNew != null && !cajeroNew.equals(cajeroOld)) {
                cajeroNew.getAtencionList().add(atencion);
                cajeroNew = em.merge(cajeroNew);
            }
            if (fichaOld != null && !fichaOld.equals(fichaNew)) {
                fichaOld.getAtencionList().remove(atencion);
                fichaOld = em.merge(fichaOld);
            }
            if (fichaNew != null && !fichaNew.equals(fichaOld)) {
                fichaNew.getAtencionList().add(atencion);
                fichaNew = em.merge(fichaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = atencion.getId();
                if (findAtencion(id) == null) {
                    throw new NonexistentEntityException("The atencion with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Atencion atencion;
            try {
                atencion = em.getReference(Atencion.class, id);
                atencion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The atencion with id " + id + " no longer exists.", enfe);
            }
            Caja caja = atencion.getCaja();
            if (caja != null) {
                caja.getAtencionList().remove(atencion);
                caja = em.merge(caja);
            }
            Cajero cajero = atencion.getCajero();
            if (cajero != null) {
                cajero.getAtencionList().remove(atencion);
                cajero = em.merge(cajero);
            }
            Ficha ficha = atencion.getFicha();
            if (ficha != null) {
                ficha.getAtencionList().remove(atencion);
                ficha = em.merge(ficha);
            }
            em.remove(atencion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Atencion> findAtencionEntities() {
        return findAtencionEntities(true, -1, -1);
    }

    public List<Atencion> findAtencionEntities(int maxResults, int firstResult) {
        return findAtencionEntities(false, maxResults, firstResult);
    }

    private List<Atencion> findAtencionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Atencion.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Atencion findAtencion(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atencion.class, id);
        } finally {
            em.close();
        }
    }

    public int getAtencionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Atencion> rt = cq.from(Atencion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
