import HUST.Chinese.Lexical.Analysis.System.ICTMain;

import java.io.*;

public class ziliao {
    public static void main(String[] args) throws IOException {
        String[] a = new String[6237];
        //构建数组来存储要输出的文本中的字符
        int a1 = 0;

        //首先找到文本的路径，让程序能够读取文本的内容
        String b= new String();
        FileInputStream c = new FileInputStream("c:\\Users\\Tuski\\Desktop\\减税降费助力双循环.txt");
        InputStreamReader d = new InputStreamReader(c, "UTF-8");
       //构建br变量，使文档能够被读取 br实际上是输入流
        BufferedReader br = new BufferedReader(d);
        String z = br.readLine();
        //读取文本内容（构造while循环，一行一行读取文本）
        while ((z = br.readLine()) != null) {
        b=b+z+"\r\n";
        }
        //输出文本
        System.out.println(b);

        //读取词典并存入词组
        FileInputStream m = new FileInputStream("C:\\Users\\Tuski\\Desktop\\词典.txt");
        InputStreamReader n = new InputStreamReader(m,"UTF-8");
        BufferedReader br1 = new BufferedReader(n);
        String v[]=new String[10000000];
        String k = null;
        int s=0;
        int cn[]=new int[10000000];
        while((k=br1.readLine())!=null ){
            v[s]=k;
            //s为词典行数
            System.out.println(v[s]);
            s=s+1;
        }

        String str=b;

        String result = ICTMain.fenci(str);
   //    System.out.println(result);

        //读取储存在词典.txt里面的词表
        int u=0;
        while(u<b.length()){
            String zoo="";
            if(b.length()-u>=5){
                zoo=b.substring(u,u+5);
            }

            //判断截取的字符串是否是所需字符串
            //运用boolean来判断
            boolean we=false;
            for(int j=0;j<v.length;j=j+1){
                if(zoo.equals(v[j])){
                    we=true;
                }
            }
            //如果截取的长度为11的字符串不是我们所需的，则继续截取
            //若zoo的字符串长度相等
            //用equals来判断是否相等（不用处于同一位置）
            while(we==false&&zoo.length()>1){
                zoo=zoo.substring(0,zoo.length()-1);
                //在while循环里面嵌套for循环
                for(int r=0;r<v.length;r=r+1){
                    if(zoo.equals(v[r])){
                        we=true;
                    }
                }
            }
            //现在开始对文本中我们所需要的词语进行搜寻并将找到的词语存在数组a中
            a[a1]=zoo;
            a1=a1+1;
            //可以先不输出System.out.println(zoo);
            //在这个时候开始进行下一次的搜寻
            u=u+zoo.length();
        }

        //开始统计高频词
        int num[]=new int [6237];
        //设一个数组来存储文字
        for(int l1=0; l1<num.length;l1=l1+1){
            num[l1]=0;}
        for(int l2=0;l2<num.length;l2=l2+1) {
            for (int l3 = 0; l3 < v.length; l3 = l3 + 1) {
                if (v[l3].equals(a[l3])) {
                    num[l2] = num[l2] + 1;
                    //为文本中的每一个关键词设置一个计数器，找到一个关键词则计数器加1
                }
            }


        }
   System.out.println(result);



                    }
                }












