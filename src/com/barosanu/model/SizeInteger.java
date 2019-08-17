package com.barosanu.model;

public class SizeInteger implements Comparable<SizeInteger>{

    private int size;

    public SizeInteger(int size) {
        this.size = size;
    }

    @Override
    public String toString(){
        if (size <= 0) {
            return "0";
        } else if (size < 1024) {
            return size + " B";
        } else if (size < 1048576) {
            return size / 1024 + " kB";
        } else {
            return size / 1048576 + " MB";
        }
    }

    @Override
    public int compareTo(SizeInteger o) {
        if(size > o.size) {
            return 1;
        } else if(o.size > size) {
            return -1;
        } else {
            return 0;
        }
    }
}
