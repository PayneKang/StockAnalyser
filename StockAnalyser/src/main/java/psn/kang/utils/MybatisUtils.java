package psn.kang.utils;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import psn.kang.stock.spiders.TempMain;

import java.io.InputStream;

public class MybatisUtils {
    public static SqlSessionFactory getFactory(){
    String resource="sqlMapConfig.xml";

    String rootPath = MybatisUtils.class.getClassLoader().getResource("").getPath();
    //加载mybatis 的配置文件（它也加载关联的映射文件）
    InputStream is=MybatisUtils.class.getClassLoader().getResourceAsStream(resource);
    //构建sqlSession 的工厂
    SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
    return factory;
}
}
