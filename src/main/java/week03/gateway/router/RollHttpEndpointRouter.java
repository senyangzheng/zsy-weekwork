package week03.gateway.router;

import java.util.List;

/**
 * @author yyyz
 * @date 2022年 05月22日 22:07:38
 */
public class RollHttpEndpointRouter implements HttpEndpointRouter {

    private volatile int index = 0;

    @Override
    public String route(List<String> urls) {
        int sum = urls.size();
        int temp = index % sum;
        String url = urls.get(temp);
        index++;
        return url;
    }
}
