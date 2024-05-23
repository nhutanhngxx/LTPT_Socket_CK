package dao;

import java.util.List;
import java.util.Map;

import entity.Position;

public interface PositionDAO {
	
	public List<Position> listPositions(String name, double salaryFrom, double salaryTo);
	
	public Map<Position, Integer> listYearsOfExperienceByPosition(String ma);

}
