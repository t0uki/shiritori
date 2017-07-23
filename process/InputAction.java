package process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputAction {
	private String in;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	// 入力
	String action() {
		in = "";
		System.out.print("YOU > ");

		try {
			in = br.readLine();
		} catch (IOException e) {
			System.out.println("入力エラー");
			e.printStackTrace();
			in = action();
		}
		// 入力なしは再帰呼び出し
		if ("".equals(in)) {
			in = action();
		}
		return in;
	}

}
