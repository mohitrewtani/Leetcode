package com.mohit.coding;
class TextEditor {
    StringBuilder sb;
    int cursor;
    public TextEditor() {
        sb = new StringBuilder();
        cursor = 0;
    }
    
    public void addText(String text) {
        sb.insert(cursor,text);
        cursor = cursor + text.length();
    }
    
    public int deleteText(int k) {
    	int oldCursor = cursor;
        sb.delete(Math.max(0, cursor-k),cursor);
        cursor = Math.max(0, cursor-k);
        return oldCursor - cursor;
    }
    
    public String cursorLeft(int k) {
        cursor = Math.max(0, cursor-k);
        String s = sb.substring(Math.max(cursor-10, 0),cursor);
        return s;
    }
    
    public String cursorRight(int k) {
        cursor = Math.min(cursor+k, sb.length());
        String s = sb.substring(Math.max(0, cursor-10),cursor);
        return s;
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */
public class DesignATextEditor_2296 {

	public static void main(String[] args) {
		TextEditor textEditor = new TextEditor(); // The current text is "|". (The '|' character represents the cursor)
		textEditor.addText("leetcode"); // The current text is "leetcode|".
		textEditor.deleteText(4); // return 4
		                          // The current text is "leet|". 
		                          // 4 characters were deleted.
		textEditor.addText("practice"); // The current text is "leetpractice|". 
		textEditor.cursorRight(3); // return "etpractice"
		                           // The current text is "leetpractice|". 
		                           // The cursor cannot be moved beyond the actual text and thus did not move.
		                           // "etpractice" is the last 10 characters to the left of the cursor.
		textEditor.cursorLeft(8); // return "leet"
		                          // The current text is "leet|practice".
		                          // "leet" is the last min(10, 4) = 4 characters to the left of the cursor.
		textEditor.deleteText(10); // return 4
		                           // The current text is "|practice".
		                           // Only 4 characters were deleted.
		textEditor.cursorLeft(2); // return ""
		                          // The current text is "|practice".
		                          // The cursor cannot be moved beyond the actual text and thus did not move. 
		                          // "" is the last min(10, 0) = 0 characters to the left of the cursor.
		textEditor.cursorRight(6);
	}
}
