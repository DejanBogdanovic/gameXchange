package ch.bbcag.gamexchange.lowlevel.dao;

import java.util.List;

import ch.bbcag.gamexchange.lowlevel.model.Item;

public interface ItemDao {
  public List<Item> getAll();
  public Item getById(Long id);
  public Item create(Item item);
  public void update(Item item);
  public void delete(Item item);
}