package miage.IF.resolver;


import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import miage.IF.entity.Book;
import miage.IF.entity.Student;
import miage.IF.repository.BookEntityRepository;
import miage.IF.repository.StudentEntityRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class Mutation implements GraphQLMutationResolver {
    private BookEntityRepository bookRepository;

    private StudentEntityRepository studentEntityRepository;


    public Student newStudent(String firstName, String lastName, String email) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        return studentEntityRepository.save(student);
    }

    public Book newBook(String code, String name, Integer studentId) {
        Book book = new Book();
        book.setStudent(new Student(studentId));
        book.setCode(code);
        book.setName(name);
        return bookRepository.save(book);

    }


    public Book updateBookPageCount(String code, Integer id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            book.setCode(code);
            return bookRepository.save(book);
        }
        return null;
    }
}
