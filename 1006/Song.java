package OpenChallenge3;

public class Song {
    private String title;
    private String singer;
    private int year;
    private String lang;

    public Song(String title, String singer, int year, String lang) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.lang = lang;
    }

    public void show() {
        System.out.printf("%d년 %s의 %s가 부른 %s\n", year, lang, singer, title);
    }

    public static void main(String[] args) {
        Song song = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국");
        song.show();
    }
}