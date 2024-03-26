package ru.yablokov.springcourse.dao;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.yablokov.springcourse.models.Person;

import java.util.*;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    @PostConstruct
    public void getPeopleList()
    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Tom"));
        people.add(new Person(++PEOPLE_COUNT, "Bob"));
        people.add(new Person(++PEOPLE_COUNT, "Mike"));
        people.add(new Person(++PEOPLE_COUNT, "Katy"));
    }

    public List<Person> index(){
        return people;
    }

    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
}
