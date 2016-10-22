package com.rance.beautypapa.view;

import com.rance.beautypapa.base.BaseView;
import com.rance.beautypapa.model.VideoEntity;

import java.util.List;

/**
 * Created by Rance
 * on 2016/10/22.
 */
public interface MainView extends BaseView {

    void getVideoSuccess(List<VideoEntity> videoEntity);

    void getVideoFail(String msg);

}
