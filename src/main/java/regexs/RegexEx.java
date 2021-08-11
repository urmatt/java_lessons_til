package regexs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEx {
    public static void main(String[] args) {
        String phone = "0700180085518899";// 07**, 05**, 09**, 02**
        String email = "emailtest@gmail.com"; // *@{2+}.{2+}
        String password = "Qwerty123@"; // хотя бы одна большая буква, одна маленькая, одна цифра, один символ

        String phoneRegex = "(^[0])([2,7,5,9])([0-9]{8})";

        if (phone.matches(phoneRegex)) {
            System.out.println("Номер " + phone + " корректный");
        } else {
            System.out.println("Номер" + phone + " некорректный");
        }

        String emailRegex = "(\\w{3,})@([a-z]{2,}+\\.)([a-z]{2,4})";
        Pattern p2 = Pattern.compile(emailRegex);
        Matcher m2 = p2.matcher(email);
        if (m2.find()) {
            System.out.println("e-: " + m2.group() + " правильный");
        } else {
            System.out.println("e-mail " + email + " некорректный");
        }

        String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        Pattern p3 = Pattern.compile(passwordRegex);
        Matcher m3 = p3.matcher(password);
        if (password.matches(passwordRegex)) {
            System.out.println("Пароль надёжный");
        } else {
            System.out.println("Пароль не надёжный");
        }
    }
}
