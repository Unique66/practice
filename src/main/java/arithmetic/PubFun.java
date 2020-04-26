package arithmetic;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by SXH on 2019/2/20.
 */
public class PubFun {
    /**
     * 链接url下载图片
     * @param urlList 下载路径
     * @param path		存储路径
     */
    public static void downloadPicture(final String urlList,final String path){
        URL url = null;
        DataInputStream dataInputStream = null;
        FileOutputStream fileOutputStream = null;
        String log=null;
        try {
            url = new URL(urlList);
            dataInputStream = new DataInputStream(url.openStream());
            fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                try {
                    dataInputStream.close();
                } catch (IOException e) {
                    //log.error("dataInputStream关闭失败：",e);
                    System.out.println("dataInputStream关闭失败");
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                   // log.error("fileOutputStream关闭失败：",e);
                    System.out.println("dataInputStream关闭失败");
                    e.printStackTrace();
                }
            }
        }
    }
}
