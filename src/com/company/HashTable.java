package com.company;

public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        int index = value.hashCode();
        return index % size;
    }

    public int seekSlot(String value) {
        int index = hashFun(value);
        for (int i = 0; i < slots.length / step + 2; i++) {
            if (slots[index] == null) {
                return index;
            }
            index += step;
            if (index >= slots.length) {
                index -= slots.length;
            }
        }
        return -1;
    }

    public int put(String value) {
        int index = seekSlot(value);
        if (index != -1) {
            slots[index] = value;
            return index;
        }
        return -1;
    }

    public int find(String value) {
        int index = hashFun(value);
        for (int i = 0; i < slots.length / step + 2; i++) {
            if (slots[index] != null && slots[index].equals(value)) {
                return index;
            }
            index += step;
            if (index >= slots.length) {
                index -= slots.length;
            }
        }
        return -1;
    }
}