package pr4;

public class seasonTest {
    public static String ilove(Season s){
        String res = "Я люблю ";
        switch (s){
            case SPRING:
                res += "Весну";
            case AUTUMN:
                res += "Осень";
            case WINTER:
                res += "Зиму";
            case SUMMER:
                res += "Лето";
        }
        return res;
    }

    public static void main(String[] args) {
        Season myFav = Season.SUMMER;
        System.out.println(ilove(myFav));
        for (Season ses : Season.values()){
            System.out.println(ses + "\taverage temp: " + ses.getAvTemp() +"\t"+ ses.getDescription());
        }
    }
}
