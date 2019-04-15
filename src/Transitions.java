
public class Transitions {
	
	private final String fromState;
    private final String readValue;
    private final String toState;
    private final String writeValue;
    private final String move;

    public Transitions(String fromState, String readValue, String toState, String writeValue, String move) {
        this.fromState = fromState;
        this.readValue = readValue;
        this.toState = toState;
        this.writeValue = writeValue;
        this.move = move;
    }

    String getTo() {
        return toState;
    }

    String getReadValue() {
        return readValue;
    }

    String getFromState() {
        return fromState;
    }
    
    String getWriteValue(){
    	return writeValue;
    }
    
    String getMove(){
    	return move;
    }
}
