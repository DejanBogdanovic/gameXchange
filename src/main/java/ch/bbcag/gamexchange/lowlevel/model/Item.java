package ch.bbcag.gamexchange.lowlevel.model;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class Item implements Serializable {
	private static final long serialVersionUID = -6604363993041715170L;

	private Long id;
	private String title;
	private String description;
	private Double price;
	private String foto;
	private Long seller;
	private Long buyer;
	private Date sold;

	public Item() {
		
	}

	public Item(String title, String description, Double price, Long seller) {
		this.title = title;
		this.description = description;
		this.price = price;
		this.seller = seller;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Long getSeller() {
		return seller;
	}

	public void setSeller(Long seller) {
		this.seller = seller;
	}

	public Long getBuyer() {
		return this.buyer;
	}

	public void setBuyer(Long buyer) {
		this.buyer = buyer;
	}

	public Date getSold() {
		return sold;
	}

	public void setSold(Date sold) {
		this.sold = sold;
	}

	public String toString() {
		return "[" + getId() + "," + getTitle() + "," + getDescription() + ","
				+ getPrice() + "," + getSeller() + "," + getBuyer() + ","
				+ getSold() + "]";
	}

	public static Item fromResultSet(ResultSet rs) throws SQLException {
		Item item = new Item();

		Long id = Long.valueOf(rs.getLong("id"));
		item.setId(id);

		String title = rs.getString("title");
		item.setTitle(title);

		String description = rs.getString("description");
		item.setDescription(description);

		double price = rs.getDouble("price");
		if (price != 0) {
			item.setPrice(Double.valueOf(price));
		}

		String foto = rs.getString("foto");
		item.setFoto(foto);

		long seller = rs.getLong("seller_id");
		if (seller != 0) {
			item.setSeller(Long.valueOf(seller));
		}

		long buyer = rs.getLong("buyer_id");
		if (buyer != 0) {
			item.setBuyer(Long.valueOf(buyer));
		}

		Timestamp ts = rs.getTimestamp("sold");
		if (ts != null) {
			Date sold = new Date(ts.getTime());
			item.setSold(sold);
		}

		return item;
	}

}
