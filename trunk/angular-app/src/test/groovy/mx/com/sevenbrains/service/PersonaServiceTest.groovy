package mx.com.sevenbrains.service
import mx.com.sevenbrains.domain.Persona
import mx.com.sevenbrains.domain.Sexo
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by lordluzbel on 28/02/14.
 */

@RunWith(SpringJUnit4ClassRunner)
@ContextConfiguration("file:src/main/webapp/WEB-INF/application-context.xml")
class PersonaServiceTest {
    @Autowired
    PersonaService personaService

    @Autowired
    ApplicationContext applicationContext

    @Test
    void testRegistrarPersona() {
        Persona persona = new Persona(
                nombre: "Remedio Alejandro"
                , apellidoPaterno: "Palma"
                , apellidoMaterno: "Cordova"
                , sexo: Sexo.MASCULINO
                , fechaNacimiento: new Date()
        )

        personaService.registrarPersona(persona)
        assert persona.id != null : "Persona es null"
    }
}
