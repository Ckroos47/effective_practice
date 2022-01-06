package practice;

import lombok.Data;

/**
 * @description:  始终重写 toString 方法
 * toString 的通用约定要 求，返回的字符串应该是“一个简洁但内容丰富的表示，对人们来说是很容易阅读的”。
 *                 toString 通用约定“建议所有的子 类重写这个方法”。好的建议，的确如此!
 * @author: chenmo
 * @email: xyisbenben@aliyun.com
 * @date: 2022/1/6 2:58 下午
 */
public class Practice12 {

    @Data
    class PhoneNumber {
        private final short areaCode, prefix, lineNum;
        @Override
        public String toString(){
            return String.format("%03d-%03d-%04d",areaCode,prefix,lineNum);
        }
    }
}
