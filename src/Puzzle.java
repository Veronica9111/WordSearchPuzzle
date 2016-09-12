import java.util.ArrayList;
import java.util.List;

public class Puzzle {

	private List<List<Node>> puzzle = new ArrayList<>();
	private Boolean isWrap = true;
	private List<String> directions = new ArrayList<>();
	
	public Puzzle(Boolean isWrap){
		this.isWrap = isWrap;
		this.setDirections();
	}
	
	public void setDirections(){
		this.directions.add("east");
		this.directions.add("southeast");
		this.directions.add("south");
		this.directions.add("southwest");
		this.directions.add("west");
		this.directions.add("northwest");
		this.directions.add("north");
		this.directions.add("northeast");
	}
	
	public List<List<Node>> getPuzzle(){
		return this.puzzle;
	}

	public void loadPuzzle(List<String>inputString){
		for(int i = 0; i < inputString.size(); i++){
			List<Node> column = new ArrayList<>();
			for(int j = 0; j < inputString.get(i).length(); j++){
				Node node = new Node();
				node.setValue(inputString.get(i).substring(j, j+1));
				node.setRow(i);
				node.setColumn(j);
				column.add(node);
				
			}
			this.puzzle.add(column);
		}
	}
	
	public List<Node> searchPuzzleByLetter(String letter){
		List<Node> nodeList = new ArrayList<>();
		for(int i = 0; i < this.puzzle.size(); i++){
			for(int j = 0; j < this.puzzle.get(i).size(); j++){
				if(this.puzzle.get(i).get(j).getValue().equals(letter)){
					nodeList.add(this.puzzle.get(i).get(j));
				}
			}
			
		}
		return nodeList;
		
	}
	
	public Node getNodeByLocation(Integer rowNumber, Integer columnNumber){
		return this.puzzle.get(columnNumber).get(rowNumber);
	}
	
	public String SearchWord(Node node, String word){
		String result = "";
		for(String direction: this.directions){
			Boolean isHit = true;
			Node nextLetter = null;
			for(int i = 0; i < word.length()-1; i++){
				
				nextLetter = this.findLetter(node, direction);
				if(nextLetter == null ||!nextLetter.getValue().equals(word.substring(i+1,i+2))){
					isHit = false;
				}
			}
			if(isHit == true){
				result = node.getRow()+","+node.getColumn() + " " + nextLetter.getRow()+","+nextLetter.getColumn();

				return result;
			}
		}

		return result;
	}
	
	public Node findLetter(Node node, String direction){
		//For no wrap
		if(direction.equals("east")){
			if(node.getColumn() == this.puzzle.get(0).size()-1){
				if(this.isWrap == true){
					return this.puzzle.get(node.getRow()).get(0);
				}
				return null;
			}
			return this.puzzle.get(node.getRow()).get(node.getColumn()+1);
		}else if(direction.equals("southeast")){
			if(node.getColumn() == this.puzzle.get(0).size()-1 || node.getRow() == this.puzzle.size()-1){
				if(this.isWrap == true){
					if(node.getColumn() == this.puzzle.get(0).size()-1 && node.getRow() != this.puzzle.size()-1){
						return this.puzzle.get(node.getRow()+1).get(0);
					}else if(node.getColumn() != this.puzzle.get(0).size()-1 && node.getRow() == this.puzzle.size()-1){
						return this.puzzle.get(0).get(node.getColumn()+1);
					}else{
						return this.puzzle.get(0).get(0);
					}
				}
				return null;
			}
			return this.puzzle.get(node.getRow()+1).get(node.getColumn()+1);
		}else if(direction.equals("south")){
			if(node.getRow() == this.puzzle.size()-1){
				if(this.isWrap == true){
					return this.puzzle.get(0).get(node.getColumn());
				}
				return null;
			}
			return this.puzzle.get(node.getRow()+1).get(node.getColumn());
		}else if(direction.equals("southwest")){
			if(node.getColumn() == 0 || node.getRow() == this.puzzle.size()-1){
				if(this.isWrap == true){
					if(node.getColumn() == 0 && node.getRow() != this.puzzle.size()-1){
						return this.puzzle.get(node.getRow()+1).get(this.puzzle.get(0).size()-1);
					}else if(node.getColumn() != 0 && node.getRow() == this.puzzle.size()-1){
						return this.puzzle.get(0).get(node.getColumn()-1);
					}else{
						return this.puzzle.get(0).get(this.puzzle.get(0).size()-1);
					}
				}
				return null;
			}
			return this.puzzle.get(node.getRow()+1).get(node.getColumn()-1);
		}else if(direction.equals("west")){
			if(node.getColumn() == 0){
				if(this.isWrap == true){
					return this.puzzle.get(node.getRow()).get(this.puzzle.get(0).size()-1);
				}
				return null;
			}
			this.puzzle.get(node.getRow()).get(node.getColumn()-1);
		}else if(direction.equals("northwest")){
			if(node.getColumn() == 0 || node.getRow() == 0){
				if(this.isWrap == true){
					if(node.getColumn() != 0 && node.getRow() == 0){
						return this.puzzle.get(this.puzzle.size()-1).get(node.getColumn()-1);
					}else if(node.getColumn() == 0 && node.getRow() != 0){
						return this.puzzle.get(node.getRow()-1).get(this.puzzle.get(0).size()-1);
					}else{
						return this.puzzle.get(this.puzzle.size()-1).get(this.puzzle.get(0).size()-1);
					}
				}
				return null;
			}
			return this.puzzle.get(node.getRow()-1).get(node.getColumn()-1);
		}else if(direction.equals("north")){
			if(node.getRow() == 0){
				if(this.isWrap == true){
					return this.puzzle.get(this.puzzle.size()-1).get(node.getColumn());
				}
				return null;
			}
			return this.puzzle.get(node.getRow()-1).get(node.getColumn());
		}else if(direction.equals("northeast")){
			if(node.getColumn() == this.puzzle.get(0).size()-1 || node.getRow() == 0){
				if(this.isWrap == true){
					if(node.getColumn() != this.puzzle.get(0).size()-1 && node.getRow() == 0){
						return this.puzzle.get(this.puzzle.size()-1).get(node.getColumn()+1);
					}else if(node.getColumn() == this.puzzle.get(0).size()-1 && node.getRow() != 0){
						return this.puzzle.get(node.getRow()-1).get(0);
					}else{
						return this.puzzle.get(this.puzzle.size()-1).get(0);
					}
				}
				return null;
			}
			return this.puzzle.get(node.getRow()-1).get(node.getColumn()+1);
		}
		return null;
		
	}
}
