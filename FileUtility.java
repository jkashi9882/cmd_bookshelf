import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

//ファイル操作を行う共通的なクラス
public class FileUtility {
	//FileUtilityのコンストラクタ
	public FileUtility(String name){
		this.filename = name;
	}
	
	//ファイル内容の保存や、書き込みの際の一時作業リスト
	private List<String> list = new ArrayList<String>();
	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	//操作するファイル名称
	private String filename;
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	//読んだファイルをListに保存する処理
	public List<String> SaveList() throws IOException{
		FileReader fileread = new FileReader(filename);
		BufferedReader br = new BufferedReader(fileread);
	    String str = br.readLine();
		while(str != null){
			list.add(str);
			str = br.readLine();
		}
		br.close();
		return list;
	}
	//ファイル書き込み処理
	public void Write(String filename,String WriteStr) throws IOException{
		File file = new File(filename);
		FileWriter fw = new FileWriter(file,true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(WriteStr);
		bw.newLine();
		bw.close();
	}
    //リスト全内容コピー処理
	public void ListCopy(String filename,List<String> list) throws IOException{
		File file = new File(filename);
		FileWriter fw = new FileWriter(file,false);
		BufferedWriter bw = new BufferedWriter(fw);
		for(String s : list){
			bw.write(s);
			bw.newLine();
		}
		bw.close();
	}
}
