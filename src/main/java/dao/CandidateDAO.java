package dao;

import java.util.Map;

import entity.Candidate;

public interface CandidateDAO {
	
	public Map<Candidate, Long> listCadidatesByCompanies();
	
	public Map<Candidate, String> listCandidatesWithLongestWorking();
	
	public boolean addCandidate(Candidate candidate);
	

}
