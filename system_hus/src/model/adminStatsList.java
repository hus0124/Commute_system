package model;

import java.sql.SQLException;
import java.util.List;

public interface adminStatsList {
	List<CommuteDTO> readList(CommuteDTO cDTO) throws SQLException;
}
