package cf.reol.stingy;

import org.junit.Test;

import cf.reol.stingy.data.DetailData;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test01() throws Exception {
        DetailData detailData = new DetailData();
        assertNull("asdfg", detailData);
    }
}