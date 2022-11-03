package miage.IF.resolver;


import graphql.kickstart.tools.GraphQLResolver;
import lombok.AllArgsConstructor;
import miage.IF.entity.Book;
import miage.IF.entity.Student;
import miage.IF.repository.StudentEntityRepository;
@AllArgsConstructor
public class BookResolver implements GraphQLResolver<Book> {
    private StudentEntityRepository studentEntityRepository;


    public Student getStudent(Book book) {
        return studentEntityRepository.findById(book.getStudent()
                                             .getId())
                               .orElseThrow(null);
    }
}
