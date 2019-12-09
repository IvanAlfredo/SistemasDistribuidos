/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlcolas.control;

import controlcolas.control.exceptions.NonexistentEntityException;
import controlcolas.control.exceptions.PreexistingEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import controlcolas.modelo.Cola;
import controlcolas.modelo.Atencion;
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
public class FichaJpaController implements Serializable {

    public FichaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public FichaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("ControlColasPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Ficha ficha) throws PreexistingEntityException, Exception {
        if (ficha.getAtencionList() == null) {
            ficha.setAtencionList(new ArrayList<Atencion>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cola cola = ficha.getCola();
            if (cola != null) {
                cola = em.getReference(cola.getClass(), cola.getId());
                ficha.setCola(cola);
            }
            List<Atencion> attachedAtencionList = new ArrayList<Atencion>();
            for (Atencion atencionListAtencionToAttach : ficha.getAtencionList()) {
                atencionListAtencionToAttach = em.getReference(atencionListAtencionToAttach.getClass(), atencionListAtencionToAttach.getId());
                attachedAtencionList.add(atencionListAtencionToAttach);
            }
            ficha.setAtencionList(attachedAtencionList);
            em.persist(ficha);
            if (cola != null) {
                cola.getFichaList().add(ficha);
                cola = em.merge(cola);
            }
            for (Atencion atencionListAtencion : ficha.getAtencionList()) {
                Ficha oldFichaOfAtencionListAtencion = atencionListAtencion.getFicha();
                atencionListAtencion.setFicha(ficha);
                atencionListAtencion = em.merge(atencionListAtencion);
                if (oldFichaOfAtencionListAtencion != null) {
                    oldFichaOfAtencionListAtencion.getAtencionList().remove(atencionListAtencion);
                    oldFichaOfAtencionListAtencion = em.merge(oldFichaOfAtencionListAtencion);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findFicha(ficha.getId()) != null) {
                throw new PreexistingEntityException("Ficha " + ficha + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ficha ficha) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ficha persistentFicha = em.find(Ficha.class, ficha.getId());
            Cola colaOld = persistentFicha.getCola();
            Cola colaNew = ficha.getCola();
            List<Atencion> atencionListOld = persistentFicha.getAtencionList();
            List<Atencion> atencionListNew = ficha.getAtencionList();
            if (colaNew != null) {
                colaNew = em.getReference(colaNew.getClass(), colaNew.getId());
                ficha.setCola(colaNew);
            }
            List<Atencion> attachedAtencionListNew = new ArrayList<Atencion>();
            for (Atencion atencionListNewAtencionToAttach : atencionListNew) {
                atencionListNewAtencionToAttach = em.getReference(atencionListNewAtencionToAttach.getClass(), atencionListNewAtencionToAttach.getId());
                attachedAtencionListNew.add(atencionListNewAtencionToAttach);
            }
            atencionListNew = attachedAtencionListNew;
            ficha.setAtencionList(atencionListNew);
            ficha = em.merge(ficha);
            if (colaOld != null && !colaOld.equals(colaNew)) {
                colaOld.getFichaList().remove(ficha);
                colaOld = em.merge(colaOld);
            }
            if (colaNew != null && !colaNew.equals(colaOld)) {
                colaNew.getFichaList().add(ficha);
                colaNew = em.merge(colaNew);
            }
            for (Atencion atencionListOldAtencion : atencionListOld) {
                if (!atencionListNew.contains(atencionListOldAtencion)) {
                    atencionListOldAtencion.setFicha(null);
                    atencionListOldAtencion = em.merge(atencionListOldAtencion);
                }
            }
            for (Atencion atencionListNewAtencion : atencionListNew) {
                if (!atencionListOld.contains(atencionListNewAtencion)) {
                    Ficha oldFichaOfAtencionListNewAtencion = atencionListNewAtencion.getFicha();
                    atencionListNewAtencion.setFicha(ficha);
                    atencionListNewAtencion = em.merge(atencionListNewAtencion);
                    if (oldFichaOfAtencionListNewAtencion != null && !oldFichaOfAtencionListNewAtencion.equals(ficha)) {
                        oldFichaOfAtencionListNewAtencion.getAtencionList().remove(atencionListNewAtencion);
                        oldFichaOfAtencionListNewAtencion = em.merge(oldFichaOfAtencionListNewAtencion);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = ficha.getId();
                if (findFicha(id) == null) {
                    throw new NonexistentEntityException("The ficha with id " + id + " no longer exists.");
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
            Ficha ficha;
            try {
                ficha = em.getReference(Ficha.class, id);
                ficha.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The ficha with id " + id + " no longer exists.", enfe);
            }
            Cola cola = ficha.getCola();
            if (cola != null) {
                cola.getFichaList().remove(ficha);
                cola = em.merge(cola);
            }
            List<Atencion> atencionList = ficha.getAtencionList();
            for (Atencion atencionListAtencion : atencionList) {
                atencionListAtencion.setFicha(null);
                atencionListAtencion = em.merge(atencionListAtencion);
            }
            em.remove(ficha);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ficha> findFichaEntities() {
        return findFichaEntities(true, -1, -1);
    }

    public List<Ficha> findFichaEntities(int maxResults, int firstResult) {
        return findFichaEntities(false, maxResults, firstResult);
    }

    private List<Ficha> findFichaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Ficha.class));
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

    public Ficha findFicha(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ficha.class, id);
        } finally {
            em.close();
        }
    }

    public int getFichaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Ficha> rt = cq.from(Ficha.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
