package regexs;

public class RegexEx {
    public static void main(String[] args) {
        String phone = "0500180081";// 07**, 05**, 09**, 02**
        String email = "emailtest@gmail.com"; // *@{2+}.{2+}
        String password = "Qwerty123@"; // хотя бы одна большая буква, одна маленькая, одна цифра, один символ

        String phoneRegex = "(^[0])([2,7,5,9])([0-9]{8})";
        if (phone.matches(phoneRegex)) {
            System.out.println("Номер " + phone + " корректный");
        } else {
            System.out.println("Номер " + phone + " не некорректный");
        }

        String emailRegex = "(\\w{3,})@([a-z]{2,}+\\.)([a-z]{2,4})";
        if (email.matches(emailRegex)) {
            System.out.println("e-mail " + email + " правильный");
        } else {
            System.out.println("e-mail " + email + " некорректный");
        }

        String passwordRegex = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
        if (password.matches(passwordRegex)) {
            System.out.println("Пароль надёжный");
        } else {
            System.out.println("Пароль не надёжный");
        }
    }
}
