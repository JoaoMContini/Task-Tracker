package br.unipar.programacaoweb.taskandtracker.service;
import br.unipar.programacaoweb.taskandtracker.model.Usuario;
import br.unipar.programacaoweb.taskandtracker.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public void deletarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
