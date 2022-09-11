package com.julio.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.bookstore.domain.Livro;
import com.julio.bookstore.repositories.LivroRepository;
import com.julio.bookstore.service.exceptions.ObjectNotFoundException;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + " tipo: " + Livro.class.getName()));
	}

	public List<Livro> findAll(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoria(id_cat);
	}

	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}

//	public Livro update(Integer id, LivroDTO objDto) {
//		Livro obj = findById(id);
//
//		obj.setNome(objDto.getNome());
//		obj.setDescricao(objDto.getDescricao());
//		return repository.save(obj);
//	}

//	public void delete(Integer id) {
//		findById(id);
//		try {
//			repository.deleteById(id);
//		} catch (DataIntegrityViolationException e) {
//			throw new com.julio.bookstore.service.exceptions.DataIntegrityViolationException("Categoria não pode ser deteletado! possui livros associados.");
//		}
//
//	}
}
