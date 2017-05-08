package com.example;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static String ifstr = null;
    static String ifstrMD50 = null;
    static String ifstrMD51 = null;

    public static void main(String[] args) throws JSONException, UnsupportedEncodingException {


        Gson gson = new GsonBuilder().disableHtmlEscaping().create();







        try {

            ServerSocket server = new ServerSocket(8889);//定义客户端的端口号
            Socket client = server.accept();//定义一个Socket对象

            InputStream is = client.getInputStream();//服务器接受信息输入流，也就是接受从服务器段发送过来的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));//用bufferedreader包装下输入流

            OutputStream os = client.getOutputStream();//这是用来给服务器发送消息的输出流

//            PrintStream ps = new PrintStream(os);
//            Scanner scanner = new Scanner(System.in);//从键盘输入字符串

            boolean flag = true;//定义一个死循环，让服务器不停的接受从客户端发送来的字符串



            while (flag) {

                String s = br.readLine();//s是从客户端接受到得字符串

                System.out.println(s);
                if (null==s) {
                    break;
                }

                String[] strsplit = s.split("T");

                for (int i = 0; i < strsplit.length; i++) {
                    if (i==1) {
                        ifstr = strsplit[i];

                    }
                }
                String[] strsplits = ifstr.split("=");
                for (int i = 0; i < strsplits.length; i++) {
                    if (i==0) {
                        ifstrMD50 = strsplits[i];
                    }else if (i==1) {
                        ifstrMD51 = strsplits[i];
                    }
                }

                AllData allData = new AllData(ReturnCircleBean(),ReturnHotCoupBean(),ReturnHotTopticBean(),ReturnMainRollpagerBean(),ReturnMicroBean(),ReturnSuperManBean(),ReturnMainRollpagerBeanMicroBean());
                String str = gson.toJson(allData);
                String strMD5 = MD5Util.encrypt(str);
                // "GET /MyClass HTTP/1.1"

                if (s.equals("GET /AllData HTTP/1.1")) {

                    //CircleBean[] circleBeen, HotCoupBean[] hotCoupBeen, HotTopticBean[] hotTopticBeen, MainRollpagerBean[] mainRollpagerBeen, MicroBean[] microBeen, SuperManBean[] superManBeen, MainRollpagerBean mainRollpagermicroBeen





                    String strResponse = "HTTP/1.1 200 OK\nContent-Length: " + str.getBytes().length + "\n\n" + str;

                    os.write(strResponse.getBytes(),
                            0,
                            strResponse.getBytes().length);
                    os.flush();
                }
                else if (ifstrMD50.equals(" /AllData?MD5")) {

                    //CircleBean[] circleBeen, HotCoupBean[] hotCoupBeen, HotTopticBean[] hotTopticBeen, MainRollpagerBean[] mainRollpagerBeen, MicroBean[] microBeen, SuperManBean[] superManBeen, MainRollpagerBean mainRollpagermicroBeen



                    if (ifstrMD51.equals(strMD5+" H")) {
                        String strResponse = "HTTP/1.1 200 OK\nContent-Length: 34\n\n";

                        os.write(strResponse.getBytes(),
                                0,
                                strResponse.getBytes().length);
                        os.flush();
                    }else{
                        String strResponse = "HTTP/1.1 200 OK\nContent-Length: " + str.getBytes().length + "\n\n" + str;

                        os.write(strResponse.getBytes(),
                                0,
                                strResponse.getBytes().length);
                        os.flush();
                    }



                }





//                String s2 = scanner.nextLine();//s2是写给客户端的字符串
//                ps.println("123456789");    //给客户端发送你写的东西
            }

            client.close();
        }
        catch (IOException e) {//try 跟catch你不用管，这是用来处理异常的，就是固定格式
            e.printStackTrace();
        }
    }

    //圈子
    public static CircleBean[] ReturnCircleBean(){

        CircleBean circleBean1=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493215246132&di=acc577a5c9c7f4e2ddbf24b8241112d5&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F15%2F39%2F97%2F67i58PICae8_1024.jpg","自然观察圈",null,165,"自然之中有太多的奇迹和感动，现代人生活在钢筋混凝土森林里...",null,null,null,null,null,null);
        CircleBean circleBean2=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493865304&di=b4e1d3fffd5d4240242be44634a3d001&imgtype=jpg&er=1&src=http%3A%2F%2Fpic4.nipic.com%2F20090920%2F2572603_103929748503_2.jpg","艺术圈",null,147,"艺术源于生活--发现美，感受美，与身边的人共同分享",null,null,null,null,null,null);
        CircleBean circleBean3=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493270785159&di=fbd65a70514a45454c5e8d5fa6364f94&imgtype=0&src=http%3A%2F%2Ffile06.16sucai.com%2F2016%2F0124%2Fd139449cb7959023a4f40164e61883eb.jpg","亲子出游圈",null,82,"跟大家一起分享亲子游攻略，晒宝贝旅游美照，聊聊旅途中遇见的趣闻！",null,null,null,null,null,null);
        CircleBean circleBean4=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493270906250&di=b8b7a5106a3c57aff97889920997e2a2&imgtype=0&src=http%3A%2F%2Fimg4.duitang.com%2Fuploads%2Fitem%2F201404%2F26%2F20140426181832_uWLUj.thumb.700_0.jpeg","烘焙后厨圈",null,75,"职业吃货的聚集地，魔法般的艺术烘焙，世界优质食材的精美混搭。元子烘焙圈：极致...",null,null,null,null,null,null);
        CircleBean circleBean5=new CircleBean("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3304919173,308755164&fm=23&gp=0.jpg","动漫素描圈",null,114,"人人分享动漫素材，展示素描作品，交流心得，陪宝宝一起进入丰富的动漫世界~",null,null,null,null,null,null);
        CircleBean circleBean6=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493272291897&di=04b76d28b6cc12d584e2f3191a79628e&imgtype=0&src=http%3A%2F%2Fd.ifengimg.com%2Fq75%2Fimg1.ugc.ifeng.com%2Fnewugc%2F20161026%2Fimage%2F12%2F201_0go8NCD00_j_watermark0go8NCD00_j.jpg","孕期妈妈圈",null,68,"准妈妈们的经验分享、问答交流平台。每个准妈咪都是通往全能妈咪都是通往全能妈咪道路上的潜力股！",null,null,null,null,null,null);
        CircleBean circleBean7=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493867046&di=92df07982e5abc5d4fc1980e27fb99ce&imgtype=jpg&er=1&src=http%3A%2F%2Fhubei.sinaimg.cn%2F2013%2F0312%2FU6933P1190DT20130312114524.jpg","时尚海淘圈",null,97,"快来跟大家一起分享一下你身边的时尚好货和你的淘货经验吧！",null,null,null,null,null,null);
        CircleBean circleBean8=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493272358916&di=57274be0ce52230164fbdf51ad37cd1c&imgtype=0&src=http%3A%2F%2Fpic.66wz.com%2F0%2F00%2F23%2F60%2F236056_991510.jpg","巧手DIY圈",null,282,"有趣的你，生活中一定充满了无数的小创意和小惊喜！快来分享给大家吧。",null,null,null,null,null,null);
        CircleBean circleBean9=new CircleBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493272383138&di=2e0ceedd87748af75e0e72054eaff052&imgtype=0&src=http%3A%2F%2Fwww.forbecome.com%2Fuploadfiles%2Fpictures%2Fnews%2F20160504092754_8057.jpg","母婴喂养圈",null,69,"宝妈们快来一起分享交流关于母婴喂养方面的担心、困惑和疑问吧！",null,null,null,null,null,null);
        CircleBean circleBean10=new CircleBean("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=272822541,3680033319&fm=23&gp=0.jpg","手机摄影圈",null,228,"随手拍。用照片全是生活中的喜怒哀乐",null,null,null,null,null,null);
        CircleBean[] circleBeen = new CircleBean[]{circleBean1,circleBean2,circleBean3,
                circleBean4,circleBean5,circleBean6,
                circleBean7,circleBean8,circleBean9,circleBean10};


        return circleBeen;
    }

    //热门妙招
    public static HotCoupBean[] ReturnHotCoupBean(){

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
        HotCoupBean[] hotCoupBeen = new HotCoupBean[]{hotCoupBean1,hotCoupBean2,
                hotCoupBean3,hotCoupBean4,hotCoupBean5,hotCoupBean6,
                hotCoupBean7,hotCoupBean8,hotCoupBean9,hotCoupBean10};
        return hotCoupBeen;
    }

    //热门专题 攻略
    public static HotTopticBean[] ReturnHotTopticBean(){

        HotTopticBean hotTopticBean1=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493216360533&di=123dbd9f8917e47d4351d8bfd376ce58&imgtype=0&src=http%3A%2F%2Fimg8.itiexue.net%2F2201%2F22013024.jpg",112,4,"博物馆直观教育对孩子一生都有好处");
        HotTopticBean hotTopticBean2=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274067702&di=abca3578a51fa896f2e227dab8d15abd&imgtype=0&src=http%3A%2F%2Fcdn103.img.lizhi.fm%2Faudio_cover%2F2016%2F06%2F15%2F29263404816876679_320x320.jpg",695,21,"Hey！小朋友喜欢的英文故事来了！");
        HotTopticBean hotTopticBean3=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274115075&di=821ac803a3546e4a8b82ab2d2cf445d1&imgtype=0&src=http%3A%2F%2Fd6.yihaodianimg.com%2FN02%2FM06%2F45%2FBA%2FCgQCsFOJAomAetFQAAHNUX1iho440100.jpg",262,6,"用全新的视角颠覆育儿认知");
        HotTopticBean hotTopticBean4=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274139785&di=785a8ae2562c198966814618914e17d0&imgtype=0&src=http%3A%2F%2Fwww.xingzuo360.cn%2Fuploads%2Fallimg%2F170406%2F1491464542377997.jpg",209,6,"各种家常菜做法，你值得拥有");
        HotTopticBean hotTopticBean5=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493869352&di=f9f3344a622dd06fc1e0b792d5a43a2e&imgtype=jpg&er=1&src=http%3A%2F%2Fi.dimg.cc%2F2a%2Fd0%2F07%2F2c%2F69%2F40%2Fc9%2F52%2F42%2F18%2F61%2F73%2Ff2%2Ff2%2F96%2F89.jpg",290,4,"那些你不知道的亲子手工活儿");
        HotTopticBean hotTopticBean6=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274654995&di=6f32f6dc80879f430a9d2e9c10e27f52&imgtype=0&src=http%3A%2F%2Fimg5.duitang.com%2Fuploads%2Fitem%2F201411%2F27%2F20141127090945_NXycF.thumb.700_0.jpeg",239,4,"家有掌中宝，了解这些少烦恼");
        HotTopticBean hotTopticBean7=new HotTopticBean(null,"https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=445735604,1394376058&fm=23&gp=0.jpg",249,4,"几则简单英语小故事");
        HotTopticBean hotTopticBean8=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493955220&di=c1368c458bddbe02c9bfb22f6fee28f2&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.mp.itc.cn%2Fupload%2F20160923%2Fb05b40ffe20e438a8ae7fa3be64f7061_th.jpg",389,3,"我来帮你搬走养娃路上的绊脚石！");
        HotTopticBean hotTopticBean9=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274719810&di=f6cc7146fb97412e12e43c8b28f60496&imgtype=0&src=http%3A%2F%2Fdimg08.c-ctrip.com%2Fimages%2Ftg%2F590%2F942%2F561%2F1e77db68b3f44d939b342a207451a278.jpg",254,5,"放假啦！带上娃来场旅行吧！");
        HotTopticBean hotTopticBean10=new HotTopticBean(null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274750191&di=0d2d87a346e58f5a9d2fd2fe653f1eb3&imgtype=0&src=http%3A%2F%2Fimg.ishuo.cn%2F1604%2F1460892810.jpg",269,7,"和宝宝在一起就是要动手创作！");
        HotTopticBean[] hotTopticBeen = new HotTopticBean[]{hotTopticBean1,hotTopticBean2,
                hotTopticBean3,hotTopticBean4,hotTopticBean5,hotTopticBean6,
                hotTopticBean7,hotTopticBean8,hotTopticBean9,hotTopticBean10};

        return hotTopticBeen;
    }

    //轮播
    public static MainRollpagerBean[] ReturnMainRollpagerBean( ){


        MainRollpagerBean mainRollpagerBean1=new MainRollpagerBean("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3982378375,1641970070&fm=23&gp=0.jpg",null);
        MainRollpagerBean mainRollpagerBean2=new MainRollpagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274853026&di=892f1d313fff4ffb704cd8c7344a4d29&imgtype=0&src=http%3A%2F%2Fimg1.cache.netease.com%2Fcatchpic%2F6%2F6E%2F6ED2446973C3BC7E4CE1E95F2F952DF1.jpg",null);
        MainRollpagerBean mainRollpagerBean3=new MainRollpagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274893194&di=7d715bf60dafc41ec5aca268dbb3ac2a&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F48%2F81%2F27d58PICZn4_1024.jpg",null);
        MainRollpagerBean mainRollpagerBean4=new MainRollpagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493274958050&di=b7718ba9ff535b583c94b1ee928b89a1&imgtype=0&src=http%3A%2F%2Fwww.qbaobei.com%2FUploads%2FEditor%2F2015-11-12%2F564442056a9f4.jpg",null);
        MainRollpagerBean[] mainRollpagerBeen = new MainRollpagerBean[]{mainRollpagerBean1,
                mainRollpagerBean2,mainRollpagerBean3,mainRollpagerBean4};

        return mainRollpagerBeen;
    }

    //微课轮播
    public static MainRollpagerBean[] ReturnMainRollpagerBeanMicroBean(){



        MainRollpagerBean mainRollpagerBean1=new MainRollpagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493359307970&di=b51f1752e6f29da1ffa5b7e2b96137e2&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fw%253D580%2Fsign%3Dc0e55cb5572c11dfded1bf2b53266255%2Fd99f67d9f2d3572cb3e3078a8a13632762d0c336.jpg",null);
        MainRollpagerBean mainRollpagerBean2=new MainRollpagerBean("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493359347130&di=f7ea6ac4d0a8229e457bfc60fdfed389&imgtype=0&src=http%3A%2F%2Fimg0.ph.126.net%2FD24fK0tTLziwoVmdgERZ0Q%3D%3D%2F6598277030484874686.jpg",null);

        MainRollpagerBean[] mainRollpagerBeen = new MainRollpagerBean[]{mainRollpagerBean1,mainRollpagerBean2};
        return mainRollpagerBeen;
    }

    //微课
    public static MicroBean[] ReturnMicroBean(){



        MicroBean microBean1=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493216834209&di=4e4cebf5b171f42d5c50486d4727f350&imgtype=0&src=http%3A%2F%2Fs8.sinaimg.cn%2Fmw690%2F66f7c26dxcd081e7aa6d7%26690","只要一场游戏解决你的育儿烦恼","2016-12-21 20:00", 10,1012);
        MicroBean microBean2=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493360645603&di=011a554fca62e57fc4a41bc87a23242e&imgtype=0&src=http%3A%2F%2Fimg.mshishang.com%2Fpics%2F2016%2F0421%2F20160421052613166.jpg","小手势挡住大脾气，做个不发火妈妈","2016-12-20 20:00", 0,1254);
        MicroBean microBean3=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493275735320&di=41600a654350d0519211ac85e8e68cb8&imgtype=0&src=http%3A%2F%2Fatt2.citysbs.com%2Fhangzhou%2Fsns01%2Fforum%2F2010%2F09%2F21-08%2F20100921_8ac22014f740445472c85gBRLdxJa2P8.jpg","如何在家烘焙萌宝动物饼干？","2016-12-18 16:00", 0,983);
        MicroBean microBean4=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493275751460&di=900f738e3fdd0c32dd9543e5da3505ae&imgtype=0&src=http%3A%2F%2Fpic.qbaobei.com%2FUploads%2FPicture%2F2016-06-15%2F5760afc37a87c.jpg","爸妈适当放手让孩子专注力茁壮成树","2016-12-13 16:00", 0,1425);
        MicroBean microBean5=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493275773621&di=52bee853a9252bdb6a96a322699c34c2&imgtype=0&src=http%3A%2F%2Fimg1.0123.cn%2Farticle%2F201504%2F20150423151310_85667.jpg","宝宝辅食的那些事，不在是难事！","2016-12-02 16:00", 0,1491);
        MicroBean microBean6=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493870534&di=a7d5c57d125cc4ddbcb8bb77e043baf1&imgtype=jpg&er=1&src=http%3A%2F%2Fshuo.ucuxin.com%3A83%2Fuploads%2Fimages%2F20151119%2F1447917178275403.jpg","带着孩子重温童年衍纸与手的共鸣","2016-11-28 20:30", 0,1198);
        MicroBean microBean7=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493275835517&di=b1715c54d2bc95336d99cd17420e058e&imgtype=0&src=http%3A%2F%2Fwww.6681.com%2Fuploads%2Fallimg%2F150502%2F36-150502143637.jpg","培养聪明宝宝，天资创造力是关键","2016-11-25 20:00", 8,1493);
        MicroBean microBean8=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493275855922&di=88fbc1b39ec053818039615cc5d0cfbe&imgtype=0&src=http%3A%2F%2Fimg13.360buyimg.com%2FpopWaterMark%2Fjfs%2Ft748%2F230%2F249655186%2F408956%2F2bb250df%2F5498fd14N98cfdaac.jpg","我有课！你有娃吗？","2016-11-23 20:00", 10,928);
        MicroBean microBean9=new MicroBean(null,null,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493870595&di=d17c5edc9516059de824c242ff5e67ae&imgtype=jpg&er=1&src=http%3A%2F%2Fimg01.mmbang.info%2F5iyaya_group6_M01_57_CA_CggaDVjiDSyAPzFeAAAm33iBeoE262.jpg","准妈妈必读/抚触-传递妈妈的爱","2016-11-22 20:00", 0,1009);
        MicroBean microBean10=new MicroBean(null,null,"https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1353102998,1350451047&fm=23&gp=0.jpg","亲子早教，家庭游戏早知道","2016-11-19 20:00", 10,823);
        MicroBean[] microBeen = new MicroBean[]{microBean1,microBean2,
                microBean3,microBean4,microBean5,microBean6,
                microBean7,microBean8,microBean9,microBean10,};

        return microBeen;

    }

    //推荐达人
    public static SuperManBean ReturnSuperManBean(){

        SuperManBean superManBean1=new SuperManBean("strBackPicUrl","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1493216995697&di=50c378db0596e2e35ca38c2262e1a25e&imgtype=0&src=http%3A%2F%2Fimg.gsxservice.com%2F1265537_dvvtgnn9.jpeg","Amy",2,"4岁孩子的妈妈，美国正面管教协会注册讲师，顺德加大正面管教首席签约讲师，2016年全国...");



        return superManBean1;
    }
}  
