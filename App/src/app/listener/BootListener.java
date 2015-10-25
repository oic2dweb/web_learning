package app.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.persistence.QuestionDao;
import app.persistence.QuestionDaoImpl;
import app.persistence.QuestionSubClassDao;
import app.persistence.QuestionSubClassDaoImpl;

/**
 * Application Lifecycle Listener implementation class BootListener
 *
 */
@WebListener
public class BootListener implements ServletContextListener {

    /**
     * Default constructor.
     */
    public BootListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  {
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  {
    	QuestionSubClassDao qsDao = new QuestionSubClassDaoImpl();
    	//分類数を取得
        int total = qsDao.getTotal();
        StringBuffer sql = new StringBuffer();
        int i=1;
        sql.append("select ");
        sql.append("count(if(subclass_id="+i+",1,null)) as '"+i+"'");
        for(i+=1;i<=total;i++){
        	sql.append(",count(if(subclass_id="+i+",1,null)) as '"+i+"'");
        }
        sql.append(" from question_fe");
        QuestionDao queDao = new QuestionDaoImpl();
        //分類ごとの総問題数を取得
        ArrayList<Integer> count = queDao.getClassCount(sql.toString());
        ServletContext app = arg0.getServletContext();
        app.setAttribute("count", count);
    }

}
