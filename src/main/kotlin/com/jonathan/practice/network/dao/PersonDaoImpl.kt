package com.jonathan.practice.network.dao

import com.jonathan.practice.model.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.*


@Repository("personDaoImpl") //same with @Component
class PersonDaoImpl @Autowired constructor(
        private val jdbcTemplate: JdbcTemplate  //spring will inject instance here automatically
): PersonDao{

    override fun insertPerson(id: UUID, person: Person): Boolean {
        TODO("NOT IMPLEMENTED")
    }

    override fun getAll(): List<Person> {
        val q = "select id, name from student_table_2;"
        return jdbcTemplate.query(q){resultSet, rowNum ->
            val uuid = UUID.fromString(resultSet.getString("id"))
            val name = resultSet.getString("name")
            Person(uuid, name)
        }
    }

    override fun deletePersonById(id: UUID): Boolean {
        val q = "select * from student_table_2 where id=$id;"
        jdbcTemplate.queryForObject(q){ _, _ -> }
        return false
    }

    override fun updatePersonById(id: UUID, p: Person): Boolean {
        TODO("NOT IMPLEMENTED")
    }

    //TODO("handle null result")
    override fun getPersonById(id: UUID): Person? {
        val q = "select * from student_table_2 where id = ?"
        return jdbcTemplate.queryForObject(q, arrayOf(id as Any))
        { resultSet, rowNum ->
            val uuid = UUID.fromString(resultSet.getString("id"))
            val name = resultSet.getString("name")
            Person(uuid, name)
        }
    }
    /* in Java,
    Optional<Person> selectPersonById(UUID id){
        return PersonDatabase.data
            .filter(p -> p.getId().equals(id)
            .findFirst();
    }
     */

}