package JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import dao.CandidateDAO;
import dao.impl.CandidateImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestInstance(Lifecycle.PER_CLASS)
public class CandidateTesting {
	
	private CandidateDAO candidateDAO;
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NguyenNhutAnh_21139431_NHUTANHNGXX");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	@BeforeAll
	public void setupBeforeClass() throws Exception {
		candidateDAO = new CandidateImpl();
	}
	
	@AfterAll
	public void tearDownAfterClass() throws Exception {
		candidateDAO = null;
	}
	
	
	@Test
	void testListCadidatesByCompanies() {
		System.err.println("List of candidates by companies :");
		candidateDAO.listCadidatesByCompanies().forEach((k, v) -> System.out.println(k.getFullName() + " " + v));
	}
	
//	Tìm danh sách các ứng viên đã làm việc trên một vị trí công việc nào đó có thời gian làm lâu nhất.
	@Test
	void testListCandidatesWithLongestWorking() {
		System.err.println("List of candidates with longest working :");
		candidateDAO.listCandidatesWithLongestWorking()
				.forEach((k, v) -> System.out.println(k.getFullName() + " " + v));
	}
	
//	Thêm một ứng viên mới vào hệ thống.
//	@Test
//	void testAddCandidate() {
//		Candidate candidate = new Candidate("C173", "Nguyễn Nhựt Anh");
//		System.err.println("Add new candidate : " + candidate.getId() + " " + candidate.getFullName() + " " + candidateDAO.addCandidate(candidate));
//	}
	
}
