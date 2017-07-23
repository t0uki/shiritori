package main;

public class Help {

	public Help() {
		message();
	}

	// 仕様出力
	private void message() {
		System.out.println("\n" + "----------- Help -----------");
		System.out.println("| 入力可能文字はひらがなのみ。");
		System.out.println("| user/cpuともにpass3回で終了。");
		System.out.println("| exitで途中終了,末尾\'ん\'はあなたの負けです。");
		System.out.println("| 同一単語は一度のみです。");
		System.out.println("| cpuの用意された単語を使い切るもしくは");
		System.out.println("| cpuPass回数が3回ならあなたの勝ちです。");
		System.out.println("----------------------------" + "\n");
	}
}
