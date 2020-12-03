package com.jonathan.practice.network.dao

import com.jonathan.practice.model.Person
import java.util.*

interface PersonDao {
    fun insertPerson(id: UUID, person: Person): Boolean

    fun addPerson(person: Person): Boolean{
        val id = UUID.randomUUID()
        return insertPerson(id, person)
    }

    fun getAll(): List<Person>

    fun deletePersonById(id: UUID): Boolean

    fun updatePersonById(id: UUID, p: Person): Boolean

    fun getPersonById(id: UUID): Person?
}