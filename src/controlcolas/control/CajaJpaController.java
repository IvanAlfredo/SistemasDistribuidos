/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.control; 

import controlcolas.control.exceptions.NonexistentEntityException;
import controlcolas.control.exceptions.PreexistingEntityException;
import controlcolas.modelo.Caja;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
public class CajaJpaController implements Serializable {

    public CajaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public CajaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ControlColasPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Caja caja) throws PreexistingEntityException, Exception {
        if (caja.getCajeroList() == null) {
            caja.setCajeroList(new ArrayList<Cajero>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Cajero> attachedCajeroList = new ArrayList<Cajero>();
            for (Cajero cajeroListCajeroToAttach : caja.getCajeroList()) {
                cajeroListCajeroToAttach = em.getReference(cajeroListCajeroToAttach.getClass(), cajeroListCajeroToAttach.getId());
                attachedCajeroList.add(cajeroListCajeroToAttach);
            }
            caja.setCajeroList(attachedCajeroList);
            em.persist(caja);
            for (Cajero cajeroListCajero : caja.getCajeroList()) {
                Caja oldCajaOfCajeroListCajero = cajeroListCajero.getCaja();
                cajeroListCajero.setCaja(caja);
                cajeroListCajero = em.merge(cajeroListCajero);
                if (oldCajaOfCajeroListCajero != null) {
                    oldCajaOfCajeroListCajero.getCajeroList().remove(cajeroListCajero);
                    oldCajaOfCajeroListCajero = em.merge(oldCajaOfCajeroListCajero);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCaja(caja.getId()) != null) {
                throw new PreexistingEntityException("Caja " + caja + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Caja caja) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Caja persistentCaja = em.find(Caja.class, caja.getId());
            List<Cajero> cajeroListOld = persistentCaja.getCajeroList();
            List<Cajero> cajeroListNew = caja.getCajeroList();
            List<Cajero> attachedCajeroListNew = new ArrayList<Cajero>();
            for (Cajero cajeroListNewCajeroToAttach : cajeroListNew) {
                cajeroListNewCajeroToAttach = em.getReference(cajeroListNewCajeroToAttach.getClass(), cajeroListNewCajeroToAttach.getId());
                attachedCajeroListNew.add(cajeroListNewCajeroToAttach);
            }
            cajeroListNew = attachedCajeroListNew;
            caja.setCajeroList(cajeroListNew);
            caja = em.merge(caja);
            for (Cajero cajeroListOldCajero : cajeroListOld) {
                if (!cajeroListNew.contains(cajeroListOldCajero)) {
                    cajeroListOldCajero.setCaja(null);
                    cajeroListOldCajero = em.merge(cajeroListOldCajero);
                }
            }
            for (Cajero cajeroListNewCajero : cajeroListNew) {
                if (!cajeroListOld.contains(cajeroListNewCajero)) {
                    Caja oldCajaOfCajeroListNewCajero = cajeroListNewCajero.getCaja();
                    cajeroListNewCajero.setCaja(caja);
                    cajeroListNewCajero = em.merge(cajeroListNewCajero);
                    if (oldCajaOfCajeroListNewCajero != null && !oldCajaOfCajeroListNewCajero.equals(caja)) {
                        oldCajaOfCajeroListNewCajero.getCajeroList().remove(cajeroListNewCajero);
                        oldCajaOfCajeroListNewCajero = em.merge(oldCajaOfCajeroListNewCajero);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = caja.getId();
                if (findCaja(id) == null) {
                    throw new NonexistentEntityException("The caja with id " + id + " no longer exists.");
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
            Caja caja;
            try {
                caja = em.getReference(Caja.class, id);
                caja.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The caja with id " + id + " no longer exists.", enfe);
            }
            List<Cajero> cajeroList = caja.getCajeroList();
            for (Cajero cajeroListCajero : cajeroList) {
                cajeroListCajero.setCaja(null);
                cajeroListCajero = em.merge(cajeroListCajero);
            }
            em.remove(caja);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Caja> findCajaEntities() {
        return findCajaEntities(true, -1, -1);
    }

    public List<Caja> findCajaEntities(int maxResults, int firstResult) {
        return findCajaEntities(false, maxResults, firstResult);
    }

    private List<Caja> findCajaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Caja.class));
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

    public Caja findCaja(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Caja.class, id);
        } finally {
            em.close();
        }
    }

    public int getCajaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Caja> rt = cq.from(Caja.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
