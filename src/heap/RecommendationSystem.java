package heap;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class RecommendationSystem {

    static Set<Item> itemSet;
    public static void main(String[] args) {

        itemSet = new TreeSet<>(
                (item1, item2)-> {
                    int count = item2.count.compareTo(item1.count);
                    if (count == 0) {
                        return Integer.compare(item1.id, item2.id);
                    }
                    return count;
                });

        // Comparator.comparing(Item::getCount, Comparator.reverseOrder()).thenComparing(Item::getId)
            /*

        });*/

        Item item1 = new Item(1,"item1",0);
        Item item2 = new Item(2,"item2",0);
        Item item3 = new Item(3,"item3",0);
        Item item4 = new Item(4,"item4",0);

        addClickCount(item1);
        addClickCount(item2);
        addClickCount(item3);

        addClickCount(item1);
        addClickCount(item2);
        addClickCount(item3);

        addClickCount(item1);
        addClickCount(item2);
        addClickCount(item3);

        addClickCount(item4);

        List<Item> result = getTopKItems(4);
        result.forEach(System.out::println);
    }

    public static void addClickCount(Item item){
        if(itemSet.contains(item)){
            Item oldItem = item;
            itemSet.remove(item);

            oldItem.count++;
            itemSet.remove(item);
            itemSet.add(oldItem);
        }else {
            item.count++;
            itemSet.add(item);
        }
    }


    public static List<Item> getTopKItems(int k){
        return itemSet.stream().limit(k).collect(Collectors.toList());
    }
}

class Item {
    int id;
    String name;
    Integer count;

    public Item(int id, String name, Integer count) {
        this.id = id;
        this.name = name;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getCount() {
        return count;
    }

   /*
   treeSet not using equals and hashcode
   @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }*/

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
