package mx.com.sevenbrains.domain

import org.hibernate.annotations.Type

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.NamedNativeQueries
import javax.persistence.NamedNativeQuery
import javax.persistence.Table

/**
 * Created by henry on 7/03/14.
 */
@Entity
@Table(name = "usuarios")
@NamedNativeQueries([@NamedNativeQuery(name = "usuariosRoles", query = "select cr.nombre_rol as nombre_rol, cr.desc_rol from roles cr join usuarios_roles ur on ur.nombre_rol = cr.nombre_rol and ur.nombre_usuario = :nombre_usuario", resultClass = Roles.class)])
class Usuario {
    @Id
    @Column(nullable = false, unique = true)
    String nombre_usuario;

    @Column(nullable = false)
    String contrasena;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean enabled;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean accountNonExpired;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean credentialsNonExpired;

    @Column(nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    boolean accountNonLocked

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuarios_roles"
            , joinColumns = [@JoinColumn(name = "nombre_usuario", nullable = false, updatable = false)]
            , inverseJoinColumns = [@JoinColumn(name = "nombre_rol", nullable = false, updatable = false)])
    Set<Roles> roles;

}
