import java.util.Stack;

public class History

{
	public class Event
	{
	public int pos;
	public boolean deletion;
	public String change;
	
	public Event(boolean deletion, int position, String change) 
	{
		this.pos = position;
		this.deletion = deletion;
		this.change = change;
		
	}
	
		
	}
	
	private Stack<Event> redostack;
	private Stack<Event> undostack;
	
public History() {
	this.redostack = new Stack<Event>();
	this.undostack = new Stack<Event>();
	
}
		
	
	
	public Stack<String> history = new Stack<>();
	
	
	


    /**
       Notepad will call this function when thier text changes.

       deletion is a boolean that indicates if the action was a deletion of text or the insertion of text.
       position is the postion where the change took place
       Change is the string of characters that is the change.
     */
   public void addEvent(boolean deletion, int position, String Change)
   {
	   Event event = new Event(deletion, position, Change);
	   this.undostack.push(event);
	   redostack.clear();
   }


    /**
       Notepad will call this function when it wishes to undo the last event.

       note is a variable to the Notepad that called this function
     */
   public void undoEvent(NotePad note)
   {
	   Event lastin = undostack.pop();
	   redostack.push(lastin);
	  
	   if (lastin.deletion == true)
	   {
		   note.insert(lastin.pos, lastin.change);
	   }
	   else
	   {
		   note.remove(lastin.pos, lastin.change.length());
	   }
		   
   }


    /**
       Notepad will call this function when it wishes to redo the last event that was undone.
       Note that new actions should clear out events that can be "redone"
       note is a variable to the Notepad that called this function
     */
   public void redoEvent(NotePad note)
   {
   	
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasUndoData()
   {
       return false;
   }

    /**
       returns true if there is undo data in the History
     */
   public boolean hasReDoData()
   {
       return false;
   }
	

}
