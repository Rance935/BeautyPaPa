package com.rance.beautypapa.adapter.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.rance.beautypapa.R;
import com.rance.beautypapa.base.MyApplication;
import com.rance.beautypapa.model.VideoEntity;
import com.rance.beautypapa.widget.CircleImageView;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：Rance on 2016/10/25 15:35
 * 邮箱：rance935@163.com
 */
public class VideoViewHolder extends BaseViewHolder<VideoEntity> {

    @Bind(R.id.item_video_cover)
    ImageView itemVideoCover;
    @Bind(R.id.item_video_header)
    CircleImageView itemVideoHeader;
    @Bind(R.id.item_video_name)
    TextView itemVideoName;
    @Bind(R.id.item_video_caption)
    TextView itemVideoCaption;
    @Bind(R.id.item_video_play_num)
    TextView itemVideoPlayNum;
    @Bind(R.id.item_video_like_num)
    TextView itemVideoLikeNum;
    @Bind(R.id.item_video_comment_num)
    TextView itemVideoCommentNum;

    public VideoViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_video);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(VideoEntity videoEntity) {
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemView.setLayoutParams(layoutParams);
        Picasso.with(getContext()).load(videoEntity.getCover_pic()).into(itemVideoCover);
        Picasso.with(getContext()).load(videoEntity.getAvatar()).into(itemVideoHeader);
        itemVideoName.setText(videoEntity.getScreen_name());
        itemVideoCaption.setText(videoEntity.getCaption());
        itemVideoCommentNum.setText(videoEntity.getComments_count() + "");
        itemVideoLikeNum.setText(videoEntity.getLikes_count() + "");
        itemVideoPlayNum.setText(videoEntity.getPlays_count() + "");
    }
}
