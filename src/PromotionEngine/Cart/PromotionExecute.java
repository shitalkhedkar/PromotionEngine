package PromotionEngine.Cart;

import java.util.List;

public class PromotionExecute {

	float cdPrice;
	int totalPrice;

	public void Execute(Cart cart) {
		List<CartItem> items = cart.getItems();

		String strItem = "";
		// int itemPrice = 0;
		for (int i = 0; i < items.size(); i++) {
			SKUitem item = items.get(i).getItem();
			int itemQuantity = items.get(i).getItemQuantity();

			if ((item.getID()).equals("A") || (item.getID()).equals("B"))
				totalPrice += calculatePromotionAB(item, itemQuantity);
			else {
				if (strItem != null && !(strItem.equals("")) && !((item.getID()).equals(strItem))) {
					totalPrice -= cdPrice;
					totalPrice += calculatePromotionCD(item, itemQuantity, true);
				} else {
					strItem = item.getID();
					cdPrice = item.getUnitPrice();
					totalPrice += calculatePromotionCD(item, itemQuantity, false);
				}
			}
		}
		cart.setTotalPrice(totalPrice);

	}

	private int calculatePromotionCD(SKUitem item, int itemQuantity, boolean flag) {
		float price = item.getUnitPrice();
		double finalPrice = 0;

		if (flag == true) {
			finalPrice = (cdPrice + price) * 85.72 / 100; // 85.72 percent for C & D after applying promotion
			return (int) finalPrice;

		} else {
			return (int) price;
		}
	}

	public int calculatePromotionAB(SKUitem item, int itemQuantity) {
		String id = item.getID();
		float price = item.getUnitPrice();
		double discountedPrice;
		double finalPrice = 0;
		int grouping;
		switch (id) {
		case "A":
			grouping = 3;
			discountedPrice = price * 86.67 / 100; // 86.67 percent after applying promotion
			finalPrice = (((itemQuantity / grouping) * discountedPrice * grouping)
					+ ((itemQuantity % grouping) * price));
			break;

		case "B":
			grouping = 2;
			discountedPrice = price * 75 / 100; // 75 percent after applying promotion
			finalPrice = (((itemQuantity / grouping) * discountedPrice * grouping)
					+ ((itemQuantity % grouping) * price));
			break;
		}
		return (int) finalPrice;

	}
}
