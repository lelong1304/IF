package miage.IF.service;

import lombok.AllArgsConstructor;
import miage.IF.entity.Book;
import miage.IF.repository.BookEntityRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.util.*;

@Service
@AllArgsConstructor
public class BookService {
    private final BookEntityRepository bookEntityRepository;

    public Object test() {
        String url = "https://www.alphavantage.co/query?function=TIME_SERIES_WEEKLY&symbol=IBM&apikey=1XDCVS7DM3C1XE20";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<DataRaw> response = restTemplate.getForEntity(url,DataRaw.class);
        DataRaw res = response.getBody();
        HashMap<String, Info> timeSerie = Objects.requireNonNull(res).timeSerie;
        Info t = timeSerie.get("2022-12-02");
        System.out.println(t);
        return res.timeSerie.values();

    }
    public List<Book> findAll() {
        return bookEntityRepository.findAll();
    }

    public Book save(Book book) {
        return bookEntityRepository.save(book);
    }
}
