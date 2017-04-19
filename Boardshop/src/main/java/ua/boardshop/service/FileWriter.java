package ua.boardshop.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileWriter {

	enum Folder{
		COMMODITY, PRODUCER, CATEGORY
	}
	
	boolean write(Folder folder, MultipartFile file, Long id);
}
