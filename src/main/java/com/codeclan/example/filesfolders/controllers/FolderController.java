package com.codeclan.example.filesfolders.controllers;

import com.codeclan.example.filesfolders.models.Folder;
import com.codeclan.example.filesfolders.repositories.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/folders")
public class FolderController {

    @Autowired
    FolderRepository folderRepository;

    @GetMapping
    public ResponseEntity<List<Folder>> getAllFolders(){
        return new ResponseEntity<>(folderRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Folder>> getFolder(@PathVariable Long id){
        return new ResponseEntity<>(folderRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Folder> postFolder(@RequestBody Folder folder){
        folderRepository.save(folder);
        return new ResponseEntity<>(folder, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Folder> putFolder(@PathVariable Long id, @RequestBody Folder newFolder){
        folderRepository.findById(id)
                .map(folder -> {
                    folder.setName(newFolder.getName());
                    folder.setUser(folder.getUser());
                    folderRepository.save(folder);
                    return (folder);
                });
        return new ResponseEntity<>(newFolder, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFolder(@PathVariable Long id){
        folderRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
