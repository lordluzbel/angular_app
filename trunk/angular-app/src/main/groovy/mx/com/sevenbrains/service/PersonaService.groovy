package mx.com.sevenbrains.service
import mx.com.sevenbrains.dao.SimpleDAO
import mx.com.sevenbrains.model.Persona
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
/**
 * Created by lordluzbel on 28/02/14.
 */
@Service
class PersonaService {
    @Autowired
    SimpleDAO simpleDAO

    def registrarPersona(Persona persona){
        simpleDAO.save(persona)
    }
}
