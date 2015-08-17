package ch.bbcag.gamexchange.lowlevel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import ch.bbcag.gamexchange.lowlevel.model.Item;

public class ItemDaoImpl implements ItemDao {
	private final static Logger LOGGER = Logger.getLogger(ItemDaoImpl.class.getName());
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public ItemDaoImpl() {
		try{
			DataSource ds = (DataSource) InitialContext.doLookup("Onlineshop");
			con = ds.getConnection();
			if(con.isValid(10)) {
				LOGGER.info("Connection successful");
			}
			con.close();
		} catch(Exception ex) {
			LOGGER.severe("Connection failed");
		}
	}

	@Override
	public List<Item> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item create(Item item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Item item) {
		// TODO Auto-generated method stub
		
	}

}
