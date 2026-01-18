// 1) Using Linkedlist

// class Node {
//     int data;
//     Node next;

//     Node(int data) {
//         this.data = data;
//         next = null;
//     }
// }

// class MyQueue {
//     public static Node head;
//     public static Node tail;

//     public MyQueue() {
//         head = tail = null;
//     }
    
//     public void push(int x) {
//         Node newNode = new Node(x);
//         if(empty()) {
//             head = tail = newNode;
//             return;
//         }
//         tail.next = newNode;
//         tail = newNode;
//     }
    
//     public int pop() {
//         if(empty()) {
//             return -1;
//         }
//         int temp = head.data;
//         if(head == tail) {
//             head = tail = null;
//         } else {
//             head = head.next;
//         }
//         return temp;
//     }
    
//     public int peek() {
//         if(empty()) {
//             return -1;
//         }
//         return head.data;
//     }
    
//     public boolean empty() {
//         return head == null && tail == null;
//     }
// }






// 2) Using Stack - Approach 1

// class MyQueue {
//     Stack<Integer> s1, s2;

//     public MyQueue() {
//         s1 = new Stack<>();
//         s2 = new Stack<>();
//     }
    
//     public void push(int x) {
//         while(!s1.isEmpty()) {
//             s2.push(s1.pop());
//         }

//         s1.push(x);

//         while(!s2.isEmpty()) {
//             s1.push(s2.pop());
//         }
//     }
    
//     public int pop() {
//         return s1.pop();
//     }
    
//     public int peek() {
//         return s1.peek();
//     }
    
//     public boolean empty() {
//         return s1.isEmpty();
//     }
// }






// 3) Using Stack - Approach 2

class MyQueue {
    Stack<Integer> s1, s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.pop();
    }
    
    public int peek() {
        if(s2.isEmpty()) {
            while(!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }

        return s2.peek();
    }
    
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */ 