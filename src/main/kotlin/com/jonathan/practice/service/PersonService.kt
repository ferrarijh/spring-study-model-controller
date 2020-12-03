package com.jonathan.practice.service

import com.jonathan.practice.model.Person
import com.jonathan.practice.network.dao.PersonDao
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonService @Autowired constructor(
        @Qualifier("personDaoImpl")
        private val personDao: PersonDao
) {
    fun addPerson(p: Person): Boolean{
        return personDao.addPerson(p)
    }

    fun getAll(): List<Person>{
        return personDao.getAll()
    }

    fun getPersonById(id: UUID): Person?{
        return personDao.getPersonById(id)
    }
}