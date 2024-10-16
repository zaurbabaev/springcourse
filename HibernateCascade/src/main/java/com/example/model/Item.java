package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;

    @Column(name = "item_name")
    String itemName;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person owner;

    public Item(String itemName) {
        this.itemName = itemName;
    }


}
