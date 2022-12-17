package matala_0;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UndoableStringBuilderTest {


    @Test
    void appendCheck() {
        UndoableStringBuilder t = new UndoableStringBuilder();
        assertEquals("null", t.append(null).toString());
    }

    @Test
    void appendCheck2() {
        UndoableStringBuilder t = new UndoableStringBuilder();
        assertEquals("123456789", t.append("123456789").toString());
    }

    @Test
    void appendCheck3() {
        UndoableStringBuilder t = new UndoableStringBuilder();
        assertEquals("", t.append("").toString());
    }

    @Test
    void appendCheck4() {
        UndoableStringBuilder t = new UndoableStringBuilder();
        assertEquals("    ", t.append("    ").toString());
    }

    @Test
    void deleteCheck() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("1234567");
        assertEquals("", s.delete(0, 7).toString());
    }

    @Test
    void deleteCheck2() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("1234567");
        assertEquals("1267", s.delete(2, 5).toString());
    }

    @Test
    void deleteCheck3() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("012", s.delete(3, 1000000000).toString());
    }

    @Test
    void deleteCheck4() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        assertEquals("", s.delete(0, 0).toString());
    }

    @Test
    void deleteCheckNegativIndex() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        assertThrows(StringIndexOutOfBoundsException.class, () -> s.delete(-1, 10));
    }


    @Test
    void deleteCheckNegativIndex2() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        assertThrows(StringIndexOutOfBoundsException.class, () -> s.delete(-1, -1));
    }

    @Test
    void deleteCheckStartbiggerThenLength() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("testtest"); // s.stringbuilder.length = 8

        assertThrows(StringIndexOutOfBoundsException.class, () -> s.delete(9, 20));
    }

    @Test
    void deleteCheckStartbiggerThenLength2() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("1");

        assertThrows(StringIndexOutOfBoundsException.class, () -> s.delete(2, 20));
    }

    @Test
    void deleteCheckStartbiggerThenEnd() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world");

        assertThrows(StringIndexOutOfBoundsException.class, () -> s.delete(7, 6));
    }

    @Test
    void insertCheck() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world"); // s.stringbuilder.length = 8

        assertEquals("hello_wtestorld", s.insert(7, "test").toString());
    }

    @Test
    void insertCheck2() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world"); // s.stringbuilder.length = 11

        assertEquals("hello_worldtest", s.insert(11, "test").toString());
    }

    @Test
    void insertCheck3() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world"); // s.stringbuilder.length = 11

        assertEquals("hello_world", s.insert(11, "").toString());
    }

    @Test
    void insertCheck4() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world"); // s.stringbuilder.length = 11

        assertEquals("nullhello_world", s.insert(0, null).toString());
    }

    @Test
    void insertCheckOffsetGreaterThanLength() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world"); // s.stringbuilder.length = 11

        assertThrows(StringIndexOutOfBoundsException.class, () -> s.insert(12, "test"));
    }

    @Test
    void insertCheckNegativeOffset() {
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world"); // s.stringbuilder.length = 11
        assertThrows(StringIndexOutOfBoundsException.class, () -> s.insert(-2, "test"));
    }

    @Test
    void replaceCheck (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("01TEST4567" , s.replace(2 , 4 , "TEST").toString());
    }

    @Test
    void replaceCheck2 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("TEST" , s.replace(0 , 10000 , "TEST").toString());
    }

    @Test
    void replaceCheck3 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("TEST" , s.replace(0 , 10000 , "TEST").toString());
    }

    @Test
    void replaceCheck4 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("TEST7" , s.replace(0 , 7 , "TEST").toString());
    }

    @Test
    void replaceCheck5 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("01TEST" , s.replace(2 , 70000 , "TEST").toString());
    }

    @Test
    void replaceCheck6 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("01234567TEST" , s.replace(8 , 70000 , "TEST").toString());
    }

    @Test
    void replaceCheckNegativeIndex (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertThrows(StringIndexOutOfBoundsException.class ,() -> s.replace(-1 , 7 , "TT").toString());
    }

    @Test
    void replaceCheckNegativeIndex2 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertThrows(StringIndexOutOfBoundsException.class ,() -> s.replace(-4 , -1 , "TT").toString());
    }

    @Test
    void replaceCheckStartBiggerThanEnd (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertThrows(StringIndexOutOfBoundsException.class ,() -> s.replace(5 , 3 , "TT").toString());
    }

    @Test
    void replaceCheckStartBiggerThanLength (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertThrows(StringIndexOutOfBoundsException.class ,() -> s.replace(9 , 100 , "TT").toString());
    }

    @Test
    void replaceCheckNull(){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertThrows(NullPointerException.class ,() -> s.replace(2 , 5 , null).toString());
    }

    @Test
    void reverseCheck (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("01234567");
        assertEquals("76543210" , s.reverse().toString());
    }

    @Test
    void reverseCheck2 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append(null);
        assertEquals("llun" , s.reverse().toString());
    }

    @Test
    void reverseCheck3 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("");
        assertEquals("" , s.reverse().toString());
    }

    @Test
    void undoCheck (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_");
        s.append("world_");
        s.append("TEST");
        assertEquals("hello_world_TEST" , s.toString());
        s.undo();
        assertEquals("hello_world_" , s.toString());
        s.undo();
        assertEquals("hello_" , s.toString());
        s.undo();
        assertEquals("" , s.toString());
        s.undo();
        assertEquals("" , s.toString());
        s.undo();
        s.undo();
        assertEquals("" , s.toString());
    }

    @Test
    void undoCheck2 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.undo();
        s.undo();
        s.undo();
        assertEquals("" , s.toString());
    }

    @Test
    void undoCheck3 (){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("hello_world");
        s.delete(2 , 4); // heo_world
        s.reverse(); // dlrow_oeh
        s.append("OMER"); // dlrow_oehOMER
        s.replace(5,6,"&&");//dlrow&&oehOMER
        s.insert(1 , " ");//d lrow&&oehOMER
        assertEquals("d lrow&&oehOMER" , s.toString());
        s.undo();
        assertEquals("dlrow&&oehOMER" , s.toString());
        s.undo();
        assertEquals("dlrow_oehOMER" , s.toString());
        s.undo();
        assertEquals("dlrow_oeh" , s.toString());
        s.undo();
        assertEquals("heo_world" , s.toString());
        s.undo();
        assertEquals("hello_world" , s.toString());
        s.undo();
        assertEquals("" , s.toString());
        s.undo();
        assertEquals("" , s.toString());
    }

    @Test
    void undoCheck4(){
        UndoableStringBuilder s = new UndoableStringBuilder();
        s.append("lvl1");
        s.append("lvl2");
        s.undo();
        assertEquals("lvl1" , s.toString());
        s.delete(2,3);//lvl2
        assertEquals("lv1" , s.toString());
        s.undo();//lvl1
        assertEquals("lvl1" , s.toString());
        s.undo();//lvl0 = ""
        assertEquals("" , s.toString());
        s.undo(); // steel lvl0 = ""
        assertEquals("" , s.toString());
        s.append("level1"); // level1
        assertEquals("level1" , s.toString());
        s.undo();//lvl0 = ""
        assertEquals("" , s.toString());
    }
}