package com.codeclan.example.filesfolders;

import com.codeclan.example.filesfolders.models.File;
import com.codeclan.example.filesfolders.models.Folder;
import com.codeclan.example.filesfolders.models.User;
import com.codeclan.example.filesfolders.repositories.FileRepository;
import com.codeclan.example.filesfolders.repositories.FolderRepository;
import com.codeclan.example.filesfolders.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilesfoldersApplicationTests {

	@Autowired
	FileRepository fileRepository;

	@Autowired
	FolderRepository folderRepository;

	@Autowired
	UserRepository userRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canAddFileAndFoldersAndUsers() {
		fileRepository.deleteAll();
		folderRepository.deleteAll();
		userRepository.deleteAll();

		User rob = new User("Rob");
		userRepository.save(rob);

		Folder stuff = new Folder("Stuff", rob);
		folderRepository.save(stuff);

		File gubs = new File("gubs1","txt",25, stuff);
		fileRepository.save(gubs);
	}
}
