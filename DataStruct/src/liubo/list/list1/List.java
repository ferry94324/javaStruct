package liubo.list.list1;

public interface List {
	public int size();
    //判断线性表是否为空
    public boolean isEmpty();
    //插入元素
    public void insert(int index, Object obj) throws Exception;
    //删除元素
    public void delete(int index) throws Exception;
    //获取指定位置的元素
    public Object get(int index) throws Exception;
}
