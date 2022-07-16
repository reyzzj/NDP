package sg.edu.rp.c346.id21028514.demodatabasecrud;

import java.io.Serializable;

public class Note implements Serializable {

    private 	int id;
    private 	String noteContent;
    private     String noteContent2;
    private     String noteContent3;

    public Note(int id, String noteContent, String noteContent2, String noteContent3) {
        this.id = id;
        this.noteContent = noteContent;
        this.noteContent2 = noteContent2;
        this.noteContent3 = noteContent3;
    }

    public int getId() {  return id;  }

    public String getNoteContent() { return noteContent; }
    public String getNoteContent2() { return noteContent2; }
    public String getNoteContent3() { return noteContent3; }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
    public void setNoteContent2(String noteContent2) {
        this.noteContent2 = noteContent2;
    }
    public void setNoteContent3(String noteContent3) {
        this.noteContent3 = noteContent3;
    }

    @Override
    public String toString() { return
            "Song name: " + noteContent
            +"\n"
            +"Song Title: "  + noteContent2
            +"\n"
            +"Song Year: "  + noteContent3;
            +"\n"
            +"Song Star: "  + noteContent4;}

}

