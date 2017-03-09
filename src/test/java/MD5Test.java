import com.wy.common.util.MD5Util;
import org.junit.Test;

/**
 * Created by Administrator on 2017/3/5.
 */
public class MD5Test {
    @Test
    public void testMD5() {
        /**
         * 参数为：
         *  1、需要加密的内容
         *  2、加密是添加的盐凭证
         */
        String str=MD5Util.md5("151726","admin");
        System.out.println(str.toString());
    }
}
