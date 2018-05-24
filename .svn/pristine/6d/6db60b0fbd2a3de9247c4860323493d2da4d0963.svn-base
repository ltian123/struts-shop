package factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * 项目名称：p2p_sxj   
 * 类名称：ObjectFactory   
 * 类描述： <工厂模式，获取类>
 * 创建人：shixiaojun@itany.com  石小俊 
 * 创建时间：2014-11-6 上午11:26:12   
 * @version
 */
public class ObjectFactory {

	private static Map<String, Object> objPool = new HashMap<String, Object>();
	private static Logger logger = Logger.getLogger(ObjectFactory.class);

	static {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(ObjectFactory.class
					.getClassLoader().getResourceAsStream("bean.properties")));
			String entry=null;
            while((entry=br.readLine())!=null){
                String[] m=entry.split("=");
                logger.info(m[0]+":"+m[1]);
                objPool.put(m[0], Class.forName(m[1]).newInstance());
            }
		} catch (Exception e) {
			logger.error("ObjectFactory初始化失败",e);
			throw new ExceptionInInitializerError("ObjectFactory初始化失败");
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new ExceptionInInitializerError("ObjectFactory初始化失败");
				}
			}
		}
	}

	public static Object getObject(String key) {
		if(objPool.get(key)==null)
		{
			logger.error("根据"+key+"在ObjectFactory中没找到对应Value");
		}
		return objPool.get(key);
	}
}
