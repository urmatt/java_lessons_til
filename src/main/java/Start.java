import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Start {
    public static void main(String[] args) {
        if (args.length > 0) {
            String filePath = args[0];
            System.out.println("Проверка файла:\n" + filePath + "\n");
            File file = new File(filePath);
            if (file.exists() && file.canRead()) {
                System.out.println("Файл успешно проверен\n");
                System.out.println("Чтение содержимого с файла\n");
                try {
                    String fileContent = Files.readString(file.toPath());
                    System.out.println("Содержимое файла:\n" + fileContent);
                } catch (IOException e) {
                    System.out.println("Не удалось прочитать файл");
                }

            } else {
                System.out.println("Файл не существует или не читабелен");
            }
        } else {
            System.out.println("Путь к файлу не задан");
        }
    }
}
