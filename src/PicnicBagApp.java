
public class PicnicBagApp {

	public static void main(String[] args) {
		// Conduct Testing Here.
		Item orange = new Item("Orange", "Plastic");
		Item notOrange = new Item("Not Orange", "Plastic");
		System.out.println(orange);
		System.out.println(orange.equals(notOrange));
		System.out.println(orange == notOrange);
		System.out.println(orange.getDisposibleType());
	}

}
