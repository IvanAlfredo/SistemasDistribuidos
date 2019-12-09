/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.control;


import controlcolas.control.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import controlcolas.modelo.Caja;
import controlcolas.modelo.Atencion;
import controlcolas.modelo.Cajero;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RDuran
 */
public class CajeroJpaController implements Serializable {

    public CajeroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CajeroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ControlColasPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cajero cajero) {
        if (cajero.getAtencionList() == null) {
            cajero.setAtencionList(new ArrayList<Atencion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caja caja = cajero.getCaja();
            if (caja != null) {
                caja = em.getReference(caja.getClass(), caja.getId());
                cajero.setCaja(caja);
            }
            List<Atencion> attachedAtencionList = new ArrayList<Atencion>();
            for (Atencion atencionListAtencionToAttach : cajero.getAtencionList()) {
                atencionListAtencionToAttach = em.getReference(atencionListAtencionToAttach.getClass(), atencionListAtencionToAttach.getId());
                attachedAtencionList.add(atencionListAtencionToAttach);
            }
            cajero.setAtencionList(attachedAtencionList);
            em.persist(cajero);
            if (caja != null) {
                caja.getCajeroList().add(cajero);
                caja = em.merge(caja);
            }
            for (Atencion atencionListAtencion : cajero.getAtencionList()) {
                Cajero oldCajeroOfAtencionListAtencion = atencionListAtencion.getCajero();
                atencionListAtencion.setCajero(cajero);
                atencionListAtencion = em.merge(atencionListAtencion);
                if (oldCajeroOfAtencionListAtencion != null) {
                    oldCajeroOfAtencionListAtencion.getAtencionList().remove(atencionListAtencion);
                    oldCajeroOfAtencionListAtencion = em.merge(oldCajeroOfAtencionListAtencion);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cajero cajero) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cajero persistentCajero = em.find(Cajero.class, cajero.getId());
            Caja cajaOld = persistentCajero.getCaja();
            Caja cajaNew = cajero.getCaja();
            List<Atencion> atencionListOld = persistentCajero.getAtencionList();
            List<Atencion> atencionListNew = cajero.getAtencionList();
            if (cajaNew != null) {
                cajaNew = em.getReference(cajaNew.getClass(), cajaNew.getId());
                cajero.setCaja(cajaNew);
            }
            List<Atencion> attachedAtencionListNew = new ArrayList<Atencion>();
            for (Atencion atencionListNewAtencionToAttach : atencionListNew) {
                atencionListNewAtencionToAttach = em.getReference(atencionListNewAtencionToAttach.getClass(), atencionListNewAtencionToAttach.getId());
                attachedAtencionListNew.add(atencionListNewAtencionToAttach);
            }
            atencionListNew = attachedAtencionListNew;
            cajero.setAtencionList(atencionListNew);
            cajero = em.merge(cajero);
            if (cajaOld != null && !cajaOld.equals(cajaNew)) {
                cajaOld.getCajeroList().remove(cajero);
                cajaOld = em.merge(cajaOld);
            }
            if (cajaNew != null && !cajaNew.equals(cajaOld)) {
                cajaNew.getCajeroList().add(cajero);
                cajaNew = em.merge(cajaNew);
            }
            for (Atencion atencionListOldAtencion : atencionListOld) {
                if (!atencionListNew.contains(atencionListOldAtencion)) {
                    atencionListOldAtencion.setCajero(null);
                    atencionListOldAtencion = em.merge(atencionListOldAtencion);
                }
            }
            for (Atencion atencionListNewAtencion : atencionListNew) {
                if (!atencionListOld.contains(atencionListNewAtencion)) {
                    Cajero oldCajeroOfAtencionListNewAtencion = atencionListNewAtencion.getCajero();
                    atencionListNewAtencion.setCajero(cajero);
                    atencionListNewAtencion = em.merge(atencionListNewAtencion);
                    if (oldCajeroOfAtencionListNewAtencion != null && !oldCajeroOfAtencionListNewAtencion.equals(cajero)) {
                        oldCajeroOfAtencionListNewAtencion.getAtencionList().remove(atencionListNewAtencion);
                        oldCajeroOfAtencionListNewAtencion = em.merge(oldCajeroOfAtencionListNewAtencion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cajero.getId();
                if (findCajero(id) == null) {
                    throw new NonexistentEntityException("The cajero with id " + id + " no longer exists.");
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
            Cajero cajero;
            try {
                cajero = em.getReference(Cajero.class, id);
                cajero.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cajero with id " + id + " no longer exists.", enfe);
            }
            Caja caja = cajero.getCaja();
            if (caja != null) {
                caja.getCajeroList().remove(cajero);
                caja = em.merge(caja);
            }
            List<Atencion> atencionList = cajero.getAtencionList();
            for (Atencion atencionListAtencion : atencionList) {
                atencionListAtencion.setCajero(null);
                atencionListAtencion = em.merge(atencionListAtencion);
            }
            em.remove(cajero);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cajero> findCajeroEntities() {
        return findCajeroEntities(true, -1, -1);
    }

    public List<Cajero> findCajeroEntities(int maxResults, int firstResult) {
        return findCajeroEntities(false, maxResults, firstResult);
    }

    private List<Cajero> findCajeroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cajero.class));
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

    public Cajero findCajero(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cajero.class, id);
        } finally {
            em.close();
        }
    }

    public int getCajeroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cajero> rt = cq.from(Cajero.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
