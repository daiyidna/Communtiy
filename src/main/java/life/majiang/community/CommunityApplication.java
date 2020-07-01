package life.majiang.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("bjsxt.mapper")//指定扫描接口与映射配置文件
public class CommunityApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunityApplication.class,args);
    }
}
