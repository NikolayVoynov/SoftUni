import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L04Songs {

    public static class Song {
        private String typeList;
        private String name;
        private String time;

        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numberSongs; i++) {
            String[] dataSongs = scanner.nextLine().split("_");

            String type = dataSongs[0];
            String name = dataSongs[1];
            String time = dataSongs[2];

            Song song = new Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (typeList.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
