package com.techelevator;

import com.techelevator.view.InventoryView;
import com.techelevator.view.Menu;
import com.techelevator.view.PurchaseView;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_OPTION_EXIT = "Exit";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE,
		MAIN_MENU_OPTION_EXIT};

	private Menu menu;
	private VMInventory vmInventory;
	private InventoryView inventoryView;
	private PurchaseView purchaseView;


	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
		this.vmInventory = new VMInventory("vendingmachine.csv");
		this.inventoryView = new InventoryView(this.vmInventory);
		this.purchaseView = new PurchaseView(new Menu(System.in, System.out), this.vmInventory);
	}

	public void run() {
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				this.inventoryView.run();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				this.purchaseView.run();
			} else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}
}
