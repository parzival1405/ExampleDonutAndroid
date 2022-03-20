package quanghuu.example.donut.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Donut implements Parcelable {
    private int image;
    private String title;
    private String detail;
    private double price;

    public Donut(int image, String title, String detail, double price) {
        this.image = image;
        this.title = title;
        this.detail = detail;
        this.price = price;
    }

    protected Donut(Parcel in) {
        image = in.readInt();
        title = in.readString();
        detail = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Donut> CREATOR = new Creator<Donut>() {
        @Override
        public Donut createFromParcel(Parcel in) {
            return new Donut(in);
        }

        @Override
        public Donut[] newArray(int size) {
            return new Donut[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(image);
        parcel.writeString(title);
        parcel.writeString(detail);
        parcel.writeDouble(price);
    }
}
