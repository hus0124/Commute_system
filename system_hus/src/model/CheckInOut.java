package model;

import java.sql.SQLException;

public interface CheckInOut {

	int checkinout(CommuteDTO cDTO) throws SQLException;
}
