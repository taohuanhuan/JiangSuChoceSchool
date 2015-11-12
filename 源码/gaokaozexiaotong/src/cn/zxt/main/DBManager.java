package cn.zxt.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.util.Log;
import cn.exmp1.jisuzexiaotong.R;


 
public class DBManager {
     
    private final int BUFFER_SIZE = 400000;
    public static final String DB_NAME = "zexiaotong.db"; //��������ݿ��ļ���
    public static final String PACKAGE_NAME = "cn.exmp1.jisuzexiaotong";
    public static final String DB_PATH = "/data"
            + Environment.getDataDirectory().getAbsolutePath() + "/"
            + PACKAGE_NAME;  //���ֻ��������ݿ��λ��(/data/data/com.zexiaotong.activity/zexiaotong.db)
     
     
    private SQLiteDatabase database;
    private Context context;
 
    public DBManager(Context context) {
        this.context = context;
    }
 
    public SQLiteDatabase getDatabase() {
        return database;
    }
 
    public void setDatabase(SQLiteDatabase database) {
        this.database = database;
    }
 
    public void openDatabase() {
        System.out.println(DB_PATH + "/" + DB_NAME);
        this.database = this.openDatabase(DB_PATH + "/" + DB_NAME);
    }
 
    private SQLiteDatabase openDatabase(String dbfile) {
 
        try {
            if (!(new File(dbfile).exists())) {
                //�ж����ݿ��ļ��Ƿ���ڣ�����������ִ�е��룬����ֱ�Ӵ����ݿ�
                InputStream is = this.context.getResources().openRawResource(
                        R.raw.zexiaotong); //����������ݿ�
                FileOutputStream fos = new FileOutputStream(dbfile);
                byte[] buffer = new byte[BUFFER_SIZE];
                int count = 0;
                while ((count = is.read(buffer)) > 0) {
                    fos.write(buffer, 0, count);
                }
                fos.close();
                is.close();
            }
 
            SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile,null);
            return db;
 
        } catch (FileNotFoundException e) {
            Log.e("Database", "File not found");
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("Database", "IO exception");
            e.printStackTrace();
        }
        return null;
    }

	public SQLiteDatabase getReadableDatabase() {
		return this.database;
	}

	public void close() {
		
	}
}
