package com.project.sportstore.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public interface StorageService {
	void store (MultipartFile file);
	void init();
}
