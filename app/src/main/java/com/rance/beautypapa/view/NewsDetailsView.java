package com.rance.beautypapa.view;

import com.rance.beautypapa.base.BaseView;
import com.rance.beautypapa.model.NewsDetailsEntity;
import com.rance.beautypapa.model.NewsEntity;

/**
 * 作者：Rance on 2016/10/25 15:19
 * 邮箱：rance935@163.com
 */
public interface NewsDetailsView extends BaseView {

    void getNewsDetailsSuccess(NewsDetailsEntity newsEntity);

    void getNewsDetailsFail(String msg);

}
