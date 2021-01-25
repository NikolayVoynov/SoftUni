import java.util.Scanner;

public class E02Articles {

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

        public void renameTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void editContent(String content) {
            this.content = content;
        }

        public String getAuthor() {
            return author;
        }

        public void changeAuthor(String author) {
            this.author = author;
        }

        public String toString() {
            return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(", ");

        String title = data[0];
        String content = data[1];
        String author = data[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(": ");

            String command = input[0];

            switch (command) {
                case "Edit":
                    article.editContent(input[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(input[1]);
                    break;
                case "Rename":
                    article.renameTitle(input[1]);
                    break;
            }
        }

        System.out.println(article.toString());

    }
}
