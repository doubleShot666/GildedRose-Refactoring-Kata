package com.gildedrose;

public class OtherQualityUpdate implements UpdateQualityStrategy{

    @Override
    public void updateQuality(Item item) {
        if(item.quality <= 0){
            item.quality = item.quality + 1;
        }else{
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0){
                item.quality = item.quality - 1;
            }
        }
    }
}
