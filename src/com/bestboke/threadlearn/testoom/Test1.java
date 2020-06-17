package com.bestboke.threadlearn.testoom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Test1 {

    private static final ConcurrentMap<String, WXBizMsgCrypt> wxBizMsgCryptConcurrentMap = new ConcurrentHashMap<>();

    private static  WXBizMsgCrypt wxBizMsgCrypt;

    String     token= "infoepoch";
    String encodingAESKey = "fjR3hen8uikC2ZuoGtNl832SF76Agou3zufk4963HW8";


    private String receiveid = "123";

    private List<byte[]> aesKeyList = new ArrayList<>();

    String xml = "<xml>\n" +
            "    <ToUserName><![CDATA[toUser]]></ToUserName>\n" +
            "    <FromUserName><![CDATA[sys]]></FromUserName> \n" +
            "    <CreateTime>1403610513</CreateTime>\n" +
            "    <MsgType><![CDATA[event]]></MsgType>\n" +
            "    <Event><![CDATA[change_contact]]></Event>\n" +
            "    <ChangeType>create_user</ChangeType>\n" +
            "    <UserID><![CDATA[zhangsan]]></UserID>\n" +
            "    <Name><![CDATA[张三]]></Name>\n" +
            "    <Department><![CDATA[1,2,3]]></Department>\n" +
            "    <IsLeaderInDept><![CDATA[1,0,0]]></IsLeaderInDept>\n" +
            "    <Position><![CDATA[产品经理]]></Position>\n" +
            "    <Mobile>13800000000</Mobile>\n" +
            "    <Gender>1</Gender>\n" +
            "    <Email><![CDATA[zhangsan@gzdev.com]]></Email>\n" +
            "    <Status>1</Status>\n" +
            "    <Avatar><![CDATA[http://wx.qlogo.cn/mmopen/ajNVdqHZLLA3WJ6DSZUfiakYe37PKnQhBIeOQBO4czqrnZDS79FH5Wm5m4X69TBicnHFlhiafvDwklOpZeXYQQ2icg/0]]></Avatar>\n" +
            "    <Alias><![CDATA[zhangsan]]></Alias>\n" +
            "    <Telephone><![CDATA[020-123456]]></Telephone>\n" +
            "    <Address><![CDATA[广州市]]></Address>\n" +
            "    <ExtAttr>\n" +
            "        <Item>\n" +
            "        <Name><![CDATA[爱好]]></Name>\n" +
            "        <Type>0</Type>\n" +
            "        <Text>\n" +
            "            <Value><![CDATA[旅游]]></Value>\n" +
            "        </Text>\n" +
            "        </Item>\n" +
            "        <Item>\n" +
            "        <Name><![CDATA[卡号]]></Name>\n" +
            "        <Type>1</Type>\n" +
            "        <Web>\n" +
            "            <Title><![CDATA[企业微信]]></Title>\n" +
            "            <Url><![CDATA[https://work.weixin.qq.com]]></Url>\n" +
            "        </Web>\n" +
            "        </Item>\n" +
            "    </ExtAttr>\n" +
            "</xml>";

    String _xml = "<xml>\n" +
            "<Encrypt><![CDATA[WYQYIStmhoO0Pa6k1YpSV1vJ9TLsjzQPZim5ACO3qpXBjJ1Rj/JsqByCnGhyDYj1WhqZAER8fO+jPKNTzEQxG6iOfXVbBjixsVYfxviBFal4851l8NY2ZvADycU5VVScxhNOtJwONmKVeI8cLeOI7P8o5GtZY18kQ9TQEdcMKuQhlScUAGjsFTH6eLDS3fMruD4t5qUgI7HDDIOTvRxJyzyhbaHuZ3yybE6fGUvzh8M2DvdGd+EZTiW53RXvqJALJcO0eOvSmRgj/4HOcB+wlb9lCiKd5/V7Sc5dbgC839fnPKQotOjzFRr9ThIL4naEAoPV4CvnnXqC6E8Vh2+tzQO3OBih8OUF0zuHBC7Cv+/OieddjU44Uk3tl6A2M1AK2EAZCy8toxW5GwvHdmbu5apNUjhfLigdD/2dQuXDGukjWmkGkoSXfD0qTqw7Ai8B3Mi0Wl/C/gJSDlJ1s+IlcegJWSo3B+eYY6X4Z+sy3yY9JgyyvAKBH3k3g00ypD2Jdh7n9/c3OK8T2nNkC07wZTgpU/R3sbUmWnO+/lomN3mf/JTj0QgTKabO+HQQdDiyq3h1JaY3pKuPpFQEvxAyRiOKBqQBtWpbrIeGrBmSZ4t2+i+Nqts1RKZ6DLvZXHs7QysY9WpUnTBE6ySjgzy/UE7WAIprMg70VOhQZ9EWGd+1MhRcGKo3OgJUE7Yghkzw3d8Xkpk/pvNIkBfSbvYushTY6BMe9bOMkF4vLofeH1pdDko2XtGHIKuDsuKAMX603D/idOtKgdaUkVbWIlXzXl6maj0XGyGPUlCxYdSx2lO6PyY5IihVer/fn0ImJNLDXfPzDbMZ8sgwWGXsHar7+/PrEmVAB6rXyJQ932pHR81vgTikHl2zlANcssuWb3+6qMswG+iQ+E7iosLIFvsvD6jWQvWqQb5lVBoCJmyxnvGV8pdwOnM9k+508drVnLUgW/0wiAODkpPMVjXEeyvmZ9ToejmunyD7AN9esQgPp4Rx0tNUMgXmezjm9AVGmJeyij3UTtcPqibfhMulJQsBTSs8ZvQCNszRzbKNCgvUkyYfHlwUUeN+1Zl7nQ7bURQIMTgw13Gvr5z9HIqg6nSQqiZ4NbFYpzjijzvTzbKJpY3Kcje0JAGjd53zgiHmXPlVj0moWm3ohjmuLZ1Px1TotVQHrWvXHYc0WwXGw9zqXZUbKfHYKlwr7iwBFsNv7Dpq7H76OUm/oiZiLGW7tNaJqm17fbyRRhao3z5wf2YY/Xm/OVbSFfPoC/NNRavOZtIJ5waQ+MulCF8OEZ5Xm6Zf50pGDjUGwfcOHhpPduQc8UY9wqiX7i8YdOpwMC3RyG9uPTlHTwHnDCYmxS6/XdVOCby6sxXyohZw+75IDGN2cIYsvQGlI+UqoSv+vJGdW70euRgGrdxhkv28gjVvMxWNYbVMr1ATyDHu0jEoJ0Cy4+1Gm7jDvMhep8T6ar3jE92Y3Ce5KPYTsj2Ubqu9+DsoXAICHaNpDmTa4WPakaRtBy4VTTcnKAKOX6oPDJDgVMe1Y+rdAbr0Qkvw8CkeM7b/jVUdd+atWqGyb499clPjQo0aZnhEjCz1BLS3AHOrjTuCEUqpngW/ySP1KeH3OFyIE2UtMp9c+R+j95I2q+0PxqIjLFotJVnjcI5ndyU2BJpzCsepsCM/EWYI1ZwVSmDKQpejWv8K/P3/kJYG5xRPhY2WhUmS7cEAIZHyYbvVw9Wh4RIkM4s73bhwCtWW8ZfyBB3u7wkMVoFc1wT2sTwTIAPKd9BmVTmc1yn3B+bMvC+rp0l89MkFEmn7REA2BrOAvu/7iMVexmb35KDTazqPaH/G48BsaF9AuktCUF/kREiAu/N3B0CRhNiE07/z7BbiUw==]]></Encrypt>\n" +
            "<ToUserName><![CDATA[123]]></ToUserName>\n" +
            "<AgentID><![CDATA[]]></AgentID>\n" +
            "</xml>";


    /**
     * 加密后生成xml
     *
     * @param encrypt
     * @return
     * @throws AesException
     */
    private String xmlParse(String encrypt) {
        String format = "<xml>\n" + "<Encrypt><![CDATA[%1$s]]></Encrypt>\n"
                + "<ToUserName><![CDATA[%2$s]]></ToUserName>\n"
                + "<AgentID><![CDATA[]]></AgentID>\n" + "</xml>";
        return String.format(format, encrypt, receiveid);
    }

    private WXBizMsgCrypt getWXBizMsgCrypt(String token, String encodingAesKey) throws AesException {
        if (wxBizMsgCryptConcurrentMap.get(token) != null) {
            return wxBizMsgCryptConcurrentMap.get(token);
        }
        WXBizMsgCrypt wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAesKey, receiveid);
        wxBizMsgCryptConcurrentMap.put(token, wxBizMsgCrypt);
        aesKeyList.add(wxBizMsgCrypt.aesKey);
        return wxBizMsgCrypt;
    }

    /**
     * 实例化加解密信息
     *
     * @return
     */
    private WXBizMsgCrypt getWXBizMsgCrypt() {
        if (wxBizMsgCrypt == null) {
            try {
                wxBizMsgCrypt = new WXBizMsgCrypt(token, encodingAESKey, receiveid);
                aesKeyList.add(wxBizMsgCrypt.aesKey);
            } catch (AesException e) {
                e.printStackTrace();
            }
        }
        return wxBizMsgCrypt;
    }

    private Map<String, KeyInfo> getMap(){
        KeyInfo keyInfo = new KeyInfo();
        keyInfo.setToken("123");
        keyInfo.setEncodingAESKey("7e353b5f40f840ea93c8874964c28787cb1bab5ec1f");
        keyInfo.setUrl("134");
        Map<String, KeyInfo> keyInfoMap = new HashMap<>();
        keyInfoMap.put(token, keyInfo);
        return keyInfoMap;
    }
    @Test
    public void decTest(){
        try {
            xml = getWXBizMsgCrypt().DecryptMsg("396f85c7817cd0b3d53b5cd0bb55788b0220b7f9", "1588948704300", "g8tJzwsmSyGfuQc9", _xml);
            System.out.println(getWXBizMsgCrypt().aesKey.toString());

        } catch (AesException e) {
            e.printStackTrace();
        }
        test();
    }


    public  void test(){

        Map<String, KeyInfo> entries = getMap();
        for (Map.Entry<String, KeyInfo> entry : entries.entrySet()) {
            String token = entry.getKey();
            KeyInfo value = entry.getValue();
            String encodingAesKey = value.getEncodingAESKey();
            String url = value.getUrl();
            try {
                // 获取加密方法实例
                WXBizMsgCrypt wxBizMsgCrypt = getWXBizMsgCrypt(token, encodingAesKey);
                System.out.println(wxBizMsgCrypt.aesKey.toString());
                // 重新加密xml
                String encrypt = wxBizMsgCrypt.EncryptMsg(xml);
                // 生成时间戳
                String timeStamp = Long.toString(System.currentTimeMillis());
                System.out.println(timeStamp);
                // 生成随机字符串
                String nonce = wxBizMsgCrypt.getRandomStr();
                System.out.println(nonce);
                // 生成安全签名
                String signature = SHA1.getSHA1(token, timeStamp, nonce, encrypt);
                System.out.println(signature);
                // 生成xml
                String relayStr = xmlParse(encrypt);
                System.out.println(relayStr);
                Thread.sleep(1000L);
            } catch (AesException e) {

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            decTest();

        }
    }



}
