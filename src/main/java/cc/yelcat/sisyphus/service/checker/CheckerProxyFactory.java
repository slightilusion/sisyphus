package cc.yelcat.sisyphus.service.checker;

import cc.yelcat.sisyphus.entity.CheckerProxy;
import cc.yelcat.sisyphus.mapper.CheckerProxyMapper;
import cc.yelcat.sisyphus.service.ProxyFactory;
import cc.yelcat.sisyphus.utils.DateUtil;
import cc.yelcat.sisyphus.utils.HttpUtil;
import cc.yelcat.sisyphus.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
public class CheckerProxyFactory extends ProxyFactory<CheckerProxyFactory> {

    private final String CHECKER_URL ="https://checkerproxy.net/api/archive/";

    @Autowired
    private CheckerProxyMapper checkerProxyMapper;

    @Transactional
    @Override
    public CheckerProxyFactory build() {
        try {
            String body = HttpUtil.sendGet(CHECKER_URL+DateUtil.getTheday(), "");
            List<CheckerProxy> checkerProxies = JsonUtil.parseToList(body, CheckerProxy.class);
            System.out.println(checkerProxies.size());
            CheckerProxy checkerProxy = checkerProxies.get(1);
            System.out.println(checkerProxy);
            checkerProxyMapper.deleteAll();
            checkerProxyMapper.insertList(checkerProxies);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public static void main(String[] args) {
        String Q="    id,local_id,report_id, addr, type, kind, timeout, cookie, referer, post, ip, \n" +
                "    addr_geo_iso, addr_geo_country, addr_geo_city, ip_geo_iso, ip_geo_country, ip_geo_city, \n" +
                "    created_at, updated_at, skip, from_cache";
        String s = Q.replace(" ", "");
        String[] split = s.split(",");
        String w="varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,";
        StringBuffer ll = new StringBuffer("CREATE TABLE `yelcat`.`checker_proxy`  (");
        for (String s1 : split) {
             ll.append("`"+s1+"`"+w+"\n\n") ;
        }
        ll.append(") ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic");
        System.out.println(ll);
    }

}
