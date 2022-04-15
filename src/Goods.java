import java.math.BigDecimal;

public class Goods {

    public static final int BANNER_TYPE_GOODS = 0;
    public static final int BANNER_TYPE_H5 = 1;

    //商品id
    public int id;
    //商品名字
    public String name;
    //商品图片
    public String pic;
    //供应商
    public String provider;
    //供应商头像
    public String providerHeader;
    //是否收藏
    public boolean isCollect;
    //是否已售罄
    public boolean isSoldOut;
    //浏览数量
    public int browseCount;
    //收藏数量
    public int collectCount;
    //合约地址
    public String contractAddress;
    //认证标识
    public String authMarking;
    //认证网络
    public String authNetwork;
    //商品详情
    public String detailDesc;
    //banner图片
    public String bannerPic;
    //banner类型：0：商品；1：H5
    public int bannerType;
    //banner h5地址
    public String bannerUrl;

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", provider='" + provider + '\'' +
                ", providerHeader='" + providerHeader + '\'' +
                ", isCollect=" + isCollect +
                ", isSoldOut=" + isSoldOut +
                ", browseCount=" + browseCount +
                ", collectCount=" + collectCount +
                ", contractAddress='" + contractAddress + '\'' +
                ", authMarking='" + authMarking + '\'' +
                ", authNetwork='" + authNetwork + '\'' +
                ", detailDesc='" + detailDesc + '\'' +
                ", bannerPic='" + bannerPic + '\'' +
                ", bannerType=" + bannerType +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }
}
