package com.kcing.document.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.kcing.document.entities.Document;
import com.kcing.document.repository.DocumentRepository;

@Controller
public class DocumentController {
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@RequestMapping("/displayUpload")
	public String displayUpload(ModelMap modelMap) {
		List<Document> all = documentRepository.findAll();
		
		modelMap.addAttribute("documents", all);
		return "documentUpload";
	}
	@RequestMapping( value="/upload",method=RequestMethod.POST)
	public String uploadDocument(@RequestParam("document")MultipartFile multipartFile,@RequestParam("id") long id,ModelMap modelMap) throws IOException {
		String fileName = multipartFile.getOriginalFilename();
		Document document = new Document();
		document.setId(id);
		document.setName(fileName);
		document.setData(multipartFile.getBytes());
		documentRepository.save(document);
		
		List<Document> all = documentRepository.findAll();
		
		modelMap.addAttribute("documents", all);
		return "documentUpload";
		
	}

	@RequestMapping("/download")
	public StreamingResponseBody download(@RequestParam("id") long id,HttpServletResponse response) {
		
		Document document = documentRepository.getOne(id);
		byte[] data = document.getData();
		response.setHeader("Content-disposition", "attachment;filename-downloaded.jpeg");
		return outputStream -> {
			outputStream.write(data);
		};
		
	}
}
