import java.io.IOException;
import java.util.List;

public interface UserInterfaceInterface {
	public void setPuzzleSize() throws IOException;
	
	public void setPuzzle() throws IOException;
	
	public void setWrapFlag() throws IOException;
	
	public void setWordListNumber() throws IOException;
	
	public void setWordList() throws IOException;
}
