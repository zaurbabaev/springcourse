package az.babayev.springcourse.services;

import az.babayev.springcourse.models.Item;
import az.babayev.springcourse.models.Person;
import az.babayev.springcourse.repositories.ItemsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ItemService {

    private final ItemsRepository itemsRepository;

    public List<Item> findByItemName(String itemName) {
        return itemsRepository.findByItemName(itemName);
    }

    public List<Item> findByItemOwner(Person owner) {
        return itemsRepository.findByOwner(owner);
    }




}
