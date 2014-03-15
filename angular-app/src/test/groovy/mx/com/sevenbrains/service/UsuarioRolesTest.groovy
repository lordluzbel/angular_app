package mx.com.sevenbrains.service

import mx.com.sevenbrains.dao.SimpleDAO
import mx.com.sevenbrains.model.Roles
import mx.com.sevenbrains.model.Usuario
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by henry on 7/03/14.
 */
@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
class UsuarioRolesTest {

    @Autowired
    SimpleDAO simpleDAO;

    @Test
    def void creaUsuario(){
        Usuario user = new Usuario(
                nombre_usuario: "rpalma"
                , contrasena: "123456"
                , enabled: 1
                , accountNonExpired: 1
                , credentialsNonExpired: 1
                , accountNonLocked: 1
        )

        Usuario searchUser = simpleDAO.getHibernateTemplate().get(Usuario, user.nombre_usuario);

        if(!searchUser){
            Roles ra = new Roles(nombre_rol: "ROLE_ADMIN", desc_rol: "Administrador")


            user.roles = [ra];
            user.contrasena = new BCryptPasswordEncoder(10).encode(user.contrasena)

            simpleDAO.save(ra)
            simpleDAO.save(user)

            assert true
        }else{
            assert new BCryptPasswordEncoder().matches(user.contrasena, searchUser.contrasena)
        }

    }
}
