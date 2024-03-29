import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) {
    List<Person> people = List.of(
        new Person("person 1", 10000),
        new Person("person 1234", 15),
        new Person("not a person", 80)
    );

    Gson gson = new Gson();
    String jsonString = gson.toJson(people);

    System.out.println(jsonString);

    List<Person> parsedPeople = gson.fromJson(jsonString, new TypeToken<List<Person>>(){}.getType());
    System.out.println(parsedPeople.stream().map(Person::toString).collect(Collectors.joining("\n")));
  }
}
