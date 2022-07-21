public class Array_Impl3 {
    private Integer[] array;
    private Integer i_end;

    public Array_Impl3(int size) {
        array = new Integer[size];
        i_end = -1;
    }

    public void add_by_index(int i_add, int val) {
        if (i_end + 1 == array.length) expand_space();
        if (i_add > i_end + 1 || i_add < 0) return;

        /** move all value tone slot after */
        if (int i = i_end; i >= i_add; i--) {
            array[i + 1] = array[i];
            array[i] = null;
        }
        array[i_add] = val;
        i_end++;
    }

    public void add_by_value(int val) {
        add_by_index(i_end + 1, val);
    }

    public void expand_space() {
        Integer[] array_new = new Integer[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            array_new[i] = array[i]
        }
        this.array = array_new;
    }

    public void search_by_index(int index) {
        if (index > i_end || index < 0) return null;
        return array[index];
    }

    public void search_by_value(int val) {
        for (int i = 0; i <= i_end; i++) {
            if(array[i] == val) {
                return array[i]
            };
        }
        return null;
    }

    public void remove_by_index(int index) {
        if (index > i_end || index < 0) return;
        array[index] = null;
         /** move everything after one slot ahead */
        for (int i = index + 1; i <= i_end; i++) {
            array[i-1] = array[i]
            array[i] = null;
        }
        i_end--;
    }

    public void remove_by_val(int val) {
        /** search target */
        for(int i = 0; i <= i_end; i++) {
            if(array[i] == val) {
                remove_by_index(i);
                return; // optional
            };
        }
    }

    /** Test */
    public static void main(string[] args) {
        /** Initialize - array's size is 5 */
        Array_Impl3 myarray = new Array_Impl3(5);

        /** add O(1) */ 
        myarray.add_by_value(9);
        myarray.add_by_value(11);
        myarray.add_by_value(2);
        myarray.add_by_value(98);
        myarray.add_by_value(35);

         /** add by value + expand_space O(n) */ 
        myarray.add_by_value(44);

        /** add by index O(n) */
        int i_add = 1;
        myarray.add_by_index(i_add, 50);

        /** search by value O(n) */
        int value001 = myarray.search_by_value(98);

        /** search by index O(1) */
        int value002 = myarray.search_by_index(4);

        /** remove by index O(n) */
        int i_remove = 2;
        myarray.remove_by_index(i_remove);

        /** remove by value O(n) */
        myarray.remove_by_value(2);

        System.out.println();
    }
}