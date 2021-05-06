private String removeDoubledLetters{String str) {
	
	String newStr = "";
	for (i = 0; i < str.length(); i++) {
		char ch = str.chatAt(i);
		if (i == 0 || ch != str.chatAt(i - 1)) {
			result += ch;
		}
	}
}