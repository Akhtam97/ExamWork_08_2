import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connector connector = new Connector();
        News news = new News();
        System.out.println("Для создании новости нажмите 1 \n" +
                "Для просмотра всех новостей нажмите 2 \n" +
                "Для удалении новости по ID нажмите 3 \n" +
                "Для изменнении новости по ID нажмите 4");
        int answer = sc.nextInt();
        if (answer == 1) {
            System.out.println("Введите Заголовок");
            news.setMainNews(sc.next());
            System.out.println("Текст Новости");
            news.setText(sc.next());
            //при добавлении пробелы не видит приходится писать через _
            connector.createNews(news);
            System.out.println("Добавлено");
        } else if (answer == 2) {
            connector.getNews();
        } else if (answer == 3) {
            System.out.println("Введите id Для удалении");
            news.setId(sc.nextInt());
            connector.deleteNewsId(news);
            System.out.println("Удалил");
        }else if (answer==4){
            System.out.println("Введите новый Заголовок");
            news.setMainNews(sc.next());
            System.out.println("Введите новый текст Новостей");
            news.setText(sc.next());
            System.out.println("Введите id новостей который хотите изменить");
            news.setId(sc.nextInt());
            connector.updateNewsId(news);
        }
    }
}
