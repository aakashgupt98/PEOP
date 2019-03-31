package aakashgupt98.navifragment;

public class Project_list_Feeds {

    private String imgURL, feedName, content,date;
    //private int rating;

    public Project_list_Feeds(String name, String imgurl, String date , String content) {
        this.feedName = name;
        this.content = content;
        this.imgURL = imgurl;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getFeedName() {
        return feedName;
    }

    public String getDate() {
        return date;
    }

}
