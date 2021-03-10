package com.assess15.leetcode.arch;

public class LinkedListUtils {
    private static final LinkedListUtils utils = new LinkedListUtils();

    private LinkedListUtils() {
    }

    public static LinkedListUtils getInstance() {
        return utils;
    }

    private static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public ArchLinkedList.ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ArchLinkedList.ListNode dummyRoot = new ArchLinkedList.ListNode(0);
        ArchLinkedList.ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ArchLinkedList.ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public String listNodeToString(ArchLinkedList.ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += node.value + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }
}