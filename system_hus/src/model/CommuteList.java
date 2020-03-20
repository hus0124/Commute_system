package model;

import java.sql.SQLException;
import java.util.List;

public interface CommuteList {
	
	List<CommuteDTO> readList() throws SQLException;
	
}
