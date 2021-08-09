package regexs;

public class RegexEx {
    public static void main(String[] args) {
        String phoneO = "0707142842";// 07**, 05**, 09**, 02**
        String email = "email@gmail.com"; // *@{2+}.{2+}
        String password = "Qwerty123@"; // хотя бы одина большая буква, одна маленькая, одна цифра, один смвол

        if(phoneO.matches("regex")){
            System.out.println("Номер телефона верный");
        }

        if(email.matches("regex")){
            System.out.println("Емейл верный");
        }

        if(password.matches("regex")){
            System.out.println("Пароль надёжный");
        }
    }
}
