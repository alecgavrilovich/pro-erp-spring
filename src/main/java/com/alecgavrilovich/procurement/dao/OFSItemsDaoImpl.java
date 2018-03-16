package com.alecgavrilovich.procurement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

import com.alecgavrilovich.procurement.domain.OFSItem;

@Component
public class OFSItemsDaoImpl implements OFSItemsDao {

	@Override
	public List<OFSItem> findByOFSId(Integer ofsId) {
		
		List<OFSItem> ofsItemsList = new ArrayList<>();
		
		try {
			Connection connection = DBUtil.getDataSource().getConnection();
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM ofs_item WHERE ofs_id = ?");
			ps.setInt(1, ofsId);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				OFSItem ofsItem = new OFSItem();
				ofsItem.setId(rs.getInt("id"));
				ofsItem.setOfsId(rs.getInt("ofs_id"));
				ofsItem.setProductName(rs.getString("product_name"));
				ofsItem.setProductId(rs.getInt("product_id"));
				ofsItem.setQuantity(rs.getInt("quantity"));
				ofsItem.setOrderDate(rs.getDate("ORDER_DATE"));
				ofsItem.setDeliveryTime(rs.getDate("delivery_time"));
				ofsItemsList.add(ofsItem);
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return ofsItemsList;
	}

	@Override
	public void save(OFSItem ofsItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(OFSItem ofsItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub

	}

}
