import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UserInterface implements UserInterfaceInterface{
	
	private Integer puzzleRowNumber = 0;
	private Integer puzzleColumnNumber = 0;
	private List<String> puzzle;
	private List<String> wordList = new ArrayList<>();
	private Boolean isWrap = true;
	private Integer wordListNumber = 0;
	
	public void LoadInput() throws IOException{
		this.setPuzzleSize();
		this.setPuzzle();
		this.setWrapFlag();
		this.setWordListNumber();
		this.setWordList();
		
	}
	
	public String getSystemInput() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = "";
		s = br.readLine();
		return s;		
	}

	
	public Integer getPuzzleRowNumber() {
		return puzzleRowNumber;
	}


	public Integer getPuzzleColumnNumber() {
		return puzzleColumnNumber;
	}


	public List<String> getPuzzle() {
		return puzzle;
	}


	public List<String> getWordList() {
		return wordList;
	}


	public Boolean getIsWrap() {
		return isWrap;
	}
	
	public Integer getWordListNumber() {
		return wordListNumber;
	}


	@Override
	public void setPuzzleSize() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Input the puzzle size in format N M");
		String puzzleSize = this.getSystemInput();
		String[] tmp = puzzleSize.split(" ");
		this.puzzleColumnNumber = Integer.valueOf(tmp[0]);
		this.puzzleRowNumber = Integer.valueOf(tmp[1]);

	}

	@Override
	public void setPuzzle() throws IOException {
		System.out.println("Input the puzzle of N rows");
		this.puzzle = new ArrayList<>();
		for (int i = 0; i < this.puzzleColumnNumber; i++){
			String row = this.getSystemInput();
			this.puzzle.add(row);
			
		}

	}


	@Override
	public void setWrapFlag() throws IOException {
		System.out.println("Input the flag, WRAP or NO_WRAP");
		String flag = this.getSystemInput();
		if(flag.equals("WRAP")){
			this.isWrap = true;
		}else if(flag.equals("NO_WRAP")){
			this.isWrap = false;
		}else{
			this.setWrapFlag();
		}
	}


	@Override
	public void setWordListNumber() throws IOException {
		System.out.println("Input the number of your wordlist");
		String input = this.getSystemInput();
		Integer number = Integer.valueOf(input);
		this.wordListNumber = number;
		
	}
	
	
	@Override
	public void setWordList() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Input your word list");
		for(int i = 0; i < this.wordListNumber; i++){
			String word = this.getSystemInput();
			this.wordList.add(word);
		}
	}


}
