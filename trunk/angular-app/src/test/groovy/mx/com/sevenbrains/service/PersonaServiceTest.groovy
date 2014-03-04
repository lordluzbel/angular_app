package mx.com.sevenbrains.service

import mx.com.sevenbrains.domain.Persona
import mx.com.sevenbrains.domain.Sexo
import org.springframework.context.ApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext
/**
 * Created by lordluzbel on 28/02/14.
 */
class PersonaServiceTest extends GroovyTestCase {
    ApplicationContext applicationContext

    void setUp() {
        applicationContext = new ClassPathXmlApplicationContext(
            "file:src/main/webapp/WEB-INF/application-context.xml"
        )
    }

    void testRegistrarPersona() {
        PersonaService personaService = applicationContext.getBean("personaService")
        Persona persona = new Persona(
                nombre: "Remedio Alejandro"
                , apellidoPaterno: "Palma"
                , apellidoMaterno: "Cordova"
                , sexo: Sexo.MASCULINO
                , fechaNacimiento: new Date()
        )

        assert persona.id == null : "Persona es null"
    }
}
