import com.squareup.okhttp.*;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import javax.swing.text.Document;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @program: ssm_MultipleDataSources_demo
 * @author: DANRAN2333
 * @create: 2019-12-11 16:16
 * @description:
 */
public class Test {

    public static String Test() throws IOException {
        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType = MediaType.parse("application/json");
//        RequestBody body = RequestBody.create(mediaType, "{" +
//                "user:{\"id\":1123,\"name\":\"123456\"}" +
//                "}");
//        System.out.println("乱码");
//        String encode = URLEncoder.encode("张三", "gbk");
//
//        System.out.println("乱码" + encode);

        Request request = new Request.Builder()
                .url("http://"+"192.168.0.7"+":8080/services/RestFulDemo/rest/queryID/张三")
                .get()
                //Content-Type是指定传入参数格式，
                .addHeader("Content-Type", "application/json")
                //Accept是指定返回的数据格式
                .addHeader("Accept", "application/xml")
                .build();

        Response response = client.newCall(request).execute();
        String s=new String(response.body().bytes(),"utf-8");
        System.out.println(s);
        return null;
    }

    public static void main(String[] args) {
        try {
            Test();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
