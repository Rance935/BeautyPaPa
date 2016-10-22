package com.rance.beautypapa.model;

/**
 * Created by Rance
 * on 2016/10/22.
 */
public class VideoEntity {

    /**
     * id : 600037103
     * url : http://www.meipai.com/media/600037103
     * cover_pic : http://mvimg2.meitudata.com/5809dac6c8c3e595.jpg!thumb320
     * screen_name : 万宝路路~
     * caption : 此景~此生必来一次
     * avatar : http://mvavatar1.meitudata.com/57f3c93a86a799616.jpg
     * plays_count : 1885
     * comments_count : 13
     * likes_count : 51
     */

    private int id;
    private String url;
    private String cover_pic;
    private String screen_name;
    private String caption;
    private String avatar;
    private int plays_count;
    private int comments_count;
    private int likes_count;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getPlays_count() {
        return plays_count;
    }

    public void setPlays_count(int plays_count) {
        this.plays_count = plays_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(int likes_count) {
        this.likes_count = likes_count;
    }

    @Override
    public String toString() {
        return "VideoEntity{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", cover_pic='" + cover_pic + '\'' +
                ", screen_name='" + screen_name + '\'' +
                ", caption='" + caption + '\'' +
                ", avatar='" + avatar + '\'' +
                ", plays_count=" + plays_count +
                ", comments_count=" + comments_count +
                ", likes_count=" + likes_count +
                '}';
    }
}
