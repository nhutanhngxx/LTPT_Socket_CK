package dao.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import dao.PositionDAO;
import entity.Position;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class PositionImpl implements PositionDAO {

	private EntityManager em;

	public PositionImpl() {
		this.em = Persistence.createEntityManagerFactory("NguyenNhutAnh_21139431_NHUTANHNGXX").createEntityManager();
	}

	@Override
	public List<Position> listPositions(String name, double salaryFrom, double salaryTo) {
		return em.createNamedQuery("Position.listPositions", Position.class).setParameter("name", "%" + name + "%")
				.setParameter("salaryFrom", salaryFrom).setParameter("salaryTo", salaryTo).getResultList();
	}

	@Override
	public Map<Position, Integer> listYearsOfExperienceByPosition(String ma) {
		Map<Position, Integer> map = new LinkedHashMap<>();
		List <?> rs = em.createNativeQuery("SELECT e.position_id, DATEDIFF(YEAR, e.from_date, e.to_date) AS soNam FROM experiences e WHERE e.candidate_id = ?")
		.setParameter(1, ma).getResultList();
		rs.forEach(r -> {
			Object[] row = (Object[]) r;
			Position p = em.find(Position.class, row[0]);
			Number n = (Number) row[1];
			map.put(p, n.intValue());
		});
		return map. isEmpty() ? null : map;
	}
}
