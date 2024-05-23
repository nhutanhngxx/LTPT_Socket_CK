package dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.CandidateDAO;
import entity.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CandidateImpl implements CandidateDAO {
	
	private EntityManager em;
	
	public CandidateImpl() {
        this.em = Persistence.createEntityManagerFactory("NguyenNhutAnh_21139431_NHUTANHNGXX").createEntityManager();
	}

	@Override
	public Map<Candidate, Long> listCadidatesByCompanies() {
		Map<Candidate, Long> result = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = em.createNamedQuery("Candidate.listCandidatesByCompanies").getResultList();
		    
		for (Object[] resultItem : resultList) {
		       Candidate candidate = (Candidate) resultItem[0];
		       Long companyCount = (Long) resultItem[1];
		       result.put(candidate, companyCount);
		}
		return result;
	}
	
//	Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có thời gian làm lâu nhất.
//	+ listCandidatesWithLongestWorking (): Map<Candidate, Position>
	@Override
	public Map<Candidate, String> listCandidatesWithLongestWorking() {
		Map<Candidate, String> result = new HashMap<>();
		@SuppressWarnings("unchecked")
		List<Object[]> resultList = em.createNamedQuery("Candidate.listCandidatesWithLongestWorking").getResultList();

		for (Object[] resultItem : resultList) {
			Candidate candidate = (Candidate) resultItem[0];
			String position = (String) resultItem[1];
			result.put(candidate, position);
		}
		return result;
	}
	
	@Override
	public boolean addCandidate(Candidate candidate) {
	    if (!candidate.getId().matches("C\\d{3,}")) {
	        return false;
	    }
	    try {
	        em.getTransaction().begin();
	        em.persist(candidate);
	        em.getTransaction().commit();
	        return true;
	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
}
