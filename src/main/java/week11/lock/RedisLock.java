package week11.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @projectName: zsy-weekwork
 * @package: week11.lock
 * @className: RedisLock
 * @author: senyang.zheng
 * @description:
 * @date: 2022/7/17 01:44
 */
@Slf4j
public class RedisLock {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;


    public boolean lock(String key, long expiredTime) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (!redisTemplate.opsForValue().setIfAbsent(key, currentTimeMillis + expiredTime)) {
                if (currentTimeMillis > Long.parseLong(redisTemplate.opsForValue().get(key).toString())) {
                    redisTemplate.opsForValue().set(key, currentTimeMillis + expiredTime);
                    return true;
                }
                return false;
            }
            return true;
        } catch (Exception e) {
            log.error("获取redis锁失败", e);
            return false;
        }
    }

    public boolean unLock(String key) {
        try {
            redisTemplate.delete(key);
            return true;
        } catch (Exception e) {
            log.error("redis解锁失败：", e);
            return false;
        }
    }
}
