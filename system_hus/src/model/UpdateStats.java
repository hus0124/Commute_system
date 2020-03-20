package model;

import java.sql.SQLException;

public interface UpdateStats {

	int updateStats(CommuteDTO cDTO) throws SQLException;
}
