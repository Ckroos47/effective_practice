package practice;

import java.util.List;
import java.util.Objects;

/**
 * @description: 使用依赖注入取代硬连接资源
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2021/11/30 10:58 上午
 */
public class Practice05 {
}
class SpellChecker{
    private final Singleton dictionary;

    public SpellChecker(Singleton dictionary){
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) { return true; }
    public List<String> suggestions(String typo) { return null; }
}