package com.rance.beautypapa.view;

import com.rance.beautypapa.base.BaseView;
import com.rance.beautypapa.model.NewsEntity;
import com.rance.beautypapa.model.VideoEntity;

import java.util.List;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public interface NewsView extends BaseView {

    void getNewsSuccess(NewsEntity newsEntity);

    void getNewsFail(String msg);

}
