package sortWithCollator;

import org.junit.Test;

import static org.junit.Assert.*;

public class MSDRadixSortTest {

    @Test
    public void test(){
        String[] test = new String[]{"张三", "李四", "王五", "赵六"};
        MSDRadixSort.sort(test);

        assert(test[0].equals("李四"));
        assert(test[1].equals("王五"));
        assert(test[2].equals("张三"));
        assert(test[3].equals("赵六"));
    }

}