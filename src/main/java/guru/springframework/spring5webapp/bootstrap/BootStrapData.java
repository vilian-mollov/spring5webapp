package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author hill = new Author("Napoleon","Hill");
        Book thinkAndGrowRich = new Book("Think and Grow Rich","954321995-8");

        hill.getBooks().add(thinkAndGrowRich);
        thinkAndGrowRich.getAuthors().add(hill);

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","978-0321125217");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(hill);
        bookRepository.save(thinkAndGrowRich);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","978-0764558313");

        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());



        Publisher adison = new Publisher("Addison-Wesley Professional",
                "Wall Street 221","New York","Northeastern","Z47-18");

        System.out.println(adison);
        publisherRepository.save(adison);
        System.out.println(adison);
        System.out.println("Publishers in repository: " + publisherRepository.count());


    }
}
