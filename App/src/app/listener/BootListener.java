package app.listener;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import app.model.MainClass;
import app.model.SubClass;
import app.service.QuestionCatService;
import app.service.QuestionMainClassService;
import app.service.QuestionService;
import app.service.QuestionSubClassService;
import app.service.YearService;


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
        //分類ごとの総問題数を取得
        ArrayList<Integer> count = questionService.getClassCount(sql.toString());
        ServletContext app = arg0.getServletContext();
        app.setAttribute("count", count);

        //年度選択プルダウンメニューの要素を取得
        YearService yearService = new YearService();
        Map<Integer,String> year = yearService.getYear(1);
        app.setAttribute("year",year );

        //question_catテーブルのcat_name一覧を取得
        QuestionCatService questionCatService = new QuestionCatService();
        Map<Integer,String> catNames = questionCatService.getCatName();
        app.setAttribute("catNames", catNames);

        //question_mainclassテーブルの一覧を取得
        QuestionMainClassService questionMainClassService = new QuestionMainClassService();
        ArrayList<MainClass> mainClass = questionMainClassService.getMainClass();
        app.setAttribute("mainClass", mainClass);

        //question_subclassテーブルの一覧を取得
        ArrayList<SubClass> subClass = questionSubClassService.getSubClass();
        app.setAttribute("subClass", subClass);
        
        //wlsのフォルダがない場合のみ作成
        File newfile = new File("c:\\wls");
		if(newfile.mkdir()){
			System.out.println("ディレクトリの作成に成功しました");
		}
    }

}
