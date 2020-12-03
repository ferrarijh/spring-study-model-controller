package com.jonathan.practice.api

import com.jonathan.practice.model.Person
import com.jonathan.practice.service.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RequestMapping("api/v1/person")    //resource path in url
@RestController     //spring controller - RestController in this case
class PersonController @Autowired constructor(
        private val personService: PersonService
) {
    @PostMapping
    fun addPerson(@RequestBody p: Person){
        personService.addPerson(p)
    }

    @GetMapping
    fun getAll(): List<Person>{
        return personService.getAll()
    }

    @GetMapping(path=["{id}"])
    fun getPersonById(@PathVariable("id") id: UUID): Person?{
        return personService.getPersonById(id)
    }
}