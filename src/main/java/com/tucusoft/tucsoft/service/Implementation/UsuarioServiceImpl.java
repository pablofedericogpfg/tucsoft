package com.tucusoft.tucsoft.service.Implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.tucusoft.tucsoft.model.Usuario;
import com.tucusoft.tucsoft.repository.UsuarioRepository;
import com.tucusoft.tucsoft.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
      
       return  usuarioRepository.save(usuario);
    }

    @Override
    public Optional<Usuario> get(Integer id) {
      
       return  usuarioRepository.findById(id);
    }

    @Override
    public void update(Usuario usuario) {
 
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Integer id) {
    
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findAll() {
 
        return  usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
       return usuarioRepository.findByEmail(email);
    }

    

}
