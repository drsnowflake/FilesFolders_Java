package com.codeclan.example.filesfolders.controllers;

import com.codeclan.example.filesfolders.models.File;
import com.codeclan.example.filesfolders.repositories.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/files")
public class FileController {

    @Autowired
    FileRepository fileRepository;

    @GetMapping
    public ResponseEntity<List<File>> getAllFiles(){
        return new ResponseEntity<>(fileRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<File>> getFile(@PathVariable Long id){
        return new ResponseEntity<>(fileRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<File> postFile(@RequestBody File newFile){
        fileRepository.save(newFile);
        return new ResponseEntity<>(newFile, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<File> putFile(@PathVariable Long id, @RequestBody File newFile){
        fileRepository.findById(id)
               .map(file -> {
                    file.setName(newFile.getName());
                    file.setExtension(newFile.getExtension());
                    file.setSize(newFile.getSize());
                    file.setFolder(file.getFolder());
                    fileRepository.save(file);
                   return (file);
                });
        return new ResponseEntity<>(newFile, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFile(@PathVariable Long id){
        fileRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
