package DBTest;

import com.etc.shopsys.dao.GoodsDao;
import com.etc.shopsys.dao.GoodsEvaluateDao;
import com.etc.shopsys.dao.GoodsTypleDao;
import com.etc.shopsys.dao.impl.GoodsDaoImpl;
import com.etc.shopsys.dao.impl.GoodsEvaluateDaoImpl;
import com.etc.shopsys.dao.impl.GoodsTypleDaoImpl;
import com.etc.shopsys.domain.Goods;
import com.etc.shopsys.domain.GoodsEvaluate;
import com.etc.shopsys.domain.GoodsTyple;
import com.etc.shopsys.domain.Page;
import com.etc.shopsys.service.GoodsService;
import com.etc.shopsys.service.impl.GoodsServiceImpl;
import com.etc.shopsys.utils.CounterUtil;
import com.etc.shopsys.utils.DBUtil;
import jdk.internal.dynalink.linker.LinkerServices;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        GoodsDao goodsDao=new GoodsDaoImpl();
        //Goods goods=goodsDao.findGoodsByName("1");
        GoodsService gs=new GoodsServiceImpl();

        //gs.insertGoods(new Goods(DBUtil.getUUID(),"0009","裤子",100,100,1,1,"anomlka",""));
        goodsDao.insertGoods(new Goods(DBUtil.getUUID(),"0006","裤子",100,100,1,1,"anomlka",""));
        //System.out.println(goods);
       /* boolean i=goodsDao.insertGoods(new Goods(DBUtil.getUUID(),"0006","裤子",100,100,1,1,"anomlka",""));
        System.out.println(i);
        Goods goods=goodsDao.findGoodsById("0001");
        System.out.println(goods);
        boolean i=goodsDao.deleteGoodsById("0001");
        System.out.println(i);
        int a=goodsDao.findGoodsCount();
        System.out.println(a);
        Page<Goods> page=goodsDao.findGoodsIsDelete(1,1,3);
        List<Goods> list=page.getData();
        for (Goods goods : list) {
            System.out.println(goods);
        }
        Page<Goods> page=goodsDao.findGoodsById(2,3,3);
        List<Goods> list=page.getData();
        for (Goods goods : list) {
            System.out.println(goods);
        }
        Page<Goods> page=goodsDao.findGoodsLikeByDepict("ano",2,2);
        List<Goods> list=page.getData();
        for (Goods goods : list) {
            System.out.println(goods);
        }
        boolean i=goodsDao.updateGoodsById(new Goods("040656b5-ca27-49ae-9b68-8907df12a962","0001","裤子",9000,100.00000000,1,1,"anomlka",""));
        System.out.println(i);
        Page<Goods> page=goodsDao.findAllGoods(1,2);
        List<Goods> list=page.getData();
        for (Goods goods : list) {
            System.out.println(goods);
        }*/
        /*GoodsTypleDao goodsTypleDao=new GoodsTypleDaoImpl();
        boolean i=goodsTypleDao.insertGoodsType(new GoodsTyple(5,"yunaun"));
        System.out.println(i);
        boolean i=goodsTypleDao.deleteGoodsTypeById(1);
        System.out.println(i);
       boolean i=goodsTypleDao.updateGoodsTypeById(2,"aaiojls");
        System.out.println(i);
        GoodsTyple goodsTyple=goodsTypleDao.findGoodsTypeBygtname("aaiojls");
        System.out.println(goodsTyple);
       GoodsTyple goodsTyple=goodsTypleDao.findGoodsTypeById(4);
        System.out.println(goodsTyple);
       int i=goodsTypleDao.findGoodsCount();
        System.out.println(i);
       List<GoodsTyple> list=goodsTypleDao.findAllGoodsType();
        for (GoodsTyple goodsTyple : list) {
            System.out.println(goodsTyple);
        }*/
        /*GoodsEvaluateDao  goodsEvaluateDao=new GoodsEvaluateDaoImpl();
        boolean i=goodsEvaluateDao.insertGoodsEvaluate(new GoodsEvaluate("1","2","1"));
        System.out.println(i);
        boolean i=goodsEvaluateDao.updateGoodsEvaluateById("1","2","4");
        System.out.println(i);
        GoodsEvaluate g=goodsEvaluateDao.findGoodsEvaluateById("1","2");
        System.out.println(g);
        Page<GoodsEvaluate> page=goodsEvaluateDao.findAllGoodsEvaluate(1,2);
        List<GoodsEvaluate> list=page.getData();
        for (GoodsEvaluate goodsEvaluate : list) {
            System.out.println(goodsEvaluate);
        }*/
    }
}
