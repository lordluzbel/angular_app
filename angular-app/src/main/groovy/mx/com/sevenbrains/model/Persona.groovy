package mx.com.sevenbrains.model

import javax.persistence.*
/**
 * Created by lordluzbel on 28/02/14.
 */
@Entity
class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genSeqPersona")
    @SequenceGenerator(name = "genSeqPersona", sequenceName = "persona_id_seq", allocationSize = 1)
    Long id;
    String nombre;
    String apellidoPaterno;
    String apellidoMaterno;

    @Enumerated(EnumType.STRING)
    Sexo sexo;
    Date fechaNacimiento;
}
