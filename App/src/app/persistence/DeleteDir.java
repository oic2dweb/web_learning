package app.persistence;

import java.io.File;


public class DeleteDir {
	//フォルダとその中身を削除するメソッド
	public void delete(File f){
		if(f.exists()==false){
			return;
		}
		if(f.isFile()){
			f.delete();
		}
		if(f.isDirectory()){
			File[] files = f.listFiles();
			for(int i=0;i<files.length;i++){
				delete(files[i]);

			}
			f.delete();
		}
	}
}
