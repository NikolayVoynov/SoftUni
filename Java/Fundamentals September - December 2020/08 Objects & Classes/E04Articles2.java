import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E04Articles2 {

    static class Article {

        String title;
        String content;
        String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Article> articles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String title = data[0];
            String content = data[1];
            String author = data[2];

            Article article = new Article(title, content, author);

            articles.add(article);
        }

        String sortCommand = scanner.nextLine();

        switch (sortCommand) {
            case "title":
                articles.stream()
                        .sorted((article1, article2) -> article1.getTitle().compareTo(article2.getTitle()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "content":
                articles.stream()
                        .sorted((article1, article2) -> article1.getContent().compareTo(article2.getContent()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
            case "author":
                articles.stream()
                        .sorted((article1, article2) -> article1.getAuthor().compareTo(article2.getAuthor()))
                        .forEach(article -> System.out.println(article.toString()));
                break;
        }
    }
}
