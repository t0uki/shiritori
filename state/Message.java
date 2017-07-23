package state;

public class Message {

	// 1,win 2,lose 3bye
	public void returnMessage(int num) {
		switch (num) {
		case 1:
			win();
			break;
		case 2:
			lose();
			break;
		case 3:
			bye();
			break;
		}
	}

	private void win() {
		System.out.println("\n" + "----------- \"WIN\" -----------" + "\n");
	}

	private void lose() {
		System.out.println("\n" + "----------- \"LOSE\" -----------" + "\n");
	}

	private void bye() {
		System.out.println("\n" + "----------- \"BYE\" -----------" + "\n");
	}

	// 終了判定
	public boolean end_if(String word) {
		// 末尾’ん’もしくは"exit"
		if ('ん' == (word.charAt(word.length() - 1))) {
			returnMessage(2);
			return true;
		}
		if ("exit".equals(word)) {
			returnMessage(3);
			return true;
		}
		return false;
	}
}
