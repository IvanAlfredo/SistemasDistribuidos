/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.control;
 
import controlcolas.control.exceptions.NonexistentEntityException;
import controlcolas.control.exceptions.PreexistingEntityException;
import controlcolas.modelo.Cola;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import controlcolas.modelo.Ficha;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author RDuran
 */
public class ColaJpaController implements Serializable {

    public ColaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public ColaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ControlColasPU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cola cola) throws PreexistingEntityException, Exception {
        if (cola.getFichaList() == null) {
            cola.setFichaList(new ArrayList<Ficha>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Ficha> attachedFichaList = new ArrayList<Ficha>();
            for (Ficha fichaListFichaToAttach : cola.getFichaList()) {
                fichaListFichaToAttach = em.getReference(fichaListFichaToAttach.getClass(), fichaListFichaToAttach.getId());
                attachedFichaList.add(fichaListFichaToAttach);
            }
            cola.setFichaList(attachedFichaList);
            em.persist(cola);
            for (Ficha fichaListFicha : cola.getFichaList()) {
                Cola oldColaOfFichaListFicha = fichaListFicha.getCola();
                fichaListFicha.setCola(cola);
                fichaListFicha = em.merge(fichaListFicha);
                if (oldColaOfFichaListFicha != null) {
                    oldColaOfFichaListFicha.getFichaList().remove(fichaListFicha);
                    oldColaOfFichaListFicha = em.merge(oldColaOfFichaListFicha);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findCola(cola.getId()) != null) {
                throw new PreexistingEntityException("Cola " + cola + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cola cola) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cola persistentCola = em.find(Cola.class, cola.getId());
            List<Ficha> fichaListOld = persistentCola.getFichaList();
            List<Ficha> fichaListNew = cola.getFichaList();
            List<Ficha> attachedFichaListNew = new ArrayList<Ficha>();
            for (Ficha fichaListNewFichaToAttach : fichaListNew) {
                fichaListNewFichaToAttach = em.getReference(fichaListNewFichaToAttach.getClass(), fichaListNewFichaToAttach.getId());
                attachedFichaListNew.add(fichaListNewFichaToAttach);
            }
            fichaListNew = attachedFichaListNew;
            cola.setFichaList(fichaListNew);
            cola = em.merge(cola);
            for (Ficha fichaListOldFicha : fichaListOld) {
                if (!fichaListNew.contains(fichaListOldFicha)) {
                    fichaListOldFicha.setCola(null);
                    fichaListOldFicha = em.merge(fichaListOldFicha);
                }
            }
            for (Ficha fichaListNewFicha : fichaListNew) {
                if (!fichaListOld.contains(fichaListNewFicha)) {
                    Cola oldColaOfFichaListNewFicha = fichaListNewFicha.getCola();
                    fichaListNewFicha.setCola(cola);
                    fichaListNewFicha = em.merge(fichaListNewFicha);
                    if (oldColaOfFichaListNewFicha != null && !oldColaOfFichaListNewFicha.equals(cola)) {
                        oldColaOfFichaListNewFicha.getFichaList().remove(fichaListNewFicha);
                        oldColaOfFichaListNewFicha = em.merge(oldColaOfFichaListNewFicha);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cola.getId();
                if (findCola(id) == null) {
                    throw new NonexistentEntityException("The cola with id " + id + " no longer exists.");
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
            Cola cola;
            try {
                cola = em.getReference(Cola.class, id);
                cola.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cola with id " + id + " no longer exists.", enfe);
            }
            List<Ficha> fichaList = cola.getFichaList();
            for (Ficha fichaListFicha : fichaList) {
                fichaListFicha.setCola(null);
                fichaListFicha = em.merge(fichaListFicha);
            }
            em.remove(cola);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cola> findColaEntities() {
        return findColaEntities(true, -1, -1);
    }

    public List<Cola> findColaEntities(int maxResults, int firstResult) {
        return findColaEntities(false, maxResults, firstResult);
    }

    private List<Cola> findColaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cola.class));
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

    public Cola findCola(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cola.class, id);
        } finally {
            em.close();
        }
    }

    public int getColaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cola> rt = cq.from(Cola.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
