import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Edit extends FileUtility {
	public Edit(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	//追加処理
	public void Add() throws IOException{
		List<String> booklist = SaveList();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String booktitle = br.readLine();
		booklist.add(booktitle);
		System.out.println(booklist.get(booklist.size() - 1) + "を追加しました");
		super.Write(getFilename(), booklist.get(booklist.size() - 1));
	};
	//削除処理
	public void Delete() throws IOException{
		System.out.println("どれを削除しますか。行番号を指定してください");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		List<String> booklist = getList();
		System.out.println(booklist.get(num - 1) + "を削除しました");
		booklist.remove(num - 1);
		ListCopy(getFilename(),booklist);
	};
}
