package com.rance.beautypapa.model;

import java.util.List;

/**
 * 作者：Rance on 2016/10/27 10:34
 * 邮箱：rance935@163.com
 */
public class NewsEntity {

    /**
     * date : 20161027
     * stories : [{"images":["http://pic1.zhimg.com/b1c88ecec7262fc1d2e12ce15e8f5fc0.jpg"],"type":0,"id":8923283,"ga_prefix":"102711","title":"「小张，给你一周，写好这个项目的调查报告交给我」"},{"images":["http://pic3.zhimg.com/b326b49a21c183eb79ce838346c7c9de.jpg"],"type":0,"id":8921737,"ga_prefix":"102710","title":"年收入12 万明明很高，为什么提高税率还叫苦不迭？"},{"images":["http://pic1.zhimg.com/fa786f9a8b492a5643bad9d2fbc157cc.jpg"],"type":0,"id":8921595,"ga_prefix":"102709","title":"各国移民涌进来，对东道国是好事还是坏事？"},{"images":["http://pic3.zhimg.com/cb7862453873948a5f6b07bcf0b4e742.jpg"],"type":0,"id":8922354,"ga_prefix":"102708","title":"爱情里，也上演着一场「权力的游戏」"},{"title":"世外桃源般的诗意栖居，说的是这些建筑","ga_prefix":"102707","images":["http://pic2.zhimg.com/cdc51bbbe9aa4381ad8aa3af6c5c8011.jpg"],"multipic":true,"type":0,"id":8923141},{"images":["http://pic1.zhimg.com/068ed4bf548978b28a9e15f280ce6bbc.jpg"],"type":0,"id":8837436,"ga_prefix":"102707","title":"面试官眼里的「学习能力」，不一定是你想的那样"},{"images":["http://pic1.zhimg.com/edbd9202c3166319f0e98b6a143841bc.jpg"],"type":0,"id":8922424,"ga_prefix":"102707","title":"商场和影院，究竟谁养活谁？"},{"images":["http://pic2.zhimg.com/70c8fae52f993b4f416d6e3839ecd7f5.jpg"],"type":0,"id":8923090,"ga_prefix":"102707","title":"读读日报 24 小时热门 TOP 5 · 双 MVP 新上路，撞上老司机"},{"images":["http://pic4.zhimg.com/0e18bcf7e509b5d764e2a39ffcb6f0a7.jpg"],"type":0,"id":8919203,"ga_prefix":"102706","title":"瞎扯 · 如何正确地吐槽"}]
     * top_stories : [{"image":"http://pic4.zhimg.com/075530196633feabbd49e58f129f9def.jpg","type":0,"id":8921737,"ga_prefix":"102710","title":"年收入12 万明明很高，为什么提高税率还叫苦不迭？"},{"image":"http://pic4.zhimg.com/0a5dd3ed69e17d3a4888bba56d71cf17.jpg","type":0,"id":8837436,"ga_prefix":"102707","title":"面试官眼里的「学习能力」，不一定是你想的那样"},{"image":"http://pic3.zhimg.com/2d1576b6d663d7cad466136f0528ef5e.jpg","type":0,"id":8923090,"ga_prefix":"102707","title":"读读日报 24 小时热门 TOP 5 · 双 MVP 新上路，撞上老司机"},{"image":"http://pic3.zhimg.com/a30fddfc53e3ff6e67cfd8a1fbaf383e.jpg","type":0,"id":8922041,"ga_prefix":"102617","title":"知乎好问题 · 芝麻信用分数是怎么算出来的？"},{"image":"http://pic3.zhimg.com/0051a48741f39955b16c63c205fcc572.jpg","type":0,"id":8921597,"ga_prefix":"102615","title":"NBA 新赛季开打，这可能是最「恶意」的一份前瞻"}]
     */

    private String date;
    /**
     * images : ["http://pic1.zhimg.com/b1c88ecec7262fc1d2e12ce15e8f5fc0.jpg"]
     * type : 0
     * id : 8923283
     * ga_prefix : 102711
     * title : 「小张，给你一周，写好这个项目的调查报告交给我」
     */

    private List<StoriesBean> stories;
    /**
     * image : http://pic4.zhimg.com/075530196633feabbd49e58f129f9def.jpg
     * type : 0
     * id : 8921737
     * ga_prefix : 102710
     * title : 年收入12 万明明很高，为什么提高税率还叫苦不迭？
     */

    private List<TopStoriesBean> top_stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public List<TopStoriesBean> getTop_stories() {
        return top_stories;
    }

    public void setTop_stories(List<TopStoriesBean> top_stories) {
        this.top_stories = top_stories;
    }

    public static class StoriesBean {
        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class TopStoriesBean {
        private String image;
        private int type;
        private int id;
        private String ga_prefix;
        private String title;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
