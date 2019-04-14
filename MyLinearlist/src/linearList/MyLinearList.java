package linearList;

public interface MyLinearList {

    /***
     *
     * @param index 插入位序，index之后插入
     * @param item
     * @return
     */
    public boolean add(int index ,String item );

    public String delete(int index);

    public boolean change(int index , String new_value);

    public String findValueByIndex(int index);

    public int findIndexByValue(String value);

    public boolean isEmpty();

    public int getSize();
}
