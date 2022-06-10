package tw.leonchen.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("houseService")
public class HouseService {
	
	@Autowired
    private HouseDao hDao;
    
    public House findById(int houseid) throws SQLException {
    	return hDao.findById(houseid);
    }
    
    public List<House> findAll() {
    	return hDao.findAll();
    }
    
}
