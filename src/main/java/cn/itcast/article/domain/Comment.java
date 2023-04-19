package cn.itcast.article.domain;

public class Comment {
    private int mid;
    private int uid;
    private String name;
    private String mInner;
    private int aid;
    private String mdate;

    @Override
    public String toString() {
        return "Comment{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", mInner='" + mInner + '\'' +
                ", aid=" + aid +
                ", mdate='" + mdate + '\'' +
                '}';
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getmInner() {
        return mInner;
    }

    public void setmInner(String mInner) {
        this.mInner = mInner;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public Comment(int mid, int uid, String name, String mInner, int aid, String mdate) {
        this.mid = mid;
        this.uid = uid;
        this.name = name;
        this.mInner = mInner;
        this.aid = aid;
        this.mdate = mdate;
    }

    public Comment() {
    }
}
