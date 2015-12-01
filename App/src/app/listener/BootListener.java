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
        sql.append(" from questiones q join year y on q.year_id = y.year_id where y.flg = 1");
        
        //分類ごとの総問題数を取得
        ArrayList<Integer> count1 = questionService.getClassCount(sql.toString()+" and y.type_id = 1");
        ArrayList<Integer> count2 = questionService.getClassCount(sql.toString()+" and y.type_id = 2");
        ArrayList<Integer> count3 = questionService.getClassCount(sql.toString()+" and y.type_id = 3");
        ServletContext app = arg0.getServletContext();
        app.setAttribute("count1", count1);
        app.setAttribute("count2", count2);
        app.setAttribute("count3", count3);

        //年度選択プルダウンメニューの要素を取得
        YearService yearService = new YearService();
        Map<Integer,String> year2 = yearService.getYear(1,2);
        app.setAttribute("year2",year2 );
        
        Map<Integer,String> year1 = yearService.getYear(1,1);
        app.setAttribute("year1",year1 );
        
        Map<Integer,String> year3 = yearService.getYear(1,3);
        app.setAttribute("year3",year3 );

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
