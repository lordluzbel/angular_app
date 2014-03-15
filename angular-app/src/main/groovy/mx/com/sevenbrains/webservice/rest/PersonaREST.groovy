package mx.com.sevenbrains.webservice.rest
import mx.com.sevenbrains.model.Persona
import mx.com.sevenbrains.model.Sexo

import javax.ws.rs.*
/**
 * Created by lordluzbel on 28/02/14.
 */
@Singleton
@Path("/persona")
class PersonaREST {
    List<Persona> personaList = [
            new Persona(
                    id: 1
                    ,nombre: "Remedio Alejandro"
                    ,apellidoPaterno: "Palma"
                    ,apellidoMaterno: "Cordova"
                    ,sexo: Sexo.MASCULINO
                    ,fechaNacimiento: new Date()
            )
            ,new Persona(
                    id: 2
                    ,nombre: "Luis Fernando"
                    ,apellidoPaterno: "Aguirre"
                    ,apellidoMaterno: "Canepa"
                    ,sexo: Sexo.MASCULINO
                    ,fechaNacimiento: new Date()
            )
            ,new Persona(
                    id: 3
                    ,nombre: "Maria Eloisa"
                    ,apellidoPaterno: "Acosta"
                    ,apellidoMaterno: "Marin"
                    ,sexo: Sexo.FEMENINO
                    ,fechaNacimiento: new Date()
            )
    ]

    Random random = new Random(1000L)
    PersonaREST() {
        super()
    }

    @GET
    @Path("/list")
    @Consumes("application/json")
    @Produces("application/json")
    def List<Persona> list(){
        personaList
    }

    @GET
    @Path("/get")
    @Consumes("application/json")
    @Produces("application/json")
    def Persona get(@QueryParam("id") Long id){
        Persona resultado = null;
        personaList.each {Persona persona ->
            if (persona.id == id){
                resultado = persona
            }
        }
        return resultado
    }

    @POST
    @Path("/put")
    @Consumes("application/json")
    @Produces("application/json")
    def Persona put(Persona persona){
        persona.id = (Long) random.nextInt(100);
        personaList.add(persona)
        return persona
    }
}
