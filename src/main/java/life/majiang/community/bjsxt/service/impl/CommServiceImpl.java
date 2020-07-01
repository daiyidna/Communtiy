package life.majiang.community.bjsxt.service.impl;

import life.majiang.community.bjsxt.mapper.ComUserMapper;
import life.majiang.community.bjsxt.pojo.ComUser;
import life.majiang.community.bjsxt.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommServiceImpl  implements CommService {
    @Autowired
    private ComUserMapper commapper;

    public void insert(ComUser comUser) {
        System.out.println("到server了------------------------------------------------------");
        commapper.insert(comUser);

    }

    @Override
    public ComUser select(Integer id) {
        return  commapper.selectByPrimaryKey(id);
    }
}
