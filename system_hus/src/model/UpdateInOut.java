package model;

import java.sql.SQLException;

public interface UpdateInOut {

	int updateInOut(CommuteDTO cDTO) throws SQLException;
		
}
