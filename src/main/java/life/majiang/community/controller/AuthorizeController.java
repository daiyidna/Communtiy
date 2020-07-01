package life.majiang.community.controller;

import life.majiang.community.bjsxt.pojo.ComUser;
import life.majiang.community.bjsxt.service.CommService;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;
    private CommService commService;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String  secret;

    @Value("${github.redirect.uri}")
    private String uri;

   @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam (name = "state")String state, HttpServletRequest request) throws IOException {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id(clientId);
        accessTokenDTO.setClient_secret(secret);
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(uri);
        accessTokenDTO.setState(state);
       String accessToken = githubProvider.getAccessToken(accessTokenDTO);
       System.out.println("-----------------------------------------------");
       GithubUser githubuser = githubProvider.getUser(accessToken);
       System.out.println(githubuser.getLogin());
       if(githubuser!=null){
           //登录成功，写cookie和session
           ComUser comuser=new ComUser();
           comuser.setToken(UUID.randomUUID().toString());
           comuser.setName(githubuser.getName());
           comuser.setAccountId(String.valueOf(githubuser.getId()));
           comuser.setGmtCreate(System.currentTimeMillis());
           comuser.setGmtModified(comuser.getGmtCreate());

           commService.insert(comuser);
          // request.getSession().setAttribute("user",githubuser);
                   return "redirect:/";
       }else {
           //登录失败，重新登录
               return "redirect:/";
       }
       //return "index";
    }

}
