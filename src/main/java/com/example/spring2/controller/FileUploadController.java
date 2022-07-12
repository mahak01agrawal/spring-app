package com.example.spring2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring2.util.FileUpload;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FileUploadController {
	@Autowired
	private FileUpload fileUpload;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, String name, String section) {
		try {
			if (file.isEmpty()) {
				ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain a file");
			}
            fileUpload.uploadFile(file);
			// String path = fileUpload.uploadFile(file);
			// return ResponseEntity.ok(path);
		} catch (Exception e) {
			System.out.println(e);
		}

		return ResponseEntity.ok("Not working");

	}
}
