import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Mode extends Edit{
	public Mode(String name) {
		super(name);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	//モードを選択する
	public void ModeSelext() throws IOException{
		System.out.println("モードを選択してください");
		System.out.println("eキー:書籍一覧を編集します");
		System.out.println("sキー:書籍一覧を表示します");
		System.out.println("qキー:アプリケーションを終了します");
		System.out.println("コマンド？");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String input = br2.readLine();
		if(input.equals("e")){
			System.out.println("eキーが押されました。編集モードになります");
		    EditMode();
		}else if(input.equals("s")){
			System.out.println("sキーが押されました。書籍一覧を表示します");
			ShowMode();
		 }else if(input.equals("q")){
			System.out.println("qキーが押されました。アプリケーションを終了します");
			AppQuit();
		 }else if(!input.equals("e") || !input.equals("s") || !input.equals("q")){
			System.out.println("正しいキーが押されませんでした。もう一度正しいキーを押してください");
		 }
	}
	
	//編集モード
	public void EditMode() throws IOException{
		Edit edit = new Edit("BookList");
		List<String> editlist = edit.SaveList();
		for(int i = 0 ; i < editlist.size() ; i++){
			System.out.println(i + 1 + "." + editlist.get(i));
		}
		//追加処理か削除処理か
		System.out.println("今の書籍一覧から追加しますか。それとも削除しますか");
		System.out.println("a:追加する");
		System.out.println("d:削除する");
		System.out.println("q:編集モードを終える");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String e_input = br2.readLine();
		if(e_input.equals("a")){
			//aが入力された場合は追加処理
			edit.Add();
		}else if(e_input.equals("d")){
			//dが入力された場合は削除処理
			edit.Delete();
		}else if(e_input.equals("q")){
			System.out.println("qキーが押されました。アプリケーションを終了します");
			AppQuit();
		}
	}
	
	//表示モード
	public void ShowMode() throws IOException{
		FileReader fr = new FileReader("BookList");
		BufferedReader br = new BufferedReader(fr);
	    String str = br.readLine();
		while(str != null){
			System.out.println(str);
			str = br.readLine();
		}
		br.close();
		System.out.println("書籍一覧を表示しました");
		System.out.println("");
	}
	
	//アプリ終了
	public void AppQuit(){
		System.exit(1);
	}
}
