public void allDuplicates(String str){
	int[] freq = new int[26];
	for(char ch : str.toCharArray()){
		freq[ch - 'a']++;
	}

	for(int i=0;i<26;i++){
		if(freq[i] >0)
			System.out.println((i+'a') + "-" + freq[i]);
	}
}