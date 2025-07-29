package com.refurniture.service;

import com.refurniture.model.Item;
import com.refurniture.repository.ItemRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {
    private final ItemRepository repo;

    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    public List<Item> getAll() { return repo.findAll(); }

    public Item getById(Long id) { return repo.findById(id).orElse(null); }

    public Item create(Item item) { return repo.save(item); }

    public Item update(Long id, Item updated) {
        Item item = repo.findById(id).orElse(null);
        if (item == null) return null;
        item.setTitle(updated.getTitle());
        item.setDescription(updated.getDescription());
        item.setPrice(updated.getPrice());
        item.setImageUrl(updated.getImageUrl());
        return repo.save(item);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
