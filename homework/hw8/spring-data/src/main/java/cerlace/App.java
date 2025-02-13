package cerlace;

import cerlace.configuration.AppConfig;
import cerlace.model.Author;
import cerlace.model.Book;
import cerlace.model.Reader;
import cerlace.service.AuthorService;
import cerlace.service.BookService;
import cerlace.service.LibraryCustomService;
import cerlace.service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class App {
    private final AuthorService authorService;
    private final BookService bookService;
    private final ReaderService readerService;
    private final LibraryCustomService libraryCustomService;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.register(AppConfig.class);
        context.refresh();
        context.start();

        App app = context.getBean(App.class);

        Author authorRus = Author.builder()
                .name("Author from Russia")
                .birthDate(LocalDate.now())
                .nationality("Russia")
                .build();
        Author authorBel = Author.builder()
                .name("Author from Belarus")
                .birthDate(LocalDate.now())
                .nationality("Belarus")
                .build();
        Book bookOrig = Book.builder()
                .title("Book")
                .author(authorBel)
                .isbn("B1")
                .publishedDate(LocalDate.now())
                .build();
        Book bookFake = Book.builder()
                .title("BookFake")
                .author(authorBel)
                .isbn("B1")
                .publishedDate(LocalDate.now())
                .build();
        Reader readerOne = Reader.builder()
                .name("ReaderOne")
                .email("readerOne@mail.ru")
                .registrationDate(LocalDate.now().minusDays(1))
                .build();
        Reader readerTwo = Reader.builder()
                .name("ReaderTwo")
                .email("readerThree@mail.ru")
                .registrationDate(LocalDate.now().minusDays(3))
                .books(Set.of(bookOrig))
                .build();
        Reader readerThree = Reader.builder()
                .name("ReaderThree")
                .email("readerThree@mail.ru")
                .registrationDate(LocalDate.now().minusDays(5))
                .books(Set.of(bookOrig))
                .build();

        app.authorService.save(authorBel);
        app.authorService.save(authorRus);
        System.out.println("Ищем автора по национальности...");
        System.out.println(app.authorService.findByNationality("Belarus"));

        System.out.println(app.bookService.checkUniqueAndSave(bookOrig) ? "Книга сохранена!" : "Такая книга уже есть!");
        System.out.println(app.bookService.checkUniqueAndSave(bookFake) ? "Книга сохранена!" : "Такая книга уже есть!");

        System.out.println("Ищем книгу по части названия...");
        System.out.println(app.bookService.findByTitleContaining("Boo"));

        app.readerService.save(readerOne);
        app.readerService.save(readerTwo);
        app.readerService.save(readerThree);
        System.out.println("Ищем читателя по почте...");
        System.out.println(app.readerService.findByEmail("readerOne@mail.ru"));

        System.out.println("Проверяем пагинацию списка читателей...");
        Page<Reader> page = app.readerService.findAllAndSortByRegistrationDate(1, 1);
        page.stream().forEach(System.out::println);
        System.out.println("Всего страниц" + page.getTotalPages());

        System.out.println("Ищем читателей конкретного автора...");
        System.out.println(app.libraryCustomService.findReadersByAuthorName("Author from Belarus"));
    }
}
