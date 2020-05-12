package com.codeclan.example.filesfolders.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    private String name;

    @JsonBackReference
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "user")
    private List<Folder> folders;


    public User(String name) {
        this.name = name;
        this.folders = new ArrayList<Folder>();
    }

    public User(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void addFolder(Folder folder) {
        this.folders.add(folder);
    }
}
