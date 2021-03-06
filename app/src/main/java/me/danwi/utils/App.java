package me.danwi.utils;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.danwi.eq.EQApplication;
import me.danwi.eq.interceptor.BridgeInterceptor;
import okhttp3.Interceptor;

/**
 * Created by RunningSnail on 16/7/20.
 */
public class App extends EQApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public String getUrl() {
        return BuildConfig.SERVER_URL;
    }

    @Override
    public List<Interceptor> getPre() {
        List<Interceptor> pre = new ArrayList<>();
        pre.add(new BridgeInterceptor() {
            @Override
            public Map<String, String> add() {
                Map<String, String> map = new HashMap<>();
                map.put("name", "Jerry");
                map.put("age", "23");
                return map;
            }
        });
        return pre;
    }

    @Override
    public List<Interceptor> getPost() {
        List<Interceptor> post = new ArrayList<>();
        return post;
    }

    //配置缓存目录

    @Override
    public String getDir() {
        return getExternalCacheDir().getPath() + "/cache";
    }
}
