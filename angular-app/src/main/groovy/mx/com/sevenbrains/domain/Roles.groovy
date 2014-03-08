package mx.com.sevenbrains.domain

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.Table

/**
 * Created by henry on 7/03/14.
 */
@Entity
@Table(name = "roles")
class Roles  {
    @Id
    @Column(nullable = false, unique = true)
    String nombre_rol;

    @Column
    String desc_rol;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
    Set<Usuario> usuarios;
}
