package entity;

/**考核
 * 其中,第一行为行头,表示每列的数据信息,其中id为int,name为String,subject为String,score为int,advisor为String(里面存储的格式为[数据1,数据2],数据之间以,分隔)
 每列数据以多个空格或tab键分隔(即可能为tab键,也可能为空格)
 * Created by hao on 2016/5/12.
 */
public class ShuJu {
    public int id;
    public String name;
    public String subject;
    public  int score;
    public String advisor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public ShuJu(int id, String name, String subject, int score, String advisor) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.score = score;
        this.advisor = advisor;
    }
    public ShuJu(){

    }

    @Override
    public String toString() {
        return " " +
                " " + id +
                " " + name +
                " " + subject +
                " " + score +
                " " + advisor ;
    }
}
