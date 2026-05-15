package dev.ch.librivoxis.service.Livro;

import dev.ch.librivoxis.model.Livro;
import dev.ch.librivoxis.repository.Livro.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class LivroService {

    @Autowired
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository){
        this.livroRepository = livroRepository;
    }

    public Livro cadastrarLivro(Livro livro){
        validarLivro(livro);
        if(livroRepository.existsByIsbn(livro.getIsbn())){
            throw new RuntimeException("Já existe um livro cadastrado com este ISBN.");
        }
        return livroRepository.save(livro);
    }

    public List<Livro> listarLivros(){
        return livroRepository.findAll();
    }

    private void validarLivro (Livro livro){
        if(livro == null){
            throw new RuntimeException("Livro não pode ser nulo.");
        }
        if(livro.getTitle() == null || livro.getTitle().isBlank()){
            throw new RuntimeException("Título é obrigatório");
        }
        if(livro.getAuthor() == null || livro.getAuthor().isBlank()){
            throw new RuntimeException("Autor é obrigatório");
        }
        if(livro.getIsbn() == null || livro.getIsbn().isBlank()){
            throw new RuntimeException("ISBN é obrigatório");
        }
        if(livro.getPrice() == null){
            throw new RuntimeException("Preço é obrigatório.");
        }
        if(livro.getStockQuantity() < 0){
            throw new RuntimeException("Quantidade em estoque não pode ser negativa.");
        }
        if(livro.getPrice().compareTo(BigDecimal.ZERO) < 0){
            throw new RuntimeException("Preço não pode ser negativo");
        }
    }


}
