function DoublyLinkedList(){
    this.head = new DoublyNode(null, null, null);
    this.tail = new DoublyNode(null, null, null);
    this.clear();
}

function DoublyNode(element, next, prev){
    this.element = element;
    this.next = next;
    this.prev = prev;
}

DoublyLinkedList.prototype = {
    constructor:DoublyLinkedList,
    append:function(element){
        var newNode;
        if(this.head.next == null){
            newNode = new DoublyNode(element, this.tail, this.head);
            this.head.next = newNode;
        }else{
            newNode = new DoublyNode(element, this.tail, this.tail.prev);
            this.tail.prev.next = newNode;
        }
        this.tail.prev = newNode;
        this.length++;
    },
    insert:function(index, element){
        this._checkIndex(index);
        var previous = index == 0 ? this.head : this._indexNodeAt(index-1);
        var newNode = new DoublyNode(element, previous.next, previous);
        previous.next.prev = newNode;
        previous.next = newNode;
        this.length++;
    },
    removeAt:function(index){
        this._checkIndex(index);
        var previous = index == 0 ? this.head : this._indexNodeAt(index-1);
        var indexNode = previous.next;
        previous.next = previous.next.next;
        previous.next.prev = previous;
        this.length--;
        return indexNode.element;
    },
    indexAt:function(index){
        return this._indexNodeAt(index).element;
    },
    _checkIndex:function(index){
        if(index < 0 || index >= this.length){
            throw new Error("indexOutOfBounds : index="+index+", length="+this.length);
        }
    },
    _indexNodeAt:function(index){
        this._checkIndex(index);
        var curr;
        if(index >= this.size()/2){
            curr = this.tail.prev;
            for(var i=this.size()-1;i>index;i--){
                curr = curr.prev;
            }
        }else{
            curr = this.head.next;
            for(var i=0;i<index;i++){
                curr = curr.next
            }
        }
        return curr;
    },
    remove:function(element){
        //if(this.isEmpty()) return false;
        //var index = this.indexOf(element);
        //if(index < 0) return false;
        //this.removeAt(index);
        //return true;

        //上面使用indexOf和removeAt需要循环2次，而下面循环只需要1次
        var curr = this.head.next;
        if(curr == null) return false;

        var previous = this.head;
        for(var i=0;curr!=null;i++){
            if(curr.element == element){
                previous.next = curr.next;
                previous.next.next.prev = previous;
                this.length--;
                return true;
            }
            previous = curr;
            curr = curr.next;
        }
        return false;
    },
    indexOf:function(element){
        var curr = this.head.next;
        if(curr == null) return -1;

        for(var i=0;curr!=null;i++){
            if(curr.element == element){
                return i;
            }
            curr = curr.next;
        }
        return -1;
    },
    isEmpty:function(){
        return this.length == 0;
    },
    clear:function(){
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.length = 0;
    },
    size:function(){
        return this.length;
    },
    toString:function(){
        var eleStr = '';
        var curr = this.head.next;
        while(curr != this.tail){
            eleStr += curr.element;
            if(curr.next == this.tail) break;
            eleStr += ', ';
            curr = curr.next;
        }
        return "DoublyLinkedList (elements=["+eleStr+"])";
    }
}