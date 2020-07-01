package life.majiang.community.bjsxt.service;

import life.majiang.community.bjsxt.pojo.ComUser;

public interface CommService {
    public void insert(ComUser comUser);
    public ComUser select(Integer id);
}
