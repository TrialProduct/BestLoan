package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.security.MessageDigest;

/**
 * Created by le on 2017/5/2.
 */


public class MD5Util {

    /**
     * 加密
     * @param plaintext 明文
     * @return ciphertext 密文
     */
    public final static String  encrypt(String plaintext) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] btInput = plaintext.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 简单测试
     * @param args
     */
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        HotCoupBean hotCoupBean1=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493215934975&di=aa6281e1bc7fc7b81d19d01fe848ae60&imgtype=0&src=http%3A%2F%2Fv1.qzone.cc%2Fpic%2F201408%2F08%2F17%2F25%2F53e497895bc96805.jpg%2521600x600.jpg","讲好英语的8个窍门","rebecca",774);
        HotCoupBean hotCoupBean2=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493273361965&di=6cd56899495823ecafedf96dd92e4181&imgtype=0&src=http%3A%2F%2Fwww.tengdakeli.cn%2F350%2Ftimg02%2Fuploaded%2Fi2%2FT1LtpKFExkXXXXXXXX_%2521%25210-item_pic.jpg","怎么给孩子用精油？","苏菲",117112);
        HotCoupBean hotCoupBean3=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493868108&di=b08197f4e04b1dde0eb4058c3cba9d74&imgtype=jpg&er=1&src=http%3A%2F%2Fimg10.360buyimg.com%2Fimgzone%2Fg10%2FM00%2F0B%2F1E%2FrBEQWFFG43UIAAAAAAFMRUzjb1UAACVUQKEeccAAUxd379.jpg","了解精油的秘密","苏菲",121448);
        HotCoupBean hotCoupBean4=new HotCoupBean("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3088723484,2701405518&fm=23&gp=0.jpg","孩子湿疹之妙招--精油","苏菲",131742);
        HotCoupBean hotCoupBean5=new HotCoupBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=568245126,2679340950&fm=23&gp=0.jpg","洗澡也可以用精油","苏菲",112979);
        HotCoupBean hotCoupBean6=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493868181&di=3aae4ebe322d2826ca66ef7299fd986e&imgtype=jpg&er=1&src=http%3A%2F%2Fimg39.ddimg.cn%2F16%2F21%2F21085729-1_o.jpg","什么是芳香疗法？","苏菲",128751);
        HotCoupBean hotCoupBean7=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493273501952&di=eb15e2d0c02fe005f331622434dc438d&imgtype=0&src=http%3A%2F%2Fpic.jschina.com.cn%2F0%2F17%2F78%2F56%2F17785638_286566.jpg","祛暑润肺冰糖雪梨汤","zp",117189);
        HotCoupBean hotCoupBean8=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493273539756&di=1e143a6d0e9b22b8558dded0f0cb31f8&imgtype=0&src=http%3A%2F%2Ffile03.zk71.com%2FFile%2FCorpProductImages%2F2012%2F05%2F25%2F0_286529161_20120525111126.jpg","盛夏谨防防冰箱病","吉祥五宝",117763);
        HotCoupBean hotCoupBean9=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493868309&di=ae3109b511fc1e5b1f79e375ce619ed7&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.rbc.cn%2Fresources%2Fpicture%2F1%2F2014%2F06%2F30%2F20140630145428946.jpg","别让宝宝得上空调病","容静",147358);
        HotCoupBean hotCoupBean10=new HotCoupBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493868327&di=0bd2daa45d548abdad1f76bb26783f3d&imgtype=jpg&er=1&src=http%3A%2F%2Fimg1.gtimg.com%2Fcd%2Fpics%2Fhv1%2F125%2F208%2F579%2F37702640.jpg","三伏天儿的美食","zp",143131);
        String str1 = gson.toJson(hotCoupBean1);
        String str2 = gson.toJson(hotCoupBean2);
        String str3 = gson.toJson(hotCoupBean3);
        String str4 = gson.toJson(hotCoupBean4);
        String str5 = gson.toJson(hotCoupBean5);
        String str6 = gson.toJson(hotCoupBean6);
        String str7 = gson.toJson(hotCoupBean7);
        String str8 = gson.toJson(hotCoupBean8);
        String str9 = gson.toJson(hotCoupBean9);
        String str10 = gson.toJson(hotCoupBean10);
        String str="["+str1+","+str2+","+str3+","+str4+","+str5+","+str6+","+str7+","+str8+","+str9+","+str10+"]";

        String strResponse = "HTTP/1.1 200 OK\nContent-Length: " + str.getBytes().length + "\n\n" + str;

        String strmd5 = MD5Util.encrypt(str);
        System.out.print(strmd5);
    }

}