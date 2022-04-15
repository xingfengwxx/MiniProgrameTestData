import java.io.File;

/**
 * author : 王星星
 * date : 2022/4/15 17:41
 * email : 1099420259@qq.com
 * description : 文件重命名
 */
public class RenameFile {

    public static final String SOURCE_FOLDER = "D:\\IdeaProjects\\MiniProgramTestData\\res\\pic_goods";

    public static void main(String[] args) {
        File sourceFile = new File(SOURCE_FOLDER);
        File[] fileList = sourceFile.listFiles();
        for (int i = 0; i < fileList.length; i++) {
            String sourceName = fileList[i].getName();
            String num = sourceName.split("\\.")[0];
            String destName = "ic_goods_" + num + ".png";
            String path = SOURCE_FOLDER + File.separator + destName;
            File destFile = new File(path);
            System.out.println("原文件名：" + fileList[i].getName() + ", 重命名：" + destName);
            fileList[i].renameTo(destFile);
        }
    }
}
