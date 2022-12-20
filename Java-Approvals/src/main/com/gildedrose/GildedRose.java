package com.gildedrose;

import java.util.Hashtable;

class GildedRose {
    Item[] items;
    private final Hashtable<String, UpdateQualityStrategy> updateStrategies = new Hashtable<>();

    public GildedRose(Item[] items) {
        this.items = items;
        updateStrategies.put("Aged Brie", new AgedBrieQualityUpdate());
        updateStrategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassesQualityUpdate());
        updateStrategies.put("Sulfuras, Hand of Ragnaros", new SulfurasQualityUpdate());
        updateStrategies.put("Other", new OtherQualityUpdate());
    }

    public void updateQuality() {
        for (Item item : items) {
            this.getStrategy(item.name).updateQuality(item);
        }
    }

    private UpdateQualityStrategy getStrategy(String criteria){
        if(updateStrategies.containsKey(criteria))
            return updateStrategies.get(criteria);
        else
            return updateStrategies.get("Other");
    }
}
