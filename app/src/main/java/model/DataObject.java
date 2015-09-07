package model;

/**
 * Created by Priya on 9/7/2015.
 */
public class DataObject {
    private String mText1;
    private String mText2;
    private int mType;

    public DataObject (String text1, String text2, int type){
        mText1 = text1;
        mText2 = text2;
        this.mType = type;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2) {
        this.mText2 = mText2;
    }
}
