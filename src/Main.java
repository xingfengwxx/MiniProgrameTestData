import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("生成小程序测试数据");
        createGoodsList();
    }

    public static void createGoodsList() {
        try {
            List<DescFile> descFileList = new ArrayList<>();
            List<Goods> goodsList = new ArrayList<>();

            int[] bannerIndexArr = {7, 9, 21};
            List<Goods> bannerList = new ArrayList<>();


            String pathname = "D:\\IdeaProjects\\MiniProgramTestData\\res\\desc.txt";
            File filename = new File(pathname);
            InputStreamReader reader = new InputStreamReader(new FileInputStream(filename));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            line = br.readLine();
            while (line != null) {
                DescFile descFile = new DescFile();

                System.out.println(line);
                int nameStarIndex = line.indexOf("【");
                int nameEndIndex = line.indexOf("】");
                System.out.println("nameStarIndex=" + nameStarIndex + ", nameEndIndex=" + nameEndIndex);
                String name = line.substring(nameStarIndex + 1, nameEndIndex);
                String desc = line.substring(nameEndIndex + 1);
                System.out.println("name=" + name + ", desc=" + desc);

                descFile.name = name;
                descFile.desc = desc;
                descFileList.add(descFile);

                System.out.println("===============================");

                line = br.readLine();
            }

            System.out.println("商品数量：" + descFileList.size());
            for (int i = 0; i < descFileList.size(); i++) {
                Goods goods = new Goods();
                goods.id = i;
                goods.name = descFileList.get(i).name;
                goods.pic = "https://test.cdn.sbnh.cn/ntf/" + (i + 1) + ".png";
                goods.provider = "泡泡玛特";
                goods.providerHeader = "/images/ic_provider_header_0.png";
                goods.isCollect = false;
                goods.isSoldOut = false;
                goods.browseCount = 200 + i;
                goods.collectCount =  300 + i;
                goods.contractAddress = "深圳市南山区侨城一号";
                goods.authMarking = "3141592653";
                goods.authNetwork = "https://prod.sbnh.cn/ntf";
                goods.detailDesc = descFileList.get(i).desc;
                goodsList.add(goods);
            }

            Gson gson = new Gson();
            System.out.println("商品列表数据================================");
            System.out.println(gson.toJson(goodsList));
            System.out.println("第0个数据===================================");
            System.out.println(goodsList.get(0).toString());

            for (int i : bannerIndexArr) {
                Goods goods = goodsList.get(i);
                goods.bannerPic = "https://test.cdn.sbnh.cn/ntf/banner_" + (i + 1) + ".png";
                goods.bannerType = Goods.BANNER_TYPE_GOODS;
                bannerList.add(goods);
            }
            Goods goodsH5 = goodsList.get(0);
            goodsH5.bannerPic = "https://test.cdn.sbnh.cn/ntf/banner_h5.png";
            goodsH5.bannerType = Goods.BANNER_TYPE_H5;
            bannerList.add(goodsH5);
            System.out.println("banner数据=================================");
            System.out.println(gson.toJson(bannerList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
