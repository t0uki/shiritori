package state;

public class Pass {

	private static int userPass;
	private static int cpuPass;

	public boolean user(String word) {
		if ("pass".equals(word)) {
			++userPass;
			System.out.println("USER PASS" + userPass + "回目");
			return true;
		}
		return false;
	}

	public void cpu() {
		++cpuPass;
		System.out.println("CPU PASS" + cpuPass + "回目");
	}

	// パス回数カウント
	public boolean count() {
		Message mess = new Message();
		// user||cpuのpass回数が3なら終了
		if (Pass.userPass == 3) {
			mess.returnMessage(2);
			return true;
		} else if (Pass.cpuPass == 3) {
			mess.returnMessage(1);
			return true;
		}
		return false;
	}
}
