package arithmetic;

/**
 * Created by SXH on 2019/2/20.
 */
public class Test {
    public static void main(String[] args) {

        //测试图片下载
        String url = "http://sbzxlp-1256837708.cos.ap-shanghai.myqcloud.com/0069356447bd43DaBd277F43B7F00D12.jpg?sign=q-sign-algorithm%3Dsha1%26q-ak%3DAKIDlV8gnXXfCaovGR5ZigS6nOo8PyMaEPRH%26q-sign-time%3D1550650596%3B1550652396%26q-key-time%3D1550650596%3B1550652396%26q-header-list%3D%26q-url-param-list%3D%26q-signature%3D0e9df14098234c12994130d962eca72a75cf0032";
//    	 String url = "http://img.coocaa.com/www/attachment/forum/201602/16/085938u86ewu4l8z6flr6w.jpg";
        String path = "D://test/1.jpg";
        PubFun.downloadPicture(url, path);
        //接口校验
//    	long nowTimestamp = System.currentTimeMillis();
//    	System.out.println(nowTimestamp);
//    	System.out.println(PubFun.getSHA256("e7d245ec40764d14bd459d5f7cd9dc80,123,"+nowTimestamp).toUpperCase());
    }
}
