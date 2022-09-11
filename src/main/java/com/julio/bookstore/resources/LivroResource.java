package com.julio.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.julio.bookstore.domain.Livro;
import com.julio.bookstore.dtos.LivroDTO;
import com.julio.bookstore.service.LivroService;

@RestController
@RequestMapping(value="/livros")
public class LivroResource {
	
	@Autowired
	private LivroService service;

	@GetMapping(value="/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id){
		Livro obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
	}
	@GetMapping
	public ResponseEntity<List<LivroDTO>>findAll(@RequestParam(value="categoria", defaultValue = "0") Integer id_cat){
		List<Livro> list = service.findAll(id_cat);
		List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
//	
//	@PostMapping
//	public ResponseEntity<Livro> create(@RequestBody Livro obj){
//		obj = service.create(obj);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	
	@PatchMapping(value = "/{id}")
	public ResponseEntity<Livro> updatePath(@PathVariable Integer id, @RequestBody Livro obj){
		Livro newObj = service.update(id, obj);
		return ResponseEntity.ok().body(newObj);
	}
	

}
