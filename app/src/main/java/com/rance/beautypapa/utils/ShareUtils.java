package com.rance.beautypapa.utils;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * 作者：Rance on 2016/10/29 15:08
 * 邮箱：rance935@163.com
 */
public class ShareUtils {
    /**
     * 演示调用ShareSDK执行分享
     *
     * @param context
     */
    public static void showShare(Context context) {
        ShareSDK.initSDK(context);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();
        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle("爱啪");
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl("http://u2791965.viewer.maka.im/pcviewer/FZSJ6YJ6");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("集知乎日报和美拍为一体的供用户休闲的个人开发者软件，开放源码，与广大程序猿共同进步，乐于开源，享受编程带来的乐趣");
        //分享网络图片，新浪微博分享网络图片需要通过审核后申请高级写入接口，否则请注释掉测试新浪微博
        oks.setImageUrl("http://a3.qpic.cn/psb?/V11ezDF63CzHWO/oz.DQPJ*R15QjSrxxF6UpDQD4cHxOUl5wcd.wS9JdwI!/b/dHwBAAAAAAAA&bo=eAB4AAAAAAADByI!&rf=viewer_4");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        //oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://u2791965.viewer.maka.im/pcviewer/FZSJ6YJ6");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("集知乎日报和美拍为一体的供用户休闲的个人开发者软件，开放源码，与广大程序猿共同进步，乐于开源，享受编程带来的乐趣");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite("爱啪");
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://u2791965.viewer.maka.im/pcviewer/FZSJ6YJ6");
        // 启动分享GUI
        oks.show(context);
    }
}
