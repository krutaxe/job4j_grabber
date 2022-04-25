package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {
    private static final String SOURCE_LINK = "https://career.habr.com";
    private static final String PAGE_LINK =
            String.format("%s/vacancies/java_developer?page=", SOURCE_LINK);
    private static final String TITLE = ".vacancy-card__inner";
    private static final String VACANCY = ".vacancy-card__title";
    private final DateTimeParser dateTimeParser;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    private String retrieveDescription(String link) {
        Connection connection = Jsoup.connect(link);
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements row = document.select(".style-ugc");
        return row.first().text();
    }

    private String vacancyTitle(Element element) {
        return element.text();
    }

    private String retrieveLink(Element element) {
        Element linkEl = element.child(0);
        return String.format("%s%s", SOURCE_LINK, linkEl.attr("href"));
    }

    @Override
    public List<Post> list() {
        List<Post> postList = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            Connection connection = Jsoup.connect(PAGE_LINK + i);
            try {
                Document document = connection.get();
                Elements rows = document.select(TITLE);
                rows.forEach(row -> {
                    Element element = row.select(VACANCY).first();
                    String vacLink = retrieveLink(element);
                    String desc = retrieveDescription(vacLink);
                    String vacTitle = vacancyTitle(element);
                    Element dateElement = row.select(".vacancy-card__date").first().child(0);
                    String dateAttribute = dateElement.attr("datetime");
                    LocalDateTime dateTime = dateTimeParser.parse(dateAttribute);
                    postList.add(new Post(vacTitle, vacLink, desc, dateTime));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return postList;
    }

    public static void main(String[] args) throws IOException {
        HabrCareerParse habrCareerParse = new HabrCareerParse(new HabrCareerDateTimeParser());
        List<Post> postList = habrCareerParse.list();
        System.out.println(postList);

    }
}
