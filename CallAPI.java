//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;

public class CallAPI {

//    private JSONObject callAPI(String request, String url< String timeout){
//
//        try{
//            RequestConfig config = RequestConfig.custom().setConnectTimeout(timeout * 1000).setConnectionRequestTimeout(timeout * 1000).setSocketTimeout(timeout * 1000).build();
//            CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(config).build();
//            HttpPost post = new HttpPost(endPoint);
//            post.setHeader("Content-type", "application/json");
//            post.setHeader("cache-control", "no-cache");
//            StringEntity params = new StringEntity(request);
//            post.setEntity(params);
//            CloseableHttpResponse RSSResponse = httpClient.execute(post);
//            System.out.println(RSSResponse.getStatusLine().getStatusCode());
//
//            (JSON Response)
//            InputStream is = (RSSResponse.getEntity().getContent());
//            jsonObject = (JSONObject) jsonParser.parse(new InputStreamReader(is, "UTF-8"));
//            finalResult.put("response", jsonObject);
//
//            (XML Response)
//            BufferedReader reader = new BufferedReader(new InputStreamReader(RSSResponse.getEntity().getContent()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = reader.readLine()) != null) {
//                response.append(inputLine);
//            }
//            String str = XML.toJSONObject(response.toString()).toString();
//            newJson = (JSONObject) jsonParser.parse(str);
//            finalResult.put("response", newJson);
//
//
//
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return finalResult;
//    }
//
//}
}

//Note:
//        -----
//        --> timeout is a value like 30 sec, within 30 sec if we have not received response from server it will close the connection and gives Timeout.
//        --> We can use InputStream or BufferedReader for taking response as string.

