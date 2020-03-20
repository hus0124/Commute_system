package model;

import java.sql.SQLException;
import java.util.List;

public interface todayView {
	List<CommuteDTO> todaySelect(CommuteDTO cDTO) throws SQLException;
}
