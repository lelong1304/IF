package miage.IF.resolver;


import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import miage.IF.entity.Book;
import miage.IF.entity.Student;
import miage.IF.repository.BookEntityRepository;
import miage.IF.repository.StudentEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class Query implements GraphQLQueryResolver {
    private BookEntityRepository bookRepository;
    private StudentEntityRepository studentEntityRepository;

    public Iterable<Book> books() {
        return bookRepository.findAll();
    }

    public long countBooks() {
        return bookRepository.count();
    }

    public Iterable<Student> students() {
        return studentEntityRepository.findAll();
    }

    public long countStudents() {
        return studentEntityRepository.count();
    }
    Student student(Integer id) {
        Optional<Student> optionalStudent = studentEntityRepository.findById(id);
        return optionalStudent.orElse(null);
    }

}
