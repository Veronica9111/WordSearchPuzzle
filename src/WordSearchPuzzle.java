import java.io.IOException;
import java.util.List;

public class WordSearchPuzzle {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		UserInterface ui = new UserInterface();
		ui.LoadInput();
		Puzzle puzzle = new Puzzle(ui.getIsWrap());
		puzzle.loadPuzzle(ui.getPuzzle());
		List<String> wordList = ui.getWordList();
		for(int i = 0; i < wordList.size(); i++){
			List<Node> heads = puzzle.searchPuzzleByLetter(wordList.get(i).substring(0, 1));
			if (heads.size() > 0){
				Boolean isHit = false;
				for(Node head: heads ){
					String result = puzzle.SearchWord(head, wordList.get(i));
					if(!result.equals("")){
						System.out.println(result);
						isHit = true;
						break;
					}
				}
				if(isHit == false){
					System.out.println("NOT FOUND");
				}
			}
		}

	}

}
