package model;

import java.sql.SQLException;

public interface UpdateWorkingTime {
	
	int updateWorkingTime(CommuteDTO cDTO) throws SQLException;
	
}
