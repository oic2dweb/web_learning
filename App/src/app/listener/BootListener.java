package app.listener;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.service.QuestionService;
import app.service.QuestionSubClassService;

/**
 * Application Lifecycle Listener implementation class BootListener
 *
 */
@WebListener
public class BootListener implements ServletContextListener {
	private QuestionService questionService = new QuestionService();
	private QuestionSubClassService questionSubClassService = new QuestionSubClassService();
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
    	//分類数を取得
        int total = questionSubClassService.getTotal();
        StringBuffer sql = new StringBuffer();
        int i=1;
        sql.append("select ");
        sql.append("count(if(subclass_id="+i+",1,null)) as '"+i+"'");
        for(i+=1;i<=total;i++){
        	sql.append(",count(if(subclass_id="+i+",1,null)) as '"+i+"'");
        }
        sql.append(" from question_fe");
        //QuestionDao queDao = new QuestionDaoImpl();
        //分類ごとの総問題数を取得
        ArrayList<Integer> count = questionService.getClassCount(sql.toString());
        ServletContext app = arg0.getServletContext();
        app.setAttribute("count", count);
    }

}
