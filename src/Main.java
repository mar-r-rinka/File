import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir1 = new File("/Users/mar-r-rinka/Games");
        File[] dir = {new File("/Users/mar-r-rinka/Games", "src"),
                new File("/Users/mar-r-rinka/Games", "res"),
                new File("/Users/mar-r-rinka/Games", "savegames"),
                new File("/Users/mar-r-rinka/Games", "temp"),
                new File("/Users/mar-r-rinka/Games/src", "main"),
                new File("/Users/mar-r-rinka/Games/src", "test"),
                new File("/Users/mar-r-rinka/Games/res", "drawables"),
                new File("/Users/mar-r-rinka/Games/res", "vectors"),
                new File("/Users/mar-r-rinka/Games/res", "icons"),
        };


        File[] file = {new File("/Users/mar-r-rinka/Games/src", "Main.java"),
                new File("/Users/mar-r-rinka/Games/src", "Utils.java"),
                new File("/Users/mar-r-rinka/Games/temp", "temp.txt")};

        StringBuilder sb = new StringBuilder();

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss dd-MM-YYYY");
        Date date = new Date(System.currentTimeMillis());


        if (dir1.exists()) {
            sb.append(formatter.format(date))
                    .append(" созданы следующие каталоги:\n");
            for (int i = 0; i < dir.length; i++) {
                File newFile = new File(dir[i].getParent(), dir[i].getName());
                if (newFile.mkdir()) {
                    sb.append(newFile + "\n");
                } else {
                    sb.append(newFile + " не может быть создан. Ошибка.\n");
                }
            }

            sb.append("\n")
                    .append(formatter.format(date))
                    .append(" созданы следующие файлы:\n");
            for (int i = 0; i < file.length; i++) {
                File newFile = new File(file[i].getParent(), file[i].getName());
                try {
                    if (newFile.createNewFile())
                        sb.append(newFile + "\n");
                    ;
                } catch (IOException ex) {
                    sb.append(newFile + " не может быть создан. Ошибка.\n");
                }
            }

        } else {
            System.out.println("Путь /Users/mar-r-rinka/Games не существует");
        }

        System.out.println(sb);

        String text = sb.toString();
        try (FileOutputStream fos = new FileOutputStream("/Users/mar-r-rinka/Games/temp/temp.txt")) {
            byte[] bytes = text.getBytes();
            fos.write(bytes, 0, bytes.length);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
