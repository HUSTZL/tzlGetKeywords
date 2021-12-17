import HUST.Chinese.Lexical.Analysis.System.ICTMain;

import java.io.*;

public class getMainWord {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("减税降费助力双循环.txt") , "UTF-8"));
            String text = new String(); String aNewLine;
            //读取文本内容（构造while循环，一行一行读取文本）
            while ((aNewLine = reader.readLine()) != null)
                text = text + aNewLine + "\n";
            //输出文本
            System.out.println(text);
            String fenciresult= ICTMain.fenci(text);
            //System.out.println(fenciresult);
            String []wordlist = new String[100000];int totWordNum = 0;
            String []differentwordlist = new String[100000];int totdifferentwordNum = 0;
            int []wordnumlist = new int[100000];
            for(int i = 0; i < fenciresult.length(); i++) {
                while(fenciresult.charAt(i) == ' ' && i < fenciresult.length())
                    i++;
                int j = i;
                for( j = i; j < fenciresult.length(); j++)
                    if(fenciresult.charAt(j) == ' ')
                        break;
                if(j != i + 1)
                    wordlist[totWordNum++] = (fenciresult.substring(i, j));
                i = j;
                //System.out.println(wordlist[totWordnum-1]);
            }
            for(int i = 0; i < totWordNum; i++)
                for(int j = 0; j < totWordNum - i - 1; j++)
                    if(wordlist[j].compareTo(wordlist[j+1])>0) {
                        String temp = wordlist[j];
                        wordlist[j] = wordlist[j+1];
                        wordlist[j+1] = temp;
                    }
            for (int i = 0; i < totWordNum;i++) {
                int thisWordnum = 1;
                int j = i+1;
                while(j < totWordNum && wordlist[i].equals(wordlist[j])) {
                    thisWordnum++;
                    j++;
                }
                differentwordlist[totdifferentwordNum] = wordlist[i];
                wordnumlist[totdifferentwordNum++] = thisWordnum;
                //System.out.println(wordlist[i] + " " + thisWordnum);
                i = j-1;
            }
            for(int i = 0; i < totdifferentwordNum; i++)
                for(int j = 0; j < totdifferentwordNum - i - 1; j++)
                    if(wordnumlist[j] < wordnumlist[j+1]) {
                        String temp = differentwordlist[j];
                        differentwordlist[j] = differentwordlist[j+1];
                        differentwordlist[j+1] = temp;
                        int TEMP = wordnumlist[j];
                        wordnumlist[j] = wordnumlist[j+1];
                        wordnumlist[j+1] = TEMP;
                    }
            for(int i = 0; i < 10; i++)
                System.out.println("出现频率第" + (i+1) + "大的词为" + differentwordlist[i] + "，其出现次数为" + wordnumlist[i]);
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
