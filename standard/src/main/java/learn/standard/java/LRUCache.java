package learn.standard.java;

class LRUCache {
    private int capacity;
    private Node[] map;
    private Node head;
    private Node tail;
    private int size;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new Node[capacity];
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        size = 0;
    }

    private Node getNode(int key){

        int index = hash(key);
        Node node = map[index];
        while(node != null){
            if(node.key == key){
                if(head.linkedNext != node) {
                    if (tail.linkedNext == node) {
                        tail.linkedNext = node.linkedPre;
                        node.linkedPre.linkedNext = null;
                    } else {
                        node.linkedPre.linkedNext = node.linkedNext;
                        node.linkedNext.linkedPre = node.linkedPre;
                    }
                    node.linkedPre = null;
                    node.linkedNext = head.linkedNext;
                    if(head.linkedNext != null)
                        head.linkedNext.linkedPre = node;
                    head.linkedNext = node;
                }
                return node;
            }
            node = node.mapNext;
        }
        return null;
    }

    public int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public void put(int key, int value) {
        Node node = getNode(key);
        if(node != null){
            node.value = value;
        }
        else{
            Node newNode = new Node(key, value);
            int index = hash(key);
            Node mapNode = map[index];
            if(mapNode == null){
                map[index] = newNode;
            }
            else{
                newNode.mapNext = mapNode.mapNext;
                mapNode.mapNext = newNode;
            }
            if(head.linkedNext != null)
                head.linkedNext.linkedPre = newNode;

            newNode.linkedNext = head.linkedNext;
            head.linkedNext = newNode;
            if(size + 1 <= capacity){
                ++size;
                if(tail.linkedNext == null)
                    tail.linkedNext = newNode;
            }
            else{
                Node tailNode = tail.linkedNext;
                if(tailNode != null){
                    tail.linkedNext = tailNode.linkedPre;
                    int tailIndex = hash(tailNode.key);
                    Node tailMapNode = map[tailIndex];
                    if(tailMapNode == tailNode){
                        map[tailIndex] = tailMapNode.mapNext;
                    }
                    else{
                        while(tailMapNode.mapNext != null){
                            if(tailMapNode.mapNext == tailNode){
                                tailMapNode.mapNext = tailMapNode.mapNext.mapNext;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private int hash(int key){
        return key % capacity;
    }

    class Node{
        int key;
        int value;
        Node mapNext;
        Node linkedNext;
        Node linkedPre;
        Node(int key, int value){
            this.key = key;
            this.value = value;
            mapNext = null;
            linkedNext = null;
            linkedPre = null;
        }
    }

    public static void main(String[] args){
//        ["LRUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
//[[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1,1);
        lruCache.put(2,2);
        lruCache.put(3,3);
        lruCache.put(4,4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5,5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}