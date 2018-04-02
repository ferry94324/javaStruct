package liubo.list.list1;

public class Test {
	 public static void main(String[] args) {

	        SequenceList list = new SequenceList(20);

	        try {
	            list.insert(0, 100);
	            list.insert(0, 50);
	            list.insert(1, 20);

	            for (int i = 0; i < list.size; i++) {
	                System.out.println("第" + i + "个数为" + list.get(i));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
