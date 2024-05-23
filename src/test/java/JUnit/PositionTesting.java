package JUnit;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import dao.PositionDAO;
import dao.impl.PositionImpl;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@TestInstance(Lifecycle.PER_CLASS)
public class PositionTesting {
	
	private PositionDAO positionDAO;
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("NguyenNhutAnh_21139431_NHUTANHNGXX");
	EntityManager em = entityManagerFactory.createEntityManager();
	
	@BeforeAll
	public void setupBeforeClass() throws Exception {
		positionDAO = new PositionImpl();
	}
	
	@AfterAll
	public void tearDownAfterClass() throws Exception {
		positionDAO = null;
	}
	
	@Test
	void testListPositions() {
		System.err.println("testListPositions");
		List<Position> positions = positionDAO.listPositions("Network Administrator", 0, 10000000);
		assert(positions.size() > 0);
		positions.forEach(p -> System.out.println(p));
	}
	
	@Test
	void testListYearsOfExperienceByPosition() {
		System.err.println("testListYearsOfExperienceByPosition");
//		ma = "C101";
		Map<Position, Integer> map = positionDAO.listYearsOfExperienceByPosition("C101");
		assert(map.size() > 0);
		map.forEach((k, v) -> System.out.println(k + " " + v));
	}

}
