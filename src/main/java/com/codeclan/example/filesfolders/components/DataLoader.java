package com.codeclan.example.filesfolders.components;

import com.codeclan.example.filesfolders.models.File;
import com.codeclan.example.filesfolders.models.Folder;
import com.codeclan.example.filesfolders.models.User;
import com.codeclan.example.filesfolders.repositories.FileRepository;
import com.codeclan.example.filesfolders.repositories.FolderRepository;
import com.codeclan.example.filesfolders.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    UserRepository userRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){

        User rob = new User("Rob");
        userRepository.save(rob);

        Folder stuff = new Folder("Stuff", rob);
        folderRepository.save(stuff);

        File gubs1 = new File("gubs1", "txt", 25, stuff);
        fileRepository.save(gubs1);


    }
}
