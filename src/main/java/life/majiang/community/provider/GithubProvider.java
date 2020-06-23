package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) throws IOException {
         MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
            Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                String string=response.body().string();
                System.out.println("string="+string);
                String[] split=string.split("&");
                String tokenstr=split[0];
                String token=tokenstr.split("=")[1];
                System.out.println("token=="+token);
                return token ;
            }catch (Exception e){
                e.printStackTrace();
            }
            return  null;
    }

    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try {
            Response response= client.newCall(request).execute();
            System.out.println("************************************");
            String string = response.body().string();
            System.out.println("string=="+string);
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;

        }catch (IOException e){

        }
        return null;
    }
}

