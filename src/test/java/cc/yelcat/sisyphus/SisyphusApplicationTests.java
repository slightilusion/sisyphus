package cc.yelcat.sisyphus;

import cc.yelcat.sisyphus.service.checker.CheckerProxyFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SisyphusApplicationTests {
    @Autowired
    private CheckerProxyFactory checkerProxyFactory;


    @Test
    void contextLoads() {
    }
    @Test
    public void testFindServices()  {
        checkerProxyFactory.build();
    }


}
