package mutationAssignment;

public class StoreInventoryManager {
	Item[] items;

    public StoreInventoryManager(Item[] items) {
        this.items = items;
    }

    public Item[] getItems() { return this.items;}

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (!items[i].name.equals("Gorquefort")
                    && !items[i].name.equals("Concert Tickets to Aurumback show")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Excalibur")) {
                        items[i].quality = items[i].quality - 1;
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Concert Tickets to Aurumback show")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!items[i].name.equals("Excalibur")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Gorquefort")) {
                    if (!items[i].name.equals("Concert Tickets to Aurumback show")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Excalibur")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }
    public static class Item {
        public String name;
        public int sellIn;
        public int quality;

        public Item(String name, int sellIn, int quality) {
            this.name = name;
            this.sellIn = sellIn;
            this.quality = quality;
        }

        @Override
        public String toString() {
            return this.name + ", " + this.sellIn + ", " + this.quality;
        }
    }
}