package project.example.com.report_project.board;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by SeungJun on 2018-05-19.
 */

public class Board_CountSendHttp {

    public String SendByHttp() {
        // String strUrl = "http://hiseungjun2.cafe24.com/report_project/JSONBoardSelect.jsp";
        String strUrl = "http://tmdwns9738.cafe24.com/report_project/JSONBoardCount.jsp";
        // String strUrl = "http://192.168.137.100:8080/report_project/JSONNoticeSelect.jsp";
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get=new HttpGet(strUrl);

        try {
            //데이터 보낸 뒤 서버에서 데이터를 받아오는 과정
            HttpResponse response = client.execute(get);
            BufferedReader bufreader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"utf-8"));

            String line = null;
            String result = "";

            while ((line = bufreader.readLine()) != null) {
                result += line;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            client.getConnectionManager().shutdown();
            return "";
        }
    }

}
