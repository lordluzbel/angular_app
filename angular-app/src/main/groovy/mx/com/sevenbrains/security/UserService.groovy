package mx.com.sevenbrains.security

import mx.com.sevenbrains.dao.SimpleDAO
import mx.com.sevenbrains.model.Roles
import mx.com.sevenbrains.model.Usuario
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

/**
 * Created by henry on 7/03/14.
 */
class UserService implements UserDetailsService {
    @Autowired
    private SimpleDAO simpleDAO;

    @Override
    UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario user = simpleDAO.hibernateTemplate.get(Usuario, userName)

        return new User(
                user.nombre_usuario
                , user.contrasena
                , user.enabled
                , user.accountNonExpired
                , user.credentialsNonExpired
                , user.accountNonLocked
                , getRoles(user)
        )
    }

    def List<GrantedAuthority> getRoles(Usuario usuario)  {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        List<Roles> listaRoles = simpleDAO.hibernateTemplate.findByNamedQueryAndNamedParam("Usuario.getRoles", "nombre_usuario", usuario.nombre_usuario)
        listaRoles.each() {
            authorities.add(new SimpleGrantedAuthority(it.nombre_rol))
        }
        authorities
    }
}
