package test;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMD5 {

    /**
     * 给字符串加密(生成消息摘要)
     */
    @Test
    public void test1(){
        String str1 = DigestUtils.md5Hex("abc");
        String str2 = DigestUtils.md5Hex("abc");
        System.out.println(str1);
        System.out.println(str2);
    }

    /**
     * 给文件加密(生成消息摘要)
     * @throws FileNotFoundException
     * @throws IOException
     */
    @Test
    public void test2() throws FileNotFoundException, IOException {
        String str1 = DigestUtils.md5Hex(
                        new FileInputStream("pom.xml"));
        String str2 = DigestUtils.md5Hex(
                        new FileInputStream("pom2.xml"));
        System.out.println(str1);
        System.out.println(str2);
    }

    /**
     * 加盐，结果也是一个32位数
     */
    @Test
    public void test3(){
        String pwd = "123456";
        String salt = "你喜欢编程吗？";
        String str = DigestUtils.md5Hex(pwd+salt);
        System.out.println(str);
    }

}
