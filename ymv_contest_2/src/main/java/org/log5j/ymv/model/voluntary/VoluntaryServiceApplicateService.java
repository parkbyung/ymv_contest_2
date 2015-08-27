package org.log5j.ymv.model.voluntary;

import java.util.List;

public interface VoluntaryServiceApplicateService {
	public void registerVolunteerApplicant(VoluntaryServiceApplicateVO vsavo);
	public boolean checkVolunteerApplicant(int recruitNo, int memberNo);
	public List<ApplicantVO> findApplicantList(int recruitNo);
	public void deleteApplicant(ApplicantVO alvo);
	public void deleteVoluntaryApplicantOK(int recruitNo);
}